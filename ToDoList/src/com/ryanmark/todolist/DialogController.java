package com.ryanmark.todolist;

import com.ryanmark.todolist.datamodel.TodoData;
import com.ryanmark.todolist.datamodel.TodoItems;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItems processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItems newItem = new TodoItems(shortDescription,details,deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}