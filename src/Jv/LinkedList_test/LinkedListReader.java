package Jv.LinkedList_test;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LinkedListReader {
    //Scanner deve começar null e terminar null
    Scanner sc = null;

    public void readFile(File file) {
        ListaLigada list = new ListaLigada();

        //exception para caso nao encontrar aquivo
        try{
            sc = new Scanner(file);

            //scanner vai ler o arquivo, dai a arquitetura do arquivo eh especifica
            while (sc.hasNextLine()) {
                //primeira linha enche a lista
                String[] dataList = sc.nextLine().split(" ");
                list.createWithLine(dataList);

                //Segunda fala quantas operacoes serao realizadas
                int operations = Integer.parseInt(sc.nextLine());

                //Terceira em diante usa A(adicionar) e R(remover) no inicio, numero e posição
                for (int i = 0; i < operations; i++) {
                    //linha de operacao
                    String[] OpLine = sc.nextLine().split(" ");
                    list.operationLine(OpLine);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
            //Esse if eh necessario para evitar nullpointerexception
            if(sc != null){
                sc.close();
            }
        }
    }
}
