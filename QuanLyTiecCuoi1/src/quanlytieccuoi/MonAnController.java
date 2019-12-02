/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Monan;
import POJO.Sanh;
import Util.Utils;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author cohotech
 */
public class MonAnController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView tbMonAn;
    @FXML
    private TextField txtTenMonAn;
    @FXML
    private TextField txtGiaMonAn;

    @FXML
    private GridPane addPane;
    @FXML
    private TextArea txtNote;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }

    public void init() {

        TableColumn clTenMA = new TableColumn("Tên món ăn");
        clTenMA.setCellValueFactory(new PropertyValueFactory("tenMA"));
        TableColumn clGiaMA = new TableColumn("Giá");
        clGiaMA.setCellValueFactory(new PropertyValueFactory("price"));

        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbMonAn.getColumns().addAll(clTenMA, clGiaMA, clNote);
        this.tbMonAn.setItems(FXCollections.observableArrayList(Utils.getMonAn()));
// Load form thêm
        addPane.setVisible(false);
    }

    public void themMonAn(ActionEvent event) throws IOException {

        tbMonAn.getSelectionModel().clearSelection();
        if (!addPane.isVisible()) {
            addPane.setVisible(true);
            Alert b = Utils.getAlertTC("Hãy điền thông tin món ăn cần thêm!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {
            if (txtTenMonAn.getText().isEmpty() || txtGiaMonAn.getText().isEmpty()) {
                Alert b = Utils.getAlertTC("Bắt buộc điền tên món ăn và giá món ăn!!!", Alert.AlertType.ERROR);
                b.show();
            } else {
                Monan s = new Monan(txtTenMonAn.getText(), BigDecimal.valueOf(Double.parseDouble(txtGiaMonAn.getText())), txtNote.getText());

                if (Utils.ktTrungTenMonAn(s)) {
                    if (Utils.addOrUpdate(s)) {
                        Alert b = Utils.getAlertTC("Thêm thành công!!!", Alert.AlertType.INFORMATION);
                        b.show();
                        this.tbMonAn.setItems(FXCollections.observableArrayList(Utils.getMonAn()));
                        addPane.setVisible(false);
                    } else {
                        Alert b = Utils.getAlertTC("Thêm thất bại!!!", Alert.AlertType.ERROR);
                        b.show();
                    }

                } else {
                    Alert b = Utils.getAlertTC("Tên món ăn đã có!!!", Alert.AlertType.ERROR);
                    b.show();
                }

            }
        }

    }

    public void suaMonAn(ActionEvent event) throws IOException {
        Monan s = (Monan) tbMonAn.getSelectionModel().getSelectedItem();
        if (tbMonAn.getSelectionModel().getSelectedItem() == null) {
            Alert b = Utils.getAlertTC("Không tìm thấy giá trị để sửa!!!", Alert.AlertType.ERROR);
            b.show();
        } else if (!addPane.isVisible()) {

            addPane.setVisible(true);
            txtTenMonAn.setText(s.getTenMA());
            txtNote.setText(s.getGhiChu());
            
            txtGiaMonAn.setText(s.getPrice().toString());
            Alert b = Utils.getAlertTC("Hãy điền thông tin món ăn cần sửa!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {

            if (txtTenMonAn.getText().isEmpty() || txtGiaMonAn.getText().isEmpty()) {
                Alert b = Utils.getAlertTC("Bắt buộc điền tên món ăn và giá món ăn!!!", Alert.AlertType.ERROR);
                b.show();
            } else {

                s.setTenMA(txtTenMonAn.getText());
               
                s.setPrice(BigDecimal.valueOf(Double.parseDouble(txtGiaMonAn.getText())));
                s.setGhiChu(txtNote.getText());
                if ( Utils.addOrUpdate(s) == true) {
                    Alert b = Utils.getAlertTC("Sửa thành công!!!", Alert.AlertType.INFORMATION);
                    b.show();
                    addPane.setVisible(false);
                    this.tbMonAn.setItems(FXCollections.observableArrayList(Utils.getMonAn()));
                } else {
                    Alert b = Utils.getAlertTC("Sửa thất bại!!!", Alert.AlertType.ERROR);
                    b.show();
                }
                

            }
        }

    }

    public void backAction(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);

    }

    public void xoaMonAn(ActionEvent event) throws IOException {
        Monan s = (Monan) tbMonAn.getSelectionModel().getSelectedItem();

        if (s == null) {
            Alert b = Utils.getAlertTC("Không tìm thấy giá trị để xóa!!!", Alert.AlertType.ERROR);
            b.show();
        } else {
            Alert a = Utils.getAlertTC("Bạn có chắc chắn xóa không?", Alert.AlertType.CONFIRMATION);
            a.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {

                    if (s == null) {
                        Alert b = Utils.getAlertTC("Không tìm thấy giá trị để xóa!!!", Alert.AlertType.ERROR);
                        b.show();
                    } else if (Utils.deleteObject(s)) {

                        Alert b = Utils.getAlertTC("Xóa thành công!!!", Alert.AlertType.INFORMATION);
                        b.show();
                        this.tbMonAn.setItems(FXCollections.observableArrayList(Utils.getMonAn()));
                    } else {
                        Alert b = Utils.getAlertTC("Xóa thất bại!!!", Alert.AlertType.INFORMATION);
                        a.show();
                    }
                    

                } else if (rs == ButtonType.NO) {
                    return;
                }
            });
        }
    }
}
