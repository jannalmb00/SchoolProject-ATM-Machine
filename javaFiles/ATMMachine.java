/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmmachine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**This simulate a public ATM machine
 *
 * @author jannalomibao
 */
public class ATMMachine extends Application{

    /**This is the main class of this program and the the goals of this is to simulate a public ATM machine
     * 
     */
    //private static Stage theStage;
    public static void main(String[] args) {
        
   
        SavingAccount savingAcc1 = new SavingAccount(4501, 3000, "1119");
       ChequingAccount cheqAcc1= new ChequingAccount(5501, 2000,"2000");
        
       SavingAccount savingAcc2 = new SavingAccount(4502, 150,"0211");
       ChequingAccount cheqAcc2 = new ChequingAccount(5502, 50,"2001");
        
        //clients
        Client cl1 = new Client("Janna", "Lomibao", cheqAcc1, savingAcc1);
        Client cl2 = new Client("Johnny", "Bravo", cheqAcc2, savingAcc2);
        
        ATM.addToAccountList(cheqAcc1);
        ATM.addToAccountList(cheqAcc2);
        ATM.addToAccountList(savingAcc1);
        ATM.addToAccountList(savingAcc2);
        
        ATM.addAccNumAndPin(cheqAcc1);
        ATM.addAccNumAndPin(cheqAcc2);
        ATM.addAccNumAndPin(savingAcc1);
        ATM.addAccNumAndPin(savingAcc2);
        
        
        ChequingAccount testAcc = new ChequingAccount(111, 100, "1500");
        
        launch(args);
     
    } 
    /***
     * This method is an overridden method from 'Application' class 
     * This method initialize the first scene when it is launch
     * @param stage  this parameter will act as a window for our javaFX
     * @throws Exception 
     */

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("sceneInsertCard.fxml"));
       Scene scene = new Scene(root);
       stage.setTitle("ATM Machine");
       stage.setScene(scene);
      // theStage = stage;
       stage.show();
    
    }

   
    
}
