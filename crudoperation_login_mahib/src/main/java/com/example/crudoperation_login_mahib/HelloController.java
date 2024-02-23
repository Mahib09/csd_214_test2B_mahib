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
        private TextField fieldEmail;
        @FXML
        private TextField fieldPhone;
        @FXML
        private Label lblMessage;
        @FXML
        private Label welcomeText;
        @FXML
        private TableView<EmployeeRecord> tblView;
        @FXML
        private TableColumn<EmployeeRecord,Integer > tblColId;
        @FXML
        private TableColumn<EmployeeRecord, String> tblColName;
        @FXML
        private TableColumn<EmployeeRecord,String> tblColEmail;
        @FXML
        private TableColumn<EmployeeRecord,Integer> tblColPhone;
        ObservableList<EmployeeRecord> list = FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            tblColId.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,Integer>("employeeId"));
            tblColName.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,String>("Name"));
            tblColEmail.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,String>("Email"));
            tblColPhone.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,Integer>("Phone"));
            tblView.setItems(list);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test2";
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
                String query = "SELECT * FROM employee";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int tblId = resultSet.getInt("employeeId");
                    String tblName = resultSet.getString("Name");
                    String tblEmail = resultSet.getString("Email");
                    int tblPhone = resultSet.getInt("Phone");
                    tblView.getItems().add(new EmployeeRecord(tblId,tblName,tblEmail,tblPhone));
                }     } catch (SQLException e) {
                e.printStackTrace();     }
        }
        public void insertData(){
            if(fieldName.getText().isEmpty()){
                lblMessage.setText("Name Required to Insert");
            }else{
                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                    String query = "INSERT INTO employee ( Name, Email, Phone) VALUES ('"+fieldName.getText()+"','"+fieldEmail.getText()+"','"+fieldPhone.getText()+"')";
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
                    String query = ("UPDATE employee SET Name='" + fieldName.getText() + "',Email='" + fieldEmail.getText() + "',Phone='" + fieldPhone.getText() + "'WHERE employeeId='" + fieldId.getText() + "'");
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
                String query = ("DELETE FROM employee WHERE employeeId='"+fieldId.getText()+"'");
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
                String query = ("SELECT * FROM employee WHERE employeeId='"+fieldId.getText()+"'");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                resultSet.next();
                fieldName.setText(resultSet.getString("Name"));
                fieldEmail.setText(resultSet.getString("Email"));
                fieldPhone.setText(resultSet.getString("Phone"));
                lblMessage.setText("");
            } catch (SQLException e) {
                e.printStackTrace();     }}

        }
        public void clearForm(){
            fieldId.setText("");
            fieldName.setText("");
            fieldEmail.setText("");
            fieldPhone.setText("");
            lblMessage.setText("");
        }
    }package com.example.csd214_test2_mahib;

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
import java.util.jar.Attributes;

    public class HelloController implements Initializable {

        @FXML
        private TextField fieldId;
        @FXML
        private TextField fieldName;
        @FXML
        private TextField fieldEmail;
        @FXML
        private TextField fieldPhone;
        @FXML
        private Label lblMessage;
        @FXML
        private Label welcomeText;
        @FXML
        private TableView<EmployeeRecord> tblView;
        @FXML
        private TableColumn<EmployeeRecord,Integer > tblColId;
        @FXML
        private TableColumn<EmployeeRecord, String> tblColName;
        @FXML
        private TableColumn<EmployeeRecord,String> tblColEmail;
        @FXML
        private TableColumn<EmployeeRecord,Integer> tblColPhone;
        ObservableList<EmployeeRecord> list = FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            tblColId.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,Integer>("employeeId"));
            tblColName.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,String>("Name"));
            tblColEmail.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,String>("Email"));
            tblColPhone.setCellValueFactory(new PropertyValueFactory<EmployeeRecord,Integer>("Phone"));
            tblView.setItems(list);
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test2";
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
                String query = "SELECT * FROM employee";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int tblId = resultSet.getInt("employeeId");
                    String tblName = resultSet.getString("Name");
                    String tblEmail = resultSet.getString("Email");
                    int tblPhone = resultSet.getInt("Phone");
                    tblView.getItems().add(new EmployeeRecord(tblId,tblName,tblEmail,tblPhone));
                }     } catch (SQLException e) {
                e.printStackTrace();     }
        }
        public void insertData(){
            if(fieldName.getText().isEmpty()){
                lblMessage.setText("Name Required to Insert");
            }else{
                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                    String query = "INSERT INTO employee ( Name, Email, Phone) VALUES ('"+fieldName.getText()+"','"+fieldEmail.getText()+"','"+fieldPhone.getText()+"')";
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
                    String query = ("UPDATE employee SET Name='" + fieldName.getText() + "',Email='" + fieldEmail.getText() + "',Phone='" + fieldPhone.getText() + "'WHERE employeeId='" + fieldId.getText() + "'");
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
                String query = ("DELETE FROM employee WHERE employeeId='"+fieldId.getText()+"'");
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
                String query = ("SELECT * FROM employee WHERE employeeId='"+fieldId.getText()+"'");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                resultSet.next();
                fieldName.setText(resultSet.getString("Name"));
                fieldEmail.setText(resultSet.getString("Email"));
                fieldPhone.setText(resultSet.getString("Phone"));
                lblMessage.setText("");
            } catch (SQLException e) {
                e.printStackTrace();     }}

        }
        public void clearForm(){
            fieldId.setText("");
            fieldName.setText("");
            fieldEmail.setText("");
            fieldPhone.setText("");
            lblMessage.setText("");
        }
    }
}