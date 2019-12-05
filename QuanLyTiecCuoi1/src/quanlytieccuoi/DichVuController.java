/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Dichvu;
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
public class DichVuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView tbDichVu;
    @FXML
    private TextField txtTenDV;
    @FXML
    private TextField txtGiaDV;
    @FXML
    private ComboBox cbLoaiDv;
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
        this.cbLoaiDv.getItems().add("Ca sĩ");
        this.cbLoaiDv.getItems().add("MC");
        this.cbLoaiDv.getItems().add("Bánh kem");

        TableColumn clTenDV = new TableColumn("Tên dịch vụ");
        clTenDV.setCellValueFactory(new PropertyValueFactory("tenDV"));
        TableColumn clLoaiDV = new TableColumn("Loại sảnh");
        clLoaiDV.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbDichVu.getColumns().addAll(clTenDV, clLoaiDV, clPrice, clNote);
        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));
// Load form thêm
        addPane.setVisible(false);

        this.tbDichVu.setRowFactory(tv -> {
            TableRow<Dichvu> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                    Dichvu clickedRow = row.getItem();
                    txtTenDV.setText(clickedRow.getTenDV());
                    cbLoaiDv.getSelectionModel().select(clickedRow.getLoaiDV());
                    txtGiaDV.setText(clickedRow.getGia().toString());
                    txtNote.setText(clickedRow.getGhiChu());

                }
            });
            return row;
        });
    }

    public void themDV(ActionEvent event) throws IOException {

        tbDichVu.getSelectionModel().clearSelection();
        if (!addPane.isVisible()) {
            addPane.setVisible(true);
            Alert b = Utils.getAlertTC("Hãy điền thông tin dịch vụ cần thêm!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {
            if (txtTenDV.getText().isEmpty() || txtGiaDV.getText().isEmpty() || cbLoaiDv.getSelectionModel().getSelectedItem() == null) {
                Alert b = Utils.getAlertTC("Hãy điền đẩy đủ thông tin!!", Alert.AlertType.ERROR);
                b.show();
            } else {
                Dichvu s = new Dichvu(txtTenDV.getText(), cbLoaiDv.getSelectionModel().getSelectedItem().toString(),
                        BigDecimal.valueOf(Double.parseDouble(txtGiaDV.getText())), txtNote.getText());

                if (Utils.ktTrungTenDichvu(s)) {
                    if (Utils.addOrUpdate(s)) {
                        Alert b = Utils.getAlertTC("Thêm thành công!!!", Alert.AlertType.INFORMATION);
                        b.show();
                        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));
                        addPane.setVisible(false);
                    } else {
                        Alert b = Utils.getAlertTC("Thêm thất bại!!!", Alert.AlertType.ERROR);
                        b.show();
                    }

                } else {
                    Alert b = Utils.getAlertTC("Tên dịch vụ đã có, hãy nhập thông tin mới!!!", Alert.AlertType.ERROR);
                    b.show();
                    txtTenDV.clear();
                    cbLoaiDv.getSelectionModel().clearSelection();
                    txtGiaDV.clear();
                    txtNote.clear();

                }

            }
        }

    }

    public void suaDV(ActionEvent event) throws IOException {
        Dichvu s = (Dichvu) tbDichVu.getSelectionModel().getSelectedItem();
        if (tbDichVu.getSelectionModel().getSelectedItem() == null) {
            Alert b = Utils.getAlertTC("Không tìm thấy giá trị để sửa!!!", Alert.AlertType.ERROR);
            b.show();
        } else if (!addPane.isVisible()) {

            addPane.setVisible(true);
            txtTenDV.setText(s.getTenDV());
            txtNote.setText(s.getGhiChu());
            cbLoaiDv.getSelectionModel().select(s.getLoaiDV());
            txtGiaDV.setText(s.getGia().toString());
            Alert b = Utils.getAlertTC("Hãy điền thông tin dịch vụ cần sửa!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {

            if (txtTenDV.getText().isEmpty() || txtGiaDV.getText().isEmpty()) {
                Alert b = Utils.getAlertTC("Bắt buộc điền tên dịch vụ và giá!!!", Alert.AlertType.ERROR);
                b.show();
            } else {

                s.setTenDV(txtTenDV.getText());
                s.setLoaiDV(cbLoaiDv.getSelectionModel().getSelectedItem().toString());
                s.setGia(BigDecimal.valueOf(Double.parseDouble(txtGiaDV.getText())));
                s.setGhiChu(txtNote.getText());
                if (cbLoaiDv.getSelectionModel().getSelectedItem() != null && Utils.addOrUpdate(s) == true) {
                    Alert b = Utils.getAlertTC("Sửa thành công!!!", Alert.AlertType.INFORMATION);
                    b.show();
                    addPane.setVisible(false);
                    this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));
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
        Dichvu s = (Dichvu) tbDichVu.getSelectionModel().getSelectedItem();

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
                    this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));

                } else if (rs == ButtonType.NO) {
                    return;
                }
            });
        }
    }

}
