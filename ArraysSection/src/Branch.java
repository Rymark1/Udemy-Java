import java.util.ArrayList;

public class Branch {

    ArrayList<Customer> customer;
    String name;

    public Branch(String name){
        this.name = name;
        customer = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String cName, double initAmt){
        if (findCustomer(cName) == null){
            this.customer.add(new Customer(cName, initAmt));
            return true;
        }
        return false;
    }

    private Customer findCustomer(String cName){
        for (int i=0; i<customer.size();i++){
            if (customer.get(i).getName().equals(cName))
                return customer.get(i);
        }
        return null;
    }

    public boolean addCustomerTransaction(String customerName, double amt){
        Customer existingC = findCustomer(customerName);
        if (existingC == null){
            System.out.println("Error, the person does not exist.");
            return false;
        }
        existingC.addTransaction(amt);
        return true;
    }

    public ArrayList<Customer> getCustomers() {
        return customer;
    }
}