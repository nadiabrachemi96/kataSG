package kataSG;

import java.util.ArrayList;
import java.util.Calendar;


public class Account {
	// The owner of the account
	private Owner owner;
	// The date the account was created
	private Calendar date;
	// The amount to be deposited in the account
	private double amount;
	// The account balance
	private double balance;
	// The maximum amount to withdraw
	private double maxWithdraw;
	
	// Transaction history
	private ArrayList<History> history = new ArrayList<>(); 
	
	public Account(Owner owner, Calendar date, double amount) {
		this.owner = owner;
		this.date = date;
		this.amount = amount;
		this.balance =0;
		// The maximum amount to withdraw is 1000€ in one deal
		this.maxWithdraw=1000;
		
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double bal) {
		this.balance = this.balance + bal;
		System.out.println("Operation reussie");
		// Add the transaction to the history
		History history = new History(Calendar.getInstance(), "Deposit",bal, this.getBalance());
		this.addHistory(history);
	}


	public void withdraw(double bal) {
		// A debtor account -400 €
		if ((this.getBalance() - bal) < -400) {
			System.out.println(
					"You have exceeded the authorized amount, please contact your bank");
		} else {
			if(!(bal> maxWithdraw)) {
				this.balance = this.balance - bal;
				System.out.println("Operation reussie");
				History history = new History(Calendar.getInstance(), "withdraw", bal, this.getBalance());
				this.addHistory(history);
			}else {
				System.out.println("You cannot withdraw more than 500€");
				System.out.println("Operation échoué");
			}
			
		}
		
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void addHistory(History history) {
		this.history.add(history);
	}

	public ArrayList<History> getHistory() {
		return this.history;
	}

	@Override
	public String toString() {
		return "Account{" + "Owner=" + owner + ", Balance=" + balance +"€ }";
	}
}
