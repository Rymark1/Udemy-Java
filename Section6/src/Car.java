public class Car extends Vehicle{

    private String gears;
    private int hp;
    private String make;
    private String model;

    public Car(){
        this("",0,0,"",0, "", "");
    }

    public Car(String gears, int hp, String make, String model){
        this("",0,0,gears,hp,make,model);
    }

    public Car(String steering, int topSpeed, int maxPassengers, String gears, int hp, String make, String model){
        super(steering,topSpeed,maxPassengers);
        this.gears = gears;
        this.hp = hp;
        this.make = make;
        this.model = model;
    }

    public String getGears() {
        return gears;
    }

    public int getHp() {
        return hp;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setGears(String gears) {
        this.gears = gears;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }
}