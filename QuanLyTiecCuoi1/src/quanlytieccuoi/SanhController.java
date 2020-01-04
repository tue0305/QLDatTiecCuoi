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
        tbSanh.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//Gioi han 12 so gia tien
        Utils.KiemTraLaSo(txtGiaSanh);
        Utils.gioiHanSo(12, txtGiaSanh);

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

        if ((!txtTenSanh.getText().isEmpty() || !txtGiaSanh.getText().isEmpty() || !txtNote.getText().isEmpty()) && !tbSanh.getSelectionModel().isEmpty()) {
            txtTenSanh.clear();

            txtGiaSanh.clear();
            txtNote.clear();
            tbSanh.getSelectionModel().clearSelection();

        }
        if (!addPane.isVisible()) {
            addPane.setVisible(true);
            Utils.getAlertTC("Hãy điền thông tin cần thêm!!!", Alert.AlertType.INFORMATION).show();

        } else {
            if (txtTenSanh.getText().isEmpty() || txtGiaSanh.getText().isEmpty() || cbSanh.getSelectionModel().getSelectedItem() == null) {
                Utils.getAlertTC("Hãy điển đẩy đủ thông tin!!!", Alert.AlertType.ERROR).show();

            } else {
                Sanh s = new Sanh(txtTenSanh.getText(), BigDecimal.valueOf(Double.parseDouble(txtGiaSanh.getText())),
                        cbSanh.getSelectionModel().getSelectedItem().toString(), txtNote.getText());

                if (Utils.ktTrungTenSanh(s)) {
                    if (Utils.addOrUpdate(s)) {
                        Utils.getAlertTC("Thêm thành công!!!", Alert.AlertType.INFORMATION).show();

                        this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));
                        addPane.setVisible(false);
                    } else {
                        Utils.getAlertTC("Thêm thất bại!!!", Alert.AlertType.ERROR).show();

                    }

                } else {
                    Utils.getAlertTC("Tên sảnh đã có, hãy nhập lại thông tin!!!", Alert.AlertType.ERROR).show();

                    txtTenSanh.clear();
                    cbSanh.getSelectionModel().clearSelection();
                    txtGiaSanh.clear();
                    txtNote.clear();
                }

            }

        }
    }

    public void suaSanh(ActionEvent event) throws IOException {
        Sanh s = (Sanh) tbSanh.getSelectionModel().getSelectedItem();
        if (tbSanh.getSelectionModel().getSelectedItem() == null) {
            Utils.getAlertTC("Không tìm thấy giá trị để sửa!!!", Alert.AlertType.ERROR).show();

        } else if (!addPane.isVisible()) {

            addPane.setVisible(true);
            txtTenSanh.setText(s.getTenSanh());
            txtNote.setText(s.getGhiChu());
            cbSanh.getSelectionModel().select(s.getLoaiSanh());
            txtGiaSanh.setText(s.getGia().toString());
            Utils.getAlertTC("Hãy điền thông tin sảnh cần sửa!!!", Alert.AlertType.INFORMATION).show();

        } else {

            if (txtTenSanh.getText().isEmpty() || txtGiaSanh.getText().isEmpty() || cbSanh.getSelectionModel().getSelectedItem() == null) {
                Utils.getAlertTC("Hãy điền đầy đủ thông tin!!!", Alert.AlertType.ERROR).show();

            } else {

                s.setTenSanh(txtTenSanh.getText());
                s.setLoaiSanh(cbSanh.getSelectionModel().getSelectedItem().toString());
                s.setGia(BigDecimal.valueOf(Double.parseDouble(txtGiaSanh.getText())));
                s.setGhiChu(txtNote.getText());
                if (cbSanh.getSelectionModel().getSelectedItem() != null && Utils.addOrUpdate(s) == true) {
                    Utils.getAlertTC("Sửa thành công!!!", Alert.AlertType.INFORMATION).show();

                    addPane.setVisible(false);
                    this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));
                } else {
                    Utils.getAlertTC("Sửa thất bại!!!", Alert.AlertType.ERROR).show();

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
            Utils.getAlertTC("Không tìm thấy giá trị để xóa!!!", Alert.AlertType.ERROR).show();

        } else {
            Alert a = Utils.getAlertTC("Bạn có chắc chắn xóa không?", Alert.AlertType.CONFIRMATION);
            a.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {

                    if (s == null) {
                        Utils.getAlertTC("Không tìm thấy giá trị để xóa!!!", Alert.AlertType.ERROR).show();

                    } else if (Utils.deleteObject(s)) {

                        Utils.getAlertTC("Xóa thành công!!!", Alert.AlertType.INFORMATION).show();

                    } else {
                        Utils.getAlertTC("Xóa thất bại!!!", Alert.AlertType.INFORMATION).show();

                    }
                    this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));

                } else if (rs == ButtonType.NO) {
                    return;
                }
            });
        }
    }

}
