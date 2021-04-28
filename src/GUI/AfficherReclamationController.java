/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Reclamation;
import Services.ReclamationService;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author saida
 */
public class AfficherReclamationController implements Initializable {
 private static int idReclamation;
    @FXML
    private TextField txtAfficher;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableView<Reclamation> tvreclamation;
    @FXML
    private TableColumn<Reclamation, String> colobjet;
    @FXML
    private TableColumn<Reclamation, Integer> colidp;
    @FXML
    private TableColumn<Reclamation, Integer> colidm;
    @FXML
    private TableColumn<Reclamation, String> colcom;
    @FXML
    private TableColumn<Reclamation, Integer> colid;
    @FXML
    private TextField objet;
    @FXML
    private TextArea commentaire;

    
    /**
     * Initializes the controller class.
     */
            ObservableList<Reclamation> recllist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection con;
        PreparedStatement ste;
        ResultSet rs;
        con = MaConnexion.getinstance().getCnx();

        try {
            //  PreparedStatement preparedStatement;
            ResultSet resultSet = con.createStatement().executeQuery("select * from reclamation where id_patient_id = 67");
            while (resultSet.next()) {
                Reclamation r = new Reclamation(resultSet.getString("objet"), resultSet.getInt("id_patient_id"), resultSet.getInt("id_medecin_id"), resultSet.getString("commentaire"));
                 r.setId(resultSet.getInt("id"));
                recllist.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));

        colobjet.setCellValueFactory(new PropertyValueFactory<>("objet"));
        colidp.setCellValueFactory(new PropertyValueFactory<>("id_patient_id"));
        colidm.setCellValueFactory(new PropertyValueFactory<>("id_medecin_id"));
        colcom.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tvreclamation.setItems(recllist);
    }
    private void Refrech(){
        recllist.clear();
            Connection con;
        PreparedStatement ste;
        ResultSet rs;
        con = MaConnexion.getinstance().getCnx();

        try {
            //  PreparedStatement preparedStatement;
            ResultSet resultSet = con.createStatement().executeQuery("select * from reclamation");
            while (resultSet.next()) {
                Reclamation r = new Reclamation(resultSet.getString("objet"), resultSet.getInt("id_patient_id"), resultSet.getInt("id_medecin_id"), resultSet.getString("commentaire"));
                 r.setId(resultSet.getInt("id"));
                recllist.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));

        colobjet.setCellValueFactory(new PropertyValueFactory<>("objet"));
        colidp.setCellValueFactory(new PropertyValueFactory<>("id_patient_id"));
        colidm.setCellValueFactory(new PropertyValueFactory<>("id_medecin_id"));
        colcom.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tvreclamation.setItems(recllist);
    }

    @FXML
    private void UpdateReclamation(ActionEvent event) throws SQLException {
         Connection con;
        PreparedStatement ste;
        ResultSet rs;
        con = MaConnexion.getinstance().getCnx();
         Reclamation r = (Reclamation) tvreclamation.getSelectionModel().getSelectedItem();
        //System.out.println("R.getId() = " + r.getId());
        int id =r.getId();
                    ResultSet resultSet = con.createStatement().executeQuery("select * from reclamation");
 objet.getText();
      commentaire.getText();
      Reclamation r1 = new Reclamation(r.getId(), objet.getText(),commentaire.getText());
ReclamationService rsa = new ReclamationService();
rsa.modifierReclamation(r1);
Refrech();
         
        
        
    }

    @FXML
    private void selectionner(MouseEvent event) {
        Reclamation r = (Reclamation) tvreclamation.getSelectionModel().getSelectedItem();
        System.out.println("R.getId() = " + r.getId());
       int  index = tvreclamation.getSelectionModel().getSelectedIndex();

        AfficherReclamationController.idReclamation = r.getId();
        System.out.println(AfficherReclamationController.idReclamation);
       // String objet = tvreclamation.get
  objet.setText(colobjet.getCellData(index));
    commentaire.setText(colcom.getCellData(index));

    }

    @FXML
    private void DeleteReclamation1(ActionEvent event) {
        ReclamationService rs = new ReclamationService();
        System.out.println("id reclamation =" + AfficherReclamationController.idReclamation);
        rs.supprimerReclamation(AfficherReclamationController.idReclamation);
        
        
    }
    public void setTxtAfficher(String txtAfficher) {
        this.txtAfficher.setText(txtAfficher);
    }
    
    
    }
