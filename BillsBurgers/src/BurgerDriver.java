public class BurgerDriver {

    public static void main(String[] args) {
        Hamburger burger1 = new Hamburger("Rye", "Burger", 5.5, "Basic Burger");
        burger1.addBacon();
        burger1.addBacon();
        burger1.addCheese();
        burger1.addKetchup();
        burger1.addLettuce();
        System.out.println(burger1);

        HealthyBurger burger2 = new HealthyBurger();
        burger2.addBacon();
        burger2.addBacon();
        burger2.addCheese();
        burger2.addKetchup();
        burger2.addCheese();
        burger2.addLettuce();
        burger2.addTomato();
        System.out.println(burger2);

        DeluxeBurger burger3 = new DeluxeBurger();
        burger3.addBacon();
        burger3.addCheese();
        burger3.addTomato();
        System.out.println(burger3);
    }
}
