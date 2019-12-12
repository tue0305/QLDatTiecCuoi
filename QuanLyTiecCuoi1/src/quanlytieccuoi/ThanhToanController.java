/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Booking;
import POJO.Nhanvien;
import Util.Utils;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author minht
 */
public class ThanhToanController implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    // phí khi thanh toán trễ
    private final double CHARGE = 0.1;
    
    @FXML
    private TextField txtNV;
    @FXML
    private TextField txtNgayDat;
    @FXML
    private TextField txtSanh;
    @FXML
    private TextField txtTenKhach;
    @FXML
    private TextField txtMaDat;
    @FXML
    private TextField txtCa;
    @FXML
    private TextField txtThanhTien;
    @FXML
    private TextField txtTongTien;
    @FXML
    private TextField txtPhi;
    @FXML
    private TextField txtKhachTra;
    @FXML
    private TableView tbThucPham;
    @FXML
    private TableView tbDichVu;

    Date d = new Date();
    public Booking b = Utils.getPayBooking();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        init();
    }

    public void init() {
        
        txtNV.setText(b.getNhanVien().getTenNV());
        txtCa.setText(b.getCa().toString());
        txtNgayDat.setText(b.formatDate(b.getNgayDat()));
        txtTenKhach.setText(b.getNameCus());
        txtMaDat.setText(b.getMaBooking());
        txtSanh.setText(b.getSanh().getLoaiSanh());

//       
//        txtTongTien;
//        txtThanhTien;
//        txtPhi.setText(b.formatDate((d - b.getNgayThanhToan())));
//        txtKhachTra;
    }

    public void backAction(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("TraCuuVaThanhToan.fxml")));
        Utils.switchStage(sce, event);

    }

    public void confirmkAction(ActionEvent event) throws IOException {

        try {
            if (txtKhachTra.getText().isEmpty()) {
                Utils.getAlertTC("Tài khoẳn hoặc mật khẩu không đúng!!!", Alert.AlertType.ERROR).show();
            } else {
                Alert a = Utils.getAlertTC("Xác nhận thanh toán ?", Alert.AlertType.CONFIRMATION);
                a.showAndWait().ifPresent(rs1 -> {
                    if (rs1 == ButtonType.OK) {
                        Alert c = Utils.getAlertTC("Tiến hành in hóa đơn ?", Alert.AlertType.CONFIRMATION);
                        c.showAndWait().ifPresent(rs2 -> {
                            if (rs2 == ButtonType.OK) {
                                
                            }
                            Utils.getAlertTC("Thanh toán thành công!!!", Alert.AlertType.INFORMATION).show();
                            b.setNgayThanhToan(d);
                            b.setPrice(BigDecimal.valueOf(Double.parseDouble(txtTongTien.getText())));
//                            b.setGhiChu(String.format("Khách thanh toán trễ: %s\r\nTiền cộng thêm : %.2f", )); --->
                        });
                    } else if (rs1 == ButtonType.NO) {
                        return;
                    }
                });
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

    }
}
