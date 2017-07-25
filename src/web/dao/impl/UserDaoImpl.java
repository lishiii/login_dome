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
	 * �û�ע�� --�����ݿ�����һ���û���Ϣ
	 */
	public void addUser(User user) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// ��ȡ���Ӷ���
			conn = JdbcUtil.getConnection();
			// ���SQL���
			String sql = "insert into admin(admin,adminpwd,qq) VALUES (?,?,?);";
			// Ԥ����SQL���
			pstmt = conn.prepareStatement(sql);
			// ���ò���ֵ
			pstmt.setString(1, user.getAdmin());
			pstmt.setString(2, user.getAdminPwd());
			pstmt.setString(3, user.getQq());
			// ����
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			// �ر���Դ
			JdbcUtil.close(conn, pstmt);
		}
	}

	/*
	 * �û���¼��֤ -- ��ѯ�Ƿ��д��û�����ƥ�������
	 */
	public boolean login(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from admin where admin=? and adminpwd=?;";
			// Ԥ����
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
	 * ע��ʱ����������ѯ�Ƿ��ظ� -- ��ѯ��ע���û����Ƿ����
	 */
	public boolean checkUser(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = JdbcUtil.getConnection();
			String sql = "select * from admin where admin=?;";
			// Ԥ����
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
			// Ԥ����
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
			// ��ȡ���Ӷ���
			conn = JdbcUtil.getConnection();
			// ���SQL���
			String sql = "UPDATE admin SET admin=?,adminpwd=?,qq=? WHERE id =?;";
			// Ԥ����SQL���
			pstmt = conn.prepareStatement(sql);
			// ���ò���ֵ
			pstmt.setString(1, user.getAdmin());
			pstmt.setString(2, user.getAdminPwd());
			pstmt.setString(3, user.getQq());
			pstmt.setString(4, user.getId());
			// ����
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			// �ر���Դ
			JdbcUtil.close(conn, pstmt);
		}
	}

	public void deleteUser(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from admin where id=?;";
			// Ԥ����
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
			// Ԥ����
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
