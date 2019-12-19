    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;
import POJO.Booking;
import POJO.Sanh;
import Util.Utils;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class TEsstController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private Button btThongtin;

    @FXML
    private Button btMonAn;

    @FXML
    private Button btDichVu;

    @FXML
    private Button BtXacNhan;

    @FXML
    private VBox vboxStatus;

    @FXML
    private Label lbStatusMIn;

    @FXML
    private Label lbStatus;

    @FXML
    private VBox vboxThongTin;

    @FXML
    private VBox vboxMonAn;

    @FXML
    private VBox VboxDichVu;

    @FXML
    private VBox vboxXacNhan;
    @FXML
    private TableView tbDichVu;

    // ThongTin KH VA SANH
    @FXML
    private ComboBox cbSanh;
    @FXML
    private TextField txtTenKH;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtSoBan;
    @FXML 
    private JFXRadioButton rdCa1;
    @FXML 
    private JFXRadioButton rdCa2;
    @FXML
    private DatePicker ngayDat;
    @FXML
    private TextArea taDiaChi;
    @FXML
    private Button nextMonAn;
    @FXML
    private Button nextDichVu;
    @FXML
    private Button nextXacNhan;
    @FXML
    private Button backTTKH;
    @FXML
    private Button backDichVu;
    @FXML
    private Button backMonAn;
    //Thong tin dat mon an
    @FXML
    private TableView tbThucPham;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        init();
        kTraNhapTTKH();
       
    }
    @FXML
    private void handleClicks(ActionEvent event){

//        if(event.getSource() ==btThongtin)
//        {
//            lbStatusMIn.setText("/home/thongtin");
//            lbStatus.setText("Thông tin chung");
//            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY) ));
//            vboxThongTin.toFront();
//        }
//        else
//        if(event.getSource() ==btMonAn)
//        {
//                lbStatusMIn.setText("/home/monan");
//                lbStatus.setText("Món ăn");
//                vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY) ));
//                vboxMonAn.toFront();
//
//        }
//        else if(event.getSource() ==btDichVu)
//        {
//            lbStatusMIn.setText("/home/dichvu");
//            lbStatus.setText("Dịch vụ");
//            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY) ));
//            VboxDichVu.toFront();
//        }
//        else if(event.getSource() ==BtXacNhan)
//        {
//            lbStatusMIn.setText("/home/xacnhan");
//            lbStatus.setText("Xác nhận");
//            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(251, 15, 80), CornerRadii.EMPTY, Insets.EMPTY) ));
//            vboxXacNhan.toFront();
//
//        }
      
        if(event.getSource() ==nextMonAn)
        {
                      if (txtTenKH.getText().isEmpty() || txtSDT.getText().isEmpty()||ngayDat.getValue()==null ||cbSanh.getSelectionModel().isEmpty()||taDiaChi.getText().isEmpty()|| (!rdCa1.isSelected()&&!rdCa2.isSelected() )||txtSoBan.getText().isEmpty() ) {
                Alert b = Utils.getAlertTC("Hãy điển đẩy đủ thông tin!!!", Alert.AlertType.ERROR); 
                b.show();
                } else{
                               
                                lbStatusMIn.setText("/home/monan");
                                lbStatus.setText("Món ăn");
                                vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY) ));
                                vboxMonAn.toFront();
                                btThongtin.setStyle("-fx-background-color:#FC95BB");
                                btMonAn.setStyle("-fx-background-color:  #F7B3C8");
                                
                    }

        }
          else if(event.getSource() ==backTTKH)
        {
           lbStatusMIn.setText("/home/thongtin");
            lbStatus.setText("Thông tin chung");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxThongTin.toFront();
            btThongtin.setStyle("-fx-background-color:#F7B3C8");
            btMonAn.setStyle("-fx-background-color:#FC95BB");

        }
          else if(event.getSource() ==nextDichVu)
        {
            lbStatusMIn.setText("/home/dichvu");
            lbStatus.setText("Dịch vụ");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY) ));
            VboxDichVu.toFront();
            btDichVu.setStyle("-fx-background-color:  #F7B3C8");
            btMonAn.setStyle("-fx-background-color:#FC95BB");

        }
         else if(event.getSource() ==backMonAn)
        {
            lbStatusMIn.setText("/home/monan");
            lbStatus.setText("Món ăn");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxMonAn.toFront();
            btMonAn.setStyle("-fx-background-color:  #F7B3C8");
            btDichVu.setStyle("-fx-background-color:#FC95BB");

        }
         else if(event.getSource() ==nextXacNhan)
        {
            lbStatusMIn.setText("/home/xacnhan");
            lbStatus.setText("Xác nhận");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(197, 245, 226), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxXacNhan.toFront();
            BtXacNhan.setStyle("-fx-background-color:  #F7B3C8");
            btDichVu.setStyle("-fx-background-color:#FC95BB");
        }
         else if(event.getSource() ==backDichVu)
        {
           lbStatusMIn.setText("/home/dichvu");
            lbStatus.setText("Dịch vụ");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY) ));
            VboxDichVu.toFront();
            btDichVu.setStyle("-fx-background-color:  #F7B3C8");
            BtXacNhan.setStyle("-fx-background-color:#FC95BB");
        }
    }
       @FXML
   private void ActionBack(javafx.event.ActionEvent event) throws IOException
   {

              Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);


   }
   
   public void kTraNhapTTKH(){
         // SET DIA CHI THEO CHIU DOC 
       taDiaChi.setWrapText(true);
       // Ktra số bàn là số
       Utils.KiemTraLaSo(txtSoBan);
       //chon ngay tuong lai moi duoc
         ngayDat.valueProperty().addListener((observable, oldDate, newDate)->{            
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
      
         String s1 = sdf.format(new Date());
            if(newDate!=null){    // Ngày chọn xong rồi mới xử lý
                
            try {
                
                Date datetoday = sdf.parse(s1);
                Date dateChoose = sdf.parse(ngayDat.getValue().toString());
                if(dateChoose.after(datetoday)){            
                     ngayDat.setValue(newDate);
                    
                     try { 
                           
                            
                           List<Booking> bk = Utils.getBooking();
                            for(Booking a : bk){   
                                 Date daDat = sdf.parse(a.getNgayDat().toString());
                               if((daDat.equals(dateChoose)&&a.getCa()=='1')&&(daDat.equals(dateChoose)&&a.getCa()=='2')){    //ngay có trong csdl //chưa xử lý xong , chưa lấy được ca2 và ca1 full ngay
                                  rdCa1.setDisable(true);
                                  rdCa2.setDisable(true);    //cả 2 ca đã được chọn                                                                    
                                       break;
                                    }else{if(daDat.equals(dateChoose)&&a.getCa()=='2'){  
                                
                                        rdCa2.setDisable(true);
                                        rdCa1.setDisable(false);   // ca 2 đã chọn
                                          break;
                                        }else{if(daDat.equals(dateChoose)&&a.getCa()=='1'){
                                          
                                                     rdCa1.setDisable(true);
                                                     rdCa2.setDisable(false); // ca 1 đã chọn
                                                     break;
                                                       }else{
                                                            
                                                      rdCa1.setDisable(false);
                                                      rdCa2.setDisable(false);
                                                           }                                      
                                    }                             
                                    }
                                    
                            }} catch (ParseException ex) {
                           Logger.getLogger(TEsstController.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    
                }else{
                   ngayDat.setValue(null);
                     Alert c = Utils.getAlertTC("Chỉ đặt trong tương lai!!!", Alert.AlertType.ERROR); 
                     c.show();
               }} catch (ParseException ex) {
                Logger.getLogger(TEsstController.class.getName()).log(Level.SEVERE, null, ex);
            }              
                        }                
         });       
       
       
   }
 

    public void init() {
        //set bt thong tin dc chon
         vboxThongTin.toFront();
        btThongtin.setStyle("-fx-background-color:  #F7B3C8");
        
        // load Sanh "Thong tin dat tiec"
        List<Sanh> s = Utils.getSanh();
        for(Sanh q : s)
        {
            this.cbSanh.getItems().add(q.getTenSanh());
        }
           
        // Load danh sách DichVu
        TableColumn clTenLoaiDV = new TableColumn("Tên dịch vụ");
        clTenLoaiDV.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbDichVu.getColumns().addAll(clTenLoaiDV, clPrice, clNote);
        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));
        // Load danh sách Thuc pham
        TableColumn clTenTP = new TableColumn("Tên");
        clTenTP.setCellValueFactory(new PropertyValueFactory("tenTP"));
        TableColumn clLoaiTp = new TableColumn("Loại");
        clLoaiTp.setCellValueFactory(new PropertyValueFactory("loaiTP"));
        TableColumn clPriceTP = new TableColumn("Giá");
        clPriceTP.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn clNoteTP= new TableColumn("Ghi chú");
        clNoteTP.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbThucPham.getColumns().addAll(clTenTP, clLoaiTp, clPriceTP, clNote);
        this.tbThucPham.setItems(FXCollections.observableArrayList(Utils.getThucPham()));

    }


     // kiem trA SDT
     public void   TextFieldKeyPressed(javafx.scene.input.KeyEvent evt){
                    
                    String str = txtSDT.getText();
                    int lengthstr = str.length();
                    Utils.KiemTraLaSo(txtSDT);
                    if(lengthstr<11){          //gioi han 11 so
                       txtSDT.setEditable(true);
                       }  
                     else{
                    txtSDT.setEditable(false);                            
                              if(evt.getCode()==KeyCode.DELETE || evt.getCode()==KeyCode.BACK_SPACE)                            
                                  txtSDT.setEditable(true);
                               else
                                  txtSDT.setEditable(false);                               
                         }
                    
              }
     
     
  
    
     
     
     
 }
     
     
     
     
     

