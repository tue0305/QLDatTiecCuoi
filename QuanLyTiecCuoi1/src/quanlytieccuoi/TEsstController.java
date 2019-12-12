    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;
import POJO.Sanh;
import Util.Utils;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    @FXML
    private ComboBox cbSanh;
    @FXML
    private TextField txtTenKH;
    @FXML
    private TextField txtSDT;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        init();
    }
    @FXML
    private void handleClicks(ActionEvent event){

        if(event.getSource() ==btThongtin)
        {
            lbStatusMIn.setText("/home/thongtin");
            lbStatus.setText("Thông tin chung");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxThongTin.toFront();
        }
        else
        if(event.getSource() ==btMonAn)
        {
            lbStatusMIn.setText("/home/monan");
            lbStatus.setText("Món ăn");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(169, 198, 245), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxMonAn.toFront();

        }
        else if(event.getSource() ==btDichVu)
        {
            lbStatusMIn.setText("/home/dichvu");
            lbStatus.setText("Dịch vụ");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(253, 247, 162), CornerRadii.EMPTY, Insets.EMPTY) ));
            VboxDichVu.toFront();
        }
        else if(event.getSource() ==BtXacNhan)
        {
            lbStatusMIn.setText("/home/xacnhan");
            lbStatus.setText("Xác nhận");
            vboxStatus.setBackground(new Background(new BackgroundFill(Color.rgb(251, 15, 80), CornerRadii.EMPTY, Insets.EMPTY) ));
            vboxXacNhan.toFront();

        }

    }
       @FXML
   private void ActionBack(javafx.event.ActionEvent event) throws IOException
   {

              Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);


   }

    public void init() {
// Load danh sách DichVu

        // load Sanh "Thong tin dat tiec"
        List<Sanh> s = Utils.getSanh();
        for(Sanh q : s)
        {
            this.cbSanh.getItems().add(q.getTenSanh());
        }

        



        TableColumn clTenDV = new TableColumn("Tên dịch vụ");
        clTenDV.setCellValueFactory(new PropertyValueFactory("tenDV"));
        TableColumn clLoaiDV = new TableColumn("Loại dịch vụ");
        clLoaiDV.setCellValueFactory(new PropertyValueFactory("loaiDV"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        this.tbDichVu.getColumns().addAll(clTenDV, clLoaiDV, clPrice, clNote);
        this.tbDichVu.setItems(FXCollections.observableArrayList(Utils.getDichVu()));
        
        

    }

     public void kiemTraThemTTKH(ActionEvent event) throws IOException {

            // kiem tra sdt
            if (txtTenKH.getText().isEmpty() || txtSDT.getText().isEmpty() ) {
                Alert b = Utils.getAlertTC("Hãy điển đẩy đủ thông tin!!!", Alert.AlertType.ERROR); 
                b.show();
                } else{
 
                                       Alert b = Utils.getAlertTC("XONG Buoc thêm!!!", Alert.AlertType.INFORMATION);
                                       b.show();
 
                    }
        }
             
     // kiem trA SDT
     public void   TextFieldKeyPressed(javafx.scene.input.KeyEvent evt){
                    
                    String str = txtSDT.getText();
                    int lengthstr = str.length();
                    // lang nghe va chi chon so nguyen
                     ChangeListener<String> forceNumberListener = (observable, oldValue, newValue) -> {  //observable la gia tri thay doi
                            if (!newValue.matches("\\d*"))
                              ((StringProperty) observable).set(oldValue);
                        };
                    txtSDT.textProperty().addListener(forceNumberListener);   // forceNumberListener se duoc goi neu co thay doi
                    
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
     
     
     
     
     

