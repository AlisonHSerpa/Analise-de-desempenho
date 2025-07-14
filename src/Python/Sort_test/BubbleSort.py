import time
import tracemalloc

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr

def read_numbers(file_path):
    numbers = []
    with open(file_path, 'r') as file:
        for line in file:
            try:
                number = float(line.strip())
                numbers.append(number)
            except:
                pass
    return numbers

def main():
    input_file = "D:/projects/Analise de desempenho/src/test2/arq.txt"
    numbers = read_numbers(input_file)
    
    start_time = time.time()
    tracemalloc.start()
    
    sorted_numbers = bubble_sort(numbers)

    end_time = time.time()
    mem_used = tracemalloc.get_traced_memory()
    tracemalloc.stop()

    elapsed_time_ms = round((end_time - start_time) * 1000,2  ) 
    
    output_file = "bubblesort-saida.txt"
    with open(output_file, 'w') as file:
        for number in sorted_numbers:
            file.write(f"{number}\n")


    
    print(f"\nTempo de execução: {elapsed_time_ms} ms")
    print(f"Memória utilizada: {mem_used[1]} KB")
    print(f"Arquivo de saída '{output_file}' gerado com sucesso.")

main()