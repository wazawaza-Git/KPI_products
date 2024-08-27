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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAge() {
		return age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

}
