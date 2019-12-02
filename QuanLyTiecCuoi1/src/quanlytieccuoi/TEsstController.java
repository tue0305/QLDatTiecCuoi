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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class TEsstController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private Button btThongtin;

    @FXML
    private Button btMonAn;

    @FXML
    private Button btDichVu;

    @FXML
    private Button BtXacNhan;

    @FXML
    private VBox vboxStatus;

    @FXML
    private Label lbStatusMIn;

    @FXML
    private Label lbStatus;
    
    @FXML
    private VBox vboxThongTin;

    @FXML
    private VBox vboxMonAn;

    @FXML
    private VBox VboxDichVu;

    @FXML
    private VBox vboxXacNhan;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

    }    
    @FXML
    private void handleClicks(ActionEvent event){
        
        if(event.getSource() ==btThongtin)
        {
            lbStatusMIn.setText("/home/thongtin");
            lbStatus.setText("Thông tin chung");            
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxThongTin.toFront();
        }
        else
        if(event.getSource() ==btMonAn)
        {
            lbStatusMIn.setText("/home/monan");
            lbStatus.setText("Món ăn");            
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxMonAn.toFront();
            
        }
        else if(event.getSource() ==btDichVu)
        {
            lbStatusMIn.setText("/home/dichvu");
            lbStatus.setText("Dịch vụ");            
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY) ));
            VboxDichVu.toFront();
        }
        else if(event.getSource() ==BtXacNhan)
        {   
            lbStatusMIn.setText("/home/xacnhan");
            lbStatus.setText("Xác nhận");            
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(251, 15, 80), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxXacNhan.toFront();
            
        }
       
    }
       @FXML
   private void ActionBack(javafx.event.ActionEvent event) throws IOException
   {
       
              Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);
       
      
   }
    
}
