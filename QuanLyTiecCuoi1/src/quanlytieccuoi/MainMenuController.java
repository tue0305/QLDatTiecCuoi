/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import Util.Utils;
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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cohotech
 */
public class MainMenuController implements Initializable {

     @FXML
    private Button btNameUer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    
//     public void setNameUser(){
//   
//         btNameUer.setText();
//         
//     }

//    public void ActionExit(ActionEvent event) {
//        Platform.exit();
//        System.exit(0);
//
//    }

    @FXML
    private void ActionSignOut(javafx.event.ActionEvent event) throws IOException {

      
        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DangNhap.fxml")));
        Utils.switchStage(sce, event);

    }

    @FXML
    private void ActionDatSanh(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DatSanh.fxml")));
        Utils.switchStage(sce, event);
    }

    @FXML
    private void ActionTraCuu(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("TraCuu.fxml")));
        Utils.switchStage(sce, event);
    }

    @FXML
    private void ActionThanhToan(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("HoaDonThanhToan.fxml")));
        Utils.switchStage(sce, event);

    }

    @FXML
    private void ActionBaoCao(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("LapBaoCao.fxml")));
        Utils.switchStage(sce, event);

    }

    @FXML
    private void ActionQLSanh(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("Sanh.fxml")));
        Utils.switchStage(sce, event);

    }
    
    @FXML
    private void ActionQLDichVu(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DichVu.fxml")));
        Utils.switchStage(sce, event);

    }
  
    @FXML
    private void ActionMouseDatSanh(MouseEvent event) throws IOException {
        
            Parent blah = FXMLLoader.load(getClass().getResource("DatSanh.fxml"));
               Scene scene = new Scene(blah);
               Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               appStage.hide();
               appStage.setScene(scene);
               appStage.show();
      

    }
}
