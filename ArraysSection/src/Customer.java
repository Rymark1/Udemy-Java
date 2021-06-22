import java.util.ArrayList;

public class Customer {

    ArrayList<Double> transactions;
    String name;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(transaction);
    }

    public void addTransaction(double amt){
        this.transactions.add(amt);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }

}