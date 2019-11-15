///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package FXML;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TreeItem;
//import javafx.scene.control.TreeView;
//
//
///**
// * FXML Controller class
// *
// * @author ThanhDepTrai
// */
//public class QuanLyDatTiecController implements Initializable {
//
//    /**
//     * Initializes the controller class.
//     */
//    private TreeView <String> treeView;
//   
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//    TreeItem<String> root = new TreeItem<>("Root Node");
//    root.setExpanded(true);
//    TreeItem<String> nodeA = new TreeItem<>("Node A");
//    TreeItem<String> nodeB = new TreeItem<>("Node B");
//    TreeItem<String> nodeC = new TreeItem<>("Node  C");
//    
//    root.getChildren().add(nodeA);
//    root.getChildren().add(nodeB);
//    root.getChildren().add(nodeC);
//    treeView.setRoot(root);
//    
//    
////        new TreeItem<String>("Item 1"),
////        new TreeItem<String>("Item 2"),
////        new TreeItem<String>("Item 3")
////    );
////    TreeView<String> treeView = new TreeView<String>(root);
//// 
////    }
//
//
//      
//    
//    }
//
//    /**
//     * @return the treeView
//     */
//    public TreeView <String> getTreeView() {
//        return treeView;
//    }
//
//    /**
//     * @param treeView the treeView to set
//     */
//    public void setTreeView(TreeView <String> treeView) {
//        this.treeView = treeView;
//    }
//
//
//
//}
