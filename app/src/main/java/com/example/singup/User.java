package com.example.singup;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {
	@SerializedName("name")
	String name;
	@SerializedName("mail")
	String mail;
	@SerializedName("password")
	String password;
	@SerializedName("address")
	String address;
	@SerializedName("personType")
	String personType;
	@SerializedName("gender")
	String gender;
	//@SerializedName("id")
	/*int id;
	@SerializedName("busId")
	private ArrayList<String> busId;*/

	public User(String name, String mail, String password, String address, String personType, String gender) {
		//super();
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.address = address;
		this.personType = personType;
		this.gender = gender;
	}
	public User(){
		this.name = "Unknow";
		this.mail = "Unknow";
		this.password = "Unknow";
		this.address = "Unknow";
		this.personType = "Unknow";
		this.gender = "Unknow";
	}

	/*public void setBusId(ArrayList<String> busId) {
		this.busId = busId;
	}

	public ArrayList<String> getBusId() {
		return busId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}