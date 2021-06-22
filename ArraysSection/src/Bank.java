import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private ArrayList<Branch> branch;
    private String name;
    private Scanner scan = new Scanner(System.in);

    public Bank(String name){
        this.name = name;
        branch = new ArrayList<>();
    }

    public boolean addBranch(String bName){
        if (findBranch(bName) == null){
            branch.add(new Branch(bName));
            return true;
        }else{
            System.out.println("Error, branch already exists.");
            return false;
        }
    }

    public boolean addCustomer(String branchName, String cName, double initAmt){
        Branch branch = findBranch(branchName);
        if (branch == null)
            return false;
        else
            return branch.newCustomer(cName, initAmt);
    }

    public boolean addCustomerTransaction(String branchName, String cName, double amt){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(cName, amt);
        }
        return false;
    }

    public Branch findBranch(String branch){
        for (int i = 0; i < this.branch.size(); i++) {
            if (this.branch.get(i).getName().equals(branch))
                return this.branch.get(i);
            }
        return null;
    }

    public boolean listCustomers(String bName, boolean showTransactions){
        Branch branch = findBranch(bName);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> bCustomers = branch.getCustomers();
            for (int i = 0; i < bCustomers.size(); i++){
                System.out.println("Customer: " + bCustomers.get(i).getName() + "[" + i + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = bCustomers.get(i).getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else{
            return false;
        }
    }
}