

package quanlytieccuoi;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author cohotech
 */
public class QuanLyTiecCuoi extends Application {
    
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @Override
    public void start(Stage stage) throws Exception {





        Parent root = FXMLLoader.load(getClass().getResource("DangNhap.fxml"));

        stage.heightProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               double heigth =(double) newValue;
               
            }
        });

//        stage.initStyle(StageStyle.TRANSPARENT);

           //Lay Vi tri 
             root.setOnMousePressed((MouseEvent event) -> {
                 xOffset = event.getSceneX();
                 yOffset = event.getSceneY();
        });
        
        //mdi chuyen xung quanh
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/img/store.png"));
        stage.setTitle("Quản lý Tiệc Cưới");
         //set transparent
//        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
   


}
