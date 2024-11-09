/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package sighorta;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author giuli
 */
public class FXMLDocumentController implements Initializable {
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private double x = 0;
    private double y = 0;
    @FXML
    private Button close;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField usuario;
    
    @FXML
    public void login() {
        System.out.println("Iniciando login...");

        String sql = "SELECT * FROM usuarios WHERE email = ? and senha = ?";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, usuario.getText());
            prepare.setString(2, senha.getText());

            result = prepare.executeQuery();

            Alert alert;

            if (usuario.getText().isEmpty() || senha.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Por gentileza, preencha todos os campos");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    System.out.println("Login bem-sucedido.");
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Mensagem de Informação");
                    alert.setHeaderText(null);
                    alert.setContentText("Login realizado com sucesso!");
                    alert.showAndWait();
                    
                    String nomeUsuario = result.getString("nome"); 
                    getData.username = nomeUsuario;

                    // Fechar a janela de login
                    loginButton.getScene().getWindow().hide();

                    // Carregar o menu
                    Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    System.out.println("Usuário ou senha incorreta.");
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuário ou senha incorreta");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao realizar login");
            alert.setContentText("Ocorreu um erro: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML 
    public void close(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
