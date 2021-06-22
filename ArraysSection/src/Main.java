import java.util.Scanner;

public class Main{
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("609 462 6836");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scan.nextInt();
            scan.nextLine();

            switch(action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scan.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scan.nextLine();
        Contact contact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(contact))
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        else
            System.out.println("Cannot add, " + name + " already on file.");
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scan.nextLine();
        System.out.println("Enter new phone number: ");
        String newPhone = scan.nextLine();
        Contact newContact = Contact.createContact(newName, newPhone);
        if (mobilePhone.updateContact(existingContact,newContact))
            System.out.println("Successfully updated record");
        else
            System.out.println("Error updating record.");
    }

    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        if (mobilePhone.removeContact(existingContact))
            System.out.println("Successfully deleted");
        else
            System.out.println("Error deleting record.");
    }

    private static void queryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContact.getName() + " phone number is " + existingContact.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("""
                0 - to showdown
                1 - to print contacts
                2 - to add a new contact\s
                3 - to update existing contact
                4 - to remove an existing contact
                5 - query if an existing contact exists
                6 - to print a list of available actions.""");
        System.out.println("Choose your action: ");
    }
}