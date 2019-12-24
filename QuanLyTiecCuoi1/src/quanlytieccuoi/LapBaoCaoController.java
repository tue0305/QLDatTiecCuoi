/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;
import Util.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class LapBaoCaoController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private  PieChart pieChart;
    @FXML
    private  BarChart barChard;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        barChar();
        init();
        
    }    
    
    
    public void init(){
        
        
      
        
        PieChart.Data sine1 = new PieChart.Data("Tháng 1", Utils.tinhDoanhThuThang(1));
        PieChart.Data sine2 = new PieChart.Data("Tháng 2", Utils.tinhDoanhThuThang(2));
        PieChart.Data sine3 = new PieChart.Data("Tháng 3", Utils.tinhDoanhThuThang(3));
        PieChart.Data sine4 = new PieChart.Data("Tháng 4", Utils.tinhDoanhThuThang(4));
        PieChart.Data sine5 = new PieChart.Data("Tháng 5", Utils.tinhDoanhThuThang(5));
        PieChart.Data sine6 = new PieChart.Data("Tháng 6", Utils.tinhDoanhThuThang(6));
        PieChart.Data sine7 = new PieChart.Data("Tháng 7", Utils.tinhDoanhThuThang(7));
        PieChart.Data sine8 = new PieChart.Data("Tháng 8", Utils.tinhDoanhThuThang(8));
        PieChart.Data sine9 = new PieChart.Data("Tháng 9", Utils.tinhDoanhThuThang(9));
        PieChart.Data sine10 = new PieChart.Data("Tháng 10", Utils.tinhDoanhThuThang(10));
        PieChart.Data sine11 = new PieChart.Data("Tháng 11", Utils.tinhDoanhThuThang(11));
        PieChart.Data sine12 = new PieChart.Data("Tháng 12", Utils.tinhDoanhThuThang(12));
   
        pieChart.getData().clear();
        pieChart.getData().addAll(sine1, sine2, sine3, sine4, sine5, sine6, sine7, sine8, sine9, sine10, sine11, sine12);   
       
        pieChart.setLegendSide(Side.LEFT);
       
        
        
        pieChart.getData().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Data");
                a.setContentText(data.getName()+" : "+Utils.formatCurrency(data.getPieValue())  +" VNĐ");
                a.showAndWait();
                
                //Hieu ung piechart
                        Bounds b1 = data.getNode().getBoundsInLocal();
                        double newX = (b1.getWidth()) / 2 + b1.getMinX();
                        double newY = (b1.getHeight()) / 2 + b1.getMinY();
                        // Make sure pie wedge location is reset
                        data.getNode().setTranslateX(0);
                        data.getNode().setTranslateY(0);
                        TranslateTransition tt = new TranslateTransition(
                        Duration.millis(1500), data.getNode());
                        tt.setByX(newX);
                        tt.setByY(newY);
                        tt.setAutoReverse(true);
                        tt.setCycleCount(2);
                        tt.play();

            });
        });
        
        
        
    }
    private void barChar(){

     xAxis.setLabel("Năm");
     yAxis.setLabel("VNĐ");

     barChard.setTitle("Doanh thu năm");
   XYChart.Series series1 = new XYChart.Series<>();
   series1.setName("Năm");
  
    series1.getData().add(new XYChart.Data("2018", Utils.tinhDoanhThuNam(2018)));
    series1.getData().add(new XYChart.Data("2019", Utils.tinhDoanhThuNam(2019)));
    series1.getData().add(new XYChart.Data("2020", Utils.tinhDoanhThuNam(2020)));
 
    barChard.getData().addAll(series1);
    }
   
    
    
      @FXML
   private void ActionBack(javafx.event.ActionEvent event) throws IOException
   {

              Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);


   }
  
    
}