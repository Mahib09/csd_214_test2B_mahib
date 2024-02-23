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
    String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test2(testday))";
    String dbUser = "root";
    String dbPassword = "";
    @FXML protected void onReadButtonClicked() {
        populateTable();
    }
    @FXML protected void onInsertButtonClicked(){ insertData(); }
    @FXML protected void onUpdateButtonClicked() { updateData(); }
    @FXML protected void onDeleteButtonClicked(){ deleteData();}
    @FXML protected void onLoadButtonClicked(){loadData();}

    public void setWelcomeText(String Name){
        welcomeText.setText("Hello, "+ Name+"!" );
    }
    public void populateTable() {
        list.clear();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM task_management";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int tblId = resultSet.getInt("task_id");
                String tblName = resultSet.getString("task_name");
                String tblDescription = resultSet.getString("task_description");
                String tblStatus = resultSet.getString("task_status");
                tblView.getItems().add(new TaskRecord(tblId,tblName,tblDescription,tblStatus));
            }     } catch (SQLException e) {
            e.printStackTrace();     }
    }
    public void insertData(){
        if(fieldName.getText().isEmpty()){
            lblMessage.setText("Name Required to Insert");
        }else{
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String query = "INSERT INTO task_management ( task_name, task_description, task_status) VALUES ('"+fieldName.getText()+"','"+fieldDescription.getText()+"','"+fieldStatus.getText()+"')";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                populateTable();
                clearForm();
            } catch (SQLException e) {
                e.printStackTrace();     }
        }

    }
    public void updateData(){
        if(fieldId.getText().isEmpty()){
            lblMessage.setText("Please Enter Id to Update");
        }else{
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String query = ("UPDATE task_management SET task_name='" + fieldName.getText() + "',task_description='" + fieldDescription.getText() + "',task_status='" + fieldStatus.getText() + "'WHERE task_id='" + fieldId.getText() + "'");
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                populateTable();
                clearForm();
            } catch (SQLException e) {
                e.printStackTrace();     }
        }

    }
    public void deleteData(){
        if(fieldId.getText().isEmpty()){
            lblMessage.setText("Please Enter Id to Delete");
        }else{ try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = ("DELETE FROM task_management WHERE task_id='"+fieldId.getText()+"'");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            populateTable();
            clearForm();
        } catch (SQLException e) {
            e.printStackTrace();     }}

    }
    public void loadData(){
        if(fieldId.getText().isEmpty()){
            lblMessage.setText("Please Enter Id to Load");
        }else{try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = ("SELECT * FROM task_management WHERE task_id='"+fieldId.getText()+"'");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            fieldName.setText(resultSet.getString("task_name"));
            fieldDescription.setText(resultSet.getString("task_description"));
            fieldStatus.setText(resultSet.getString("task_status"));
            lblMessage.setText("");
        } catch (SQLException e) {
            e.printStackTrace();     }}

    }
    public void clearForm(){
        fieldId.setText("");
        fieldName.setText("");
        fieldDescription.setText("");
        fieldStatus.setText("");
        lblMessage.setText("");
    }

}