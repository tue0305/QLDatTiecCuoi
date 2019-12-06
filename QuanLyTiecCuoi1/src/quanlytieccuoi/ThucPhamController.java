/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Thucpham;
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
public class ThucPhamController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView tbThucPham;
    @FXML
    private TextField txtTenTP;
    @FXML
    private TextField txtGia;
    @FXML
    private ComboBox clLoaiTP;
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
        this.clLoaiTP.getItems().add("Khai vị");
        this.clLoaiTP.getItems().add("Món chính");
        this.clLoaiTP.getItems().add("Tráng miệng");
        this.clLoaiTP.getItems().add("Nước uống");

        TableColumn clTenTP = new TableColumn("Tên");
        clTenTP.setCellValueFactory(new PropertyValueFactory("tenTP"));
        TableColumn clLoaiTp = new TableColumn("Loại");
        clLoaiTp.setCellValueFactory(new PropertyValueFactory("loaiTP"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbThucPham.getColumns().addAll(clTenTP, clLoaiTp, clPrice, clNote);
        this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getThucPham()));
        addPane.setVisible(false);
// Load form thêm
        

        this.tbThucPham.setRowFactory(tv -> {
            TableRow<Thucpham> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                    Thucpham clickedRow = row.getItem();
                    txtTenTP.setText(clickedRow.getTenTP());
                    clLoaiTP.getSelectionModel().select(clickedRow.getLoaiTP());
                    txtGia.setText(clickedRow.getPrice().toString());
                    txtNote.setText(clickedRow.getGhiChu());

                }
            });
            return row;
        });
    }

    public void themTP(ActionEvent event) throws IOException {

        tbThucPham.getSelectionModel().clearSelection();
        addPane.setVisible(true);
        if (!addPane.isVisible()) {
            
            Alert b = Utils.getAlertTC("Hãy điền thông tin cần thêm!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {
            if (txtTenTP.getText().isEmpty() || txtGia.getText().isEmpty() || clLoaiTP.getSelectionModel().getSelectedItem() == null) {
                Alert b = Utils.getAlertTC("Hãy điền đầy đủ thông tin!!!", Alert.AlertType.ERROR);
                b.show();
            } else {
                Thucpham s = new Thucpham(txtTenTP.getText(), clLoaiTP.getSelectionModel().getSelectedItem().toString(),
                        BigDecimal.valueOf(Double.parseDouble(txtGia.getText())), txtNote.getText());

                if (Utils.ktTrungTenThucPham(s)) {
                    if (Utils.addOrUpdate(s)) {
                        Alert b = Utils.getAlertTC("Thêm thành công!!!", Alert.AlertType.INFORMATION);
                        b.show();
                        this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getThucPham()));
                        addPane.setVisible(false);
                    } else {
                        Alert b = Utils.getAlertTC("Thêm thất bại!!!", Alert.AlertType.ERROR);
                        b.show();
                    }

                } else {
                    Alert b = Utils.getAlertTC("Tên thực phẩm đã tồn tại, mời nhập mới!!!", Alert.AlertType.ERROR);
                    b.show();
                    txtTenTP.clear();
                    clLoaiTP.getSelectionModel().clearSelection();
                    txtGia.clear();
                    txtNote.clear();
                }

            }
        }

    }

    public void suaTP(ActionEvent event) throws IOException {
        Thucpham s = (Thucpham) tbThucPham.getSelectionModel().getSelectedItem();
        if (tbThucPham.getSelectionModel().getSelectedItem() == null) {
            Alert b = Utils.getAlertTC("Không tìm thấy giá trị để sửa!!!", Alert.AlertType.ERROR);
            b.show();
        } else if (!addPane.isVisible()) {

            addPane.setVisible(true);
            txtTenTP.setText(s.getTenTP());
            txtNote.setText(s.getGhiChu());
            clLoaiTP.getSelectionModel().select(s.getLoaiTP());
            txtGia.setText(s.getPrice().toString());
            Alert b = Utils.getAlertTC("Hãy điền thông tin cần sửa!!!", Alert.AlertType.INFORMATION);
            b.show();
        } else {

            if (txtTenTP.getText().isEmpty() || txtGia.getText().isEmpty() || clLoaiTP.getSelectionModel().getSelectedItem() == null) {
                Alert b = Utils.getAlertTC("!Hãy điền đầy đủ thông tin!!", Alert.AlertType.ERROR);
                b.show();
            } else {

                s.setTenTP(txtTenTP.getText());
                s.setLoaiTP(clLoaiTP.getSelectionModel().getSelectedItem().toString());
                s.setPrice(BigDecimal.valueOf(Double.parseDouble(txtGia.getText())));
                s.setGhiChu(txtNote.getText());
                if (clLoaiTP.getSelectionModel().getSelectedItem() != null && Utils.addOrUpdate(s) == true) {
                    Alert b = Utils.getAlertTC("Sửa thành công!!!", Alert.AlertType.INFORMATION);
                    b.show();
                    addPane.setVisible(false);
                    this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getThucPham()));
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

    public void xoaTP(ActionEvent event) throws IOException {
        Thucpham s = (Thucpham) tbThucPham.getSelectionModel().getSelectedItem();

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
                    this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getThucPham()));

                } else if (rs == ButtonType.NO) {
                    return;
                }
            });
        }
    }

}
