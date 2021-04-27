public class Holden extends Car{

    public Holden(int cylinders, String name){
        super(cylinders,name);
    }

    public String startEngine(){
        return Holden.class.getName() + " -> startEngine()";
    }

    public String accelerate(){
        return Holden.class.getName() + " -> accelerate()";
    }

    public String brake(){
        return Holden.class.getName() + " -> brake()";
    }
}