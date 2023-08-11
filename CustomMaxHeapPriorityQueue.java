public class CustomMaxHeapPriorityQueue {

    // Array to store the heap elements
    private int[] heapArray;

    // Current number of elements in the heap
    private int currentSize;

    // Maximum capacity of the heap
    private int maxCapacity;

    // Constructor to initialize the priority queue with a specified capacity
    public CustomMaxHeapPriorityQueue(int capacity) {
        this.maxCapacity = capacity;
        this.heapArray = new int[capacity];
        this.currentSize = 0;
    }

    // Function to calculate the index of the parent of a given index
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // Function to calculate the index of the left child of a given index
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Function to calculate the index of the right child of a given index
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Function to swap elements at two indices in the heap array
    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    // Function to maintain the heap property by moving an element down
    private void heapifyDown(int index) {
        int largest = index;
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if (left < currentSize && heapArray[left] > heapArray[largest]) {
            largest = left;
        }

        if (right < currentSize && heapArray[right] > heapArray[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Function to maintain the heap property by moving an element up
    private void heapifyUp(int index) {
        int parent = getParentIndex(index);

        if (parent >= 0 && heapArray[parent] < heapArray[index]) {
            swap(parent, index);
            heapifyUp(parent);
        }
    }

    // Function to get the maximum element without removing it from the heap
    public int getMax() {
        if (currentSize == 0) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        return heapArray[0];
    }

    // Function to extract and remove the maximum element from the heap
    public int extractMax() {
        if (currentSize == 0) {
            throw new IllegalStateException("Priority queue is empty.");
        }

        int max = heapArray[0];
        heapArray[0] = heapArray[currentSize - 1];
        currentSize--;
        heapifyDown(0);
        return max;
    }

    // Function to insert a new element into the heap
    public void insert(int value) {
        if (currentSize == maxCapacity) {
            throw new IllegalStateException("Priority queue is full.");
        }

        heapArray[currentSize] = value;
        currentSize++;
        heapifyUp(currentSize - 1);
    }

    // Function to check if the priority queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Function to get the current size of the priority queue
    public int getSize() {
        return currentSize;
    }

    // Main method to demonstrate the usage of the custom max heap priority queue
    public static void main(String[] args) {
        CustomMaxHeapPriorityQueue maxHeap = new CustomMaxHeapPriorityQueue(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(2);
        maxHeap.insert(6);

        // Extract and print elements in descending order
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extractMax() + " ");
        }
    }
}
