package kataSG;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Create Owner
		Owner owner1= new Owner("toto","TotoFirstName", 1, "toto1@gmail.com");
		//Create account for owner1
		Account account1=new Account(owner1,Calendar.getInstance(),0);
		System.out.println("Deposit 500€ ");
	    account1.setBalance(500);//Deposit money
	    System.out.println("Withdraw 900€ ");
	    account1.withdraw(900);//withdraw Money(A debtor account -400 €)
	    System.out.println("Withdraw 100");
	    account1.withdraw(100);//try to withdraw with no money in the account
	    
	    //Show History of the account
	    System.out.println("History :");
	    for (History history1 : account1.getHistory()) {
			System.out.println(history1);
		}
		
		TimeUnit.SECONDS.sleep(10);
		
		//To try creation of account
		System.out.println("**********************************************");
		try (Scanner scanner = new Scanner(System.in)) {
			boolean quit = false;
			Treatment treat = new Treatment();
			Set<Account> setAccount = new HashSet<>();
			while (quit != true) {

				System.out.println("Please Make your choice");
				System.out.println("Please type 1 to create an account");
				System.out.println("Please type 2 to connect to your account");
				int choice = evoidException(0, 0, "Invalid onput, please Type 1 or 2", scanner);

				switch (choice) {
				// create an account
				case 1:
					Owner owner = new Owner();
					owner.createOwner();
					Account account = new Account(owner, Calendar.getInstance(), 0);
					System.out.println(account);
					setAccount.add(account);
					break;

				case 2:
					
                    String email;
                    //Make sure we have the correct syntax for an email address
					do {
						System.out.println("Please enter your email address");
						email = scanner.next();
					} while (!(email.matches(".+@.+\\.[a-z]+")));
					
					System.out.println("Please enter your access code");
					int codeAccess = evoidException(0, 1, "Invalid input, please enter your access code", scanner);

					
                	treat.count(setAccount,email, codeAccess);
					break;

				default:
					break;
				}
			}
		}

	}

	// To avoid the exception InputMismatchException if the user puts a character/string
	public static int evoidException(int choice, int minValue, String message, Scanner scanner) {

		do {
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(message);
			}
			scanner.nextLine(); // clears the buffer
		} while (choice < minValue);

		
		return choice;
	}
}
