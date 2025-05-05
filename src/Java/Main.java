package Java;
import Java.interfaces.LinkedListReader;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //esse main eh apenas para testes

        //criando arquivo e reader, verifica se o arquivo existe e dps le
        LinkedListReader reader = new LinkedListReader();
        File caminho;

        // Verificar o sistema operacional
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {  // Windows
            caminho = new File("D:/projects/Analise de desempenho/src/test/text.txt");
        } else {  // Linux/WSL
            caminho = new File("/mnt/d/projects/Analise de desempenho/src/test/text.txt");
        }

        if (caminho.exists()) {
            reader.readFile(caminho);
        }
        else{
            System.out.println("File not found");
        }
    }
}