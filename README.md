# 📊 Projeto Acadêmico — Análise de Desempenho

Este repositório foi desenvolvido com fins estritamente acadêmicos, com o objetivo de aprofundar a compreensão e a prática da análise de desempenho em diferentes linguagens de programação. Todas as estruturas de dados e algoritmos foram implementados manualmente, **sem o uso de bibliotecas externas**.

---

## 🎯 Objetivo

Explorar a implementação de estruturas clássicas de dados e algoritmos, analisando seu desempenho prático com base em tempo de execução e uso de memória. As comparações são feitas entre três linguagens de programação: **Java**, **Python** e **JavaScript (Node.js)**.

---

## ⚙️ Requisitos

Antes de executar os testes, certifique-se de ter as seguintes ferramentas instaladas:

* [Java 23](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Python 3.10](https://www.python.org/downloads/release/python-3100/)
* [Node.js 22.15](https://nodejs.org/)
* [WSL (Windows Subsystem for Linux)](https://learn.microsoft.com/pt-br/windows/wsl/install) — caso esteja utilizando Windows
* Git para clonar este repositório:

  ```bash
  git clone https://github.com/AlisonHSerpa/Analise-de-desempenho.git
  ```
  
* instalar as bibliotecas request e fastAPI:

  ```bash
  pip install request
  pip install fastAPI
  ```
* [Docker 28.3](https://www.docker.com/products/docker-desktop/)

---

## 🧪 Atividade 1 — Lista Encadeada Simples (Simple LinkedList)

### Objetivo

Implementar uma estrutura de lista encadeada simples nas três linguagens, medindo o tempo de execução dos métodos principais:

* Criação
* Inserção
* Remoção
* Impressão

### ▶️ Como executar

#### Python

```bash
cd python/LinkedList_test
time python3 Reader.py
```

#### Java

```bash
cd Java/LinkedList_test
javac -d . *.java
time java Main
```

#### Node.js

```bash
cd JS/LinkedList_test
time node Reader.js
```

> 💡 No Windows, recomenda-se o uso do WSL:

```bash
wsl --install
```

---

## 🧪 Atividade 2 — Algoritmos de Ordenação (Sort)

### Objetivo

Avaliar o **tempo de execução** e o **uso de memória** de algoritmos de ordenação (Bubble Sort e Selection Sort) implementados nas três linguagens.

### ▶️ Como executar

#### Python

```bash
cd python/Sort_test
python3 BubbleSort.py
python3 SelectionSort.py
```

#### Java

```bash
cd Java/Sort_test
javac -d . *.java
java Jva.Sort_test.Main
```

#### Node.js

```bash
cd JS/Sort_test
node Reader.js
```

> 💡 No Windows, recomenda-se o uso do WSL:

```bash
wsl --install
```

---

## 🧪 Atividade 3 — Balanceador de carga (load blance)

### Objetivo

Criar um balanceador de carga (ou load balance), uma aplicação que administra varias instancias de backend para controlar o fluxo de requisições agindo como um proxy reverso (reverse proxy) e impedindo um overload de requisições. Essa aplicação utiliza `docker`, `nginx` e `docker compose`

## ▶️ Como executar

Vá até o diretorio ` ...\Analise de desempenho\src\load_balance` e siga as instruções de `instrucoes.txt`, realizando todo o processo no diretorio apontado.

---

## 🔎 Conclusões

> *Espaço reservado para inserção dos resultados obtidos nas análises de desempenho.*

---

### 💡 Observações

> É importante salientar que o entendimento das linguagens utilizadas e a forma como elas foram implementadas nesse repositório pelo autor do mesmo é diferencial para os resultados obtidos nesta analise, portanto esse estudo não deve levado como resultado definitivo, mas como um projeto com fins acadêmicos.

---

## 👨‍💻 Autor

Desenvolvido por **Alison Serpa**, como parte dos estudos em Análise de Desempenho no curso de **Engenharia da Computação** da **Universidade Federal Rural de Pernambuco (UFRPE)** — Unidade Acadêmica de Belo Jardim (UABJ).
