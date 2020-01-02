/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import Util.Utils;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author cohotech
 */
public class DangNhapController implements Initializable {

    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField pfPassword;
    @FXML
    private JFXTextField textField;
   @FXML
   private FontAwesomeIcon fontAWESOME;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.pfPassword.textProperty().addListener(et -> {
            textField.setText(pfPassword.getText());
        });
        
   
    }


    public void showPW(MouseEvent e) {
        if (pfPassword.isVisible()) {
            textField.setText(pfPassword.getText());
            textField.setVisible(true);
            pfPassword.setVisible(false);
            fontAWESOME.setIconName("EYE_SLASH");
                    
   
        } else {
            pfPassword.setText(textField.getText());
            pfPassword.setVisible(true);
            textField.setVisible(false);
            fontAWESOME.setIconName("EYE");
        }
        

    }

    @FXML
    public void Login(ActionEvent event) throws IOException {
//
        String u = txtUsername.getText();
        String p = pfPassword.getText();

        try {
            if (u.isEmpty()) {
                Utils.getAlertTC("Tài khoản trống!!!", Alert.AlertType.ERROR).showAndWait();

            } else if (p.isEmpty()) {
            Utils.getAlertTC("Mật khẩu trống!!!", Alert.AlertType.ERROR).showAndWait();
              

                //Hàm kiểm tra đăng nhập
            } else if (Utils.KiemtraTKandMK(u, p) ) {
                Utils.setUsernameText(u);
                Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));

                Utils.switchStage(sce, event);

            } else {
                
                Utils.getAlertTC("Tài khoẳn hoặc mật khẩu không đúng!!!", Alert.AlertType.ERROR).showAndWait();

                
            }

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

    }
      public void TextFieldKeyPressed(javafx.scene.input.KeyEvent evt) {

       
     
       if(evt.getCode() == KeyCode.ENTER ){
           String u = txtUsername.getText();
        String p = pfPassword.getText();

        try {
            if (u.isEmpty()) {
                Utils.getAlertTC("Tài khoản trống!!!", Alert.AlertType.ERROR).showAndWait();

            } else if (p.isEmpty()) {
            Utils.getAlertTC("Mật khẩu trống!!!", Alert.AlertType.ERROR).showAndWait();
              

                //Hàm kiểm tra đăng nhập
            } else if (Utils.KiemtraTKandMK(u, p) ) {
                Utils.setUsernameText(u);
                Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));

                Utils.switchStagekeyevent(sce, evt);

            } else {
                
                Utils.getAlertTC("Tài khoẳn hoặc mật khẩu không đúng!!!", Alert.AlertType.ERROR).showAndWait();

                
            }

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
           
       }

    }

}
