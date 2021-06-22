public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Rookie");
        dog.breath();
        dog.eat();

        Parrot parrot = new Parrot("Australian Ringneck");
        parrot.breath();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Happyfeet");
        penguin.breath();
        penguin.eat();
        penguin.fly();
    }
}