/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Mail.senMail;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author saida
 */
public class RepondreReclamationController implements Initializable {

    @FXML
    private TextField emailTXFLD;
    @FXML
    private TextField sujetTextField;
    @FXML
    private TextArea messageTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EnvoyerMessage(ActionEvent event) {
       String recepient = emailTXFLD.getText();
       String objet = sujetTextField.getText();
       String text = messageTextField.getText();
        try {
            senMail(recepient,objet,text) ; 
                    } catch (Exception ex) {
            Logger.getLogger(RepondreReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

