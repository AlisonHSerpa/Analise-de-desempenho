package Java;

import Java.interfaces.LinkedListReader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //esse main eh apenas para testes

        //criando arquivo e reader, verifica se o arquivo existe e dps le
        LinkedListReader reader = new LinkedListReader();
        File file = new File("src/Java.test/text.txt");

        if (file.exists()) {
            reader.readFile(file);
        }
        else{
            System.out.println("File not found");
        }
    }
}