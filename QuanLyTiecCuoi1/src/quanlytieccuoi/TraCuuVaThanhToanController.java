/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Booking;
import POJO.Sanh;
import Util.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ThanhDepTrai
 */
public class TraCuuVaThanhToanController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtTC;
    @FXML
    private DatePicker dpStart;
    @FXML
    private DatePicker dpEnd;
    @FXML
    private TableView tbBooking;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }    
    
    public void init() {
        txtTC.setPromptText("Nhập tên hoặc số điện thoại khách...");
       

        TableColumn clMaDatTiec = new TableColumn("Mã đặt tiệc");
        clMaDatTiec.setCellValueFactory(new PropertyValueFactory("maBooking"));
        TableColumn clTenKH = new TableColumn("Tên khách hàng");
       clTenKH.setCellValueFactory(new PropertyValueFactory("nameCus"));
        TableColumn clSDT = new TableColumn("Số điện thoại");
        clSDT.setCellValueFactory(new PropertyValueFactory("phoneCus"));
        TableColumn clNgayDat = new TableColumn("Ngày đặt");
        clNgayDat.setCellValueFactory(new PropertyValueFactory("ngayDat"));
        TableColumn clNgayThanhToan=  new TableColumn("Ngày thanh toán");
        clNgayThanhToan.setCellValueFactory(new PropertyValueFactory("ngayThanhToan"));
        TableColumn clGia= new TableColumn("Tổng tiền");
        clGia.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));
        
        

        this.tbBooking.getColumns().addAll(clMaDatTiec, clTenKH, clSDT, clNgayDat, clNgayThanhToan, clGia, clNote);
        this.tbBooking.setItems(FXCollections.observableArrayList(Utils.getBooking()));
        // Tìm kiếm booking theo tên và số điện thoại khách hàng
        this.txtTC.textProperty().addListener(et ->{
            this.tbBooking.getItems().clear();
            this.tbBooking.setItems(FXCollections.observableArrayList(
                    Utils.getBookingSearch(this.txtTC.getText())));
            
        });
        
// Load form thêm

        
    }

    
    // => chưa hoàn thành
    public void suaBooking(ActionEvent event) throws IOException {
        TextField txttenKH = new TextField();
        txttenKH.setPromptText("Tên khách hàng...");
        TextField txtSDT = new TextField();
        txtSDT.setPromptText("Số điện thoại...");
        StackPane update = new StackPane();
        txtSDT.setPromptText("Số điện thoại...");
        
        Stage s = new Stage();
        s.setTitle("Cập nhập thông tin");
        
    }

    public void backAction(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);

    }

    public void xoaBooking(ActionEvent event) throws IOException {
        Booking s = (Booking) tbBooking.getSelectionModel().getSelectedItem();

        if (s == null) {
            Alert b = Utils.getAlertTC("Hãy chọn giá trị bên dưới!!", Alert.AlertType.ERROR);
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
                    this.tbBooking.setItems(FXCollections.observableArrayList(Utils.getBooking()));

                } else if (rs == ButtonType.NO) {
                    return;
                }
            });
        }
    }
    
}
