import java.util.ArrayList;

public class MobilePhoneMP {
    private String myNumber;
    private ArrayList<ContactMP> list;


    public MobilePhoneMP(String myNumber){
        this.myNumber = myNumber;
        this.list = new ArrayList<>();
    }

    public boolean addNewContact(ContactMP contact){
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        list.add(contact);
        return true;
    }

    private int findContact(ContactMP contact){
        return this.list.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i < this.list.size(); i++){
            ContactMP contact = this.list.get(i);
            if (contact.getName().equals(contactName))
                return i;
        }
        return -1;
    }

    public String queryContact(ContactMP contact){
        if (findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    public ContactMP queryContact(String name){
        int position = findContact(name);
        if (position >= 0)
            return this.list.get(position);
        return null;
    }

    public boolean updateContact(ContactMP oldContact, ContactMP newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition< 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        }
        else if (findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() + " already exists.  " +
                    "Update was not successful.");
            return false;
        }
        this.list.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(ContactMP contact){
        int foundPosition = findContact(contact);
        if (foundPosition< 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.list.remove(foundPosition);
        System.out.println(contact.getName() + ", was removed.");
        return true;
    }

    public void printContactMP(){
        System.out.println("Contact List");
        for (int i = 0; i < this.list.size(); i++){
            System.out.println((i+1) + "." +
                    this.list.get(i).getName() + " -> " +
                    this.list.get(i).getPhone());
        }
    }
}