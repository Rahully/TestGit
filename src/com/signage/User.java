package com.signage;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users")
@SuppressWarnings("serial")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="user_id", length=11)
	private int user_id;
	private int masjid_id;
	@Column(name="email_id", length=50)
	private String email_id;
	@Column(name="password", length=50)
	private String password;
	private String is_Active;
	private String isSuperAdmin;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMasjid_id() {
		return masjid_id;
	}
	public void setMasjid_id(int masjid_id) {
		this.masjid_id = masjid_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIs_Active() {
		return is_Active;
	}
	public void setIs_Active(String is_Active) {
		this.is_Active = is_Active;
	}
	public String getIsSuperAdmin() {
		return isSuperAdmin;
	}
	public void setIsSuperAdmin(String isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
}
