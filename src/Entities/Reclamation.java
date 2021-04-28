/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author saida
 */
public class Reclamation {
     private int id;
    private String objet;
    private int id_patient_id;
    private int id_medecin_id;
    private String commentaire;
    private int etat; 

    public Reclamation(int id, String objet, int id_patient_id, int id_medecin_id, String commentaire) {
        this.id = id;
        this.objet = objet;
        this.id_patient_id = id_patient_id;
        this.id_medecin_id = id_medecin_id;
        this.commentaire = commentaire;
    }

    public Reclamation(String objet, int id_patient_id, int id_medecin_id, String commentaire) {
        this.objet = objet;
        this.id_patient_id = id_patient_id;
        this.id_medecin_id = id_medecin_id;
        this.commentaire = commentaire;
    }
  public Reclamation( int id, String objet, String commentaire) {
        this.id = id;
        this.objet = objet;
        this.commentaire = commentaire;
    }

    public Reclamation() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public int getId_patient_id() {
        return id_patient_id;
    }

    public void setId_patient_id(int id_patient_id) {
        this.id_patient_id = id_patient_id;
    }

    public int getId_medecin_id() {
        return id_medecin_id;
    }

    public void setId_medecin_id(int id_medecin_id) {
        this.id_medecin_id = id_medecin_id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", objet=" + objet + ", id_patient_id=" + id_patient_id + ", id_medecin_id=" + id_medecin_id + ", commentaire=" + commentaire + ", etat=" + etat + '}';
    }
   
}
