package sample;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty notes;

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.notes.set(notes);
    }

    public Contact() {
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.notes = new SimpleStringProperty();
    }

    public String getFirstName() {
        return firstNameProperty().get();
    }

    public void setFirstName(String firstName) {
        try{
            firstNameProperty().set(firstName);
        }
        catch (NullPointerException e){
            System.out.println("Null Pointer Exception first name");
        }
    }

    public SimpleStringProperty firstNameProperty(){
        return firstName;
    }

    public String getLastName() {
        return lastNameProperty().get();
    }

    public void setLastName(String lastName) {
        try{
            lastNameProperty().set(lastName);
        }
        catch (NullPointerException e){
            System.out.println("Null Pointer Exception lastname");
        }
    }

    public SimpleStringProperty lastNameProperty(){
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumberProperty().get();
    }

    public void setPhoneNumber(String phoneNumber) {
        try{
            phoneNumberProperty().set(phoneNumber);
        }
        catch (NullPointerException e){
            System.out.println("Null Pointer Exception phoneNumber");
        }
    }

    public SimpleStringProperty phoneNumberProperty(){
        return phoneNumber;
    }

    public String getNotes() {
        return notesProperty().get();
    }

    public void setNotes(String notes) {
        try{
            notesProperty().set(notes);
        }
        catch (NullPointerException e){
            System.out.println("Null Pointer Exception first name");
        }
    }

    public SimpleStringProperty notesProperty(){
        return notes;
    }
}