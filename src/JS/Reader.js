const LinkedList = require('./Linkedlist.js');
const fs = require('fs');

class FileProcessor {
    constructor() {
        this.list = new LinkedList();
    }

    async processFile(filename) {
        try {
            const filePath = path.resolve(__dirname, filename);
            await this.verifyFileExists(filePath);
            const data = await this.readFileContents(filePath);
            this.processData(data);
        } catch (error) {
            console.error(`Error processing file: ${error.message}`);
            process.exit(1);
        }
    }

    async verifyFileExists(filePath) {
        if (!fs.existsSync(filePath)) {
            throw new Error(`File not found: ${filePath}\nEnsure text.txt is in the test folder`);
        }
    }

    async readFileContents(filePath) {
        return new Promise((resolve, reject) => {
            fs.readFile(filePath, 'utf8', (err, data) => {
                if (err) reject(err);
                else resolve(data);
            });
        });
    }

    processData(data) {
        const lines = data.trim().split('\n');
        const firstLine = lines[0].trim().split(' ').map(Number);
        const operationsCount = parseInt(lines[1].trim());
        
        this.list.addAll(firstLine);

        for (let i = 2; i < 2 + operationsCount; i++) {
            this.processLine(lines[i]);
        }
    }

    processLine(line) {
        const trimmedLine = line.trim();
        if (!trimmedLine) return;

        const parts = trimmedLine.split(' ');
        const command = parts[0];

        switch (command) {
            case 'A':
                this.handleAddCommand(parts);
                break;
            case 'R':
                this.handleRemoveCommand(parts);
                break;
            case 'P':
                this.handlePrintCommand();
                break;
            default:
                console.error(`Unknown command: ${command}`);
        }
    }

    handleAddCommand(parts) {
        if (parts.length >= 3) {
            const num = parseInt(parts[1]);
            const pos = parseInt(parts[2]);
            this.list.addAtPosition(num, pos);
        }
    }

    handleRemoveCommand(parts) {
        if (parts.length >= 2) {
            const num = parseInt(parts[1]);
            this.list.removeElement(num);
        }
    }

    handlePrintCommand() {
        this.list.print();
    }
}

const os = require('os');
const path = require('path');

let caminho;

// Verificar o sistema operacional
if (os.platform() === 'win32') {  // Windows
    caminho = path.join('D:', 'projects', 'Analise de desempenho', 'src', 'test', 'text.txt');
} else {  // Linux/WSL
    caminho = path.join('/mnt', 'd', 'projects', 'Analise de desempenho', 'src', 'test', 'text.txt');
}

// Uso
(async () => {
    const processor = new FileProcessor();
    await processor.processFile(caminho);
})();