package Jva.BubbleSort_test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void readNumbers(File file, ArrayList<Integer> list) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        //exception para caso nao encontrar aquivo
        try{
            //scanner vai ler o arquivo, dai a arquitetura do arquivo eh especifica
            while (sc.hasNextLine()) {
                list.add(Integer.parseInt(sc.nextLine()));
            }
        } finally{
            //Esse if eh necessario para evitar nullpointerexception
            if(sc != null){
                sc.close();
            }
        }
    }

    public static void writeFile(ArrayList<Integer> list) {
        String mkdir = System.getProperty("user.dir");
        try (FileWriter fw = new FileWriter(mkdir +"/log_Java.txt", true)) {

            for (Integer number : list) {
                fw.write(number.toString());
                fw.write(System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File test = new File("D:/projects/Analise de desempenho/src/test2/arq.txt");
        ArrayList<Integer> list = new ArrayList<>();

        System.gc();

        long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        //cria lista, preenche a lista, organiza a lista, escrever arquivo
        readNumbers(test, list);
        BubbleSort.bubbleSort(list);
        writeFile(list);

        long memoriaDepois = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long memoriaTotal = memoriaDepois - memoriaAntes;
        System.out.println("Memoria utilizada: " +memoriaTotal/1024 + " KB");
    }
}
