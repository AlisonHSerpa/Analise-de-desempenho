from LinkedList import ListaEncadeada

def processar_arquivo(nome_arquivo):
    lista = ListaEncadeada()

    with open(nome_arquivo, 'r') as file:
        # Processa primeira linha com números iniciais
        primeira_linha = file.readline().strip()
        if primeira_linha:
            numeros = list(map(int, primeira_linha.split()))
            for num in numeros:
                lista.adicionar_no_final(num)
        
        # Processa comandos subsequentes
        for linha in file:
            linha = linha.strip()
            if not linha:
                continue
                
            if linha == 'P':
                lista.imprimir()
            elif linha.startswith('A'):
                partes = linha.split()
                valor = int(partes[1])
                if len(partes) == 3:  # A valor posicao
                    posicao = int(partes[2])
                    try:
                        lista.inserir_na_posicao(valor, posicao)
                    except IndexError:
                        print(f"Posição {posicao} inválida para inserção")
                else:  # A valor (adiciona no final)
                    lista.adicionar_no_final(valor)
            elif linha.startswith('R'):
                valor = int(linha.split()[1])
                if not lista.remover(valor):
                    print(f"Valor {valor} não encontrado para remoção")
    
    return lista

# Caminho do teste
import os

if os.name == 'nt':  # Windows
    caminho = 'D:/projects/Analise de desempenho/src/test/text.txt'
else:  # Linux/WSL
    caminho = '/mnt/d/projects/Analise de desempenho/src/test/text.txt'

# Testendo o código
lista_final = processar_arquivo(caminho)