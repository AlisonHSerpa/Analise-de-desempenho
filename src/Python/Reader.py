from LinkedList import linkedList as ListaEncadeada

# Método para processar um arquivo de entrada e realizar as operações da lista
def processar_arquivo(nome_arquivo):
    # Cria uma nova Lista Ligada vazia.
    lista_encadeada = ListaEncadeada()

    # Abre o arquivo para leitura
    with open(nome_arquivo, 'r', encoding="utf-8") as arquivo:
        # Lê a primeira linha com os valores iniciais para a lista
        valores_iniciais = map(int, arquivo.readline().strip().split())
        for valor in valores_iniciais:
            lista_encadeada.adicionar_no_inicio(valor)
        
        # Lê o número deações a serem realizadas
        num_acoes = int(arquivo.readline().strip())
        
        # Para cada ação especifica no arquivo
        for _ in range(num_acoes):
            # Lê a linha e divide em partes
            linha = arquivo.readline().strip().split()
            # O primeiro item é o tipo de ação (A, R ou P)
            acao = linha[0]
            
            # Se a  ação for 'A', adiciona um valor na posição especificada
            if acao == 'A':
                # O valor a ser adicionado  
                valor = int(linha[1])
                # A posição onde será inserido
                posicao = int(linha[2])
                lista_encadeada.inserir_na_posicao(valor, posicao)
            # Se a ação for 'R', remove o valor na posição especifica
            elif acao == 'R': 
                # A posição a ser removida
                posicao = int(linha[1])
                lista_encadeada.remover(posicao)
            # Se a ação for 'P', imprime a lista atual
            elif acao == 'P': 
                lista_encadeada.exibir()

    return lista_encadeada # Retorna a lista encadeada final

# Testendo o código
nome_arquivo = "D:/projects/Analise de desempenho/src/test/text.txt"

lista_encadeada = processar_arquivo(nome_arquivo)