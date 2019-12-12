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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author cohotech
 */
public class DangNhapController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField textField;

    //
    Alert a;
    @FXML
    private TextField txtPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();

    }

    public void init() {
        try {
            String password = "";
            txtUsername.setPromptText("Enter your username...");

            pfPassword.setPromptText("Enter your password...");

            textField.setPromptText("Enter your password...");

        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

    }

    public void showPW(ActionEvent e) {
        if (pfPassword.isVisible()) {
            textField.setText(pfPassword.getText());
            textField.setVisible(true);
            pfPassword.setVisible(false);
            return;
        } else {
            pfPassword.setText(textField.getText());
            pfPassword.setVisible(true);
            textField.setVisible(false);
        }

    }

    @FXML
    public void Login(ActionEvent event) throws IOException {

        pfPassword.setVisible(true);
        textField.setVisible(false);
        String u = txtUsername.getText();
        String p = pfPassword.getText();

        try {
            if (u.isEmpty()) {
                Utils.getAlertTC("Tài khoản trống!!!", Alert.AlertType.ERROR).showAndWait();
                

            } else if (p.isEmpty()) {
                
                
//Hàm kiểm tra đăng nhập
            } else if (Utils.KiemtraTKandMK(u, p)) {
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

}
