import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name){
        if (findBranch(name) == null){
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String nBranch, String cName, double amt){
        Branch branch = findBranch(nBranch);
        if (branch != null){
            return branch.newCustomer(cName,amt);
        }
        return false;
    }

    public boolean addCustomerTransaction(String nBranch, String cName, double amt){
        Branch branch = findBranch(nBranch);
        if (branch != null)
            return branch.addCustomerTransaction(cName,amt);
        return false;
    }

    private Branch findBranch(String name){
        for (int i = 0; i < branches.size(); i++){
            if (branches.get(i).getName().equals(name))
                return branches.get(i);
        }
        return null;
    }

    public boolean listCustomers(String nBranch, boolean printTransactions){
        Branch branch = findBranch(nBranch);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> customers = new ArrayList<Customer>(branch.getCustomers());
            for (int i = 0; i < customers.size(); i++){
                Customer customer = customers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (1+i) + "]");
                ArrayList<Double> transactions = new ArrayList<Double>(customer.getTransactions());
                if (printTransactions){
                    System.out.println("Transactions");
                    for(int j = 0; j < transactions.size();j++){
                        System.out.println("[" + (1+j) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}