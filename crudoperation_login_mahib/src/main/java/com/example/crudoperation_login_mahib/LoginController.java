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

    String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test2(testday))";
    String dbUser = "root";
    String dbPassword = "";
    @FXML
   protected void onLoginClick(){
        String Entered_email=loginUsername.getText();
        String Entered_password=loginPassword.getText();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            String query="SELECT * FROM user_info Where user_email='"+Entered_email+"' and user_password='"+Entered_password+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                String Name=resultSet.getString("user_name");
                try {
                    // Load the FXML file for the second scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                    Parent secondScene = loader.load();

                    // Access the controller of the second scene
                    HelloController helloController = loader.getController();

                    // Set the data in the controller of the second scene
                    helloController.setWelcomeText(Name);

                    // Create a new stage for the second scene
                    Stage secondStage = new Stage();
                    secondStage.setTitle("User Scene");
                    secondStage.setScene(new Scene(secondScene));

                    // Close the first scene's stage
                    Stage firstSceneStage = (Stage) loginUsername.getScene().getWindow(); // Assuming hbt is a node in the first scene
                    firstSceneStage.close();

                    // Show the second stage
                    secondStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                loginMessage.setText("Invalid UserName or Password");
            }
        }catch (SQLException e) {
            e.printStackTrace();     }

    }
}







