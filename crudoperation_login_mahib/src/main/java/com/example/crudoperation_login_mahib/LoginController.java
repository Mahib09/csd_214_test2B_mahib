package com.example.crudoperation_login_mahib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;


public class LoginController {
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Label loginMessage;

    String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test2";
    String dbUser = "root";
    String dbPassword = "";
    @FXML
    protected void onLoginClick(){

          }




}


