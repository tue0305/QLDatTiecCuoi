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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author cohotech
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button btNameUser;

    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        btNameUser.setText(Utils.getUsernameText());
       
        

    }
    
//   

    @FXML
    private void ActionSignOut(javafx.event.ActionEvent event) throws IOException {

      
        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DangNhap.fxml")));
        Utils.switchStage(sce, event);

    }

      @FXML
    private void ActionMouseDatSanh(MouseEvent event) throws IOException {
        
          Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DatTiec.fxml")));
          Utils.switchStageMouseClick(sce, event);
    }

      @FXML
    private void ActionMouseTraCuu(MouseEvent event) throws IOException {
        
          Scene sce = new Scene(FXMLLoader.load(getClass().getResource("TraCuuVaThanhToan.fxml")));
          Utils.switchStageMouseClick(sce, event);
    }


    @FXML
    private void ActionMouseBaoCao(MouseEvent event) throws IOException {
        
          Scene sce = new Scene(FXMLLoader.load(getClass().getResource("LapBaoCao.fxml")));
          Utils.switchStageMouseClick(sce, event);
    }

     @FXML
    private void ActionMouseSanh(MouseEvent event) throws IOException {
        
          Scene sce = new Scene(FXMLLoader.load(getClass().getResource("Sanh.fxml")));
          Utils.switchStageMouseClick(sce, event);
    }
    
    @FXML
    private void ActionMouseDichVu(MouseEvent event) throws IOException {
        
          Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DichVu.fxml")));
          Utils.switchStageMouseClick(sce, event);
    }
    @FXML
    private void ActionMouseThucPham(MouseEvent event) throws IOException {
        
          Scene sce = new Scene(FXMLLoader.load(getClass().getResource("ThucPham.fxml")));
          Utils.switchStageMouseClick(sce, event);
    }


}
