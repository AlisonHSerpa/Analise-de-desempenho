package Java.interfaces;

import Java.FatherModel.FatherObj;
import Java.Models.LinkedList;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LinkedListReader implements Reader {
    //Scanner deve começar null e terminar null
    Scanner sc = null;

    public void readFile(File file) {
        //to usando poliformismo para a as classes retornarem diferentes objetos
        //confira a classe FatherObj para mais detalhes
        FatherObj list = new LinkedList();

        //exception para caso nao encontrar aquivo
        try{
            sc = new Scanner(file);

            //scanner vai ler o arquivo, dai a arquitetura do arquivo eh especifica
            while (sc.hasNextLine()) {
                //primeira linha enche a lista
                String[] dataList = sc.nextLine().split(" ");
                ((LinkedList) list).createWithLine(dataList);

                //Segunda fala quantas operacoes serao realizadas
                int operations = Integer.parseInt(sc.nextLine());

                //Terceira em diante usa A(adicionar) e R(remover) no inicio, numero e posição
                for (int i = 0; i < operations; i++) {
                    //linha de operacao
                    String[] OpLine = sc.nextLine().split(" ");
                    ((LinkedList) list).operationLine(OpLine);
                    ((LinkedList) list).printList();
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
