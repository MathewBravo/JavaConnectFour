import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.RuntimeException

public class Main {

    // change this method
    public static void method() throws IOException{
        throw new IOException();
    }

    /* Do not change code below */
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}