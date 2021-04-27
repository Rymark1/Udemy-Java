import java.text.DecimalFormat;

public class Hamburger {

    private String name, meat, breadRollType;
    private double price;

    private String addition1Name, addition2Name, addition3Name, addition4Name;
    private double addition1Price, addition2Price, addition3Price, addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.breadRollType = breadRollType;
        this.name = name;
        this.meat = meat;
        this.price = price;
    }

    public void addHamburgerAddition1(String addition1Name, double addition1Price){
        this.addition1Name = addition1Name;
        this.addition1Price = addition1Price;
    }

    public void addHamburgerAddition2(String addition2Name, double addition2Price){
        this.addition2Name = addition2Name;
        this.addition2Price = addition2Price;
    }

    public void addHamburgerAddition3(String addition3Name, double addition3Price){
        this.addition3Name = addition3Name;
        this.addition3Price = addition3Price;
    }

    public void addHamburgerAddition4(String addition4Name, double addition4Price){
        this.addition4Name = addition4Name;
        this.addition4Price = addition4Price;
    }

    public double itemizeHamburger(){
        double totalPrice = this.price;
        DecimalFormat df = new DecimalFormat("###.##");

        System.out.println(this.name + " hamburger on a " +this.breadRollType + " roll with " + this.meat + ", price is " + this.price);
        if (this.addition1Name != null){
            totalPrice += addition1Price;
            System.out.println("Added "+ this.addition1Name + " for an extra "+ df.format(this.addition1Price));
        }
        if (this.addition2Name != null){
            totalPrice += addition2Price;
            System.out.println("Added "+ this.addition2Name + " for an extra "+ df.format(this.addition2Price));
        }
        if (this.addition3Name != null) {
            totalPrice += addition3Price;
            System.out.println("Added "+ this.addition3Name + " for an extra "+ df.format(this.addition3Price));
        }
        if (this.addition4Name != null) {
            totalPrice += addition4Price;
            System.out.println("Added "+ this.addition4Name + " for an extra "+ df.format(this.addition4Price));
        }
        return totalPrice;
    }
}