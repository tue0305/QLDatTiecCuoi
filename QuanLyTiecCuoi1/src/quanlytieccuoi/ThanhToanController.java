/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Booking;
import POJO.Dichvu;
import POJO.Thucpham;
import Util.Utils;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private final static double CHARGE = 0.01;

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

    private Date d = new Date();
    private Booking b = Utils.getPayBooking();
    private Long diff;
    private Double fee;
    //  tổng tiền thực phẩm và dịch vụ
    private Double TienTP = Utils.getPriceOfFoods();
    private Double TienDV = Utils.getPriceOfServices();
    private Double Tong;
    private Double thanhTien = TienTP + TienDV + b.getSanh().getGia().doubleValue();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        init();
    }

    public void init() {
        //công thức thành tiền
        

        // Trả về số ngày trễ
        diff = (d.getTime() - b.getNgayDat().getTime()) / (24 * 60 * 60 * 1000);
        // phí
        fee = diff.doubleValue() * CHARGE;
        //Tổng tiền (Tiền đã tính phí trễ hẹn)
        Tong = fee * thanhTien;

        txtNV.setText(b.getNhanVien().getTenNV());
        txtCa.setText(b.getCa().toString());
        txtNgayDat.setText(b.formatDate(b.getNgayDat()));
        txtTenKhach.setText(b.getNameCus());
        txtMaDat.setText(b.getMaBooking());
        txtSanh.setText(b.getSanh().getLoaiSanh());

        txtPhi.setText(String.format("%.2f", fee));
        txtKhachTra.setText(String.format("%d", diff));

//      Load bảng thực phẩm
        TableColumn clMaTP = new TableColumn("Mã");
        clMaTP.setCellValueFactory(new PropertyValueFactory("maTP"));
        TableColumn clTenTP = new TableColumn("Tên");
        clTenTP.setCellValueFactory(new PropertyValueFactory("tenTP"));
        TableColumn clLoaiTP = new TableColumn("loại");
        clLoaiTP.setCellValueFactory(new PropertyValueFactory("loaiTP"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbThucPham.getColumns().addAll(clMaTP, clTenTP, clLoaiTP, clPrice, clNote);
        this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getFoodsOfBooking(b)));

        //      Load bảng dịch vụ
        TableColumn clMaDV = new TableColumn("Mã");
        clMaDV.setCellValueFactory(new PropertyValueFactory("maDV"));

        TableColumn clLoaiDV = new TableColumn("loại");
        clLoaiDV.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clGiaDV = new TableColumn("Giá");
        clGiaDV.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clGhiChu = new TableColumn("Ghi chú");
        clGhiChu.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbDichVu.getColumns().addAll(clMaDV, clLoaiDV, clGiaDV, clGhiChu);
        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getServicesOfBooking(b)));

        txtThanhTien.setText(String.format( Utils.formatCurrency(thanhTien)));
        txtTongTien.setText(String.format( Utils.formatCurrency(Tong)));
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
                                System.out.print(txtTongTien.getText());
                            }
                            Utils.getAlertTC("Thanh toán thành công!!!", Alert.AlertType.INFORMATION).show();
                            b.setNgayThanhToan(d);
                            b.setPrice(BigDecimal.valueOf(Double.parseDouble(txtTongTien.getText())));
                            String q = String.format("Khách thanh toán trễ: %d ngày\r\nTiền cộng thêm : %.4f %", diff, diff * CHARGE);
                            b.setGhiChu(String.format("Khách thanh toán trễ: %d ngày\r\nTiền cộng thêm : %.4f %", diff, diff * CHARGE));
                            System.out.print(q);
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
