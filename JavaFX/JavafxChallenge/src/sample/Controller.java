package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableView<Contact> contactTableView;
    @FXML
    private TableColumn<Contact, String> firstNameCol;
    @FXML
    private TableColumn<Contact, String> lastNameCol;
    @FXML
    private TableColumn<Contact, String> phoneNumberCol;
    @FXML
    private TableColumn<Contact, String> notesCol;
    @FXML
    private GridPane mainGridPane;

    public void initialize(){
        contactTableView.setItems(ContactData.getInstance().getContacts());
        contactTableView.setPlaceholder(new Label("No Contacts"));
        contactTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactTableView.getSelectionModel().selectFirst();

        contactTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2){
                    showEditItemDialog();
                }
            }
        });

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("phoneNumber"));
        notesCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("notes"));
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("Use this dialog to create a new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("menucontroller.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            MenuController menuController = fxmlLoader.getController();
            Contact newContact = menuController.processResults();
            contactTableView.getSelectionModel().select(newContact);
        }
    }

    @FXML
    public void showEditItemDialog() {
        Contact selectedItem = contactTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null){
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Use this dialog to edit a contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("menucontroller.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        MenuController menuController = fxmlLoader.getController();
        menuController.setEditFields(selectedItem);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            contactTableView.getSelectionModel().select(selectedItem);
            menuController.processResults(selectedItem);
        }
    }

    public void handleKeyPressed(KeyEvent keyEvent){
        Contact selectedItem = contactTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            if (keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteContact(selectedItem);
            }
        }
    }

    public void deleteContact(Contact contact){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete contact");
        alert.setHeaderText("delete contact " + contact.getFirstName() + " " + contact.getLastName());
        alert.setContentText("Are you sure?  Press OK to confirm or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            ContactData.getInstance().deleteContact(contact);
        }
    }

    public void deleteContactMenu(){
        Contact selectedItem = contactTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            deleteContact(selectedItem);
        }
    }

    public void exitProgram(){
        Platform.exit();
    }
}