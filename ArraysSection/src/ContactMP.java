public class ContactMP {

    private String name;
    private String phone;

    public ContactMP(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public static ContactMP createContact(String name, String phone){
        return new ContactMP(name, phone);
    }
}
