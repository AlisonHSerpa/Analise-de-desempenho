# Classe No da linkedList
class node:
    def __init__(self, dado):
        self.dado = dado
        self.proximo = None

class linkedList:
    def __init__(self):
        self.cabeca = None

        # Médoto para adicionar no inicio da lista
    def adicionar_no_inicio(self, dado):
        novo_no = node(dado)
        # Se a lista estiver vazia, o novo no se torna o no cabeca
        if not self.cabeca: 
            self.cabeca = novo_no
            return
        # Caso contrário fazer novo_no virar a cabeca
        novo_no.next = self.cabeca
        self.cabeca = novo_no
        

    # Metodo Adicionar, esse metodo inseri um novo no em uma posicao especifica
    def inserir_na_posicao(self, dado, posicao):
        # Cria um novo no com o valor fornecido pelo arquivo de texto
        novo_no = node(dado) 
        # Se a posicao for 0, insere o novo no no inicio(cabeca)
        if posicao == 0:
            novo_no.proximo = self.cabeca
            self.cabeca = novo_no
            return
        # Caso contrario, percorre a lista ate a posicao anterior a posicao desejada
        atual = self.cabeca
        for _ in range(posicao - 1):
            # Se a posição nao existe, encerra
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

        # Método Remover o primeiro no com um valor especifico
    def remover(self, valor):
        # Se a lista estiver vazia, encerra a execucao
        if self.cabeca is None:
            return
        
        # Caso o valor esteja no primeiro no (cabeca), ajusta a cabeça para o proximo no
        if self.cabeca.dado == valor:
            self.cabeca = self.cabeca.proximo
            return

        # Percorre a lista para encontrar o no com o valor desejado
        atual = self.cabeca
        anterior = None
        while atual is not None and atual.dado != valor:
            anterior = atual
            atual = atual.proximo

        # Se o no com o valor foi encontrado, remove-o
        if atual is not None:
            anterior.proximo = atual.proximo


    # Metodo Imprimir a lista, metodo que vai exibir os elementos da lista.
    def exibir(self):
        # Cria uma lista para armazenar os valores.
        elementos = []
        # Inicia do no cabeça(primeiro no)
        atual = self.cabeca
        # Percorre a lista e adiciona cada valor a lista 'elementos'
        while atual:
            elementos.append(atual.dado)
            atual = atual.proximo
        # Imprime os valores da lista separados por " -> "
        print(" -> ".join(map(str, elementos)))


