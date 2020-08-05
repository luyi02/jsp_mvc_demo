package cn.luyi.domain;

/**
 * 封装数据的javaBean的编写
 * @author luyi
 *
 */
public class User {
	private int nid;
	private String username;
	private String password;
	private String role;
	
	public User(){
		
	};
	public User(String username, String password, String role){
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
