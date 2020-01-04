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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart ;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
    private VBox vboxBarChart, vboxPieChart;
    @FXML 
    private Button btQuayLai;
    @FXML
    private Button btQuanLy;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
       
        barChart();
        
    }    

     
 
    
    public void pieChart(int nam){
        
        
      
        
        PieChart.Data sine1 = new PieChart.Data("Tháng 1", Utils.tinhDoanhThuThang(1,nam));
        PieChart.Data sine2 = new PieChart.Data("Tháng 2", Utils.tinhDoanhThuThang(2,nam));
        PieChart.Data sine3 = new PieChart.Data("Tháng 3", Utils.tinhDoanhThuThang(3,nam));
        PieChart.Data sine4 = new PieChart.Data("Tháng 4", Utils.tinhDoanhThuThang(4,nam));
        PieChart.Data sine5 = new PieChart.Data("Tháng 5", Utils.tinhDoanhThuThang(5,nam));
        PieChart.Data sine6 = new PieChart.Data("Tháng 6", Utils.tinhDoanhThuThang(6,nam));
        PieChart.Data sine7 = new PieChart.Data("Tháng 7", Utils.tinhDoanhThuThang(7,nam));
        PieChart.Data sine8 = new PieChart.Data("Tháng 8", Utils.tinhDoanhThuThang(8,nam));
        PieChart.Data sine9 = new PieChart.Data("Tháng 9", Utils.tinhDoanhThuThang(9,nam));
        PieChart.Data sine10 = new PieChart.Data("Tháng 10", Utils.tinhDoanhThuThang(10,nam));
        PieChart.Data sine11 = new PieChart.Data("Tháng 11", Utils.tinhDoanhThuThang(11,nam));
        PieChart.Data sine12 = new PieChart.Data("Tháng 12", Utils.tinhDoanhThuThang(12,nam));
   
        pieChart.getData().clear();
        pieChart.getData().addAll(sine1, sine2, sine3, sine4, sine5, sine6, sine7, sine8, sine9, sine10, sine11, sine12);   
       
        pieChart.setLegendSide(Side.LEFT);
       
        
        
        pieChart.getData().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
              
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
            data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " \n",Utils.formatCurrency(data.pieValueProperty().getValue()), " VNĐ"
                        )
                );
            
            
        });
        
        
        
    }
   
     public void barChart( ) {
          vboxBarChart.toFront();
          btQuanLy.toFront();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        //final BarChart<String,Number> bc = new BarChart(xAxis,yAxis);
         final BarChartExt<String, Number> bc = new BarChartExt<>(xAxis, yAxis);
        bc.setTitle("Doanh thu năm");
        xAxis.setLabel("Năm");       
        yAxis.setLabel("VNĐ");
        xAxis.setTickLabelFont(javafx.scene.text.Font.font("Arial", 22));
        XYChart.Series series1 = new XYChart.Series<>();
        
        // Láy ds năm có trong bill
        ArrayList<Integer> dsNam = new ArrayList<>();
        ArrayList<Integer> dsNamDaLoc = new ArrayList<>();

         List<Booking> bk = Utils.getBooking();
         bk.forEach((a) -> {
             //Loc ds booking
             try{
                 Date date = a.getNgayThanhToan();      //.lay ngay thanh toan
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(date);                   //set cal = ngay thanh toan
                 int namCSDL = cal.get(Calendar.YEAR);
                 dsNam.add(namCSDL);
                 
                 for (int item : dsNam) {
                     //kiem tra ds da có trong mảng chưa và thêm vào
                     if (!dsNamDaLoc.contains(item)) {
                         dsNamDaLoc.add(item);
                         
                     }
                 }
                 
             }catch(NullPointerException ex){ // su ly ngay thanh toan rong
             }
        });
         Collections.sort(dsNamDaLoc);
         // lay ds nam da loc duoi csdl de add vao 
        series1.setName("Năm");
        dsNamDaLoc.forEach( n -> {
          series1.getData().add(new XYChart.Data(""+n, Utils.tinhDoanhThuNam(n)));
        
        });
        
        bc.getData().clear();
        bc.getData().addAll(series1);
      
        //Lay tung node 
        bc.getData().forEach((data) -> {
            data.getData().forEach((item) -> {
                item.getNode().setOnMousePressed((MouseEvent event) -> {
                    pieChart(Integer.parseInt(item.getXValue()));
                    vboxPieChart.toFront();    
                    btQuayLai.toFront();
                });               
            });
        });
        
    
       
        bc.setPrefSize(972, 565);
        vboxBarChart.getChildren().add(bc);
    
     }
        
      @FXML
   private void ActionBack(javafx.event.ActionEvent event) throws IOException
   {

              Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);


   }
    @FXML
   private void ActionBackBarChart(javafx.event.ActionEvent event) throws IOException
   {
        
       btQuanLy.toFront();
       vboxBarChart.toFront();

   }
     
    private static class BarChartExt<X, Y> extends BarChart<X, Y> {   //thiêt kế barchar khác kế thừa từ lớp barchar

        /**
         * Registry for text nodes of the bars
         */
        Map<Node, Node> nodeMap = new HashMap<>();

        public BarChartExt(Axis xAxis, Axis yAxis) {
            super(xAxis, yAxis);
        }

        /**
         * them text vao bars
         */
        @Override
        protected void seriesAdded(XYChart.Series<X, Y> series, int seriesIndex) {

            super.seriesAdded(series, seriesIndex);

            for (int j = 0; j < series.getData().size(); j++) {

                XYChart.Data<X, Y> item = series.getData().get(j);

                Node text = new Text(Utils.formatCurrency( Double.parseDouble(String.valueOf(item.getYValue())) )+" VNĐ" ); //đỊNH DẠNG TEXT HIEN THI
                nodeMap.put(item.getNode(), text);
                getPlotChildren().add(text);

            }

        }

     

        /**
         * Adjust text of bars, position them on top
         */
        @Override
        protected void layoutPlotChildren() {

            super.layoutPlotChildren();

            nodeMap.keySet().forEach((bar) -> {
                Node text = nodeMap.get(bar);
                text.relocate(bar.getBoundsInParent().getMinX(), bar.getBoundsInParent().getMinY()-25 );
            });

        }
    }
  
    
}