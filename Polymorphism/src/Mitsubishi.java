public class Mitsubishi extends Car{

    public Mitsubishi(int cylinders, String name){
        super(cylinders,name);
    }

    public String startEngine(){
        return Mitsubishi.class.getName() + " -> startEngine()";
    }

    public String accelerate(){
        return Mitsubishi.class.getName() + " -> accelerate()";
    }

    public String brake(){
        return Mitsubishi.class.getName() + " -> brake()";
    }
}