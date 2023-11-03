/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudoperationproject.view;

import crudoperationproject.controller.UserControl;
import crudoperationproject.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Mohamed
 */
public class RightPane extends VBox{
    
    HBox searchPane = new HBox();
    TextField txtSearch = new TextField();
    Button btnSearch = new Button("Search");
    
    TableView<User> table = new TableView();
    
    UserControl userControl = new UserControl();
   
    public RightPane() {
        
        TableColumn<User , Integer> columnId = new TableColumn("ID");
        TableColumn<User , String> columnName = new TableColumn("Name");
        TableColumn<User , Integer> columnAge = new TableColumn("Age");
        TableColumn<User , Integer> columnYear = new TableColumn("Year");
        
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        
        columnId.prefWidthProperty().bind(table.widthProperty().divide(4));
        columnName.prefWidthProperty().bind(table.widthProperty().divide(4));
        columnAge.prefWidthProperty().bind(table.widthProperty().divide(4));
        columnYear.prefWidthProperty().bind(table.widthProperty().divide(4));
        
        table.getColumns().addAll(columnId , columnName , columnAge , columnYear);
        
        table.setItems(userControl.getAllUsers());
        
        searchPane.getChildren().addAll(txtSearch , btnSearch);
        searchPane.setSpacing(20);
        searchPane.setPadding(new Insets(10));
        searchPane.setAlignment(Pos.CENTER);
        
        this.setPadding(new Insets(20));
        this.getChildren().addAll(searchPane , table);
        
        
        table.setOnMouseClicked(e->{
            User user = table.getSelectionModel().getSelectedItem();
            CRUDOperationProject.leftPane.txtName.setText(user.getName());
            CRUDOperationProject.leftPane.txtAge.setText(user.getAge() + "");
            CRUDOperationProject.leftPane.txtYear.setText(user.getYear() + "");
            CRUDOperationProject.leftPane.tempId = user.getId();
            
        });
        
        btnSearch.setOnMouseClicked(e->{
            
            this.table.setItems(userControl.search(txtSearch.getText()));
        });
        
    }
    
}
