/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cohotech
 */
public class MainMenuController implements Initializable {

    /**
     * Initializes the controller class.
        */
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
       
    }    
     public void ActionExit(ActionEvent event){
         Platform.exit();
         System.exit(0);
         
        }
   @FXML
   private void ActionSignOut(javafx.event.ActionEvent event) throws IOException
   {
       
               Parent blah = FXMLLoader.load(getClass().getResource("DangNhap.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
       
      
   }
    @FXML
   private void ActionDatSanh(javafx.event.ActionEvent event) throws IOException
   {
       
               Parent blah = FXMLLoader.load(getClass().getResource("DatSanh.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
       
      
   }
    @FXML
   private void ActionTraCuu(javafx.event.ActionEvent event) throws IOException
   {
       
               Parent blah = FXMLLoader.load(getClass().getResource("TraCuu.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
       
      
   }
    @FXML
   private void ActionThanhToan(javafx.event.ActionEvent event) throws IOException
   {
       
               Parent blah = FXMLLoader.load(getClass().getResource("HoaDonThanhToan.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
       
      
   }
   @FXML
   private void ActionBaoCao(javafx.event.ActionEvent event) throws IOException
   {
       
               Parent blah = FXMLLoader.load(getClass().getResource("LapBaoCao.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
       
      
   }
 
    
}
