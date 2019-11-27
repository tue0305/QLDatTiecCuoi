/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytieccuoi;

import POJO.Sanh;
import Util.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cohotech
 */
public class SanhController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView tbSanh;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadSanh();
    }

    public void backAction(ActionEvent event) throws IOException {

        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        Utils.switchStage(sce, event);

    }
    public void loadSanh()
    {
        TableColumn clTenSanh = new TableColumn("Tên sảnh");
        clTenSanh.setCellValueFactory(new PropertyValueFactory("tenSanh"));
        TableColumn clLoaiSanh = new TableColumn("Loại sảnh");
        clLoaiSanh.setCellValueFactory(new PropertyValueFactory("loaiSanh"));
        TableColumn clPrice = new TableColumn("Giá");
        clPrice.setCellValueFactory(new PropertyValueFactory("gia"));
        TableColumn clNote = new TableColumn("Ghi chú");
        clNote.setCellValueFactory(new PropertyValueFactory("ghiChu"));

        TableColumn colAction = new TableColumn();
        colAction.setCellFactory(p -> {

            Button btn = new Button("Xóa");

            btn.setOnAction(et -> {
                Alert a = Utils.getAlertTC("Are you sure?", Alert.AlertType.CONFIRMATION);
                a.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        TableCell cl = (TableCell) ((Button) et.getSource()).getParent();
                        Sanh s = (Sanh) cl.getTableRow().getItem();

                        if (Utils.deleteSanh(s) == true) {
                            Utils.getAlertTC("Delete succcessful!!!", Alert.AlertType.INFORMATION).show();
                            
                        } else {
                            Utils.getAlertTC("Delete failed!!!", Alert.AlertType.ERROR).show();
                        }
                    }
                });

            });

            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });

        this.tbSanh.getColumns().addAll(clTenSanh, clLoaiSanh, clPrice, clNote, colAction);
        this.tbSanh.setItems(FXCollections.observableArrayList(Utils.getSanh()));
    }

//    public void addSanh(ActionEvent event) throws IOException {
//
//        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
//        Utils.switchStage(sce, event);
//
//    }
//
//    public void xoaSanh(ActionEvent event) throws IOException {
//
//        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
//        Utils.switchStage(sce, event);
//
//    }
//
//    public void suaSanh(ActionEvent event) throws IOException {
//
//        Scene sce = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
//        Utils.switchStage(sce, event);
//
//    }
}
