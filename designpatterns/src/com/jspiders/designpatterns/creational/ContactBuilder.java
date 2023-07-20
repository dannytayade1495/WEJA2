package com.jspiders.designpatterns.creational;

public class ContactBuilder {

	private String firstName;
	private String middleName;
	private String lastName;
	private String nickName;
	private String email;
	private long mobileNumber;
	private long landlineNumber;
	private String address;
	private String gender;
	private String dateOfBirth;
	private int age;

	public ContactBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactBuilder middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public ContactBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactBuilder nickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public ContactBuilder email(String email) {
		this.email = email;
		return this;
	}

	public ContactBuilder mobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public ContactBuilder landlineNumber(long landlineNumber) {
		this.landlineNumber = landlineNumber;
		return this;
	}

	public ContactBuilder address(String address) {
		this.address = address;
		return this;
	}

	public ContactBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}

	public ContactBuilder dateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public ContactBuilder age(int age) {
		this.age = age;
		return this;
	}

	public Contact getContact() {
		return new Contact(firstName, middleName, lastName, nickName, email, mobileNumber, landlineNumber, address,
				gender, dateOfBirth, age);
	}

}
