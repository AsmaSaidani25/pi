/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Services.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author saida
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private TextField txtObjet;
    @FXML
    private TextField txtCommentaire;
    @FXML
    private Button btnAjout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddReclamation(ActionEvent event) {
        try{
        String Objet = txtObjet.getText();
        String commenataire = txtCommentaire.getText();

        ReclamationService p = new ReclamationService();
        Reclamation r = new Reclamation(Objet, 67, 3, commenataire);

        p.ajouterReclamation(r);
      FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclamation.fxml"));
      Parent root = loader.load();
      AfficherReclamationController arc = loader.getController();
      arc.setTxtAfficher(p.AfficherReclamation().toString());
      txtObjet.getScene().setRoot(root);
        }catch(IOException ex ){
            System.out.println(ex.getMessage());
        }
    }
    }
    

