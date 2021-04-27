public class Vehicle {

    private String steering;
    private int topSpeed;
    private int maxPassengers;

    public Vehicle(){
        this("",0,0);
    }

    public Vehicle(int topSpeed){
        this(topSpeed,0);
    }

    public Vehicle(int topSpeed,int maxPassengers){
        this("",topSpeed,maxPassengers);
    }

    public Vehicle (String steering, int topSpeed, int maxPassengers){
        this.steering = steering;
        this.topSpeed = topSpeed;
        this.maxPassengers = maxPassengers;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
}