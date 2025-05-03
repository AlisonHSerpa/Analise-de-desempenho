class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    addAtEnd(data) {
        const newNode = new Node(data);
        if (!this.head) {
            this.head = newNode;
        } else {
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    addAtPosition(data, position) {
        if (position < 0 || position > this.size) {
            console.error(`Invalid position: ${position}`);
            return;
        }

        const newNode = new Node(data);
        
        if (position === 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            let current = this.head;
            let prev = null;
            let index = 0;
            
            while (index < position) {
                prev = current;
                current = current.next;
                index++;
            }
            
            newNode.next = current;
            prev.next = newNode;
        }
        this.size++;
    }

    removeElement(data) {
        let current = this.head;
        let prev = null;
        let found = false;

        while (current) {
            if (current.data === data) {
                if (!prev) {
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }
                this.size--;
                found = true;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return found;
    }

    print() {
        let current = this.head;
        const elements = [];
        while (current) {
            elements.push(current.data);
            current = current.next;
        }
        console.log(elements.join(' '));
    }

    addAll(elements) {
        for (const element of elements) {
            this.addAtEnd(element);
        }
    }
}

module.exports = LinkedList; // Para CommonJS (Node.js tradicional)