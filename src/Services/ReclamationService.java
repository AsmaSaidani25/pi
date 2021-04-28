
package Services;

import Entities.Reclamation;
import Tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReclamationService {
      private Connection cnx;  
   private PreparedStatement ste;
   private  ResultSet rs;

   public ReclamationService(){
       cnx = MaConnexion.getinstance().getCnx();
    
}
   public void ajouterReclamation(Reclamation r){
       try {
           String sql = "insert into reclamation(objet,id_patient_id,id_medecin_id,commentaire,etat)"+"values(?,?,?,?,0)";
           ste = cnx.prepareStatement(sql);
           ste.setString(1, r.getObjet());
           ste.setInt(2, r.getId_patient_id());
           ste.setInt(3, r.getId_medecin_id());
           ste.setString(4, r.getCommentaire());
           ste.executeUpdate();
           ste.close();
           System.out.println("Reclamation Ajoutée");
       } catch (SQLException ex) {
         System.out.println(ex.getMessage());
       }
}
       
public void modifierReclamation(Reclamation r) {
       
       try{
        String sql2="UPDATE reclamation SET objet=?,commentaire=?  WHERE id=?";
            
           PreparedStatement  ste  = cnx.prepareStatement(sql2);
            ste.setString(1, r.getObjet());
            ste.setString(2,r.getCommentaire());
            ste.setInt(3, r.getId());
            
            ste.executeUpdate();
            ste.close();
            System.out.println("Reclamation Modifiée");

            
       }catch (SQLException ex) {
           Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
}



// showReclamations();
 public List<Reclamation> readAll() throws SQLException {
        List<Reclamation> Reclamations = new ArrayList<>();
        String sql ="select * from reclamation  R ";
               

         try {
           
	    PreparedStatement ste= cnx.prepareStatement(sql);
	    ResultSet res= ste.executeQuery();
            

     while (res.next()) {   
         
              
               System.out.println("Objet  = "+res.getString("objet") );
               System.out.println("Commentaire  = "+res.getString("commentaire") );
     }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
            
        }
       
         
         return Reclamations;
     
    }
 //Supprimer Anas 
  public void supprimerReclamation(int id) {
        String query = "DELETE from Reclamation where id= " + "'" + id + "'";
        try {
            Statement s = cnx.createStatement();
            s.executeUpdate(query);
            System.out.println("Reclamation Supprimée de la base ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

   
   public void supprimer(int p) {
       
         try {
              String req2 =
                      "delete from reclamation where id=?";    
             
              PreparedStatement ps = 
                      cnx.prepareStatement(req2);
              ps.setInt(1, p);
              ps.executeUpdate();
           
          } catch (SQLException ex) {
              System.out.println(ex);
          }
    }

   
   
    public Object AfficherReclamation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
