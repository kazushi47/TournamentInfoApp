package bean;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 4284572555216108008L;
	
	private int id;
	private String username;
	private String password;
	private int role_number;
	private String role_name;
	private int login_status;
	private Date last_login_time;
	private String email;
	private String full_name;
	
	public User() {
		super();
		id = -1;
		username = null;
		password = null;
		role_number = -1;
		role_name = null;
		login_status = -1;
		last_login_time = null;
		email = null;
		full_name = null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getRole_number() {
		return role_number;
	}
	public void setRole_number(int role_number) {
		this.role_number = role_number;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getLogin_status() {
		return login_status;
	}
	public void setLogin_status(int login_status) {
		this.login_status = login_status;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role_number=" + role_number
				+ ", role_name=" + role_name + ", login_status=" + login_status + ", last_login_time=" + last_login_time
				+ ", email=" + email + ", full_name=" + full_name + "]";
	}

}
