/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

/**This is a ChequingAccount class that extends in Account class
 *
 * @author jannalomibao
 */
public class ChequingAccount extends Account {

    public ChequingAccount(int accountNumber, double balance, String pin) {
        super(accountNumber, balance, pin);
    }

    @Override
    public boolean withdraw(double desiredAmount) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       
                if ( desiredAmount <= balance) {
                    balance -= desiredAmount;
                    System.out.println(desiredAmount + " withdrawn successfully from ChequingAccount.");
                    System.out.println(balance);
                    return true;
                } else 
             return false;
    }
    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
