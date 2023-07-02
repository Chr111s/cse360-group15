import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends Application {
    private static final String PATIENT_ID = "12345";
    private static final String PATIENT_PASSWORD = "12345";

    private TextField idField;
    private PasswordField passwordField;
    private Label messageLabel;

    private App app;

    public LoginPage(App app) {
        this.app = app;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(5);
        grid.setHgap(5);

        Label titleLabel = new Label("PediatricsSystem");
        grid.add(titleLabel, 1,0);

        Label idLabel = new Label("ID:");
        grid.add(idLabel, 0, 1);

        idField = new TextField();
        grid.add(idField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 3);

        messageLabel = new Label();
        grid.add(messageLabel, 0, 3, 2, 1);

        loginButton.setOnAction(e -> handleLogin());

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin() {
        String id = idField.getText();
        String password = passwordField.getText();

        if (PATIENT_ID.equals(id) && PATIENT_PASSWORD.equals(password)) {
            app.switchToPatientPortal();
        } else {
            messageLabel.setText("Incorrect ID or password");
        }
    }
}
