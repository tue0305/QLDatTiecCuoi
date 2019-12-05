/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author cohotech
 */
public class SanhController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView tbSanh;
    @FXML
    private TextField txtTenSanh;
    @FXML
    private TextField txtGiaSanh;
    @FXML
    private ComboBox cbSanh;
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
// Load danh sách sảnh
        this.cbSanh.getItems().add("A");
        this.cbSanh.getItems().add("B");
        this.cbSanh.getItems().add("C");
        this.cbSanh.getItems().add("D");
        this.cbSanh.getItems().add("E");

        TableColumn clTenSanh = new TableColumn("Tên sảnh");
        clTenSanh.setCellValueFactory(new PropertyValueFactory("tenSanh"));
        TableColumn clLoaiSanh = new TableColumn("Loại sảnh");
        clLoaiSanh.setCellValueFactory(new PropertyValueFactory("loaiSanh"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbSanh.getColumns().addAll(clTenSanh, clLoaiSanh, clPrice, clNote);
        this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));
        addPane.setVisible(false);
// Load form thêm

        this.tbSanh.setRowFactory(tv -> {
            TableRow<Sanh> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                    Sanh clickedRow = row.getItem();
                    txtTenSanh.setText(clickedRow.getTenSanh());
                    cbSanh.getSelectionModel().select(clickedRow.getLoaiSanh());
                    txtGiaSanh.setText(clickedRow.getGia().toString());
                    txtNote.setText(clickedRow.getGhiChu());

                }
            });
            return row;
        });
    }
    public void themSanh(ActionEvent event) throws IOException {

        tbSanh.getSelectionModel().clearSelection();
        addPane.setVisible(true);
        if (txtTenSanh.getText().isEmpty() || txtGiaSanh.getText().isEmpty() || cbSanh.getSelectionModel().getSelectedItem() == null) {
            Alert b = Utils.getAlertTC("Hãy điển đẩy đủ thông tin!!!", Alert.AlertType.ERROR);
            b.show();
        } else {
            Sanh s = new Sanh(txtTenSanh.getText(), BigDecimal.valueOf(Double.parseDouble(txtGiaSanh.getText())),
                    cbSanh.getSelectionModel().getSelectedItem().toString(), txtNote.getText());

            if (Utils.ktTrungTenSanh(s)) {
                if (Utils.addOrUpdate(s)) {
                    Alert b = Utils.getAlertTC("Thêm thành công!!!", Alert.AlertType.INFORMATION);
                    b.show();
                    this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));
                    addPane.setVisible(false);
                } else {
                    Alert b = Utils.getAlertTC("Thêm thất bại!!!", Alert.AlertType.ERROR);
                    b.show();
                }

            } else {
                Alert b = Utils.getAlertTC("Tên sảnh đã có, hãy nhập lại thông tin!!!", Alert.AlertType.ERROR);
                b.show();
                txtTenSanh.clear();
                cbSanh.getSelectionModel().clearSelection();
                txtGiaSanh.clear();
                txtNote.clear();
            }

        }

    }

    public void suaSanh(ActionEvent event) throws IOException {
        Sanh s = (Sanh) tbSanh.getSelectionModel().getSelectedItem();
        if (tbSanh.getSelectionModel().getSelectedItem() == null) {
            Alert b = Utils.getAlertTC("Không tìm thấy giá trị để sửa!!!", Alert.AlertType.ERROR);
            b.show();
        } else if (!addPane.isVisible()) {

            addPane.setVisible(true);
            txtTenSanh.setText(s.getTenSanh());
            txtNote.setText(s.getGhiChu());
            cbSanh.getSelectionModel().select(s.getLoaiSanh());
            txtGiaSanh.setText(s.getGia().toString());
            Alert b = Utils.getAlertTC("Hãy điền thông tin sảnh cần sửa!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {

            if (txtTenSanh.getText().isEmpty() || txtGiaSanh.getText().isEmpty()) {
                Alert b = Utils.getAlertTC("Bắt buộc điền tên sảnh và giá sảnh!!!", Alert.AlertType.ERROR);
                b.show();
            } else {

                s.setTenSanh(txtTenSanh.getText());
                s.setLoaiSanh(cbSanh.getSelectionModel().getSelectedItem().toString());
                s.setGia(BigDecimal.valueOf(Double.parseDouble(txtGiaSanh.getText())));
                s.setGhiChu(txtNote.getText());
                if (cbSanh.getSelectionModel().getSelectedItem() != null && Utils.addOrUpdate(s) == true) {
                    Alert b = Utils.getAlertTC("Sửa thành công!!!", Alert.AlertType.INFORMATION);
                    b.show();
                    addPane.setVisible(false);
                    this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));
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

    public void xoaSanh(ActionEvent event) throws IOException {
        Sanh s = (Sanh) tbSanh.getSelectionModel().getSelectedItem();

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

                    } else {
                        Alert b = Utils.getAlertTC("Xóa thất bại!!!", Alert.AlertType.INFORMATION);
                        a.show();
                    }
                    this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));

                } else if (rs == ButtonType.NO) {
                    return;
                }
            });
        }
    }

}
