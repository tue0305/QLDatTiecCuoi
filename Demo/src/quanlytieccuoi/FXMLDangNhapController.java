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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author cohotech
 */
public class FXMLDangNhapController implements Initializable {
    
    
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    //
    Stage stage;
    
    Scene sce; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void Login(ActionEvent event) throws IOException {
        if (txtUsername.getText().isEmpty()) {
            System.err.println("Hãy nhập tài khoản");
            return;
        }
        if (txtPassword.getText().isEmpty()) {
            System.err.println("Hãy nhập mật khẩu");
            return;
            }
        if(Utils.KiemtraTKandMK(txtUsername.getText(), txtPassword.getText()) == false)
        {
            Alert alert = Utils.getAlert("Tài khoản hoặc mật khẩu không đúng!!!", Alert.AlertType.ERROR);
            alert.show();
        }
        else
        {
            sce = new Scene(FXMLLoader.load(getClass().getResource("QuanLyDatTiec.fxml")));
            stage.setScene(sce);
            stage.show();    
        }
            
            
    }

    /**
     * @return the txtUsername
     */
    public TextField getTxtUsername() {
        return txtUsername;
    }

    /**
     * @param txtUsername the txtUsername to set
     */
    public void setTxtUsername(TextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    /**
     * @return the txtPassword
     */
    public TextField getTxtPassword() {
        return txtPassword;
    }

    /**
     * @param txtPassword the txtPassword to set
     */
    public void setTxtPassword(TextField txtPassword) {
        this.txtPassword = txtPassword;
    }
}
