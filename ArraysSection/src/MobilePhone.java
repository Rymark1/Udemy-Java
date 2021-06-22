import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        int index = findContact(contact.getName());
        if (index == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldC, Contact newC){
        int index = findContact(oldC);
        if (index >= 0) {
            myContacts.set(index, newC);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        int index = findContact(contact);
        if (index >= 0) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact){
        int index = myContacts.indexOf(contact);
        if (index >= 0)
            return index;
        return -1;
    }

    private int findContact(String name){
        for (int i=0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(name))
                return i;
        }
        return -1;
    }

    public Contact queryContact(String name){
        int index = findContact(name);
        if (index >= 0)
            return myContacts.get(index);
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size();i++){
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}