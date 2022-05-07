package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AdicionarButton;

    @FXML
    private Button EditarButton;

    @FXML
    private Button ExcluirButton;

    @FXML
    private TextField TarefaTextField;

    @FXML
    private ListView<String> TarefasListView;
    
    private ObservableList<String> obsTarefas;

    @FXML
    public void adicionar(ActionEvent event) {
    	Tarefas.getTarefas().add(TarefaTextField.getText());
    	obsTarefas.add(TarefaTextField.getText());
    	System.out.println(Tarefas.getTarefas().toString());
    }
    
    @FXML
    public void editar(ActionEvent event) {
    	Tarefas.getTarefas().set(TarefasListView.getSelectionModel().getSelectedIndex(), TarefaTextField.getText());
    	obsTarefas.set(TarefasListView.getSelectionModel().getSelectedIndex(), TarefaTextField.getText());
    	System.out.println(Tarefas.getTarefas().toString());
    }
    
    @FXML
    public void excluir(ActionEvent event) {
    	Tarefas.getTarefas().remove(TarefasListView.getSelectionModel().getSelectedIndex());
    	obsTarefas.remove(TarefasListView.getSelectionModel().getSelectedIndex());
    	System.out.println(Tarefas.getTarefas().toString());
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	obsTarefas = FXCollections.observableArrayList(Tarefas.getTarefas());
    	
    	TarefasListView.setItems(obsTarefas);
		
	}
    
    
}
