/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**This class simulate the system of a public ATM machine
 *
 * @author jannalomibao
 */
public class ATM {
    static HashMap<Integer, String> accNumPinCheqmapp = new HashMap<>();
     static HashMap<Integer, String> accNumPinSavingmapp = new HashMap<>();

     static ArrayList <Account>accountList = new ArrayList<>();
     
     static int currentAccNum;
     static String currentPinNum;
     static Account currentAcc;
     static double currentDesiredAmount;
     /**
      * This method calls different method to perform a withdraw transaction
      * @return This returns true if every steps are meet and false if  one of the condition is violated
      * @throws inputWithdrawInvalidException 
      */
     
  
    static boolean withdrawTransaction() {
        //boolean result = false;
        
            if ( TransactionHandler.isAllowed(currentDesiredAmount) ==  true && currentAcc.withdraw(currentDesiredAmount)==true){
                  writeTransactionSummary(currentAccNum, "Withdraw", currentAcc.getBalance(), currentDesiredAmount, currentAcc.getBalance()-currentDesiredAmount);
                 //if(currentAcc.withdraw(currentDesiredAmount)==true)
                 //Account.accountHelper.displayCurrrentBalance(currentAcc, currentDesiredAmount);
                 //result = true;
                 return true;

             } 
            else
                  return false;
                  
        
    }
    /***
     * This method writes the transaction summary  to a CSV file
     * @param accNum the account number of the current client
     * @param transactionType type of transaction
     * @param previousBalance balance before the transaction
     * @param desiredAmount withdraw amount entered by the client
     * @param currentBalance the new balance of the account
     */
    static void writeTransactionSummary(int accNum,String transactionType, double previousBalance, double desiredAmount, double currentBalance){
        String data [] ={
            LocalDateTime.now().toString(),
            String.valueOf(accNum),
            transactionType,
            String.valueOf(previousBalance),
            String.valueOf(desiredAmount),
            String.valueOf(currentBalance)
        };
          try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            for (String value : data) {
                writer.write(value);
                writer.write(",");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void depositTransaction(){
        
    }
    /***
     * A method that adds the account number paired with pin into a HashMap.
     * @param acc  This holds the account that will be stored.
     */

    public static void addAccNumAndPin(Account acc){
        //accNumPinCheqmapp.put(accNum, pin);
        if(acc instanceof ChequingAccount){
            accNumPinCheqmapp.put(acc.getAccountNumber(),acc.getPin() );
        }
        else if(acc instanceof SavingAccount){
            accNumPinSavingmapp.put(acc.getAccountNumber(), acc.getPin());
        }
        else{
            System.out.println("account not available");
        }
    }
    /***
     * This method  adds the account into an ArrayList.
     * @param acc  This holds the account that will be be stored.
     */
        public static void addToAccountList(Account acc){
        if(acc instanceof ChequingAccount || acc instanceof SavingAccount ){
            accountList.add( acc);
        }
        else{
            //create exceptionhandling 
            System.out.println("account not available");
        }
        }
        /***
         * It is a helper class of ATM class that helps ATM to execute the withdraw transaction.
         */
    public static class TransactionHandler{
        /***
         * This method is used to help the ATM to authenticate the client or the account that the client wish to verify.
         * @param accNum This holds the entered account number.
         * @param pin This holds the entered pin.
         * @param map This holds the certain HashMap. 
         *@return This returns true if the account number and pin matches in the HashMap.
         * 
         */
        public static boolean clientAuthneticator(int accNum, String pin , HashMap<Integer, String> map) {
            
               String CPin = map.get(accNum);
               System.out.println(CPin);
            return  Objects.equals(CPin, pin) == true; 
           
        }
        /***
         * This method is used to verify and get the specific account that is being accessed.
         * @param accNum- This holds the entered account number
         * @return - This returns the account under the account number being entered
         */
        public static Account getAccount(int accNum){

            for (Account acc :accountList)
                if (acc.getAccountNumber() == accNum)
                    return acc;
           
           return null;
        
        }
        /****
         * This method is used to verify if the amount that the client which to retrieve is allowed
         * @param amount This hold the withdraw amount that the client wish to retrieve
         * @return This returns if the amount entered is greater than the restricted amount and less and equal to zero
         * 
         * 
         */
        
        public static boolean isAllowed(double amount ){
            // boolean result = false;
            return (amount < 20000 && amount > 0); // throw new withdrawAmountInvalid("Invalid withdraw amount input (isAllowed)");
            //result = true;
       
           
        }
        
    }
}
