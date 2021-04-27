public class Rx350 extends Car {
    private String warranty;

    public Rx350(){
        this("");
    }

    public Rx350(String warranty){
        super("AWD",135,5,"Automatic",250,"Lexus","Rx350");
        this.warranty = warranty;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String toString(){
        return super.getMake() + " "  + super.getTopSpeed();
    }

    public static void main(String[] args) {
        Rx350 car1 = new Rx350();
        System.out.println(car1);
    }
}