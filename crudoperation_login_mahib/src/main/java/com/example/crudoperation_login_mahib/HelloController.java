package com.example.crudoperation_login_mahib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldDescription;
    @FXML
    private TextField fieldStatus;
    @FXML
    private Label lblMessage;
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<TaskRecord> tblView;
    @FXML
    private TableColumn<TaskRecord,Integer > tblColId;
    @FXML
    private TableColumn<TaskRecord, String> tblColName;
    @FXML
    private TableColumn<TaskRecord,String> tblColDescription;
    @FXML
    private TableColumn<TaskRecord,String> tblColStatus;
    ObservableList<TaskRecord> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblColId.setCellValueFactory(new PropertyValueFactory<TaskRecord,Integer>("task_id"));
        tblColName.setCellValueFactory(new PropertyValueFactory<TaskRecord,String>("task_name"));
        tblColDescription.setCellValueFactory(new PropertyValueFactory<TaskRecord,String>("task_description"));
        tblColStatus.setCellValueFactory(new PropertyValueFactory<TaskRecord,String>("task_status"));
        tblView.setItems(list);
    }
    String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test2(testday)";
    String dbUser = "root";
    String dbPassword = "";

}