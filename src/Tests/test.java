/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Entities.Reclamation;
import Services.ReclamationService;
import Tools.MaConnexion;
import java.sql.SQLException;

/**
 *
 * @author saida
 */
public class test {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws SQLException {
       MaConnexion cm = MaConnexion.getinstance();
       Reclamation re = new Reclamation("",71,2,"Trés Mauvaise");
       ReclamationService rs = new ReclamationService();
     // rs.ajouterReclamation(re);
      //rs.readAll();
   // int p=7;
            // rs.supprimer(p);
                    Reclamation rm = new Reclamation("",71,2,"trés Mauvaise");

     rs.modifierReclamation(rm);
      
    }
    
    }
    
