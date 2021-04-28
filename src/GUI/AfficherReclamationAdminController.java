/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Tools.MaConnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author saida
 */
public class AfficherReclamationAdminController implements Initializable {

    @FXML
    private HBox hbox;
    @FXML
    private TextField txtRecherche;
    @FXML
    private TableView<Reclamation> tvreclamation1;
    @FXML
    private TableColumn<Reclamation, Integer> colid;
    @FXML
    private TableColumn<Reclamation, String> colobjet;
    @FXML
    private TableColumn<Reclamation, Integer> colidp;
    @FXML
    private TableColumn<Reclamation, Integer> colidm;
    @FXML
    private TableColumn<Reclamation, String> colcom;
   
    ObservableList<Reclamation> listR;
    ObservableList<Reclamation> dataList;
    private Parent Reclamation;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connection con;
        PreparedStatement ste;
        ResultSet rs;
        con = MaConnexion.getinstance().getCnx();
        ObservableList<Reclamation> recllist = FXCollections.observableArrayList();

        try {
            //  PreparedStatement preparedStatement;
            ResultSet resultSet = con.createStatement().executeQuery("select * from reclamation");
            while (resultSet.next()) {
                Reclamation r = new Reclamation(resultSet.getString("objet"), resultSet.getInt("id_patient_id"), resultSet.getInt("id_medecin_id"), resultSet.getString("commentaire"));
                 r.setId(resultSet.getInt("id"));
                recllist.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherReclamationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));

        colobjet.setCellValueFactory(new PropertyValueFactory<>("objet"));
        colidp.setCellValueFactory(new PropertyValueFactory<>("id_patient_id"));
        colidm.setCellValueFactory(new PropertyValueFactory<>("id_medecin_id"));
        colcom.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tvreclamation1.setItems(recllist);
    }    

    @FXML
    private void list(KeyEvent event) {
    }

    @FXML
    private void selectionner(MouseEvent event) {
    }

    @FXML
    private void EnvoyerMail(ActionEvent event) {
    }
    
}
