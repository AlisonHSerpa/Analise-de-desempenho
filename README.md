# Projeto Acadêmico - Testes de Estruturas de Dados em Jv

Este projeto foi desenvolvido com fins **estritamente acadêmicos** para auxiliar no entendimento e prática de **analise de desempenho** em Jv. Todos os algoritmos e estruturas foram implementados manualmente, sem o uso de bibliotecas externas.

## 📘 Objetivo

Explorar a implementação e o desempenho de estruturas clássicas de dados, bem como testar seus principais métodos de forma prática e analisar o tempo de execução em diferentes linguagens de programação dessa desta estrutura.

## 🧱 Estruturas de Dados Implementadas

- Lista Encadeada Simples

## ⚙️ Linguagens implementadas

- Jv
- Python
- Jv Script (JS)

## 🏠 Arquitetura do projeto
```
  Analise-de-desempenho/
├── .idea/
├── .vscode/
├── out/
├── src/
│   ├── Jv/
│   │   ├── FatherModel/
│   │   │   └── FatherObj.java
│   │   ├── interfaces/
│   │   │   ├── LinkedListReader.java
│   │   │   └── Reader.java
│   │   ├── Models/
│   │   │   ├── ListaLigada.java
│   │   │   └── No.java
│   │   └── Main.java
│   ├── JS/
│   │   ├── Linkedlist.js
│   │   └── Reader.js
│   ├── Python/
│   │   ├── ListaLigada.py
│   │   └── Reader.py
│   └── test/
│       └── text.txt
├── .gitignore
├── Analise de desempenho.iml
└── README.md

```

## 🧪 Testes Realizados

Cada estrutura possui uma classe reader, que é responsável por ler um txt de arquitetura especifica para realização dos testes.
Na atual versão deste programa, é necessario programar no main o diretorio para o arquivo, criar um objeto que implementa o Reader e executar o main.

## ▶️ Como Executar

1. Baixe e instale as seguintes versões:

   * `Python 3.10`
   * `Java 23`
   * `Node.js 22.15`

2. Clone este repositório em sua máquina local:
3. Para executar o programa em **Java**:

   * Compile e execute o arquivo `Main.java` usando os seguintes comandos no terminal:

   ```bash
   javac -d . *.java
   java Main
   ```

   OBS: você deve estar no diretório correto para executar esses comandos.

4. Para executar o programa em **Python**:

   * No terminal, navegue até o diretório onde está o arquivo `Reader.py` e execute:

   ```bash
   python Reader.py
   ```
  
   OBS: no Linux, o comando certo deve ser `python3`

5. Para executar o programa em **JavaScript (Node.js)**:

   * No terminal, navegue até o diretório onde está o arquivo `Reader.js` e execute:

   ```bash
   node Reader.js
   ```


## 👨‍💻 Autor

Desenvolvido por Alison Serpa, como parte dos estudos em Analise de desempenho no curso de Engenharia da Computação da UFRPE na Unidade Academica de Belo Jardim (UABJ).

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
