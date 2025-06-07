package Jva.Sort_test;

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

    //vai parar na pasta Aanalise de desempenho
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
        File test = new File("arq.txt");
        ArrayList<Integer> list = new ArrayList<>();
        readNumbers(test, list);

        System.gc();

        //teste com bubbleSort
        long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long inicioBubble = System.nanoTime();
        BubbleSort.bubbleSort(list);
        long fimBubble = System.nanoTime();
        long memoriaDepois = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        writeFile(list);
        long memoriaTotal = memoriaDepois - memoriaAntes;
        double tempoBubble = (fimBubble - inicioBubble) / 1_000_000.0;
        System.out.println("Memoria utilizada em bubblesort: " +memoriaTotal/1024 + " KB");
        System.out.printf("Tempo de execução: %.3f ms%n", tempoBubble);

        System.gc();

        list.clear();
        readNumbers(test, list);

        //teste com selectionSort
        long memoriAanterior = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long inicioSelection = System.nanoTime();
        SelectionSort.selectionSort(list);
        long fimSelection = System.nanoTime();
        long memoriaPosterior = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        writeFile(list);
        long memoriaUtilizada = memoriAanterior - memoriaPosterior;
        double tempoSelection = (fimSelection - inicioSelection) / 1_000_000.0;
        System.out.println("Memoria utilizada em selectionsort: " +memoriaUtilizada/1024 + " KB");
        System.out.printf("Tempo de execução: %.3f ms%n", tempoSelection);
    }
}
