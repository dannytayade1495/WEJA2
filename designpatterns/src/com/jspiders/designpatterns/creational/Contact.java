package com.jspiders.designpatterns.creational;

public class Contact {

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

	public Contact(String firstName, String middleName, String lastName, String nickName, String email,
			long mobileNumber, long landlineNumber, String address, String gender, String dateOfBirth, int age) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.landlineNumber = landlineNumber;
		this.address = address;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", nickName=" + nickName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", landlineNumber="
				+ landlineNumber + ", address=" + address + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", age=" + age + "]";
	}

}
