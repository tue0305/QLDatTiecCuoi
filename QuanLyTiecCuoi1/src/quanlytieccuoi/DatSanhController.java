/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Sanh;
import Util.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
    @FXML
    private ComboBox<Sanh> cbSanh;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbSanh.getItems().addAll(Utils.getSanh());
      
     
    }
 
    public void ActionBack(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);

    }
    
}
