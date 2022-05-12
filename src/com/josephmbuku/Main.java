package com.josephmbuku;

import java.util.Scanner;

// Person Class
class Person {
    public String person1Name = "Wanjiru";
    public Double person1AccBal = 0.0;
    public String person2Name = "Juma";
    public Double person2AccBal = 0.0;
    public String person3Name = "Linda";
    public Double person3AccBal = 0.0;

    public void personNames() {
        System.out.println("Person 1: -> "+ person1Name + " : " + "Starting Balance is: -> "+person1AccBal );
        System.out.println("Person 2: -> "+ person2Name + " : " + "Starting Balance is: -> "+person2AccBal );
        System.out.println("Person 3: -> "+ person3Name + " : " + "Starting Balance is: -> "+person3AccBal );
    }
}

class BankTransactions extends Person{
    Person person = new Person();
    double person1AccVal = person.person1AccBal;
    double person2AccVal = person.person1AccBal;
    double person3AccVal = person.person1AccBal;


    // Deposit Function
    public void depositFunction() {
        Scanner depositInputValue = new Scanner(System.in);

        System.out.println("Deposit To: 1) " + person.person1Name+ " 2) "+ person.person2Name + " 3) "+person.person3Name);
        int depositChoice = depositInputValue.nextInt();

        System.out.println("Enter Amount you wish to Deposit for this person: " + depositChoice);

        // Deposit to Person 1
        if (depositChoice == 1) {
            System.out.println("Amount: ");
            double depositAmount = depositInputValue.nextDouble();

            person1AccVal += depositAmount;
            System.out.println(person.person1Name + " Balance is: "+ person1AccVal);
        }

        // Deposit to Person 2
        else if (depositChoice == 2) {
            System.out.println("Amount: ");
            double depositAmount = depositInputValue.nextDouble();

            person2AccVal += depositAmount;
            System.out.println(person.person2Name + " Balance is: "+ person2AccVal);
        }

        // Deposit to Person 3
        else if (depositChoice == 3) {
            System.out.println("Amount ");
            double depositAmount = depositInputValue.nextDouble();

            person3AccVal += depositAmount;
            System.out.println(person.person3Name + " Balance is: "+ person3AccVal);
        }

        else {
            System.out.println("Unknown Person's Account Number: ");
            depositInputValue.close();
            return;
        }
    }

    // Withdraw Function
    public void withdrawFunction() {
        Scanner withdrawInputValue = new Scanner(System.in);

        System.out.println("Withdraw from: 1) " + person.person1Name+ " 2) "+ person.person2Name + " 3) "+person.person3Name);
        int personsAccount = withdrawInputValue.nextInt();

        // Withdraw from the First Person
        if (personsAccount == 1) {
            System.out.println("Amount: ");
            double amountToWithdraw = withdrawInputValue.nextDouble();

            if (person1AccVal - amountToWithdraw < 0) {
                System.out.println("Withdraw Amount Exceeds " + person.person1Name + " Balance");
                withdrawInputValue.close();
            }
            person1AccVal -= amountToWithdraw;
        }

        // Withdraw from Second Person
        else if (personsAccount == 2) {
            System.out.println("Amount: ");
            double amountToWithdraw = withdrawInputValue.nextDouble();

            if (person2AccVal - amountToWithdraw < 0) {
                System.out.println("Withdraw Amount Exceeds " + person.person2Name+ " Balance");
                withdrawInputValue.close();
            }
            person2AccVal -= amountToWithdraw;
        }

        // Withdraw from Third Person
        else if (personsAccount == 3) {
            System.out.println("Amount: ");
            double amountToWithdraw = withdrawInputValue.nextDouble();

            if (person3AccVal - amountToWithdraw < 0) {
                System.out.println("Withdraw Amount Exceeds " + person.person3Name + " Balance");

                withdrawInputValue.close();
            }
            person3AccVal -= amountToWithdraw;
        }

        else {
            System.out.println("Unknown Person's Account Number: ");
            withdrawInputValue.close();
            return;
        }
    }

    // Transfer Function
    public void transferFunction() {
        Scanner transferInputValue = new Scanner(System.in);

        System.out.println("Deposit To: 1) " + person.person1Name+ " 2) "+ person.person2Name + " 3) "+person.person3Name);
        int fromChoice = transferInputValue.nextInt();

        System.out.println("Transfer To: 1) Wanjiru, 2) Juma, 3)Linda");
        int toChoice = transferInputValue.nextInt();

        if (fromChoice == toChoice) {
            System.out.println("You cannot transfer to the same account number");
            transferInputValue.close();
        }

        // Wanjiru to Juma or Linda
        else if (fromChoice == 1) {
            System.out.println("Amount: ");
            double transferAmount = transferInputValue.nextDouble();

            if (person1AccVal - transferAmount < 0 ){
                System.out.println("Transfer amount exceeds Wanjiru's account balance");
                transferInputValue.close();
            }
            person1AccVal-=transferAmount;

            // transfer to Juma
            if (toChoice == 2) {
                person2AccVal += transferAmount;
                System.out.println("Juma's Account credited with Amount: " +transferAmount + "Juma's Balance is: " +person2AccVal);
            }

            // transfer to Linda
            else if (toChoice == 3) {
                person3AccVal += transferAmount;
                System.out.println("Linda's Account credited with Amount: " +transferAmount + "Linda's Balance is: " +person3AccVal);
            }
        }

        // Juma to Wanjiru or Linda
        else if (fromChoice == 2) {
            System.out.println("Amount: ");
            double transferAmount = transferInputValue.nextDouble();

            if (person2AccVal - transferAmount < 0 ){
                System.out.println("Transfer amount exceeds Juma's account balance");
                transferInputValue.close();
            }
            person2AccVal-=transferAmount;

            // Transfer to Wanjiru.
            if (toChoice == 1) {
                person3AccVal += transferAmount;
                System.out.println("Wanjiru's Account credited with Amount: " +transferAmount + "Wanjiru's Balance is: " +person3AccVal);
            }

            // Transfer to Linda
            else if (toChoice == 3) {
                person3AccVal += transferAmount;
                System.out.println("Linda's Account credited with Amount: " +transferAmount + "Linda's Balance is: " +person3AccVal);
            }
        }

        // Linda to Juma or Wanjiru
        else if (fromChoice == 3) {
            System.out.println("Amount: ");
            double transferAmount = transferInputValue.nextDouble();

            if (person3AccVal - transferAmount < 0 ){
                System.out.println("Transfer amount exceeds Linda's account balance");
                transferInputValue.close();
            }
            person3AccVal-=transferAmount;

            // Transfer to Wanjiru.
            if (toChoice == 1) {
                person1AccVal += transferAmount;
                System.out.println("Wanjiru's Account credited with Amount: " +transferAmount + "Wanjiru's Balance is: " +person1AccVal);
            }

            // Transfer to Juma
            else if (toChoice == 2) {
                person2AccVal += transferAmount;
                System.out.println("Juma's Account credited with Amount: " +transferAmount + "Juma's Balance is: " +person2AccVal);
            }
        }

        else {
            System.out.println("Unknown Accounts Chosen:");
            transferInputValue.close();;
        }
    }

    // Running Transactions:
    public void selectTransaction() {
        System.out.println("Select Transaction: 1) Deposit 2) Withdraw 3) Transfer");

        Scanner transactionInputValue = new Scanner(System.in);
        int transactionChoice = transactionInputValue.nextInt(); // Chose Transaction Type.

        // Deposit Function
        if (transactionChoice == 1) {
            depositFunction();
        }

        // Withdraw Function
        else if (transactionChoice == 2) {
            withdrawFunction();
        }

        // Transfer Function
        else if (transactionChoice == 3) {
            transferFunction();
        }

    }
}

public class Main extends Person{
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       // Person Object
       Person person = new Person();

       // BankTransaction Object
       BankTransactions bankTransactions = new BankTransactions();

       // Display Person Names and Initial Balances
       person.personNames();

       // Select Transactions
       bankTransactions.selectTransaction();

       System.out.println("Do you Another Transaction? Type -> True, Or -> False: ");
       boolean anotherTransactionChoice = input.nextBoolean();

       if (anotherTransactionChoice == true) {
//           System.out.println("You Chose Another Transaction");
           bankTransactions.selectTransaction();
       }
       else if (anotherTransactionChoice == false){
//            System.out.println("You do Not want another Transaction");
           input.close();
       }




   }
}
