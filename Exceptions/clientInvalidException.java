/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

/**This exception extends to exception and is used when client encountered during the authentication process
 *
 * @author jannalomibao
 */
public class clientInvalidException extends Exception {
    public clientInvalidException(String message){
        super(message);
    }
    public clientInvalidException (Throwable cause){
        super(cause);
        System.out.println("");
        
    }
}
