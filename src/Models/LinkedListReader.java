package Models;

import FatherModel.FatherObj;
import interfaces.Reader;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LinkedListReader implements Reader {
    //Scanner deve começar null e terminar null
    Scanner sc = null;

    public FatherObj readFile(File file) {
        //to usando poliformismo para a as classes retornarem diferentes objetos
        //confira a classe FatherObj para mais detalhes
        FatherObj list = new LinkedList();

        //exception para caso nao encontrar aquivo
        try{
            sc = new Scanner(file);

            //scanner vai ler o arquivo, dai a arquitetura do arquivo eh especifica
            while (sc.hasNextLine()) {
                //primeira linha enche a lista
                //Segunda fala quantas operacoes serao realizadas
                //Terceira em diante usa A(adicionar) e R(remover) no inicio
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
        return list;
    }
}
