package com.abc.bank.account;

import java.io.Serializable;


public class OpenAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountId;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String panNumber;
	private String address;
	private String state;
	private String city;
	private Integer zipCode;
	private Double balance;
	private Integer Status;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public OpenAccount(String accountId, String password, String firstName, String middleName, String lastName,
			String dob, String panNumber, String address, String state, String city, Integer zipCode, Double balance,Integer Status) {
		super();
		this.accountId = accountId;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.panNumber = panNumber;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.balance = balance;
		this.Status=Status;
	}
	
	public Integer getStatus() {
		return Status;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "OpenAccount [accountId=" + accountId + ", password=" + password + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", dob=" + dob + ", panNumber=" + panNumber
				+ ", address=" + address + ", state=" + state + ", city=" + city + ", zipCode=" + zipCode + ", balance="
				+ balance + "]";
	}
	
	
}
