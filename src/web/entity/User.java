package web.entity;

/*
 * entity 实体
 * contact 
 */
public class User {

	private String admin; // 用户名
	private String adminPwd; // 密码
	private String qq; //QQ
	private String id; //ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminpwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
	public String toString() {
		return "User [admin=" + admin + ", adminPwd=" + adminPwd + ", qq=" + qq
				+ ", id=" + id + "]";
	}



}