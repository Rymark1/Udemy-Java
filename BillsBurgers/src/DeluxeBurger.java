public class DeluxeBurger extends Hamburger{

    public DeluxeBurger(){
        super ("Deluxe Roll", "Wagyu Beef", 11.5, "Deluxe Burger");
        super.setMaxExtras(5);
        super.addBacon();
        super.addCheese();
        super.addKetchup();
        super.addLettuce();
        super.addTomato();
        super.setMaxExtras(0);
    }
}