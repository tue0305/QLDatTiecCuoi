/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @author ThanhDepTrai
 */
public class DatSanhController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
       @FXML
   private void ActionBack(javafx.event.ActionEvent event) throws IOException
   {
       
               Parent blah = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
       
      
   }
    
}
