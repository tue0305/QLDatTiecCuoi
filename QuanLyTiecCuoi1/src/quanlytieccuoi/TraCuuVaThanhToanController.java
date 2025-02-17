/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Booking;
import Util.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView tbBooking;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }

    public void init() {
        txtTC.setPromptText("Nhập tên hoặc số điện thoại khách...");
        tbBooking.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn clTenKH = new TableColumn("Tên khách hàng");
        clTenKH.setCellValueFactory(new PropertyValueFactory("nameCus"));
        TableColumn clSDT = new TableColumn("Số điện thoại");
        clSDT.setCellValueFactory(new PropertyValueFactory("phoneCus"));
        TableColumn clNgayDat = new TableColumn("Ngày đặt");
        clNgayDat.setCellValueFactory(new PropertyValueFactory("ngayDat"));
        TableColumn clCa = new TableColumn("Ca");
        clCa.setCellValueFactory(new PropertyValueFactory("ca"));
        TableColumn clSanh = new TableColumn("Sanh");
        clSanh.setCellValueFactory(new PropertyValueFactory("sanh"));
        TableColumn clNgayThanhToan = new TableColumn("Ngày thanh toán");
        clNgayThanhToan.setCellValueFactory(new PropertyValueFactory("ngayThanhToan"));

// Xem thông tin       
        TableColumn clWatch = new TableColumn();

        clWatch.setCellFactory(param -> {
            Button btn = new Button("Xem");
            btn.setOnAction(et -> {

                try {
                    TableCell cel = (TableCell) ((Button) et.getSource()).getParent();
                    Booking q = (Booking) cel.getTableRow().getItem();

                    Utils.setPayBooking(q);

                    Utils.setSign(true);
                    Scene sce = btn.getScene();
                    Scene sce1 = new Scene(FXMLLoader.load(getClass().getResource("ThanhToan.fxml")));

                    Stage stage = (Stage) sce.getWindow();
                    stage.close();

                    stage.hide();
                    stage.setScene(sce1);
                    stage.show();

                } catch (IOException ex) {
                    Logger.getLogger(TraCuuVaThanhToanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;

        }
        );
// Thanh Toán
        TableColumn clPay = new TableColumn();

        clPay.setCellFactory(param -> {
            Button btn = new Button("Thanh toán");

            btn.setOnAction(et -> {

                try {

                    TableCell cel = (TableCell) ((Button) et.getSource()).getParent();
                    Booking q = (Booking) cel.getTableRow().getItem();
                    if (q.getNgayThanhToan() != null) {
                        Utils.getAlertTC("Đơn đặt đã thanh toán!!!", Alert.AlertType.ERROR).show();
                    } else {

                        Utils.setPayBooking(q);

                        Utils.setSign(false);
                        Scene sce = btn.getScene();
                        Scene sce1 = new Scene(FXMLLoader.load(getClass().getResource("ThanhToan.fxml")));

                        Stage stage = (Stage) sce.getWindow();
                        stage.close();

                        stage.hide();
                        stage.setScene(sce1);
                        stage.show();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(TraCuuVaThanhToanController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;

        }
        );
// Column xóa 

        TableColumn clDel = new TableColumn();

        clDel.setCellFactory(param -> {
            Button btn = new Button("Xóa");

            btn.setOnAction(et -> {

                TableCell cel = (TableCell) ((Button) et.getSource()).getParent();
                Booking q = (Booking) cel.getTableRow().getItem();

                Utils.getAlertTC("Bạn có chắc chắn xóa không?", Alert.AlertType.CONFIRMATION).showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        if (Utils.deleteObject(q)) {
                            Utils.getAlertTC("Xóa thành công!!!", Alert.AlertType.INFORMATION).show();

                        } else {
                            Utils.getAlertTC("Xóa thất bại!!!", Alert.AlertType.INFORMATION).show();
                        }
                        this.tbBooking.setItems(FXCollections.observableArrayList(Utils.getBooking()));

                    } else if (rs == ButtonType.NO) {
                        return;
                    }
                });

            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;

        });

        this.tbBooking.getColumns()
                .addAll(clTenKH, clSDT, clNgayDat, clCa, clSanh, clNgayThanhToan, clWatch, clPay, clDel);

        this.tbBooking.setItems(FXCollections.observableArrayList(Utils.getBooking()));
        // Tìm kiếm booking theo tên và số điện thoại khách hàng

        this.txtTC.textProperty()
                .addListener(et -> {
                    this.tbBooking.getItems().clear();
                    this.tbBooking.setItems(FXCollections.observableArrayList(
                            Utils.getBookingSearch(this.txtTC.getText())));

                }
                );

// Load form thêm
    }

    public void backAction(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);

    }

}
