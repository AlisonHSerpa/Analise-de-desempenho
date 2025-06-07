const fs = require('fs');
const os = require('os');
const path = require('path');
const BubbleSort = require("./BubbleSort");
const SelectionSort = require("./SelectionSort");

async function readNumbers(filePath) {
    const numbers = [];
    const data = await fs.promises.readFile(filePath, 'utf-8');
    
    for (const line of data.split(/\r?\n/)) {
        const trimmed = line.trim();
        const num = parseFloat(trimmed);
        if (!isNaN(num) && trimmed !== '') {
            numbers.push(num);
        }
    }
    
    return numbers;
}

async function writeFile(arrayNumeros, filename) {
    const conteudo = arrayNumeros.join('\n');
    try {
        await fs.promises.writeFile(filename, conteudo);
        console.log(`Arquivo ${filename} salvo com sucesso!`);
    } catch (err) {
        console.error('Erro ao escrever no arquivo:', err);
    }
}

// Caminho relativo ao diretório atual do script
const caminho = path.join(__dirname, 'src', 'test2', 'arq.txt');

// Uso
(async () => {
    try {
        // BubbleSort
        const array = await readNumbers(caminho);
        const bubbleSorter = new BubbleSort();
        const startTimeBubble = process.hrtime();
        const sortedArrayBubble = bubbleSorter.bubbleSort([...array]); 
        const endTimeBubble = process.hrtime(startTimeBubble); 
        
        await writeFile(sortedArrayBubble, 'bubble_sort_result.txt');
        console.log(`BubbleSort executado em ${endTimeBubble[0]}s ${endTimeBubble[1]/1e6}ms`);
        console.log("Memória utilizada (BubbleSort):", process.memoryUsage().rss / 1024 / 1024, "MB");

        // SelectionSort
        const array2 = await readNumbers(caminho);
        const selectionSorter = new SelectionSort();
        const startTimeSelection = process.hrtime();
        const sortedArraySelection = selectionSorter.selectionSort([...array2]);
        const endTimeSelection = process.hrtime(startTimeSelection);
        
        await writeFile(sortedArraySelection, 'selection_sort_result.txt');
        console.log(`SelectionSort executado em ${endTimeSelection[0]}s ${endTimeSelection[1]/1e6}ms`);
        console.log("Memória utilizada (SelectionSort):", process.memoryUsage().rss / 1024 / 1024, "MB");

    } catch (err) {
        console.error('Ocorreu um erro:', err);
    }
})();
