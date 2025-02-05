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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private TextField cultivar_diasatecolheita;

    @FXML
    private Button cultivar_editButton;

    @FXML
    private TextField cultivar_id;

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
    private TextField localizacao_id;

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
    private TextField id_plantio;

    @FXML
    private AnchorPane plantio_page;

    @FXML
    private Button relatorios_button;

    @FXML
    private TableView<cultivarData> table_cultivar;

    @FXML
    private TableColumn<cultivarData, Integer> table_cultivar_diasatecolheita;

    @FXML
    private TableColumn<cultivarData, Integer> table_cultivar_id;

    @FXML
    private TableColumn<cultivarData, String> table_cultivar_nomecientifico;

    @FXML
    private TableColumn<cultivarData, String> table_cultivar_nomepopular;

    @FXML
    private TableView<localizacaoData> table_localizacao;

    @FXML
    private TableColumn<localizacaoData, Integer> table_localizacao_coluna;

    @FXML
    private TableColumn<localizacaoData, String> table_localizacao_descricao;

    @FXML
    private TableColumn<localizacaoData, Integer> table_localizacao_id;

    @FXML
    private TableColumn<localizacaoData, Integer> table_localizacao_linha;

    @FXML
    private TableView<plantioData> table_plantio;

    @FXML
    private TableColumn<plantioData, String> table_plantio_cultivar;

    @FXML
    private TableColumn<plantioData, String> table_plantio_datacolheita;
    
    @FXML
    private TableColumn<plantioData, String> table_plantio_estado;

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
    private TableView<usuariosData> table_usuarios;

    @FXML
    private TableColumn<usuariosData, String> table_usuarios_email;

    @FXML
    private TableColumn<usuariosData, Integer> table_usuarios_id;

    @FXML
    private TableColumn<usuariosData, String> table_usuarios_nome;

    @FXML
    private TableColumn<usuariosData, String> table_usuarios_tipo;

    @FXML
    private TextField usuario_email;

    @FXML
    private TextField usuario_id;

    @FXML
    private Button usuarios_addButton;

    @FXML
    private Button usuarios_clearButton;

    @FXML
    private Button usuarios_delButton;

    @FXML
    private Button usuarios_editButton;

    @FXML
    private TextField usuarios_nome;

    @FXML
    private AnchorPane usuarios_page;
    
    @FXML
    private AnchorPane embreve_page;

    @FXML
    private ComboBox<String> usuarios_tipo;

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
        String sql = "INSERT INTO plantio (id_cultivar, id_localizacao, dataPlantio, estado, dataColheitaEstimada) "
                   + "VALUES (?, ?, ?, ?, ?)";

        connect = database.connectDb();

        try {
            Alert alert;

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
                Integer cultivarId = getIdByDescription("cultivar", "nome_popular", plantio_cultivar.getSelectionModel().getSelectedItem());
                Integer localizacaoId = getIdByDescription("localizacao", "descricao", plantio_localizacao.getSelectionModel().getSelectedItem());
                Integer estadoId = getIdByDescription("estado_plantio", "descricao", plantio_estado.getSelectionModel().getSelectedItem());

                if (cultivarId == null || localizacaoId == null || estadoId == null) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Mensagem de Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Erro ao obter ID para uma das seleções.");
                    alert.showAndWait();
                    return;
                }

                // Obter dataPlantio e calcular dataColheitaEstimada
                LocalDate plantioDate = dataPlantio.getValue();
                int diasAteColheita = getDiasAteColheita(cultivarId);
                LocalDate dataColheitaEstimada = plantioDate.plusDays(diasAteColheita);

                prepare = connect.prepareStatement(sql);
                prepare.setInt(1, cultivarId);
                prepare.setInt(2, localizacaoId);
                prepare.setDate(3, Date.valueOf(plantioDate));
                prepare.setInt(4, estadoId);
                prepare.setDate(5, Date.valueOf(dataColheitaEstimada));  // Adiciona dataColheitaEstimada

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Adicionado com sucesso!");
                alert.showAndWait();

                plantioShowListData();
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
    Integer cultivarId = getIdByDescription("cultivar", "nome_popular", plantio_cultivar.getSelectionModel().getSelectedItem());
    Integer localizacaoId = getIdByDescription("localizacao", "descricao", plantio_localizacao.getSelectionModel().getSelectedItem());
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

    LocalDate plantioDate = dataPlantio.getValue();
    if (plantioDate == null) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Mensagem de Erro");
        alert.setHeaderText(null);
        alert.setContentText("Data de plantio não pode estar vazia.");
        alert.showAndWait();
        return;
    }

    // Obter dias_ate_colheita e calcular dataColheitaEstimada
    int diasAteColheita = getDiasAteColheita(cultivarId);
    if (diasAteColheita == 0) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Mensagem de Erro");
        alert.setHeaderText(null);
        alert.setContentText("Dias até colheita não podem ser zero.");
        alert.showAndWait();
        return;
    }

    LocalDate dataColheitaEstimada = plantioDate.plusDays(diasAteColheita);

    // Preparar a instrução SQL de atualização incluindo dataColheitaEstimada
    String sql = "UPDATE plantio SET id_cultivar = ?, id_localizacao = ?, dataPlantio = ?, estado = ?, dataColheitaEstimada = ? WHERE id = ?";

    connect = database.connectDb();

    try {
        Alert alert;

        if (plantio_cultivar.getSelectionModel().getSelectedItem() == null
                || plantio_localizacao.getSelectionModel().getSelectedItem() == null
                || dataPlantio.getValue() == null
                || estadoSelecionado == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Mensagem de Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos obrigatórios.");
            alert.showAndWait();

        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Mensagem de Confirmação");
            alert.setHeaderText(null);
            alert.setContentText("Tem certeza de que deseja atualizar o Plantio ID: " + plantioId + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(sql);
                prepare.setInt(1, cultivarId);
                prepare.setInt(2, localizacaoId);
                prepare.setDate(3, Date.valueOf(plantioDate));
                prepare.setInt(4, estadoId);
                prepare.setDate(5, Date.valueOf(dataColheitaEstimada));
                prepare.setInt(6, Integer.parseInt(plantioId));

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mensagem de Informação");
                alert.setHeaderText(null);
                alert.setContentText("Atualização realizada com sucesso!");
                alert.showAndWait();

                plantioShowListData();
                plantioClear();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Método para buscar dias_ate_colheita do cultivar com base no id
private int getDiasAteColheita(int cultivarId) {
    int diasAteColheita = 0;
    String sql = "SELECT dias_ate_colheita FROM cultivar WHERE id = ?";

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setInt(1, cultivarId);
        result = prepare.executeQuery();

        if (result.next()) {
            diasAteColheita = result.getInt("dias_ate_colheita");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return diasAteColheita;
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
                    alert.setTitle("Messagem");
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
                + "p.dataPlantio, p.dataColheitaEstimada, e.descricao AS plantio_estado "
                + "FROM plantio p "
                + "JOIN cultivar c ON p.id_cultivar = c.id "
                + "JOIN localizacao l ON p.id_localizacao = l.id "
                + "JOIN estado_plantio e ON p.estado = e.id ";
        


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
                        result.getDate("dataColheitaEstimada"),
                        result.getString("plantio_estado")
                );

                listData.add(plantio);
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
        table_plantio_datacolheita.setCellValueFactory(new PropertyValueFactory<>("plantio_datacolheita"));
        table_plantio_estado.setCellValueFactory(new PropertyValueFactory<>("plantio_estado"));

        table_plantio.setItems(plantioList);
    }

    public ObservableList<cultivarData> cultivarData() {
        ObservableList<cultivarData> listData = FXCollections.observableArrayList();
        String sql = "SELECT c.id, c.nome_popular, c.nome_cientifico, c.dias_ate_colheita"
                + " FROM cultivar c";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                // Construa o objeto plantioData com os valores retornados
                cultivarData cultivar = new cultivarData(
                        result.getInt("id"),
                        result.getString("nome_popular"),
                        result.getString("nome_cientifico"),
                        result.getInt("dias_ate_colheita")
                );

                listData.add(cultivar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<cultivarData> cultivarList;

    public void cultivarShowListData() {

        cultivarList = cultivarData();

        table_cultivar_id.setCellValueFactory(new PropertyValueFactory<>("cultivar_id"));
        table_cultivar_nomepopular.setCellValueFactory(new PropertyValueFactory<>("cultivar_nomepopular"));
        table_cultivar_nomecientifico.setCellValueFactory(new PropertyValueFactory<>("cultivar_nomecientifico"));
        table_cultivar_diasatecolheita.setCellValueFactory(new PropertyValueFactory<>("cultivar_diasatecolheita"));

        table_cultivar.setItems(cultivarList);
    }

    public void cultivarAdd() {

        String sql = "INSERT INTO cultivar (nome_popular,nome_cientifico,dias_ate_colheita) "
                + "VALUES (?, ?, ?)";

        connect = database.connectDb();

        try {
            Alert alert;

            // Verifique se os campos obrigatórios estão preenchidos
            if (cultivar_nomepopular.getText().isEmpty()
                    || cultivar_nomecientifico.getText().isEmpty()
                    || cultivar_diasatecolheita.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, preencha todos os campos em branco.");
                alert.showAndWait();

            } // CHECK IF THE FLOWER ID IS ALREADY EXIST
            String checkData = "SELECT id FROM cultivar WHERE id = '"
                    + cultivar_id.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cultivar ID " + cultivar_id.getText() + " já existente!");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, cultivar_nomepopular.getText());
                prepare.setString(2, cultivar_nomecientifico.getText());
                prepare.setString(3, cultivar_diasatecolheita.getText());
                
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Messagem");
                alert.setHeaderText(null);
                alert.setContentText("Adicionado com sucesso!");
                alert.showAndWait();

                // SHOW UPDATED TABLEVIEW
                cultivarShowListData();

                // CLEAR ALL FIELDS
                cultivarClear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cultivarClear() {

        cultivar_id.setText("");
        cultivar_nomepopular.setText("");
        cultivar_nomecientifico.setText("");
        cultivar_diasatecolheita.setText("");
        
    }
    
    public void cultivarUpdate() {

        // Preparar a instrução SQL de atualização     
        String sql = "UPDATE cultivar SET nome_popular = '" + cultivar_nomepopular.getText()
           + "', nome_cientifico = '" + cultivar_nomecientifico.getText()
           + "', dias_ate_colheita = '" + cultivar_diasatecolheita.getText() 
           + "' WHERE id = '" + cultivar_id.getText() + "'";
        connect = database.connectDb();

        try {
            Alert alert;

            // Verificar se todos os campos obrigatórios estão preenchidos
            if (cultivar_nomepopular.getText().isEmpty()
                    || cultivar_nomecientifico.getText().isEmpty()
                    || cultivar_diasatecolheita.getText().isEmpty()) {

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
                alert.setContentText("Tem certeza de que deseja atualizar o Cultivar ID: " + cultivar_id.getText() + "?");
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
                    cultivarShowListData();

                    // Limpar todos os campos
                    cultivarClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cultivarSelect() {
        cultivarData cultivar = table_cultivar.getSelectionModel().getSelectedItem();
        if (cultivar == null) {
            System.out.println("Nenhum cultivar foi selecionado.");
            return;  // Se não houver seleção, retorna sem fazer mais nada
        }
        int num = table_cultivar.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        cultivar_id.setText(String.valueOf(cultivar.getCultivar_id()));
        cultivar_nomepopular.setText(cultivar.getCultivar_nomepopular());
        cultivar_nomecientifico.setText(cultivar.getCultivar_nomecientifico());
        cultivar_diasatecolheita.setText(String.valueOf(cultivar.getCultivar_diasatecolheita()));

    }
    
    public void cultivarDelete() {
        String plantioId = id_plantio.getText();
        String sql = "DELETE FROM cultivar WHERE id = '"
                + cultivar_id.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (cultivar_id.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por gentileza, filtre o id do item que deseja deletar");
                alert.showAndWait();

            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Messagem de confirmação");
                alert.setHeaderText(null);
                alert.setContentText("Você tem certeza que deseja deletar o cultivar : " + cultivar_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Messagem");
                    alert.setHeaderText(null);
                    alert.setContentText("Deletado com sucesso!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    cultivarShowListData();

                    // CLEAR ALL FIELDS
                    cultivarClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ObservableList<localizacaoData> localizacaoData() {
        ObservableList<localizacaoData> listData = FXCollections.observableArrayList();
        String sql = "SELECT l.id, l.descricao, l.coluna, l.linha"
                + " FROM localizacao l";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                // Construa o objeto plantioData com os valores retornados
                localizacaoData localizacao = new localizacaoData(
                        result.getInt("id"),
                        result.getString("descricao"),
                        result.getInt("coluna"),
                        result.getInt("linha")
                );

                listData.add(localizacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<localizacaoData> localizacaoList;

    public void localizacaoShowListData() {

        localizacaoList = localizacaoData();

        table_localizacao_id.setCellValueFactory(new PropertyValueFactory<>("localizacao_id"));
        table_localizacao_descricao.setCellValueFactory(new PropertyValueFactory<>("localizacao_descricao"));
        table_localizacao_coluna.setCellValueFactory(new PropertyValueFactory<>("localizacao_coluna"));
        table_localizacao_linha.setCellValueFactory(new PropertyValueFactory<>("localizacao_linha"));

        table_localizacao.setItems(localizacaoList);
    }

    public void localizacaoAdd() {

        String sql = "INSERT INTO localizacao (descricao,coluna,linha) "
                + "VALUES (?, ?, ?)";

        connect = database.connectDb();

        try {
            Alert alert;

            // Verifique se os campos obrigatórios estão preenchidos
            if (localizacao_descricao.getText().isEmpty()
                    || localizacao_coluna.getText().isEmpty()
                    || localizacao_linha.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, preencha todos os campos em branco.");
                alert.showAndWait();

            } 
            String checkData = "SELECT id FROM cultivar WHERE id = '"
                    + localizacao_id.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Localizacao ID " + localizacao_id.getText() + " já existente!");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, localizacao_descricao.getText());
                prepare.setString(2, localizacao_coluna.getText());
                prepare.setString(3, localizacao_linha.getText());
                
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Messagem");
                alert.setHeaderText(null);
                alert.setContentText("Adicionado com sucesso!");
                alert.showAndWait();

                // SHOW UPDATED TABLEVIEW
                localizacaoShowListData();

                // CLEAR ALL FIELDS
                localizacaoClear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void localizacaoClear() {

        localizacao_id.setText("");
        localizacao_descricao.setText("");
        localizacao_coluna.setText("");
        localizacao_linha.setText("");
        
    }
    
    public void localizacaoUpdate() {

        // Preparar a instrução SQL de atualização     
        String sql = "UPDATE localizacao SET descricao = '" + localizacao_descricao.getText()
           + "', coluna = '" + localizacao_coluna.getText()
           + "', linha = '" + localizacao_linha.getText() 
           + "' WHERE id = '" + localizacao_id.getText() + "'";
        connect = database.connectDb();

        try {
            Alert alert;

            // Verificar se todos os campos obrigatórios estão preenchidos
            if (localizacao_id.getText().isEmpty()
                    || localizacao_coluna.getText().isEmpty()
                    || localizacao_linha.getText().isEmpty()) {

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
                alert.setContentText("Tem certeza de que deseja atualizar a Localização ID: " + localizacao_id.getText() + "?");
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
                    localizacaoShowListData();

                    // Limpar todos os campos
                    localizacaoClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void localizacaoSelect() {
        localizacaoData localizacao = table_localizacao.getSelectionModel().getSelectedItem();
        if (localizacao == null) {
            System.out.println("Nenhuma localizacao foi selecionada.");
            return;  // Se não houver seleção, retorna sem fazer mais nada
        }
        int num = table_localizacao.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        localizacao_id.setText(String.valueOf(localizacao.getLocalizacao_id()));
        localizacao_descricao.setText(localizacao.getLocalizacao_descricao());
        localizacao_coluna.setText(String.valueOf(localizacao.getLocalizacao_coluna()));
        localizacao_linha.setText(String.valueOf(localizacao.getLocalizacao_linha()));

    }
    
    public void localizacaoDelete() {
        String sql = "DELETE FROM localizacao WHERE id = '"
                + localizacao_id.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (localizacao_id.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por gentileza, filtre o id do item que deseja deletar");
                alert.showAndWait();

            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Messagem de confirmação");
                alert.setHeaderText(null);
                alert.setContentText("Você tem certeza que deseja deletar a localização : " + localizacao_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Messagem");
                    alert.setHeaderText(null);
                    alert.setContentText("Deletado com sucesso!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    localizacaoShowListData();

                    // CLEAR ALL FIELDS
                    localizacaoClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ObservableList<usuariosData> usuariosData() {
        ObservableList<usuariosData> listData = FXCollections.observableArrayList();
        String sql = "SELECT u.id, u.nome, u.email, tu.descricao as tipoUsuario"
                + " FROM usuarios u"
                + " JOIN tipo_usuario tu ON u.tipo_usuario = tu.id "
                + " WHERE status = '1'";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                // Construa o objeto plantioData com os valores retornados
                usuariosData usuario = new usuariosData(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("email"),
                        result.getString("tipoUsuario")
                );

                listData.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<usuariosData> usuariosList;

    public void usuariosShowListData() {

        usuariosList = usuariosData();

        table_usuarios_id.setCellValueFactory(new PropertyValueFactory<>("usuarios_id"));
        table_usuarios_nome.setCellValueFactory(new PropertyValueFactory<>("usuarios_nome"));
        table_usuarios_email.setCellValueFactory(new PropertyValueFactory<>("usuarios_email"));
        table_usuarios_tipo.setCellValueFactory(new PropertyValueFactory<>("usuarios_tipo"));

        table_usuarios.setItems(usuariosList);
    }
    public void usuariosAdd() {

        // Adicione o campo senha ao SQL de inserção, definindo o valor "123" como senha padrão
        String sql = "INSERT INTO usuarios (nome, email, tipo_usuario, senha) VALUES (?, ?, ?, '123')";

        connect = database.connectDb();

        try {
            Alert alert;

            // Verifique se os campos obrigatórios estão preenchidos
            if (usuarios_nome.getText().isEmpty()
                    || usuario_email.getText().isEmpty()
                    || usuarios_tipo.getSelectionModel().getSelectedItem() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, preencha todos os campos em branco.");
                alert.showAndWait();
            } else {
                // Verificar se o ID já existe
                String checkData = "SELECT id FROM usuarios WHERE id = '"
                        + usuario_id.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                Integer tipoUsuarioId = getIdByDescription("tipo_usuario", "descricao", (String) usuarios_tipo.getSelectionModel().getSelectedItem());

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario ID " + usuario_id.getText() + " já existente!");
                    alert.showAndWait();
                } else {
                    // Preparando a inserção com os valores definidos
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, usuarios_nome.getText());
                    prepare.setString(2, usuario_email.getText());
                    prepare.setInt(3, tipoUsuarioId);

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Mensagem");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuário adicionado com sucesso!");
                    alert.showAndWait();

                    // Mostrar os dados atualizados na tabela
                    usuariosShowListData();

                    // Limpar todos os campos
                    usuariosClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void usuariosClear() {

        usuario_id.setText("");
        usuarios_nome.setText("");
        usuario_email.setText("");
        usuarios_tipo.getSelectionModel().clearSelection();
        
    }
    
    public void usuariosUpdate() {
        Integer tipoUsuarioId = getIdByDescription("tipo_usuario", "descricao", (String) usuarios_tipo.getSelectionModel().getSelectedItem());
        // Preparar a instrução SQL de atualização     
        String sql = "UPDATE usuarios SET nome = '" + usuarios_nome.getText()
           + "', email = '" + usuario_email.getText()
           + "', tipo_usuario = '" + tipoUsuarioId
           + "' WHERE id = '" + usuario_id.getText() + "'";
        connect = database.connectDb();

        try {
            Alert alert;

            // Verificar se todos os campos obrigatórios estão preenchidos
            if (usuario_id.getText().isEmpty()
                    || usuarios_nome.getText().isEmpty()
                    || usuario_email.getText().isEmpty()) {

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
                alert.setContentText("Tem certeza de que deseja atualizar o Usuario ID: " + usuario_id.getText() + "?");
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
                    usuariosShowListData();

                    // Limpar todos os campos
                    usuariosClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void usuariosSelect() {
        usuariosData usuario = table_usuarios.getSelectionModel().getSelectedItem();
        if (usuario == null) {
            System.out.println("Nenhum usuario foi selecionado.");
            return;  // Se não houver seleção, retorna sem fazer mais nada
        }
        int num = table_usuarios.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        usuario_id.setText(String.valueOf(usuario.getUsuarios_id()));
        usuarios_nome.setText(usuario.getUsuarios_nome());
        usuario_email.setText(usuario.getUsuarios_email());
        String tipo = getTipoById(usuario.getUsuarios_id());
        // Preenche o ComboBox com o tipo
        usuarios_tipo.setValue(tipo);
    }
    
    private String getTipoById(int usuarioId) {
        String tipo = null;
        String sql = "SELECT tu.descricao FROM usuarios u "
                + "JOIN tipo_usuario tu ON u.tipo_usuario = tu.id "
                + "WHERE u.id = ?";

        try {
            // Conecta ao banco de dados
            connect = database.connectDb();
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, usuarioId);  // Define o ID do plantio
            result = prepare.executeQuery();

            // Se um resultado for encontrado, obtém a descrição do estado
            if (result.next()) {
                tipo = result.getString("descricao");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipo;
    }
    public void usuariosDelete() {
        String sql = "UPDATE usuarios SET status = 0 WHERE id = ?";

        connect = database.connectDb();

        try {
            Alert alert;

            if (usuario_id.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por gentileza, filtre o id do item que deseja deletar");
                alert.showAndWait();

            } else {          
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Messagem de confirmação");
                alert.setHeaderText(null);
                alert.setContentText("Você tem certeza que deseja deletar o usuario : " + usuario_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.setInt(1, Integer.parseInt(usuario_id.getText()));
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Messagem");
                    alert.setHeaderText(null);
                    alert.setContentText("Deletado com sucesso!");
                    alert.showAndWait();

                    // SHOW UPDATED TABLEVIEW
                    usuariosShowListData();

                    // CLEAR ALL FIELDS
                    usuariosClear();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void loadUsuariosTipoDescriptions() {
        ObservableList<String> usuariosTipoDescriptions = FXCollections.observableArrayList();
        String sql = "SELECT descricao FROM tipo_usuario";

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                usuariosTipoDescriptions.add(result.getString("descricao"));
            }
            usuarios_tipo.setItems(usuariosTipoDescriptions); // Definir os itens no ComboBox
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void verificarPermissaoUsuario() {
        int tipoUsuarioAtual = getTipoUsuarioAtual();

        // Torna o botão visível apenas se o tipo de usuário for 3
        usuarios_button.setVisible(tipoUsuarioAtual == 3);
        cultivar_button.setVisible(tipoUsuarioAtual == 3);
        localizacao_button.setVisible(tipoUsuarioAtual == 3);
        plantio_addButton.setVisible(tipoUsuarioAtual != 1);
        plantio_delButton.setVisible(tipoUsuarioAtual != 1);
        plantio_editButton.setVisible(tipoUsuarioAtual != 1);
        plantio_clearButton.setVisible(tipoUsuarioAtual != 1);

    }

    private int getTipoUsuarioAtual() {
        int tipoUsuario = -1;
        String sql = "SELECT tipo_usuario FROM usuarios WHERE id = ?"; // A tabela e coluna podem variar conforme o seu banco de dados

        connect = database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, getData.userId); // Supondo que getData.username tenha o nome do usuário logado
            result = prepare.executeQuery();

            if (result.next()) {
                tipoUsuario = result.getInt("tipo_usuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoUsuario;
    }


    public void switchForm(ActionEvent event) {
        
        if (event.getSource() == home_button) {
            plantio_page.setVisible(false);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(false);
            usuarios_page.setVisible(false);
            embreve_page.setVisible(true);

            home_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");

        } else if (event.getSource() == plantio_button) {
            plantioClear();
            plantio_page.setVisible(true);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(false);
            usuarios_page.setVisible(false);
            embreve_page.setVisible(false);

            plantio_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");

            plantioShowListData();

        } else if (event.getSource() == cultivar_button) {
            cultivarClear();
            plantio_page.setVisible(false);
            cultivar_page.setVisible(true);
            localizacao_page.setVisible(false);
            usuarios_page.setVisible(false);
            embreve_page.setVisible(false);
            

            cultivar_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");
            embreve_page.setVisible(false);
            
            cultivarShowListData();

        } else if (event.getSource() == localizacao_button) {
            localizacaoClear();
            plantio_page.setVisible(false);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(true);
            usuarios_page.setVisible(false);
            embreve_page.setVisible(false);

            localizacao_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            usuarios_button.setStyle("-fx-background-color: transparent");
            localizacaoShowListData();
        }
        
        else if (event.getSource() == usuarios_button) {
            usuariosClear();
            plantio_page.setVisible(false);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(false);
            usuarios_page.setVisible(true);
            embreve_page.setVisible(false);

            usuarios_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            relatorios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuariosShowListData();
        }
        else if (event.getSource() == relatorios_button) {
            plantio_page.setVisible(false);
            cultivar_page.setVisible(false);
            localizacao_page.setVisible(false);
            usuarios_page.setVisible(false);
            embreve_page.setVisible(true);

            relatorios_button.setStyle("-fx-background-color:linear-gradient(to bottom right, #d3133d, #a4262f)");
            usuarios_button.setStyle("-fx-background-color: transparent");
            home_button.setStyle("-fx-background-color: transparent");
            plantio_button.setStyle("-fx-background-color: transparent");
            cultivar_button.setStyle("-fx-background-color: transparent");
            localizacao_button.setStyle("-fx-background-color: transparent");
            usuariosShowListData();
        }
    }
    
    public void atualizarSenha() {
        Alert alert;

        // Campos para senha atual e nova senha
        PasswordField senhaAtualField = new PasswordField();
        senhaAtualField.setPromptText("Digite sua senha atual");

        PasswordField novaSenhaField = new PasswordField();
        novaSenhaField.setPromptText("Digite a nova senha");

        PasswordField confirmarNovaSenhaField = new PasswordField();
        confirmarNovaSenhaField.setPromptText("Confirme a nova senha");

        // Caixa de diálogo para entrada das senhas
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Atualizar Senha");
        alert.setHeaderText("Por favor, insira a senha atual e a nova senha.");
        alert.getDialogPane().setContent(new VBox(senhaAtualField, novaSenhaField, confirmarNovaSenhaField));
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            String senhaAtual = senhaAtualField.getText();
            String novaSenha = novaSenhaField.getText();
            String confirmarNovaSenha = confirmarNovaSenhaField.getText();

            if (novaSenha.isEmpty() || confirmarNovaSenha.isEmpty()) {
                mostrarMensagem("Erro", "A nova senha e a confirmação não podem estar em branco.");
                return;
            }

            if (!novaSenha.equals(confirmarNovaSenha)) {
                mostrarMensagem("Erro", "A nova senha e a confirmação devem ser iguais.");
                return;
            }

            // Verifique a senha atual do usuário no banco de dados
            String sql = "SELECT senha FROM usuarios WHERE id = ?";
            connect = database.connectDb();
            try {
                prepare = connect.prepareStatement(sql);
                prepare.setInt(1, getData.userId); // Use o ID do usuário logado
                result = prepare.executeQuery();

                if (result.next()) {
                    String senhaExistente = result.getString("senha");

                    if (!senhaExistente.equals(senhaAtual)) {
                        mostrarMensagem("Erro", "Senha atual incorreta.");
                        return;
                    }

                    // Atualize a senha para a nova senha
                    sql = "UPDATE usuarios SET senha = ? WHERE id = ?";
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, novaSenha);
                    prepare.setInt(2, getData.userId);

                    int rowsAffected = prepare.executeUpdate();
                    if (rowsAffected > 0) {
                        mostrarMensagem("Sucesso", "Senha atualizada com sucesso!");
                    } else {
                        mostrarMensagem("Erro", "Falha ao atualizar a senha.");
                    }
                } else {
                    mostrarMensagem("Erro", "Usuário não encontrado.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                mostrarMensagem("Erro", "Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    // Método auxiliar para exibir alertas
    private void mostrarMensagem(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        verificarPermissaoUsuario();
        loadCultivarDescriptions();
        loadLocalizacaoDescriptions();
        loadEstadoDescriptions();
        loadUsuariosTipoDescriptions();
       
    }

}
