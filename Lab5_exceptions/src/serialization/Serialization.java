package serialization;

import by.gsu.pms.Milk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    public void serialization(Milk[] milks) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("milk.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(milks);
        objectOutputStream.close();
    }
}