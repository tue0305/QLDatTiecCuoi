/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Booking;
import POJO.Nhanvien;
import Util.Utils;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
    private JFXTextField txtNV;
    @FXML
    private JFXTextField txtNgayDat;
    @FXML
    private JFXTextField txtSanh;
    @FXML
    private JFXTextField txtTenKhach;
    @FXML
    private JFXTextField txtMaDat;
    @FXML
    private JFXTextField txtCa;
    @FXML
    private TextField txtThanhTien;
    @FXML
    private JFXTextField txtTongTien;
    @FXML
    private TextField txtPhi;
    @FXML
    private JFXTextField txtSoBan;
    @FXML
    private TextField txtStt;
    @FXML
    private TableView tbThucPham;
    @FXML
    private TableView tbDichVu;
    @FXML
    private Button btThanhToan;
    @FXML
    private Label lbTitle;

    private Date d = new Date();
    private Long diff;
    private Double fee;
    //
    private Booking b = Utils.getPayBooking();

    private Double tienTP = Utils.getPriceOfFoods();
    private Double tienDV = Utils.getPriceOfServices();
    private Double tongTIen;

    private Nhanvien n = Utils.findStaff(Utils.getUsernameText());

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        init();
    }

    public void init() {
        tbThucPham.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbDichVu.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        if (Utils.getSign() == true) {
            btThanhToan.setVisible(false);
            if (Utils.getPayBooking().getNgayThanhToan() == null) {
                txtStt.setText("Chưa hoàn tất thanh toán.");
            } else {
                txtStt.setText("Đã thanh toán.");
            }
            lbTitle.setText("CHI TIẾT GIAO DỊCH");
        } else {
            lbTitle.setText("THANH TOÁN");
        }
        //công thức thành tiền
        Double thanhTien = tienTP + tienDV + b.getSanh().getGia().doubleValue();
        // Trả về số ngày trễ
        diff = (d.getTime() - b.getNgayDat().getTime()) / (24 * 60 * 60 * 1000);
        if (diff <= 0) {
            diff = 0L;
            // phí
            fee = 0.0;
        } else {
            fee = diff.doubleValue() * CHARGE;
        }

        //Tổng tiền (Tiền đã tính phí trễ hẹn)
        tongTIen = fee * thanhTien + thanhTien;

        txtNV.setText(n.getTenNV());
        txtCa.setText(b.getCa().toString());
        txtNgayDat.setText(b.formatDate(b.getNgayDat()));
        txtTenKhach.setText(b.getNameCus());
        txtMaDat.setText(b.getMaBooking());
        txtSanh.setText(b.getSanh().getLoaiSanh());

        txtPhi.setText(String.format("%.2f", fee));

        txtSoBan.setText(b.getSoBan().toString());

//      Load bảng thực phẩm
        TableColumn clMaTP = new TableColumn("Mã");

        clMaTP.setCellValueFactory(
                new PropertyValueFactory("maTP"));
        TableColumn clTenTP = new TableColumn("Tên");

        clTenTP.setCellValueFactory(
                new PropertyValueFactory("tenTP"));
        TableColumn clLoaiTP = new TableColumn("loại");

        clLoaiTP.setCellValueFactory(
                new PropertyValueFactory("loaiTP"));
        TableColumn clPrice = new TableColumn("Giá");

        clPrice.setCellValueFactory(
                new PropertyValueFactory("price"));
        TableColumn clNote = new TableColumn("Ghi chú");

        clNote.setCellValueFactory(
                new PropertyValueFactory("ghiChu"));

        this.tbThucPham.getColumns()
                .addAll(clMaTP, clTenTP, clLoaiTP, clPrice, clNote);

        this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getFoodsOfBooking(b)));

        //      Load bảng dịch vụ
        TableColumn clMaDV = new TableColumn("Mã");

        clMaDV.setCellValueFactory(
                new PropertyValueFactory("maDV"));

        TableColumn clLoaiDV = new TableColumn("loại");

        clLoaiDV.setCellValueFactory(
                new PropertyValueFactory("loaiDV"));
        TableColumn clGiaDV = new TableColumn("Giá");

        clGiaDV.setCellValueFactory(
                new PropertyValueFactory("gia"));
        TableColumn clGhiChu = new TableColumn("Ghi chú");

        clGhiChu.setCellValueFactory(
                new PropertyValueFactory("ghiChu"));

        this.tbDichVu.getColumns()
                .addAll(clMaDV, clLoaiDV, clGiaDV, clGhiChu);

        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getServicesOfBooking(b)));

        txtThanhTien.setText(String.format(Utils.formatCurrency(thanhTien)));
        txtTongTien.setText(String.format(Utils.formatCurrency(tongTIen)));
    }

    public void backAction(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("TraCuuVaThanhToan.fxml")));
        Utils.switchStage(sce, event);
        Utils.setSign(null);
        Utils.resetPayment();

    }

    public void confirmkAction(ActionEvent event) throws IOException {

        try {

            Utils.getAlertTC("Hãy kiểm tra kĩ thông tin và xác nhận thanh toán ?", Alert.AlertType.CONFIRMATION).showAndWait().ifPresent(rs1 -> {

                if (rs1 == ButtonType.OK) {
                    Utils.getAlertTC("Tiến hành in hóa đơn ?", Alert.AlertType.CONFIRMATION).showAndWait().ifPresent(rs2 -> {

                        if (rs2 == ButtonType.OK) {
                            System.out.print(txtTongTien.getText());// chỗ in hóa đơn
                        }

                        b.setNgayThanhToan(d);
                        b.setPrice(BigDecimal.valueOf(Double.parseDouble(txtTongTien.getText().replace(",", ""))));

                        if (!fee.equals(0)) {
                            b.setGhiChu(b.getGhiChu() + String.format("\r\bKhách thanh toán trễ: %d ngày\r\nTiền cộng thêm : %.4f%%", diff, diff * CHARGE));
                        } else {
                            b.setGhiChu(String.format("Thanh toán đúng hẹn."));
                        }
                        b.setNhanVien(n);
                        if (Utils.addOrUpdate(b)) {

                            Utils.getAlertTC("Thanh toán thành công!!!", Alert.AlertType.INFORMATION).showAndWait().ifPresent(rs3 -> {
                                if (rs1 == ButtonType.OK) {
                                    try {
                                        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("TraCuuVaThanhToan.fxml")));
                                        Utils.switchStage(sce, event);
                                        Utils.resetPayment();
                                    } catch (IOException ex) {
                                        System.err.print(ex.getMessage());
                                    }
                                }

                            });

                        } else {
                            Utils.getAlertTC("Thanh toán thất bại!!!", Alert.AlertType.ERROR).show();
                        }

                    });
                } else if (rs1 == ButtonType.NO) {
                    return;
                }
            });

        } catch (Exception e) {
            System.err.print(e.getMessage());

        }
    }
}
