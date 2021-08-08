package com.example.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type_id;
	private String document_id;
	private String first_name;
	private String last_name;
	private String phone;
	private String address;
	private String email;

	public Customer(Long id, String type_id, String document_id, String first_name, String last_name, String phone,
			String address) {
		super();
		this.id = id;
		this.type_id = type_id;
		this.document_id = document_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.address = address;
	}

	public Customer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getDocument_id() {
		return document_id;
	}

	public void setDocument_id(String document_id) {
		this.document_id = document_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", type_id=" + type_id + ", document_id=" + document_id + ", first_name="
				+ first_name + ", last_name=" + last_name + ", phone=" + phone + ", address=" + address + ", email="
				+ email + "]";
	}

}
