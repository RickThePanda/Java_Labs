import by.gsu.asoilab.Material;
import by.gsu.asoilab.Subject;

public class Runner {
    public static void main(String[] args) {
        //1. Create the object representing the steel wire having the volume 0.03 cubic meter.
        Subject subject = new Subject("wire", new Material("steel", 7850.0), 0.03);

        //2. Print the object content to the console, using toString( ) method.
        System.out.println(subject);

        //3. Update the wire material on the copper (density = 8500) and print its mass.
        subject.setMaterial(new Material("copper", 8500.0));
        System.out.println("The " + subject.getName() + " mass is " + subject.getMass() + " kg. ");

        //4. Restore the wire material and print it.
        subject.setMaterial(new Material("steel", 7850.0));
        System.out.println(subject);
    }
}
