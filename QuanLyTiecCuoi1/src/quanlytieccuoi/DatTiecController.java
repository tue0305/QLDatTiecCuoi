package quanlytieccuoi;

import POJO.Booking;
import POJO.Dichvu;
import POJO.Khachhang;
import POJO.Menu;
import POJO.Nhanvien;
import POJO.Sanh;
import POJO.Thucpham;
import Util.Utils;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class DatTiecController implements Initializable {

    @FXML
    private Label lbStatusMIn, lbStatus;

    @FXML
    private VBox vboxMonAn, VboxDichVu, vboxXacNhan, vboxThongTin, vboxStatus;

// ThongTin KH VA SANH
    @FXML
    private TextField txtTenKH, txtSDT, txtSoBan, txtLoaiTiec;
    @FXML
    private ComboBox cbSanh;
// Ca
    @FXML
    private JFXRadioButton rdCa1, rdCa2;

    @FXML
    private DatePicker dpNgayDat;
    @FXML
    private TextArea taDiaChi, taGhiChu, taXNDiaChi;

    @FXML
    private Button nextMonAn, nextDichVu, nextXacNhan, backTTKH, backDichVu, backMonAn,
            btThongtin, btMonAn, btDichVu, BtXacNhan;

//Thong tin dat mon an
    @FXML
    private TableView tbThucPham, tbThucPhamC, tbXacNhanTP,
            tbDichVu, tbDichVuC, tbXacNhanDV;

    //Thong tin xac nhan
    @FXML
    private JFXTextField txtXNTenKH, txtXNSDT, txtXNLoaiTiec, txtXNNgay,
            txtXNSANH, txtXNSoBan, txtXNCa, txtXNTongTien;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        chonTheoThuTu();
        init();
        kTraNhapTTKH();

    }

    @FXML
    private void handleClicks(ActionEvent event) {

        if (event.getSource() == nextMonAn) {

            if (txtTenKH.getText().isEmpty() || txtSDT.getText().isEmpty()
                    || dpNgayDat.getValue() == null || cbSanh.getSelectionModel().isEmpty()
                    || (!rdCa1.isSelected() && !rdCa2.isSelected()) || txtSoBan.getText().isEmpty()) {
                Utils.getAlertTC("Hãy điển đẩy đủ thông tin!!!", Alert.AlertType.ERROR).show();
           } else {

                lbStatusMIn.setText("/home/monan");
                lbStatus.setText("Món ăn");
                vboxStatus.setBackground(new Background(new BackgroundFill(
                        Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY)));
                vboxMonAn.toFront();
                btThongtin.setStyle("-fx-background-color:#FC95BB");
                btMonAn.setStyle("-fx-background-color:  #F7B3C8");

            }

        } else if (event.getSource() == backTTKH) {
            lbStatusMIn.setText("/home/thongtin");
            lbStatus.setText("Thông tin chung");
            vboxStatus.setBackground(new Background(new BackgroundFill(
                    Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
            vboxThongTin.toFront();
            btThongtin.setStyle("-fx-background-color:#F7B3C8");
            btMonAn.setStyle("-fx-background-color:#FC95BB");

        } else if (event.getSource() == nextDichVu) {
            lbStatusMIn.setText("/home/dichvu");
            lbStatus.setText("Dịch vụ");
            vboxStatus.setBackground(new Background(new BackgroundFill(
                    Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY)));
            VboxDichVu.toFront();
            btDichVu.setStyle("-fx-background-color:  #F7B3C8");
            btMonAn.setStyle("-fx-background-color:#FC95BB");
            tbThucPham.getSelectionModel().clearSelection();
            tbThucPhamC.getSelectionModel().clearSelection();

        } else if (event.getSource() == backMonAn) {
            lbStatusMIn.setText("/home/monan");
            lbStatus.setText("Món ăn");
            vboxStatus.setBackground(new Background(new BackgroundFill(
                    Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY)));
            
            vboxMonAn.toFront();
            btMonAn.setStyle("-fx-background-color:  #F7B3C8");
            btDichVu.setStyle("-fx-background-color:#FC95BB");

        } else if (event.getSource() == nextXacNhan) {
            NapThongTinXacNhan();
            lbStatusMIn.setText("/home/xacnhan");
            lbStatus.setText("Xác nhận");
            vboxStatus.setBackground(new Background(new BackgroundFill(
                    Color.rgb(197, 245, 226), CornerRadii.EMPTY, Insets.EMPTY)));
            
            vboxXacNhan.toFront();
            BtXacNhan.setStyle("-fx-background-color:  #F7B3C8");
            btDichVu.setStyle("-fx-background-color:#FC95BB");
            tbXacNhanDV.setItems(tbDichVuC.getItems());
            tbXacNhanTP.setItems(tbThucPhamC.getItems());
            
        } else if (event.getSource() == backDichVu) {
            lbStatusMIn.setText("/home/dichvu");
            lbStatus.setText("Dịch vụ");
            vboxStatus.setBackground(new Background(new BackgroundFill(
                    Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY)));
            
            VboxDichVu.toFront();
            btDichVu.setStyle("-fx-background-color:  #F7B3C8");
            BtXacNhan.setStyle("-fx-background-color:#FC95BB");
        }
    }

    @FXML
    private void ActionBack(javafx.event.ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);

    }

    public void kTraNhapTTKH() {
        // SET DIA CHI THEO CHIU DOC 
        taDiaChi.setWrapText(true);
        taXNDiaChi.setWrapText(true);

       
        // Ktra số bàn là số va gioi han 3 ki tu

        Utils.KiemTraLaSo(txtSoBan);
        Utils.gioiHanSo(3, txtSoBan);
        
        // Ktra số sdt là số va gioi han 11 ki tu
         Utils.KiemTraLaSo(txtSDT);
         Utils.gioiHanSo(11, txtSDT);
// Kiểm tra ngày đặt(ẩn những ngày quá khứ và hiện tại)
        List<Booking> ls = Utils.getBooking();
        dpNgayDat.setDayCellFactory(picker -> new DateCell() {

            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) <= 0);
            }
        });

    }

    private void chonTheoThuTu() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cbSanh.setDisable(true);
        rdCa1.setDisable(true);
        rdCa2.setDisable(true);
        dpNgayDat.valueProperty().addListener((observable, oldDate, newDate) -> {
            if (newDate != null) {

                // load Sanh "Thong tin dat tiec"
                this.cbSanh.getItems().clear();
                List<Sanh> s = Utils.getSanh();
                for (Sanh q : s) {
                    this.cbSanh.getItems().add(q.toString());
                }

                cbSanh.setValue(null);
                cbSanh.setDisable(false);
                rdCa1.setSelected(false);
                rdCa2.setSelected(false);
                rdCa1.setDisable(true);  
                rdCa2.setDisable(true);
                // 
                try {
                    Date dateChoose = sdf.parse(dpNgayDat.getValue().toString());

                    try {
                        List<Booking> bk = Utils.getBooking();
                        for (Booking a : bk) {
                            Date daDat1 = sdf.parse(a.getNgayDat().toString());
                            for (Booking b : bk) {
                                Date daDat2 = sdf.parse(b.getNgayDat().toString());         //lap lại để xác định có 2 ca đã chọn
                                if (daDat2.equals(dateChoose) && b.getCa() == '1' && (daDat1.equals(dateChoose) && a.getCa() == '2') && a.getSanh()==b.getSanh()
                                        || daDat2.equals(dateChoose) && b.getCa() == '2'&& (daDat1.equals(dateChoose) && a.getCa() == '1')& a.getSanh()==b.getSanh()) {
                                    cbSanh.getItems().remove(b.getSanh().getLoaiSanh());
                                    break;                   // ngắt lặp trog   }
                                }
                                
                            }
                        }
                    } catch (ParseException ex) {
                        System.err.print(ex.getMessage());
                    }
                } catch (ParseException ex) {
                     System.err.print(ex.getMessage());
                }

                //
                cbSanh.valueProperty().addListener((observable1, oldDate1, newDate1) -> {

                    if (newDate1 != null) {
                        rdCa1.setSelected(false);
                        rdCa2.setSelected(false);
                        rdCa1.setDisable(true);
                        rdCa2.setDisable(true);

                        try {
                            Date dateChoose = sdf.parse(dpNgayDat.getValue().toString());
                            cbSanh.setValue(newDate1);
                            try {
                                List<Booking> bk = Utils.getBooking();
                                for (Booking a : bk) {
                                    Date daDat1 = sdf.parse(a.getNgayDat().toString());
                                    if ((daDat1.equals(dateChoose) && a.getCa() == '2'
                                            && (a.getSanh().getLoaiSanh().equals(
                                                    cbSanh.getValue().toString())))
                                            || (daDat1.equals(dateChoose) && a.getCa() == '1') 
                                            && (a.getSanh().getLoaiSanh().equals(
                                                    cbSanh.getValue().toString()))) { // Nếu là đã có ca1 or 2

                                        if (daDat1.equals(dateChoose) && a.getCa()
                                                == '2' && (a.getSanh().getLoaiSanh().equals(
                                                        cbSanh.getValue().toString()))) {   //ca2 da dc chon
                                            
                                            rdCa1.setDisable(false);
                                            rdCa2.setDisable(true);
                                            break;
                                        } else {                    //ca 1 da dc chon
                                            rdCa1.setDisable(true);
                                            rdCa2.setDisable(false);
                                            break;
                                        }

                                    } else {

                                        rdCa1.setDisable(false);
                                        rdCa2.setDisable(false);
                                    }
                                }
                            } catch (ParseException ex) {
                                System.err.print(ex.getMessage());
                            }
                        } catch (ParseException ex) {
                             System.err.print(ex.getMessage());
                        }
                    }

                });

            }

        });

    }


    public void init() {
        
// 
    tbDichVu.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tbDichVuC.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tbXacNhanDV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tbThucPham.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tbThucPhamC.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tbXacNhanTP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//Group radio button

        ToggleGroup toggleGroup = new ToggleGroup();
        rdCa1.setToggleGroup(toggleGroup);
        rdCa2.setToggleGroup(toggleGroup);

//set bt thong tin dc chon
        vboxThongTin.toFront();
        btThongtin.setStyle("-fx-background-color:  #F7B3C8");

// Load danh sách DichVu
        TableColumn clTenLoaiDV = new TableColumn("Tên dịch vụ");
        clTenLoaiDV.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbDichVu.getColumns().addAll(clTenLoaiDV, clPrice, clNote);
        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));
        
// Bảng chọn dịch vụ
        TableColumn clTenLoaiDVC = new TableColumn("Tên dịch vụ");
        clTenLoaiDVC.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clPriceC = new TableColumn("Giá");
        clPriceC.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNoteC = new TableColumn("Ghi chú");
        clNoteC.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbDichVuC.getColumns().addAll(clTenLoaiDVC, clPriceC, clNoteC);
        
//Bảng xác nhận dịch vụ
        TableColumn clXacNhanTenLoaiDV = new TableColumn("Tên dịch vụ");
        clXacNhanTenLoaiDV.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clXacNhanPrice = new TableColumn("Giá");
        clXacNhanPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clXacNhanNote = new TableColumn("Ghi chú");
        clXacNhanNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbXacNhanDV.getColumns().addAll(clXacNhanTenLoaiDV, clXacNhanPrice, clXacNhanNote);
        
// Load danh sách Thuc pham
        TableColumn clTenTP = new TableColumn("Tên");
        clTenTP.setCellValueFactory(new PropertyValueFactory("tenTP"));
        TableColumn clLoaiTp = new TableColumn("Loại");
        clLoaiTp.setCellValueFactory(new PropertyValueFactory("loaiTP"));
        TableColumn clPriceTP = new TableColumn("Giá");
        clPriceTP.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clNoteTP = new TableColumn("Ghi chú");
        clNoteTP.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbThucPham.getColumns().addAll(clTenTP, clLoaiTp, clPriceTP, clNoteTP);
        this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getThucPham()));

//Bảng chọn thưc phẩm
        TableColumn clTenTPC = new TableColumn("Tên");
        clTenTPC.setCellValueFactory(new PropertyValueFactory("tenTP"));
        TableColumn clLoaiTpC = new TableColumn("Loại");
        clLoaiTpC.setCellValueFactory(new PropertyValueFactory("loaiTP"));
        TableColumn clPriceTPC = new TableColumn("Giá");
        clPriceTPC.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clNoteTPC = new TableColumn("Ghi chú");
        clNoteTPC.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbThucPhamC.getColumns().addAll(clTenTPC, clLoaiTpC, clPriceTPC, clNoteTPC);
        
//Bảng xác nhận thực phẩm
        TableColumn clXacNhanTenTP = new TableColumn("Tên");
        clXacNhanTenTP.setCellValueFactory(new PropertyValueFactory("tenTP"));
        TableColumn clXacNhanLoaiTp = new TableColumn("Loại");
        clXacNhanLoaiTp.setCellValueFactory(new PropertyValueFactory("loaiTP"));
        TableColumn clXacNhanPriceTP = new TableColumn("Giá");
        clXacNhanPriceTP.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clXacNhanNoteTP = new TableColumn("Ghi chú");
        clXacNhanNoteTP.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbXacNhanTP.getColumns().addAll(clXacNhanTenTP, clXacNhanLoaiTp,
                clXacNhanPriceTP, clXacNhanNoteTP);
    }

    // Chọn thực phẩm
    @FXML
    private void themTP(ActionEvent event) throws IOException {
        try {
            Thucpham s = (Thucpham) tbThucPham.getSelectionModel().getSelectedItem();
            if (s == null) {
                
                s = (Thucpham) tbThucPhamC.getSelectionModel().getSelectedItem();
                if (s == null) {
                    Utils.getAlertTC("Hãy chọn thực phẩm!!!", Alert.AlertType.ERROR).show();
                } else {
                    this.tbThucPham.getItems().add(s);
                    this.tbThucPhamC.getItems().remove(s);
                    this.tbThucPhamC.getSelectionModel().clearSelection();
                }
                
            } else {

                this.tbThucPhamC.getItems().add(s);
                this.tbThucPham.getItems().remove(s);
                this.tbThucPham.getSelectionModel().clearSelection();
                
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

    }
//Chọn dịch vụ

    @FXML
    private void themDV(ActionEvent event) throws IOException {
        try {
            Dichvu s = (Dichvu) tbDichVu.getSelectionModel().getSelectedItem();
            if (s == null) {
                
                s = (Dichvu) tbDichVuC.getSelectionModel().getSelectedItem();
                if (s == null) {
                    
                    Utils.getAlertTC("Hãy chọn dịch vụ!!!", Alert.AlertType.ERROR).show();
                    
                } else {
                    
                    this.tbDichVu.getItems().add(s);
                    this.tbDichVuC.getItems().remove(s);
                    this.tbDichVuC.getSelectionModel().clearSelection();
                    
                }
            } else {

                this.tbDichVuC.getItems().add(s);
                this.tbDichVu.getItems().remove(s);
                this.tbDichVu.getSelectionModel().clearSelection();
                
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());

        }

    }

    // kiem trA SDT
    public void TextFieldKeyPressed(javafx.scene.input.KeyEvent evt) {

       
        Utils.KiemTraLaSo(txtSDT);
       

    }

    @FXML
    private void saveBooking(ActionEvent event) throws IOException {
        try {
            Utils.getAlertTC("Xác nhận đặt tiệc!!", Alert.AlertType.CONFIRMATION)
                    .showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    Character ca;
                    Integer soBan = Integer.parseInt(txtSoBan.getText());

                    LocalDate localDate = dpNgayDat.getValue();
                    
                    Date ngayDat = Date.from(localDate.atStartOfDay().atZone(
                            ZoneId.systemDefault()).toInstant());

                    String note = String.format("%s\r\n%s", txtLoaiTiec.getText(),
                            taGhiChu.getText());
                    
                    Nhanvien nv = Utils.findStaff(Utils.getUsernameText());
                    
                    Menu menu = new Menu(tbThucPhamC.getItems());
                    
                    Khachhang kh = new Khachhang(txtTenKH.getText(),
                            txtSDT.getText(), taDiaChi.getText());
                    
                    Sanh s = Utils.getSanhByTypeName((String) cbSanh.
                            getSelectionModel().getSelectedItem());
                    
                    List<Dichvu> dv = tbDichVuC.getItems();

                    if (rdCa1.isSelected()) {
                        ca = '1';
                    } else {
                        ca = '2';
                    }

                    if (Utils.addBooking(ngayDat, ca, nv, kh, s, menu, dv, soBan, note)) {

                        try {
                            Scene sce = new Scene(FXMLLoader.load(getClass().getResource("DatTiec.fxml")));
                            Utils.switchStage(sce, event);
                        } catch (IOException ex) {
                            Logger.getLogger(DatTiecController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Utils.getAlertTC("Đặt thành công!!!", Alert.AlertType.INFORMATION).show();
                    } else {
                        Utils.getAlertTC("Đặt thất bại!!!", Alert.AlertType.ERROR).show();
                    }
                } else if (rs == ButtonType.NO) {
                    return;
                }
            });

        } catch (Exception e) {
            System.err.print(e.getMessage());

        }

    }

    private void NapThongTinXacNhan() {
        txtXNTenKH.setText(txtTenKH.getText());
        txtXNSDT.setText(txtSDT.getText());
        txtXNLoaiTiec.setText(txtLoaiTiec.getText());
        txtXNSoBan.setText(txtSoBan.getText());
        txtXNNgay.setText(dpNgayDat.getValue().toString());
        txtXNSANH.setText(cbSanh.getValue().toString());

        if (rdCa1.isSelected()) {
            txtXNCa.setText("Trưa");
        } else {
            txtXNCa.setText("Tối");
        }
     
        taXNDiaChi.setText(taDiaChi.getText());

// Show tổng tiền
        Double Tong = Utils.getSanhByTypeName(txtXNSANH.getText()).getGia().doubleValue();
        if(!tbDichVuC.getItems().isEmpty())
        {
            List<Dichvu> dv = tbDichVuC.getItems();
            for(Dichvu d : dv){
                Tong += d.getGia().doubleValue();
            }

        }
        if(!tbThucPhamC.getItems().isEmpty())
        {
            List<Thucpham> tp = tbThucPhamC.getItems();
            for(Thucpham t : tp){
                Tong += t.getPrice().doubleValue() * Double.parseDouble(txtSoBan.getText());
            }
        }
        
        
        txtXNTongTien.setText(String.format(Utils.formatCurrency(Tong) + "VNĐ"));

    }

}
