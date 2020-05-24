package serialization;

import by.gsu.pms.Milk;

import java.io.*;

public class Deserialization {

    public Milk[] deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("milk.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Milk[] milks = (Milk[]) objectInputStream.readObject();
        objectInputStream.close();
        return milks;
    }
}