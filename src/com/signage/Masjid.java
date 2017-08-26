package com.signage;

public class Masjid {
	
	private int masjid_id;
	private String masjid_name;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	public int getMasjid_id() {
		return masjid_id;
	}
	public void setMasjid_id(int masjid_id) {
		this.masjid_id = masjid_id;
	}
	public String getMasjid_name() {
		return masjid_name;
	}
	public void setMasjid_name(String masjid_name) {
		this.masjid_name = masjid_name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
