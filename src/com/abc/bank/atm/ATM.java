package com.abc.bank.atm;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.AccountNotFoundException;

import com.abc.bank.account.Branch;
import com.abc.bank.account.OpenAccount;

public class ATM {
	private Scanner sc;
	private static OpenAccount open;
	public void consoleMenu() throws AccountNotFoundException, ClassNotFoundException, IOException {
		System.out.println("!! *****  ABC Bank  ***** !! ");
		sc = new Scanner(System.in);

		boolean session = true; 

		while (session) {
				System.out.print("\n Menu: \n \n"
							 + "1. Account Details \n"
							 + "2. Password Change \n"
							 + "3. Balance Update \n"
							 + "4. Check Account Balance\n"
							 + "5. End Session\n \n"
							 + "Enter selection: ");

				int selection = sc.nextInt();
				switch (selection) {
					case 1:
						accountDetails();
						break;
					case 2:
						passwordChange();
						break;
					case 3:
						balanceUpdate();
						break;
					case 4:
						checkBalance();
						break;
					case 5:
						session = false;
						break;
				}
		}
		

		System.out.println("\nThank you for banking with us!\n");
	}
	public OpenAccount verificationAccount() throws AccountNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Enter your Account Id ");
		String account=sc.next();
		System.out.println("Enter your Password ");
		String password=sc.next();
		String f="D:\\Beginner\\Assignment05\\database\\"+account+".txt";
		File file=new File(f);
		if (file.exists()) {
			Branch branch=new Branch();
			open=branch.readFromFile(account);
			
			if(open.getPassword()==password) {
				if(open.getStatus()==0) {
					System.out.println("Account inactive,Plz contact to home Branch.");
					throw new InvalidInputException("Invalid Account .");
				}else
				return open;
			}else {
				throw new InvalidInputException("Password wrong");
			}
		}else {
			throw new AccountNotFoundException("Account not found with id "+account);
		}
	}
	public void accountDetails() throws AccountNotFoundException, ClassNotFoundException, IOException  {
		open=verificationAccount();
		System.out.println(open);
	}
	public void passwordChange() throws AccountNotFoundException, ClassNotFoundException, IOException {
			open=verificationAccount();
			System.out.println("Enter new  Password ");
			String password=sc.next();
			System.out.println("Confirm new  Password ");
			String password1=sc.next();
			if(password==password1) {
					open.setPassword(password1);
			}else {
				throw new InvalidInputException("Password not Match");
			}	
	}
	public void balanceUpdate() {
		try {
			open=verificationAccount();
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Curent Balance : "+open.getBalance());
		System.out.println("Press 1 for Deposit and 2 for Credit .");
		int n=sc.nextInt();
		Double balance=open.getBalance();
		if(n==1) {
			System.out.print("Enter amount to be deposit to account :");
			double bal=sc.nextDouble();
			balance=balance+bal;
			open.setBalance(balance);
			
		}else if(n==2) {
			System.out.print("Enter amount to be deposit to account :");
			double bal=sc.nextDouble();
			balance=balance-bal;
			open.setBalance(balance);
		}
		
	}
	public void checkBalance() {
		try {
			open=verificationAccount();
		} catch (AccountNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Balance : "+open.getBalance());
	}
	public static void main(String args[]) throws AccountNotFoundException, ClassNotFoundException, IOException {
		ATM atm=new ATM();
		atm.consoleMenu();
	}

}
