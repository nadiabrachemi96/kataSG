package kataSG;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;

public class Treatment {
	
	Scanner scanner = new Scanner(System.in);
	

	public Account count(Set<Account> listAccount, String email, int codeAccess)
			throws InterruptedException, IOException {
		boolean quit = false;
		// We must ensure that there are already created accounts
		if (listAccount != null) {
			for (Account account : listAccount) {
				// verify that an account with the email address and access code exists
				if (account.getOwner().getAccessCode() == codeAccess && account.getOwner().getEmail().equals(email)) {
					while (quit != true) {
						System.out.println("Please type 1 to check your account balance");
						System.out.println("Please type 2 to deposit money");
						System.out.println("Please type 3 to withdraw money");
						System.out.println("Please type 4 to show history");
						System.out.println("Please type 5 to quit");

						int choice = 0;
						// To avoid InputMismatchException if the input is not int
						choice = App.evoidException(0, 0, "Invalid inpu, please try again", scanner);

						int code;
						int amount = 0;
						
						switch (choice) {

						case 1:
							System.out.println("Your balance is " + account.getBalance() + "€");
							break;
						case 2: // US 1
							System.out.println("What is the amount you want to deposit ?");
							amount = App.evoidException(0, 0, "Invalid inpu, please enter the amount to deposit",
									scanner);
							account.setBalance(amount);
						
							break;
						// To withdraw
						case 3: // US 2
							System.out.println("What is the amount you want to withdraw ?");
							amount = App.evoidException(0, 0, "Invalid inpu, please enter the amount to withdraw",
									scanner);
							// Ask for the access code
							System.out.println("Please enter your access code again");
							code = App.evoidException(0, 1, "Invalid input, please enter the correct acess code",
									scanner);

							if (account.getOwner().getAccessCode() == code) {
								account.withdraw(amount);
							}
							
							break;
						// To show history
						case 4: // US 3
							System.out.println("History :");
							for (History history1 : account.getHistory()) {
								System.out.println(history1);
							}

							break;
						// To quit
						case 5:

							System.out.println("Logout successful\r\n" + "see you soon");
							System.out.println("*******************************************");
							
							quit = true;

							break;

						}
					}
					return account;
				} else {

					System.out.println("Please enter the correct credentials");
					System.out.println("*******************************************");

				}
			}

		}
		return null;
	}
  
}
