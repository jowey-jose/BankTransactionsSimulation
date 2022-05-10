package com.josephmbuku;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner inputValue = new Scanner (System.in); // New Scanner Object To allow user Enter amount to deposit.

    // Ask for Initial Balance
        System.out.println("Wanjiru's Initial Balance? ");
        double wanjiruAccBal = inputValue.nextDouble();
        System.out.println("Juma's Initial Balance? ");
        double jumaAccBal = inputValue.nextDouble();
        System.out.println("Linda's Initial Balance? ");
        double lindaAccBal = inputValue.nextDouble();

    // Check Account Balances Not Less than 0 or Negative Balance
        if (wanjiruAccBal < 0 || jumaAccBal < 0 || lindaAccBal < 0) {
            System.out.println("Initial Balance Should Be 0 and Above.");
            inputValue.close();
            return;
        }

    // Ask for transaction
        System.out.println("Choose an Operation: 1) Deposit, 2) Withdraw, 3) Transfer: ");
        int transactionChoice = inputValue.nextInt(); // Read Integer Value
        System.out.println("You Chose Transaction Choice: " + transactionChoice );

        // Deposit Function
        if (transactionChoice == 1) {
            System.out.println("Deposit to: 1)Wanjiru, 2)Juma, 3)Linda ");
            int personsAccount = inputValue.nextInt();

            System.out.println("Enter Amount you wish to Deposit for this person: " +personsAccount);

            if (personsAccount == 1) {
                System.out.println("Amount: ");
                double amountDeposited = inputValue.nextDouble();
                wanjiruAccBal += amountDeposited;
            }

            else if (personsAccount == 2) {
                System.out.println("Amount: ");
                double amountDeposited = inputValue.nextDouble();
                jumaAccBal += amountDeposited;
            }

            else if (personsAccount == 3) {
                System.out.println("Amount ");
                double amountDeposited = inputValue.nextDouble();
                lindaAccBal += amountDeposited;
            }

            else {
                System.out.println("Unknown Person's Account Number: ");
                inputValue.close();
                return;
            }
        }

        // Withdraw Function
        else if (transactionChoice == 2) {
            System.out.println("Withdraw from: 1) Wanjiru, 2) Juma, 3) Linda ");
            int personsAccount = inputValue.nextInt();

            if (personsAccount == 1) {
                System.out.println("Amount: ");
                double amountToWithdraw = inputValue.nextDouble();
                if (wanjiruAccBal - amountToWithdraw < 0) {
                    System.out.println("Withdraw Amount Exceeds Wanjiru's Balance");
                    inputValue.close();
                    return;
                }
                wanjiruAccBal -= amountToWithdraw;
            }

            else if (personsAccount == 2) {
                System.out.println("Amount: ");
                double amountToWithdraw = inputValue.nextDouble();
                if (jumaAccBal - amountToWithdraw < 0) {
                    System.out.println("Withdraw Amount Exceeds Juma's Balance");
                    inputValue.close();
                    return;
                }
                jumaAccBal -= amountToWithdraw;
            }

            else if (personsAccount == 3) {
                System.out.println("Amount: ");
                double amountToWithdraw = inputValue.nextDouble();
                if (lindaAccBal - amountToWithdraw < 0) {
                    System.out.println("Withdraw Amount Exceeds Linda's Balance");
                    inputValue.close();
                    return;
                }
                lindaAccBal -= amountToWithdraw;
            }

            else {
                System.out.println("Unknown Person's Account Number: ");
                inputValue.close();
                return;
            }
        }

        // Transfer Function
        else if (transactionChoice == 3) {
            System.out.println("Transfer From: 1) Wanjiru, 2) Juma, 3)Linda");
            int fromChoice = inputValue.nextInt();

            System.out.println("Transfer To: 1) Wanjiru, 2) Juma, 3)Linda");
            int toChoice = inputValue.nextInt();

            if (fromChoice == toChoice) {
                System.out.println("You cannot transfer to the same account number");
                inputValue.close();
                return;
            }

            // Wanjiru to Juma or Linda
            else if (fromChoice == 1) {
                System.out.println("Amount: ");
                double transferAmount = inputValue.nextDouble();

                if (wanjiruAccBal - transferAmount < 0 ){
                    System.out.println("Transfer amount exceeds Wanjiru's account balance");
                    inputValue.close();
                    return;
                }
                wanjiruAccBal-=transferAmount;

                // transfer to Juma
                if (toChoice == 2) {
                    jumaAccBal += transferAmount;
                    System.out.println("Juma's Account credited with Amount: " +transferAmount + "Juma's Balance is: " +jumaAccBal);
                }

                // transfer to Linda
                else if (toChoice == 3) {
                    lindaAccBal += transferAmount;
                    System.out.println("Linda's Account credited with Amount: " +transferAmount + "Linda's Balance is: " +lindaAccBal);
                }
            }

            // Juma to Wanjiru or Linda
            else if (fromChoice == 2) {
                System.out.println("Amount: ");
                double transferAmount = inputValue.nextDouble();

                if (jumaAccBal - transferAmount < 0 ){
                    System.out.println("Transfer amount exceeds Juma's account balance");
                    inputValue.close();
                    return;
                }
                jumaAccBal-=transferAmount;

                // Transfer to Wanjiru.
                if (toChoice == 1) {
                    wanjiruAccBal += transferAmount;
                    System.out.println("Wanjiru's Account credited with Amount: " +transferAmount + "Wanjiru's Balance is: " +wanjiruAccBal);
                }

                // Transfer to Linda
                else if (toChoice == 3) {
                    lindaAccBal += transferAmount;
                    System.out.println("Linda's Account credited with Amount: " +transferAmount + "Linda's Balance is: " +lindaAccBal);
                }
            }

            // Linda to Juma or Wanjiru
            else if (fromChoice == 3) {
                System.out.println("Amount: ");
                double transferAmount = inputValue.nextDouble();

                if (lindaAccBal - transferAmount < 0 ){
                    System.out.println("Transfer amount exceeds Linda's account balance");
                    inputValue.close();
                    return;
                }
                lindaAccBal-=transferAmount;

                // Transfer to Wanjiru.
                if (toChoice == 1) {
                    wanjiruAccBal += transferAmount;
                    System.out.println("Wanjiru's Account credited with Amount: " +transferAmount + "Wanjiru's Balance is: " +wanjiruAccBal);
                }

                // Transfer to Juma
                else if (toChoice == 2) {
                    jumaAccBal += transferAmount;
                    System.out.println("Juma's Account credited with Amount: " +transferAmount + "Juma's Balance is: " +jumaAccBal);
                }
            }

            else {
                System.out.println("Unknown Accounts Chosen:");
                inputValue.close();;
                return;
            }

        }

        else {
            System.out.println("Invalid Transaction Choice");
            inputValue.close();
            return;
        }

        inputValue.close();
        System.out.println("Wanjiru's New Balance is: "+ wanjiruAccBal);
        System.out.println("Juma's New Balance is: "+ jumaAccBal);
        System.out.println("Linda's New Balance is: "+ lindaAccBal);

    }
}
