package bank;

import java.io.*;

import javax.swing.JOptionPane;


public abstract class Account implements Serializable{ 
	protected String ID;				
	protected String PIN;				
	
	protected int balance = 0;			
	protected int unbalance = 0;		
	
	protected int type;
	protected boolean state = true;	
	
	
	protected String name;
	protected String address;
	protected int birthYear;
	protected int birthMonth;
	protected int birthDay;
	protected int credit = 0;	
	protected boolean age = true;
	protected int overdrawlimit;
	private int overdraw = 0;
	
	//getter() & setter()
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean getAge() {
		return age;
	}
	public void setAge(boolean age) {
		this.age = age;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUnbalance() {
		return unbalance;
	}

	public void setUnbalance(int unbalance) {
		this.unbalance = unbalance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	public Account(){
		ThirdParty getcredit = new ThirdParty();
		credit = getcredit.getCredit();
		//System.out.println(credit);
	}
	
	public void deposit(){	
		String depositStr = JOptionPane.showInputDialog("Please input the value that you would like to deposit: ");
		try{
			int deposit = Integer.parseInt(depositStr);
			balance += deposit;
			JOptionPane.showMessageDialog(null,"You have depositted successfully.","Information",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Input Invalid.\nPlease try again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		
//		System.out.println("You have depositted $" + deposit + " successfully!");
//		System.out.println("Your balance is $" + balance +" in the account.");
	}
	
	public void chequeDeposit(){	
		String depositStr = JOptionPane.showInputDialog("Please input the value that you would like to deposit by cheque\nIt will get into your balance at next time you login the account.: ");
		try{
			int cheque = Integer.parseInt(depositStr);
			unbalance += cheque;
			JOptionPane.showMessageDialog(null,"You have depositted (unclear) successfully.","Information",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Input Invalid.\nPlease try again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
//		System.out.println("You have depositted $" + cheque + " successfully!");
//		System.out.println("It may take a few minutes to deposit in your account.");
//		System.out.println("Your balance is $" + balance +" in the account.");
	}
	
	
	public void suspend(){				
		state = false;
		
	}
	
	public void restart(){				
		state = true;
		System.out.println("The account " + ID + " has been restarted successfully!");
		
	}
	
	
	abstract public void withdraw();
	
	
	abstract public void refund();
	abstract public int getOverdraw();
	
	
	abstract public int getRsvDeposit();
	abstract public void setRsvDeposit();
	abstract public void setRsvDeposit(int value);
	
}
