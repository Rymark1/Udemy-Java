
import java.text.NumberFormat;

public class Hamburger {
    
    private String bread;
    private String meat;
    private String name;
    private int lettuce;
    private int tomato;
    private int cheese;
    private int ketchup;
    private int bacon;
    private double lettucePrice = .10;
    private double tomatoPrice = .20;
    private double cheesePrice = .50;
    private double ketchupPrice = .20;
    private double baconPrice = 1.00;
    private int totalExtras;
    private double price;
    private int maxExtras;

    public Hamburger(String bread, String meat, double price, String name) {
        this.bread = bread;
        this.meat = meat;
        this.price = price;
        this.name = name;
        this.lettuce = 0;
        this.tomato = 0;
        this.cheese = 0;
        this.ketchup = 0;
        this.bacon = 0;
        this.totalExtras = 0;
        this.maxExtras = 4;
    }
    
    public void addLettuce(){
        if (this.totalExtras <maxExtras) {
            this.lettuce += 1;
            this.totalExtras += 1;
        }
        else
            System.out.println("Topping not added.  Maximum amount reached.");
    }

    public void addTomato(){
        if (this.totalExtras <maxExtras) {
            this.tomato += 1;
            this.totalExtras += 1;
        }
        else
            System.out.println("Topping not added.  Maximum amount reached.");
    }

    public void addCheese(){
        if (this.totalExtras <maxExtras) {
            this.cheese += 1;
            this.totalExtras += 1;
        }
        else
            System.out.println("Topping not added.  Maximum amount reached.");
    }

    public void addKetchup(){
        if (this.totalExtras <maxExtras) {
            this.ketchup += 1;
            this.totalExtras += 1;
        }
        else
            System.out.println("Topping not added.  Maximum amount reached.");
    }

    public void addBacon(){
        if (this.totalExtras <maxExtras) {
            this.bacon += 1;
            this.totalExtras += 1;
        }
        else
            System.out.println("Topping not added.  Maximum amount reached.");
    }

    public void setMaxExtras(int maxExtras) {
        this.maxExtras = maxExtras;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String printOrder(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String order = "Base Burger\t" + fmt.format(this.price);
        if (lettuce != 0)
            order += "\nLettuce\t" + fmt.format(this.lettucePrice*this.lettuce);
        if (tomato != 0)
            order += "\nTomato\t" + fmt.format(this.tomatoPrice*this.tomato);
        if (cheese != 0)
            order += "\nCheese\t" + fmt.format(this.cheesePrice*this.cheese);
        if (ketchup != 0)
            order += "\nKetchup\t" + fmt.format(this.ketchupPrice*this.ketchup);
        if (bacon != 0)
            order += "\nBacon\t" + fmt.format(this.baconPrice*bacon);
        order += "\nTotal Price\t" + fmt.format(this.price + (this.lettuce * this.lettucePrice) + (this.tomatoPrice * this.tomato) +
                (this.cheesePrice * this.cheese) + (this.ketchup * this.ketchupPrice) + (this.bacon + this.baconPrice));
        order += "\n";
        return order;
    }

    public String toString(){
        return this.printOrder();
    }
}