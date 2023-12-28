/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

/**This is simulates the client that will accommodate by the ATM
 *
 * @author jannalomibao
 */
public class Client {
     private String firstName;
    private String LastName;
    ChequingAccount chequingAcc;
    SavingAccount savingAcc;
    /***
     * Constructor for the Client class that will initialize the value of fields
     * @param firstName This holds the first name of the client
     * @param LastName This holds the last name of the client
     * @param chequingAcc This holds the chequing account of the client
     * @param savingAcc This holds the saving account of the client
     */

    public Client(String firstName, String LastName, ChequingAccount chequingAcc, SavingAccount savingAcc) {
        this.firstName = firstName;
        this.LastName = LastName;
        this.chequingAcc = chequingAcc;
        this.savingAcc = savingAcc;
    }
    /***
     * A setter method to manipulate the first name indirectly
     * @param firstName  a String type that holds the first name that will be assign in the field first name
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /***
     * A setter method to manipulate the last name indirectly
     * @param LastName  a String type that holds  last name that will be assign in the field last name
     */

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    /***
     * A setter method to manipulate the chequing account indirectly
     * @param chequingAcc  a chequing account type that holds the chequing account
     */

    public void setChequingAcc(ChequingAccount chequingAcc) {
        this.chequingAcc = chequingAcc;
    }
    /***
     * A setter method to manipulate the saving account indirectly
     * @param savingAcc  a saving account type that holds the saving account
     */

    public void setSavingAcc(SavingAccount savingAcc) {
        this.savingAcc = savingAcc;
    }
    /**
     * A getter method to indirectly access the firstName field
     * @return It will return the firstName
     */

    public String getFirstName() {
        return firstName;
    }
    /**
     * A getter method to indirectly access the lastName field
     * @return It will return the lastName
     */

    public String getLastName() {
        return LastName;
    }
    /**
     * A getter method to indirectly access the chequing account field
     * @return It will return the chequing account
     */

    public ChequingAccount getChequingAcc() {
        return chequingAcc;
    }
    /**
     * A getter method to indirectly access the saving account field
     * @return It will return the saving account
     */

    public SavingAccount getSavingAcc() {
        return savingAcc;
    }
}
