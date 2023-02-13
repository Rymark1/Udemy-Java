package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MenuController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextArea notesArea;

    public Contact processResults(){
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesArea.getText().trim();
        Contact contact = new Contact();
        if (!firstNameField.getText().isEmpty()){
            contact.setFirstName(firstName);
        }
        if (!lastNameField.getText().isEmpty()){
            contact.setLastName(lastName);
        }
        if (!phoneNumberField.getText().isEmpty()){
            contact.setPhoneNumber(phoneNumber);
        }
        if (!notesArea.getText().isEmpty()){
            contact.setNotes(notes);
        }
        ContactData.getInstance().addContacts(contact);
        return contact;
    }


    public void processResults(Contact contact) {
        for(int i=0; i<ContactData.getInstance().getContacts().size(); i++) {
            boolean isExist = ContactData.getInstance().getContacts().get(i).equals(contact);
            if(isExist) {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();
                String notes = notesArea.getText().trim();
                if(!firstNameField.getText().isEmpty()) {
                    contact.setFirstName(firstName);
                }
                if(!lastNameField.getText().isEmpty()) {
                    contact.setLastName(lastName);
                }
                if(!phoneNumberField.getText().isEmpty()) {
                    contact.setPhoneNumber(phoneNumber);
                }
                if(!notesArea.getText().isEmpty()) {
                    contact.setNotes(notes);
                }
                ContactData.getInstance().getContacts().set(i, contact);
            }
        }
    }

    public void setEditFields(Contact contact){
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        notesArea.setText(contact.getNotes());
    }

}
