/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sighorta;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author giuli
 */
public class menu implements Initializable {

    @FXML
    private Button close;

    @FXML
    private Button cultivar_addButton;

    @FXML
    private Button cultivar_button;

    @FXML
    private Button cultivar_clearButton;

    @FXML
    private Button cultivar_delButton;

    @FXML
    private ComboBox<?> cultivar_diasatecolheita;

    @FXML
    private Button cultivar_editButton;

    @FXML
    private TextField cultivar_nomecientifico;

    @FXML
    private TextField cultivar_nomepopular;

    @FXML
    private AnchorPane cultivar_page;

    @FXML
    private TextField cultivar_search;

    @FXML
    private Button desconectar_button;

    @FXML
    private Button home_button;

    @FXML
    private Button localizacao_addButton;

    @FXML
    private Button localizacao_button;

    @FXML
    private Button localizacao_clearButton;

    @FXML
    private TextField localizacao_coluna;

    @FXML
    private Button localizacao_delButton;

    @FXML
    private TextField localizacao_descricao;

    @FXML
    private Button localizacao_editButton;

    @FXML
    private TextField localizacao_linha;

    @FXML
    private AnchorPane localizacao_page;

    @FXML
    private TextField localizacao_search;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private Button plantio_addButton;

    @FXML
    private Button plantio_button;

    @FXML
    private Button plantio_clearButton;

    @FXML
    private ComboBox<String> plantio_cultivar;

    @FXML
    private DatePicker dataPlantio;

    @FXML
    private Button plantio_delButton;

    @FXML
    private Button plantio_editButton;

    @FXML
    private ComboBox<String> plantio_estado;

    @FXML
    private ComboBox<String> plantio_localizacao;

    @FXML
    private TextField plantio_search;

    @FXML
    private TextField id_plantio;

    @FXML
    private AnchorPane plantio_page;

    @FXML
    private Button relatorios_button;

    @FXML
    private TableView<?> table_cultivar;

    @FXML
    private TableColumn<?, ?> table_cultivar_diasatecolheita;

    @FXML
    private TableColumn<?, ?> table_cultivar_id;

    @FXML
    private TableColumn<?, ?> table_cultivar_nomecientifico;

    @FXML
    private TableColumn<?, ?> table_cultivar_nomepopular;

    @FXML
    private TableView<?> table_localizacao;

    @FXML
    private TableColumn<?, ?> table_localizacao_coluna;

    @FXML
    private TableColumn<?, ?> table_localizacao_descricao;

    @FXML
    private TableColumn<?, ?> table_localizacao_id;

    @FXML
    private TableColumn<?, ?> table_localizacao_linha;

    @FXML
    private TableView<plantioData> table_plantio;

    @FXML
    private TableColumn<plantioData, String> table_plantio_cultivar;

    @FXML
    private TableColumn<plantioData, String> table_plantio_datacolheita;

    @FXML
    private TableColumn<plantioData, String> table_plantio_dataplantio;

    @FXML
    private TableColumn<plantioData, Integer> table_plantio_id;

    @FXML
    private TableColumn<plantioData, String> table_plantio_localizacao;

    @FXML
    private Label usuario_menu;

    @FXML
    private Button usuarios_button;

    @FXML
    public void close() {
        System.exit(0);
    }

    @FXML
    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    private double x = 0;
    private double y = 0;

    public void logout() {

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Messagem de confirmação");
            alert.setHeaderText(null);
            alert.setContentText("Você tem certeza que deseja desconectar?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                // HIDE YOUR DASHBOARD FORM
                desconectar_button.getScene().getWindow().hide();

                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayUsername() {

        String user = getData.username;
        usuario_menu.setText(user.substring(0, 1).toUpperCase() + user.substring(1));

    }

    public void loadCultivarDescriptions() {

        ObservableList<String> cultivarDescriptions = FXCollections.observableArrayList();
        String sql = "SELECT nome_popular FROM cultivar";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                String nomePopular = result.getString("nome_popular");
                cultivarDescriptions.add(nomePopular);
            }
            plantio_cultivar.setItems(cultivarDescriptions); // usa o fx:id plantio_cultivar
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadLocalizacaoDescriptions() {

        ObservableList<String> localizacaoDescriptions = FXCollections.observableArrayList();
        String sql = "SELECT descricao FROM localizacao";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                localizacaoDescriptions.add(result.getString("descricao"));
            }
            plantio_localizacao.setItems(localizacaoDescriptions); // usa o fx:id plantio_localizacao
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadEstadoDescriptions() {

        ObservableList<String> estadoDescriptions = FXCollections.observableArrayList();
        String sql = "SELECT descricao FROM estado_plantio";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                estadoDescriptions.add(result.getString("descricao"));
            }
            plantio_estado.setItems(estadoDescriptions); // usa o fx:id plantio_estado
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void plantioAdd() {

        String sql = "INSERT INTO plantio (id_cultivar, id_localizacao, dataPlantio, estado) "
                + "VALUES (?, ?, ?, ?)";

        connect = database.connectDb();

        try {
            Alert alert;

            // Verifique se os campos obrigatórios estão preenchidos
            if (plantio_cultivar.getSelectionModel().getSelectedItem() == null
                    || plantio_localizacao.getSelectionModel().getSelectedItem() == null
                    || dataPlantio.getValue() == null
                    || plantio_estado.getSelectionModel().getSelectedItem() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, preencha todos os campos em branco.");
                alert.showAndWait();

            } else {
                // Obter os IDs correspondentes das descrições selecionadas nos ComboBox
                Integer cultivarId = getIdByDescription("cultivar", "nome_popular", (String) plantio_cultivar.getSelectionModel().getSelectedItem());
                Integer localizacaoId = getIdByDescription("localizacao", "descricao", (String) plantio_localizacao.getSelectionModel().getSelectedItem());
                Integer estadoId = getIdByDescription("estado_plantio", "descricao", (String) plantio_estado.getSelectionModel().getSelectedItem());

                if (cultivarId == null || localizacaoId == null || estadoId == null) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Mensagem de Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Erro ao obter ID para uma das seleções.");
                    alert.showAndWait();
                    return;
                }

                // Prepara a consulta de inserção
                prepare = connect.prepareStatement(sql);
                prepare.setInt(1, cultivarId); // ID do cultivar
                prepare.setInt(2, localizacaoId); // ID da localização

                // Assuming dataPlantio is a DatePicker
                LocalDate localDate = dataPlantio.getValue();
                java.sql.Date sqlDate = Date.valueOf(localDate);
                prepare.setString(3, String.valueOf(sqlDate));
                prepare.setInt(4, estadoId); // ID do estado

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Adicionado com sucesso!");
                alert.showAndWait();

                // Atualizar a TableView com os dados mais recentes
                plantioShowListData();

                // Limpar todos os campos
                plantioClear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void plantioSelect() {
        plantioData plantio = table_plantio.getSelectionModel().getSelectedItem();
        if (plantio == null) {
            System.out.println("Nenhum plantio foi selecionado.");
            return;  // Se não houver seleção, retorna sem fazer mais nada
        }
        int num = table_plantio.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        plantio_cultivar.setValue(plantio.getPlantio_cultivar());  // Usar setValue para ComboBox
        plantio_localizacao.setValue(plantio.getPlantio_localizacao());  // Usar setValue para ComboBox
        LocalDate plantioData = plantio.getPlantio_dataplantio().toLocalDate();  // Conversão de java.sql.Date para LocalDate
        dataPlantio.setValue(plantioData);
        String estado = getEstadoById(plantio.getPlantio_id());

        // Preenche o ComboBox com o estado
        plantio_estado.setValue(estado);
        id_plantio.setText(String.valueOf(plantio.getPlantio_id()));

    }

    private String getEstadoById(int plantioId) {
        String estado = null;
        String sql = "SELECT e.descricao FROM plantio p "
                + "JOIN estado_plantio e ON p.estado = e.id "
                + "WHERE p.id = ?";

        try {
            // Conecta ao banco de dados
            connect = database.connectDb();
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, plantioId);  // Define o ID do plantio
            result = prepare.executeQuery();

            // Se um resultado for encontrado, obtém a descrição do estado
            if (result.next()) {
                estado = result.getString("descricao");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public void plantioUpdate() {

        // Obter o ID correspondente das descrições selecionadas nos ComboBox
        Integer cultivarId = getIdByDescription("cultivar", "nome_popular", (String) plantio_cultivar.getSelectionModel().getSelectedItem());
        Integer localizacaoId = getIdByDescription("localizacao", "descricao", (String) plantio_localizacao.getSelectionModel().getSelectedItem());
        String estadoSelecionado = plantio_estado.getSelectionModel().getSelectedItem();
        Integer estadoId = getIdByDescription("estado_plantio", "descricao", estadoSelecionado);
        String plantioId = id_plantio.getText();

        if (cultivarId == null || localizacaoId == null || estadoId == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao obter ID para uma das seleções.");
            alert.showAndWait();
            return;
        }

        // Preparar a instrução SQL de atualização
        String sql = "UPDATE plantio SET id_cultivar = " + cultivarId
                + ", id_localizacao = " + localizacaoId
                + ", dataPlantio = '" + java.sql.Date.valueOf(dataPlantio.getValue()) + "'"
                + ", estado = " + estadoId
                + " WHERE id = '" + plantioId + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            // Verificar se todos os campos obrigatórios estão preenchidos
            if (plantio_cultivar.getSelectionModel().getSelectedItem() == null
                    || plantio_localizacao.getSelectionModel().getSelectedItem() == null
                    || dataPlantio.getValue() == null
                    || estadoSelecionado == null) {
                System.out.println(plantio_cultivar.getSelectionModel().getSelectedItem());
                System.out.println(plantio_localizacao.getSelectionModel().getSelectedItem());
                System.out.println(dataPlantio.getValue());
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, preencha todos os campos obrigatórios.");
                alert.showAndWait();

            } else {
                // Confirmar atualização
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Mensagem de Confirmação");
                alert.setHeaderText(null);
                alert.setContentText("Tem certeza de que deseja atualizar o Plantio ID: " + plantioId + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    // Executa a atualização
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Mensagem de Informação");
                    alert.setHeaderText(null);
                    alert.setContentText("Atualização realizada com sucesso!");
                    alert.showAndWait();

                    // Mostrar dados atualizados na TableView
                    plantioShowListData();

                    // Limpar todos os campos
                    plantioClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void plantioClear() {

        plantio_cultivar.getSelectionModel().clearSelection();
        plantio_localizacao.getSelectionModel().clearSelection();
        dataPlantio.setValue(null);
        plantio_estado.getSelectionModel().clearSelection();
        id_plantio.setText("");
    }

    public void plantioDelete() {
        String plantioId = id_plantio.getText();
        String sql = "DELETE FROM plantio WHERE id = '"
                + plantioId + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (plantioId.isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por gentileza, filtre o id do item que deseja deletar");
                alert.showAndWait();

            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Messagem de confirmação");
                alert.setHeaderText(null);
                alert.setContentText("Você tem certeza que deseja deletar o plantio : " + plantioId + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Deletado com sucesso!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    plantioShowListData();

                    // CLEAR ALL FIELDS
                    plantioClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Integer getIdByDescription(String tableName, String descriptionColumn, String description) {
        Integer id = null;
        String sql = "SELECT id FROM " + tableName + " WHERE " + descriptionColumn + " = ?";

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, description);
            result = prepare.executeQuery();

            if (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public ObservableList<plantioData> plantioData() {
        ObservableList<plantioData> listData = FXCollections.observableArrayList();
        String sql = "SELECT p.id, c.nome_popular AS plantio_cultivar, l.descricao AS plantio_localizacao, "
                + "p.dataPlantio, p.dataColheitaEstimada "
                + "FROM plantio p "
                + "JOIN cultivar c ON p.id_cultivar = c.id "
                + "JOIN localizacao l ON p.id_localizacao = l.id ";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                // Construa o objeto plantioData com os valores retornados
                plantioData plantio = new plantioData(
                        result.getInt("id"),
                        result.getString("plantio_cultivar"),
                        result.getString("plantio_localizacao"),
                        result.getDate("dataPlantio"),
                        result.getDate("dataColheitaEstimada")
                );

                listData.add(plantio);
                System.out.println("Carregando: " + plantio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<plantioData> plantioList;

    public void plantioShowListData() {

        plantioList = plantioData();

        table_plantio_id.setCellValueFactory(new PropertyValueFactory<>("plantio_id"));
        table_plantio_cultivar.setCellValueFactory(new PropertyValueFactory<>("plantio_cultivar"));
        table_plantio_localizacao.setCellValueFactory(new PropertyValueFactory<>("plantio_localizacao"));
        table_plantio_dataplantio.setCellValueFactory(new PropertyValueFactory<>("plantio_dataplantio"));
        table_plantio_datacolheita.setCellValueFactory(new PropertyValueFactory<>("plantio_datacolheita"));

        table_plantio.setItems(plantioList);
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_button) {
            plantio_page.setVisible(false);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(false);

            home_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");

        } else if (event.getSource() == plantio_button) {
            plantio_page.setVisible(true);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(false);

            plantio_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");

            plantioShowListData();

        } else if (event.getSource() == cultivar_button) {
            plantio_page.setVisible(false);
            cultivar_page.setVisible(true);
            localizacao_page.setVisible(false);

            cultivar_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");

        } else if (event.getSource() == localizacao_button) {
            plantio_page.setVisible(false);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(true);

            localizacao_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        loadCultivarDescriptions();
        loadLocalizacaoDescriptions();
        loadEstadoDescriptions();
        plantioShowListData();

    }

}
