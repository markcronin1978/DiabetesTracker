package ie.cit.domain;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Physician {
	
	@NotEmpty
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String address1;
	@NotEmpty
	private String address2;
	@NotEmpty
	private String address3;
	private String address4;
	@NotEmpty @Min(3)
	private String phoneNumber;
	@NotEmpty @Email
	private String username;
	@NotEmpty
	private String password;
	
	public Physician (){
		this.id = UUID.randomUUID().toString();
	}
	public Physician(int id, String name, String address1, String address2,
			String address3, String address4, String phoneNumber, String username, String password) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	@Override
	public String toString() {
		return "Physician [id=" + id + ", name=" + name + ", address1="
				+ address1 + ", address2=" + address2 + ", address3="
				+ address3 + ", address4=" + address4 + ", phoneNumber="
				+ phoneNumber + ", username=" + username + "]";
	}
	
}
