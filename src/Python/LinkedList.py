class No:
    def __init__(self, valor):
        self.valor = valor
        self.proximo = None

class ListaEncadeada:
    def __init__(self):
        self.cabeca = None
    
    def adicionar_no_final(self, valor):
        novo_no = No(valor)
        if not self.cabeca:
            self.cabeca = novo_no
            return
        atual = self.cabeca
        while atual.proximo:
            atual = atual.proximo
        atual.proximo = novo_no
    
    def adicionar_no_inicio(self, valor):
        novo_no = No(valor)
        novo_no.proximo = self.cabeca
        self.cabeca = novo_no
    
    def remover(self, valor):
        atual = self.cabeca
        anterior = None
        while atual:
            if atual.valor == valor:
                if anterior:
                    anterior.proximo = atual.proximo
                else:
                    self.cabeca = atual.proximo
                return True
            anterior = atual
            atual = atual.proximo
        return False
    
    def inserir_na_posicao(self, valor, posicao):
        if posicao == 0:
            self.adicionar_no_inicio(valor)
            return
        
        novo_no = No(valor)
        atual = self.cabeca
        for _ in range(posicao - 1):
            if not atual:
                raise IndexError("Posição fora do alcance")
            atual = atual.proximo
        
        if not atual:
            raise IndexError("Posição fora do alcance")
        
        novo_no.proximo = atual.proximo
        atual.proximo = novo_no
    
    def imprimir(self):
        elementos = []
        atual = self.cabeca
        while atual:
            elementos.append(str(atual.valor))
            atual = atual.proximo
        print(' '.join(elementos) if elementos else "Lista vazia")