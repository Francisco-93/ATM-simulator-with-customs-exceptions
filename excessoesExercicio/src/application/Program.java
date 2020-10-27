package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.NoBalanceException;
import model.exceptions.WithdrawLimitException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.println("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			acc.withdraw(sc.nextDouble());
			System.out.print("New Balance: " + acc.getBalance());			
		}
		catch(NoBalanceException e) {
			System.out.println(e.getMessage());
		}
		catch (WithdrawLimitException e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();			
		}
	}
}
