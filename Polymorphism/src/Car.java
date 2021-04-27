public class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }

    public String startEngine(){
        return Car.class.getName() + " -> startEngine()";
    }

    public String accelerate(){
        return Car.class.getName() + " -> accelerate()";
    }

    public String brake(){
        return Car.class.getName() + " -> brake()";
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public static void main(String[] args) {
    }
}