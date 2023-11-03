/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudoperationproject.view;

import com.sun.jmx.snmp.BerDecoder;
import crudoperationproject.controller.UserControl;
import crudoperationproject.model.User;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Mohamed
 */
public class LeftPane extends VBox{
    
    Label labelTitle = new Label("Add New User");
    TextField txtName = new TextField();
    TextField txtAge = new TextField();
    TextField txtYear = new TextField();
    
    
    Button btnSave = new Button("Save");
    Button btnUpdate = new Button("Update");
    Button btnDelete = new Button("Delete");
    
    UserControl userControl =new UserControl();
    
    int tempId;
    
    public LeftPane() {
        
        txtName.setFont(new Font(20));
        txtAge.setFont(new Font(20));
        txtYear.setFont(new Font(20));
        
        txtName.setPromptText("Enter Name");
        txtAge.setPromptText("Enter Age");
        txtYear.setPromptText("Enter Year");
        
        btnSave.setPrefWidth(150);
        btnUpdate.setPrefWidth(150);
        btnDelete.setPrefWidth(150);
        
        btnSave.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18;-fx-text-fill:#fff;");
        btnUpdate.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18;-fx-text-fill:#fff;");
        btnDelete.setStyle("-fx-background-color:#2ecc71;-fx-font-size:18;-fx-text-fill:#fff;");
        
        labelTitle.setStyle("-fx-font-size:20px;-fx-text-fill:#fff");
        
        this.setStyle("-fx-background-color:#3498db");
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(labelTitle, txtName, txtAge, txtYear, btnSave, btnUpdate, btnDelete);
    
    
    
        /// action
        /*
        btnSave.setOnMouseClicked(new EventHandler<MouseEvent> () {

            @Override
            public void handle(MouseEvent t) {
                
            }
        });
        */
        
        btnSave.setOnMouseClicked(e->{
            User user = new User();
            user.setName(txtName.getText());
            user.setAge(Integer.parseInt(txtAge.getText()));
            user.setYear(Integer.parseInt(txtYear.getText()));
            
            userControl.insert(user);
            
            CRUDOperationProject.rightPane.table.setItems(userControl.getAllUsers());
            
            txtName.setText("");
            txtAge.setText("");
            txtYear.setText("");
        });
            
        
        btnUpdate.setOnMouseClicked(e->{
            User user = new User();
            user.setId(tempId);
            user.setName(txtName.getText());
            user.setAge(Integer.parseInt(txtAge.getText()));
            user.setYear(Integer.parseInt(txtYear.getText()));
            
            userControl.update(user);
            
            CRUDOperationProject.rightPane.table.setItems(userControl.getAllUsers());
            
            txtName.setText("");
            txtAge.setText("");
            txtYear.setText("");
            
        });
        
        btnDelete.setOnMouseClicked(e->{
            userControl.Delete(tempId);
            CRUDOperationProject.rightPane.table.setItems(userControl.getAllUsers());
            
            txtName.setText("");
            txtAge.setText("");
            txtYear.setText("");
            
        });
    
    }
}
