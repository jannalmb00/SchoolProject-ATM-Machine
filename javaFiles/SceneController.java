/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmmachine;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**This class holds the method in changing scenes and actions in the JavaFX
 *This class implements Initializable interface
 * @author jannalomibao
 */
public  class SceneController implements Initializable{
     
    @FXML
     TextField accNumbTextField; // login
    @FXML
     TextField  pinCodeTextField; //login
    @FXML
     TextField inputAmountTextField; // amount input
   
    @FXML
     Label warningInputLabel;// warning for invalid amount label
    @FXML
     Label warningLabel; //warning for invalid account 
    
   
     TextField focusedTextField ; 
     Stage stage ;
     Scene scene;
     Parent root;
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }
    /**
     * This method displays the first scene which is the insert card scene
     * This simulates as client insert its card
     * @param e
     * @throws IOException 
     */
    public void goToSceneInsertCard(ActionEvent e) throws IOException{
       root = FXMLLoader.load(getClass().getResource("sceneInsertCard.fxml"));
       stage =(Stage)((Node) e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    /***
     * This method displays the scene where the cleint enters its account number and pin code to log in to its account
     * @param event
     * @throws IOException 
     */
   public void goToSceneClientInputAccNumPin(ActionEvent event) throws IOException{
       root = FXMLLoader.load(getClass().getResource("sceneClientInputAccNumPin.fxml"));
       stage =(Stage)((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
   /**
    * This method displays the option available for the ATM
    * @param e
    * @throws IOException 
    */
   public void goToSceneDisplayMenu(ActionEvent e) throws IOException{
       root = FXMLLoader.load(getClass().getResource("sceneDisplayMenu.fxml"));
       stage =(Stage)((Node) e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
  /**
   * This method displays the scene where the client enters the desired amount for the withdraw transaction
   * @param e
   * @throws IOException 
   */
   public void goToSceneWithdrawTransaction(ActionEvent e) throws IOException{
       root = FXMLLoader.load(getClass().getResource("sceneWithdrawfxml.fxml"));
       stage =(Stage)((Node) e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
   /***
    * This method displays the withdraw receipts after inputting the desired amount 
    * @param e
    * @throws IOException 
    */
   
   public void goToSceneWithdrawReceipt(ActionEvent e) throws IOException {
 
 
       root = FXMLLoader.load(getClass().getResource("sceneReceipt.fxml"));
       stage =(Stage)((Node) e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
       
       Label withdrawAmount = new Label();
       withdrawAmount.setText(String.valueOf(ATM.currentDesiredAmount));
       withdrawAmount.setLayoutX(300);
       withdrawAmount.setLayoutY(163);
       withdrawAmount.setPrefHeight(38);
       withdrawAmount.setPrefWidth(251);
       withdrawAmount.setStyle("-fx-border-color: white;-fx-font-size:18");
       ((AnchorPane) root).getChildren().add(withdrawAmount);
       
       Label newBalance = new Label();
       newBalance.setText(String.valueOf(ATM.currentAcc.getBalance()));
       newBalance.setLayoutX(294);
       newBalance.setLayoutY(244);
       newBalance.setPrefHeight(38);
       newBalance.setPrefWidth(251);
       newBalance.setStyle("-fx-border-color: white;-fx-font-size:18");
       ((AnchorPane) root).getChildren().add(newBalance);
       
   }
   /**
    * This methods displays the option for more transaction
    * @param e
    * @throws IOException 
    */
   public void goToSceneMoreTransaction(ActionEvent e) throws IOException{
       root = FXMLLoader.load(getClass().getResource("sceneMoreTransacton.fxml"));
       stage =(Stage)((Node) e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }
   /**
    * This methods displays the balance of the account entered
    * @param e
    * @throws IOException 
    */
  
   public void goToSceneCheckBalance(ActionEvent e) throws IOException{
       
       
       root = FXMLLoader.load(getClass().getResource("sceneCheckBalance.fxml"));
       stage =(Stage)((Node) e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
       
       Label checkBalanceLabel = new Label();
       checkBalanceLabel.setText(String.valueOf(ATM.currentAcc.getBalance()));
       checkBalanceLabel.setLayoutX(312);
       checkBalanceLabel.setLayoutY(211);
       checkBalanceLabel.setPrefHeight(34);
       checkBalanceLabel.setPrefWidth(114);
       checkBalanceLabel.setStyle("-fx-border-color: white;-fx-font-size:20");
       ((AnchorPane) root).getChildren().add(checkBalanceLabel);
     

   }
   
   
   /**
    * This methods executes the initialization and authentication of the account number and pin entered
    * @param e
    * @throws IOException
    * @throws clientInvalidException 
    */
    @FXML
    private void initializeAccNumberPinCodeButton(ActionEvent e) throws IOException, clientInvalidException{
        //create a customize exception handling
        
        try{
            ATM.currentAccNum = Integer.parseInt(accNumbTextField.getText());
            ATM.currentPinNum = pinCodeTextField.getText();
        
            ATM.currentAcc = ATM.TransactionHandler.getAccount(ATM.currentAccNum);
            if(ATM.currentAcc != null ){
                if(ATM.currentAcc instanceof ChequingAccount){
                    if(ATM.TransactionHandler.clientAuthneticator(ATM.currentAccNum, ATM.currentPinNum, ATM.accNumPinCheqmapp))
                      goToSceneDisplayMenu(e);
                } else if(ATM.currentAcc instanceof SavingAccount){
                    if(ATM.TransactionHandler.clientAuthneticator(ATM.currentAccNum, ATM.currentPinNum, ATM.accNumPinSavingmapp))
                      goToSceneDisplayMenu(e);
                }else
                    throw new clientInvalidException("Type of Account does not exist");
 
            }else {
            throw new clientInvalidException("Invalid account number");
                }
             }catch(NumberFormatException nE){
                 //warningLabel.setText(nE.getMessage());
                 warningLabel.setText("Numbers only");
             }
        catch(Exception ex){
           // Note to self: set the message in a label on the window....
            System.out.println(ex.getMessage());
            warningLabel.setText(ex.getMessage());
            //setClientInputWarningLabel(ex.getMessage());
            
         //showAlert("Invalid input. Please enter a valid number greater than 10.");
           
          }
    }
    /**
     * This method is used when the button is used during the time where the client inputs the account number and pin code
     * @param e 
     */
    @FXML
    private void numberClickedButton(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String buttonText = clickedButton.getText();
        //focusedTextField = accNumbTextField;
       if (focusedTextField != null) {
           if(focusedTextField == accNumbTextField){
               accNumbTextField.appendText(buttonText);
           }
           else if (focusedTextField == pinCodeTextField){
               pinCodeTextField.appendText(buttonText);
           }
        }
       }
    /**
     * This method is used when delete button is used during the time where the client inputs the account number and pin code
     * @param e 
     */
    @FXML
    private void deleteButton(ActionEvent e){
        String numberInserted = focusedTextField.getText();
        if(focusedTextField != null && numberInserted.length() != 0)
             focusedTextField.setText(numberInserted.substring(0, numberInserted.length() - 1));    
            
    }
    /***
     * This method is used when delete button is used during the time where the client inputs the desired amount
     * @param e 
     */
    @FXML
    private void deleteButtonInput(ActionEvent e){
        String numberInserted = inputAmountTextField.getText();
        if(inputAmountTextField != null && numberInserted.length() != 0)
             inputAmountTextField.setText(numberInserted.substring(0, numberInserted.length() - 1));    
            
    }
    /***
     * This method is used when the button is used during the time where the client inputs its desired amount to withdraw
     * @param e
     * @throws IOException 
     */
    @FXML
    private void inputAmountNumberClickedButton(ActionEvent e) throws IOException{
        Button clickedButton = (Button) e.getSource();
        String buttonText = clickedButton.getText();
        if (inputAmountTextField != null){
            inputAmountTextField.appendText(buttonText);
           // System.out.println;
        }
        else 
            System.out.println("Null");
      
    }
    /**
     * This method is used executes the initialization and verification for the withdraw request
     * @param e
     * @throws IOException
     * @throws inputWithdrawInvalidException 
     */
    @FXML
    private void desiredAmountSubmit(ActionEvent e) throws IOException, inputWithdrawInvalidException{
        
        //System.out.println("inout amount text field: "+inputAmountTextField.getText());
        try{
            ATM.currentDesiredAmount = Double.parseDouble(inputAmountTextField.getText());
            
            if(ATM.withdrawTransaction() == true){
         
                goToSceneWithdrawReceipt(e);
   
            }  
            else 
                throw new inputWithdrawInvalidException("Invalid withdraw");
        } catch(NumberFormatException nE){
                 //warningInputLabel.setText(nE.getMessage());
                 warningInputLabel.setText("Numbers only");
             }
        catch(inputWithdrawInvalidException ex){
           
         System.out.println(ex.getMessage());
        
         warningInputLabel.setText(ex.getMessage());

        }
    }
   
    /**
     * This method is used to set the focus of what text field is being clicked during the time when the client input its account number and pin
     * this is dedicated for accNumbTextField
     */
    @FXML
    private void setFocusedAccNumTextField1() {
       focusedTextField = accNumbTextField;
    }
    /**
     * This method is used to set the focus of what text field is being clicked during the time when the client input its account number and pin
     * this is dedicated for pinCodeTextField
     */

    @FXML
    private void setFocusedPinCodeTextField2() {
        focusedTextField = pinCodeTextField;
    }
   

    
 }
    
    

   
    
