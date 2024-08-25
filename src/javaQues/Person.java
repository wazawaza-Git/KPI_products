package javaQues;

public class Person {
	String name = null;
	String age = null;
	String gender = null;
	String address = null;
	String job = null;

	public Person(String name, String age, String gender, String address, String job) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getJob() {
		return job;
	}

}
