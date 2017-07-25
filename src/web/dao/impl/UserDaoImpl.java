package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.dao.UserDao;
import web.entity.User;
import web.util.JdbcUtil;

public class UserDaoImpl implements UserDao {
	/*
	 * 用户注册 --向数据库增加一条用户信息
	 */
	public void addUser(User user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 获取连接对象
			conn = JdbcUtil.getConnection();
			// 添加SQL语句
			String sql = "insert into admin(admin,adminpwd,qq) VALUES (?,?,?);";
			// 预编译SQL语句
			pstmt = conn.prepareStatement(sql);
			// 设置参数值
			pstmt.setString(1, user.getAdmin());
			pstmt.setString(2, user.getAdminPwd());
			pstmt.setString(3, user.getQq());
			// 编译
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			// 关闭资源
			JdbcUtil.close(conn, pstmt);
		}
	}

	/*
	 * 用户登录验证 -- 查询是否有此用户和所匹配的密码
	 */
	public boolean login(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from admin where admin=? and adminpwd=?;";
			// 预编译
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getAdmin());
			pstmt.setString(2, user.getAdminPwd());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

	}

	/*
	 * 注册时根据姓名查询是否重复 -- 查询该注册用户名是否存在
	 */
	public boolean checkUser(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = JdbcUtil.getConnection();
			String sql = "select * from admin where admin=?;";
			// 预编译
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}

	public List<User> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from admin;";
			// 预编译
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setAdmin(rs.getString("admin"));
				user.setAdminpwd(rs.getString("adminpwd"));
				user.setQq(rs.getString("qq"));
				list.add(user);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	public void updateUser(User user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 获取连接对象
			conn = JdbcUtil.getConnection();
			// 添加SQL语句
			String sql = "UPDATE admin SET admin=?,adminpwd=?,qq=? WHERE id =?;";
			// 预编译SQL语句
			pstmt = conn.prepareStatement(sql);
			// 设置参数值
			pstmt.setString(1, user.getAdmin());
			pstmt.setString(2, user.getAdminPwd());
			pstmt.setString(3, user.getQq());
			pstmt.setString(4, user.getId());
			// 编译
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			// 关闭资源
			JdbcUtil.close(conn, pstmt);
		}
	}

	public void deleteUser(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from admin where id=?;";
			// 预编译
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	}

	public User findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from admin where id=?;";
			// 预编译
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			User user = null;
			if(rs.next()){
				user = new User();
				user.setId(rs.getString("id"));
				user.setAdmin(rs.getString("admin"));
				user.setAdminpwd(rs.getString("adminpwd"));
				user.setQq(rs.getString("qq"));
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

}
