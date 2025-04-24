package Models;

import FatherModel.FatherObj;

public class LinkedList extends FatherObj {
    private No head;

    //metodo para ler uma linha de operacao de acordo com o modelo de read do linkedlistReader (linha 23)
    public void operationLine(String[] OpLine){
        //instancia possivel descricao de posicao
        int position;

        //Se a linha descrever a posicao ao qual o numero sera removido/adicionado, salva essa posicao
        if (OpLine.length == 3) {
            position = Integer.parseInt(OpLine[2]);
        }
        //Se nao descrever, sera adicionado no comeco
        else{
            position = 0;
        }

        if (OpLine[0].equals("A")) {
            int data = Integer.parseInt(OpLine[1]); //instancia repetida para evitar out of bound
            insereElementoPosicao(data, position);
        }
        else if (OpLine[0].equals("R")) {
            int data = Integer.parseInt(OpLine[1]); //instancia repetida para evitar out of bound
            removerElemento(data);
        }
        //se for a linha com P, de print
        else{
            printList();
        }
    }

    //preencher toda a lista com um unico array de strings
    public void createWithLine(String[] line){
        for (String s : line) {
            int data = Integer.parseInt(s);
            insereFim(data);
        }
    }


    //metodos padrao de LinkedList
    public LinkedList() {
        super();
    }

    public No getHead(){
        return head;
    }

    public void setHead(No head){
        this.head = head;
    }

    public void insereInicio(int i) {
        //criando no que sera a nova cabeca
        No n = new No(i);

        //seta como a nova cabeca
        n.setProximo(head);
        setHead(n);
    }

    //busca um elemento se existir retorna true
    public boolean buscaElemento(int i) {
        //se nao existe lista, retorna falso
        if (head == null){
            return false;
        }

        //procura o valor e se chegar no ultimo e nao achar, eh falso
        No n = head;
        while (n.getValor() != i){
            if (n.getProximo() != null){
                n = n.getProximo();
            }
            else {
                return false;
            }
        }

        //se sair do loop, eh por que achou
        return true;
    }

    //recebe um valor e devolve o indice desse valor, caso nao encontre, retorna -1
    public int buscaIndice(int i) {
        //contador para salvar os indices da lista
        int count = 0;

        //procura o valor e se chegar no ultimo e nao achar, nao existe
        No n = head;
        while (n.getValor() != i){
            if (n.getProximo() != null){
                n = n.getProximo();
                count++;
            }
            else {
                return -1;
            }
        }

        //se sair do loop, eh por que achou na posicao count
        return count;
    }

    public void insereFim(int i) {
        //se nao existir cabeca, ele cria um Models.No e adiciona
        if (head == null){
            head = new No(i);
            return;
        }
        //percorre a lista para achar o ultimo
        No n = head;
        while (n.getProximo() != null){
            n = n.getProximo();
        }
        //cria o ultimo e coloca o penultimo para apontar para o ultimo
        No last = new No(i);
        n.setProximo(last);
    }

    public void removeInicio() {
        if (head == null){
            return;
        }

        //define que a nova cabeca deve ser o proximo Models.No da antiga cabeca
        No newHead = head.getProximo();
        //seta a nova cabeca
        setHead(newHead);
    }

    public void removeFim() {
        if (head == null){
            return;
        }

        //o Models.No n vai percorrer a lista, o Models.No Before vai seguir o n até que n seja o ultimo
        //dai o proximo de before vira null
        No n = head;
        No before = n;

        //percorre a lista para achar o fim
        while (n.getProximo() != null){
            before = n;
            n = n.getProximo();
        }

        before.setProximo(null);
    }

    //recebe um indice pra remover o No daquele indice
    public void removeIndice(int i) {
        No n = head;

        //percorre a lista ate chegar na posicao
        for (int f= 1; f<i; f++) {
            n = n.getProximo();
        }

        //remove a posicao
        n.setProximo(n.getProximo().getProximo());
    }

    public void insereElementoPosicao(int i, int j) {
        //busca a posicao
        No n = head;
        No anterior = n;
        for (int b=1 ; b<=j ; b++) {
            anterior = n;
            n = n.getProximo();

            //se for null, adiciona no i no final
            if (n == null) {
                insereFim(i);
                return;
            }
        }

        //caso contrario colocar i para apontar para o Models.No na posicao j
        No novo = new No(i);
        novo.setProximo(n);

        //e anterior comeca a apontar para o novo Models.No da posicao j
        anterior.setProximo(novo);
    }

    //ve se o elemento existe, e remove o indice onde ele esta
    public void removerElemento(int i) {
        if (buscaElemento(i)) {
            removeIndice(buscaIndice(i));
        }
        else {
            System.out.println("erro ao remover elemento, elemento " +i+ " nao existe");
        }
    }

    public void printList(){
        if (head == null){
            System.out.println("Lista vazia");
        }
        else{
            //percorre e printa a lista ligada
            No n = head;
            System.out.print("Lista: ");
            while (n.getProximo() != null){
                System.out.print(n.getValor()+ " ");
                n = n.getProximo();
            }
            System.out.println(n.getValor());
        }
    }

}