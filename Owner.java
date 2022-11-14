package kataSG;

import java.util.Scanner;

public class Owner {
	// Account holder information
	private String name;
	private String firstName;
	private String email;
	//In order to count the number of accounts created
	private static Integer accountNumber = 0;
	private int accessCode;
	private Scanner scanner = new Scanner(System.in);

	public Owner() {

	}

	public Owner(String name, String firstName, Integer accountNumber, String email) {
		this.name = name;
		this.firstName = firstName;
		this.firstName = firstName;
		this.email = email;
		//Generate a random access code
		this.accessCode = (int) ((Math.random() * (9999 - 1111)) + 1000);
		accountNumber++;
	}

	// Registration of a new customer
	public Owner createOwner() {
		System.out.println("We Will proceed to the creation of your account");
		System.out.println("Please enter your name");
		this.name = scanner.next();
		System.out.println("Please enter your first name");
		this.firstName = scanner.next();

		do {
			System.out.println("Please enter your email address");
			this.email = scanner.next();
		} while (!(email.matches(".+@.+\\.[a-z]+")));

		// Generate a random secret code between 1000 and 9999
		this.accessCode = (int) ((Math.random() * (9999 - 1000)) + 1000);
		accountNumber++;
		return this;
	}

	public void deleteOwner() {
		accountNumber--;
	}

	public int getAccessCode() {
		return accessCode;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAccountNumber(Integer accountNumb) {
		accountNumber = accountNumb;
	}
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "{" + "name='" + name + '\'' + ", first name='" + firstName + '\'' + ", access code=" + accessCode
				+ ", account numbere=" + accountNumber + '}';
	}
}
