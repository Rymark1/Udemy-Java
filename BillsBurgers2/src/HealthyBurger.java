import java.text.DecimalFormat;

public class HealthyBurger extends Hamburger{
    
    private String healthyExtra1Name, healthyExtra2Name;
    private double healthyExtra1Price, healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye");
    }
    
    public void addHealthyAddition1(String healthyExtra1Name, double healthyExtra1Price){
        this.healthyExtra1Name = healthyExtra1Name;
        this.healthyExtra1Price = healthyExtra1Price;
    }

    public void addHealthyAddition2(String healthyExtra2Name, double healthyExtra2Price){
        this.healthyExtra2Name = healthyExtra2Name;
        this.healthyExtra2Price = healthyExtra2Price;
    }

    @Override
    public double itemizeHamburger() {
        DecimalFormat df = new DecimalFormat("###.##");
        double totalPrice = super.itemizeHamburger();

        if (this.healthyExtra1Name != null) {
            totalPrice += this.healthyExtra1Price;
            System.out.println("Added "+ this.healthyExtra1Name + " for an extra "+ df.format(this.healthyExtra1Price));
        }
        if (this.healthyExtra2Name != null) {
            totalPrice += this.healthyExtra2Price;
            System.out.println("Added "+ this.healthyExtra2Name + " for an extra "+ df.format(this.healthyExtra2Price));
        }

        return totalPrice;
    }
}