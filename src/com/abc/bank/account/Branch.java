package com.abc.bank.account;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Branch {
	private static OpenAccount open;

	public void AccountDetails(){
		System.out.println("!!**  Account Details  **!! ");
		System.out.println("Please fill up form ");
		Scanner scan=new Scanner(System.in);
		System.out.print("Account Id  : ");
		String accountId=scan.next();
		System.out.print("Password  : ");
		String password=scan.next();
		System.out.print("First Name  : ");
		String fName=scan.next();
		System.out.print("Middle Name : ");
		String mName=scan.next();
//		char ch=mName.charAt(0);
//		if(ch=='\n') {
//			System.out.println();
//		}
		System.out.print("Last Name : ");
		String lName=scan.next();
		System.out.print("Date Of Birth : ");
		String dob=scan.next();
		System.out.print("Pan Number : ");
		String pan=scan.next();
		System.out.print("Address : ");
		String address=scan.next();
		System.out.print("State : ");
		String state=scan.next();
		System.out.print("City : ");
		String city=scan.next();
		System.out.print("Zip Code : ");
		Integer zipCode=scan.nextInt();
		System.out.print("Account Balance : ");
		Double balance=scan.nextDouble();
		int Status=(int) Math.round(Math.random())  ;
		open=new OpenAccount(accountId, password, fName, mName, lName, dob, pan, address, state, city, zipCode, balance,Status);
		System.out.println("Thank you for submitting details.");
	}
	public void writeToFile() throws IOException {
		String file="D:\\Beginner\\Assignment05\\database\\"+open.getAccountId()+".txt";
		
		FileOutputStream fos=new FileOutputStream(new File(file));
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(open);
			oos.flush();
		}
		System.out.println("Account Created with Account Id "+open.getAccountId()+open.getMiddleName());
	}
	public OpenAccount readFromFile(String accountId) throws IOException, ClassNotFoundException {
		String file="D:\\Beginner\\Assignment05\\database\\"+accountId+".txt";
		FileInputStream fis=new FileInputStream(file);
		BufferedInputStream bis=new BufferedInputStream(fis);
		ObjectInputStream ois=new ObjectInputStream(bis);
		OpenAccount account=(OpenAccount)ois.readObject();
		return account;
	}
	public static void main(String[] args) throws IOException {
		Branch branch=new Branch();
		branch.AccountDetails();
		branch.writeToFile();
		
		
	}

}
