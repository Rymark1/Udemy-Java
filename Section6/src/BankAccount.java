public class BankAccount {

    private long accountNbr;
    private double balance;
    private String name;
    private String email;
    private String phoneNbr;

    public BankAccount(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNbr() {
        return accountNbr;
    }

    public void setAccountNbr(long accountNbr) {
        this.accountNbr = accountNbr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    public double deposit(double deposit){
        if (deposit < 0){
            System.out.println("Deposit cannot be negative.");
            return balance;
        }
        else
            balance += deposit;
        return balance;
    }

    public double withdraw(double withdraw) {
        if (balance - withdraw < 0) {
            System.out.println("Insufficient Funds");
            return balance;
        } else
            balance -= withdraw;
        return balance;
    }
}