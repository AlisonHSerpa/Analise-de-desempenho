const fs = require('fs');
const os = require('os');
const path = require('path');
const BubbleSort = require("./BubbleSort");

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

let caminho;

// Verificar o sistema operacional
if (os.platform() === 'win32') {  // Windows
    caminho = path.join('D:', 'projects', 'Analise de desempenho', 'src', 'test2', 'arq.txt');
} else {  // Linux/WSL
    caminho = path.join('/mnt', 'd', 'projects', 'Analise de desempenho', 'src', 'test2', 'arq.txt');
}

// Uso
(async () => {
    const array = await readNumbers(caminho);

    const sorter = new BubbleSort(); // Criando uma instância da classe
    const sortedArray = sorter.bubbleSort(array); // Chamando o método da instância
    
    console.log("Memória utilizada: " + process.memoryUsage().rss / 1024 + " KB");
})();
