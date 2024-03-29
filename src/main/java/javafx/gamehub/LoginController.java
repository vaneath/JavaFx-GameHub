package javafx.gamehub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        if ( !usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank() ) {
//            loginMessageLabel.setText("Login Save!");
            validateLogin(actionEvent);
//            switchToHome(actionEvent);
        } else {
            loginMessageLabel.setText("Please enter Username and Password");
        }
    }
    public void validateLogin(ActionEvent actionEvent){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "select count(1) FROM user_information WHERE Username = \"" + usernameTextField.getText() + "\" and Password = \"" + passwordTextField.getText() +"\";";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    switchToHome(actionEvent);
                }
                else {
                    loginMessageLabel.setText("Invalid Login, Please try again.");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void switchToSignup(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Signup.fxml")).load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Home.fxml")).load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
































































