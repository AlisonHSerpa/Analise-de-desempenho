# Classe No da linkedList
class node:
    def __init__(self, dado):
        self.dado = dado
        self.proximo = None

# Classe LinkedList
class linkedList:
    def __init__(self):
        self.cabeca = None

        # Médoto para adicionar no inicio da lista
    def adicionar_no_inicio(self, dado):
        novo_no = node(dado)
        # Se a lista estiver vazia, o novo nó se torna o no cabeca
        if not self.cabeca: 
            self.cabeca = novo_no
            return
        # Caso contrário fazer novo_no virar a cabeca
        novo_no.next = self.cabeca
        self.cabeca = novo_no
        

    # Método Adicionar, esse método inseri um novo nó em uma posição especifica
    def inserir_na_posicao(self, dado, posicao):
        # Cria um novo nó com o valor fornecido pelo arquivo de texto
        novo_no = node(dado) 
        # Se a posição for 0, insere o novo nó no inicio(cabeça)
        if posicao == 0:
            novo_no.proximo = self.cabeca
            self.cabeca = novo_no
            return
        # Caso contrário, percorre a lista até a posição anterior a posição desejada
        atual = self.cabeca
        for _ in range(posicao - 1):
            # Se a posição não existe, encerra
            if atual is None: 
                return
            atual = atual.proximo
        if atual is None:
            return
        # Insere o novo nó na posição especifica e ajusta os ponteiros
        # [atual] -> [X]
        novo_no.proximo = atual.proximo
        atual.proximo = novo_no
        # [atual] -> [novo_no] -> [X]

        # Método Remover o primeiro nó com um valor específico
    def remover(self, valor):
        # Se a lista estiver vazia, encerra a execução
        if self.cabeca is None:
            return
        
        # Caso o valor esteja no primeiro nó (cabeça), ajusta a cabeça para o próximo nó
        if self.cabeca.dado == valor:
            self.cabeca = self.cabeca.proximo
            return

        # Percorre a lista para encontrar o nó com o valor desejado
        atual = self.cabeca
        anterior = None
        while atual is not None and atual.dado != valor:
            anterior = atual
            atual = atual.proximo

        # Se o nó com o valor foi encontrado, remove-o
        if atual is not None:
            anterior.proximo = atual.proximo


    # Método Imprimir a lista, metodo que vai exibir os elementos da lista.
    def exibir(self):
        # Cria uma lista para armazenar os valores.
        elementos = []
        # Inicia do nó cabeça(primeiro nó)
        atual = self.cabeca
        # Percorre a lista e adiciona cada valor à lista 'elementos'
        while atual:
            elementos.append(atual.dado)
            atual = atual.proximo
        # Imprime os valores da lista separados por " -> "
        print(" -> ".join(map(str, elementos)))


