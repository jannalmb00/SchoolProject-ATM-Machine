/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

/** This is a abstract class that serves as a blueprint to SavingAccount class and ChequingAccount class
 *
 * @author jannalomibao
 */
public abstract class Account {
    private int accountNumber;
    /***
     * This field holds the balance of the class object
     */
    protected double balance;
    private String pin;
    
    /***
     * Constructor for Account that has three parameters
     * @param accountNumber- an int type that is unique to every instance of this class
     * @param balance a double type for the balance of a specific Account
     * @param pin- pin a String type that acts as a password  of a specific Account
     */

    public Account(int accountNumber, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }
    /***
     * A getter method to indirectly access the pin of an account
     * @return It returns String type pin
     */

    public String getPin() {
        return pin;
    }
    /***
     * A setter method to manipulate the pin indirectly
     * @param pin  a String type that holds  an pin that will be assign in the field pin
     */

    public void setPin(String pin) {
        this.pin = pin;
    }
    /***
     * A getter method to indirectly access the account number of an account
     * @return It returns int type account number
     */

    public int getAccountNumber() {
        return accountNumber;
    }
    /***
     * A setter method to manipulate the account number indirectly
     * @param accountNumber  a int type that holds  an account number that will be assign in the field account number
     */

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    /***
     * A getter method to indirectly access the balance of an account
     * @return It returns double type balance
     */

    public double getBalance() {
        return balance;
    }
    /***
     * A setter method to manipulate the balance indirectly
     * @param balance  a double type that holds  an balance that will be assign in the field account number
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /***
     * An abstract method used to identify and perform the withdraw operation 
     * @param desiredAmount - a double type that holds the withdraw amount 
     * @return   This method returns true if the operation is succesfully executed
     */
    public abstract boolean withdraw( double desiredAmount);
    /***
     * An abstract method used to perform a deposit transaction for an account
     * @param amount  A double type that holds the 
     */
    public abstract void deposit(double amount);
    
    
    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }
    /***
     * This is a class inside the Account class that serves as a place for methods that can help the Account class
     */
    public class  accountHelper{
        /***
         * This class is used to comprehensively display the current balance of the Account in the console
         * @param account this parameter holds the account that its current balance will be displayed
         * @param amount this parameter holds the withdraw amount
         */
       public static void displayCurrentBalance(Account account, double amount) {
           
        double remainingBalance = account.getBalance();
        System.out.println("Withdrawn: " + amount);
        System.out.println("Remaining balance: " + remainingBalance);
    }  
        
        
    }
    
}
