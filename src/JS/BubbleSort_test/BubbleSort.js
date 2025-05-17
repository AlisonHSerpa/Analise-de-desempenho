class BubbleSort {
    bubbleSort(arr) {
        let n = arr.length;
        let swapped;

        do {
            swapped = false;
            for (let i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Troca os elementos
                    let temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--; // Otimização: após cada iteração, o maior elemento está no final
        } while (swapped);

        return arr;
    }
}

module.exports = BubbleSort;