package com.ryanmark.todolist;

import com.ryanmark.todolist.datamodel.TodoData;
import com.ryanmark.todolist.datamodel.TodoItems;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {

    private List<TodoItems> todoItems;
    @FXML
    private ListView<TodoItems> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listConextMenu;
    @FXML
    private ToggleButton filterToggleButton;
    @FXML
    private FilteredList<TodoItems> filteredList;

    private Predicate<TodoItems> wantAllItems;
    private Predicate<TodoItems> wantTodaysItems;

    public void initialize(){

        listConextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItems item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listConextMenu.getItems().addAll(deleteMenuItem);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItems>() {
            @Override
            public void changed(ObservableValue<? extends TodoItems> observableValue, TodoItems oldValue, TodoItems newValue) {
                if (newValue != null){
                    TodoItems item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        wantAllItems = new Predicate<TodoItems>() {
            @Override
            public boolean test(TodoItems todoItems) {
                return true;
            }
        };

        wantTodaysItems= new Predicate<TodoItems>() {
            @Override
            public boolean test(TodoItems todoItems) {
                return (todoItems.getDeadline().equals(LocalDate.now()));
            }
        };

        filteredList = new FilteredList<TodoItems>(TodoData.getInstance().getTodoItems(), new Predicate<TodoItems>() {
            @Override
            public boolean test(TodoItems todoItems) {
                return true;
            }
        });
        SortedList<TodoItems> sortedList = new SortedList<TodoItems>(filteredList, new Comparator<TodoItems>() {
            @Override
            public int compare(TodoItems o1, TodoItems o2) {
                return o1.getDeadline().compareTo(o2.getDeadline());
            }
        });

        todoListView.setItems(sortedList);
//        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItems>, ListCell<TodoItems>>() {
            @Override
            public ListCell<TodoItems> call(ListView<TodoItems> todoItemsListView) {
                ListCell<TodoItems> cell = new ListCell<TodoItems>(){
                    @Override
                    protected void updateItem(TodoItems item, boolean empty) {
                        super.updateItem(item, empty);;
                        if (empty){
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().isBefore(LocalDate.now().minusDays(7))) {
                                setTextFill(Color.BLACK);
                            }
                            else if (item.getDeadline().isBefore((LocalDate.now()))) {
                                setTextFill(Color.GREEN);
                            } else if (item.getDeadline().equals(LocalDate.now())) {
                                setTextFill(Color.BROWN);
                            } else if (item.getDeadline().isAfter((LocalDate.now()))) {
                                setTextFill(Color.YELLOW);
                            }
                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty){
                                cell.setContextMenu(null);
                            }
                            else{
                                cell.setContextMenu(listConextMenu);
                            }
                        }
                );
                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New TodoItem");
        dialog.setHeaderText("Use this dialog to create a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
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
            DialogController controller = fxmlLoader.getController();
            TodoItems newItem = controller.processResults();
            todoListView.getSelectionModel().select(newItem);
        }
    }

    public void exitProgram(){
        Platform.exit();
    }

    public void handleKeyPressed(KeyEvent keyEvent){
        TodoItems selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            if (keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
    }


    @FXML
    public void handleClickListView(){
        TodoItems item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }

    public void deleteItem(TodoItems item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("delete item " + item.getShortDescription());
        alert.setContentText("Are you sure?  Press OK to confirm or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            TodoData.getInstance().deleteTodoItem(item);
        }
    }

    public void handleFilterButton(){
        TodoItems selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (filterToggleButton.isSelected()){
            filteredList.setPredicate(wantTodaysItems);
            if (filteredList.isEmpty()){
                itemDetailsTextArea.clear();
                deadlineLabel.setText("");
            }
            else if (filteredList.contains(selectedItem)){
                todoListView.getSelectionModel().select(selectedItem);
            }
            else {
                todoListView.getSelectionModel().selectFirst();
            }
        }else{
            filteredList.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem);
        }
    }
}