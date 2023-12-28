/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

/**
 *This exceptions is used when the entered amount violates the constraints of the ATM and the account
 * @author jannalomibao
 */
public class inputWithdrawInvalidException extends Exception{
    public inputWithdrawInvalidException(String message){
        super(message);
    }
    
}
