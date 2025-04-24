import FatherModel.FatherObj;
import Models.LinkedListReader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        LinkedListReader reader = new LinkedListReader();
        File file = new File("src/test/text.txt");

        if (file.exists()) {
            reader.readFile(file);
        }
        else{
            System.out.println("File not found");
        }
    }
}