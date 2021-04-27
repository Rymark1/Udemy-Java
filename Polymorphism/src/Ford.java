public class Ford extends Car{

    public Ford(int cylinders, String name){
        super(cylinders,name);
    }

    public String startEngine(){
        return Ford.class.getName() + " -> startEngine()";
    }

    public String accelerate(){
        return Ford.class.getName() + " -> accelerate()";
    }

    public String brake(){
        return Ford.class.getName() + " -> brake()";
    }
}