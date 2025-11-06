public class PowerOfTwoMaxHeap {
    private int branchingFactor; // instead of x, use branchingFactor = 2^x
    private int[] heap;
    private int size;
    private int capacity;

    public PowerOfTwoMaxHeap(int exponent) {
        this.branchingFactor = (int) Math.pow(2, exponent);
        this.capacity = 1000;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2;
            int[] newHeap = new int[capacity];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }

    private int parent(int index) {
        return (index - 1) / branchingFactor;
    }

    private int child(int parentIndex, int childNum) {
        return branchingFactor * parentIndex + childNum + 1;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int index) {
        int temp = heap[index];
        while (index > 0 && temp > heap[parent(index)]) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = temp;
    }

    public int popMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int index) {
        int temp = heap[index];
        while (true) {
            int maxChildIndex = -1;
            int maxChildValue = Integer.MIN_VALUE;

            for (int i = 0; i < branchingFactor; i++) {
                int childIndex = child(index, i);
                if (childIndex < size && heap[childIndex] > maxChildValue) {
                    maxChildValue = heap[childIndex];
                    maxChildIndex = childIndex;
                }
            }

            if (maxChildIndex != -1 && heap[maxChildIndex] > temp) {
                heap[index] = heap[maxChildIndex];
                index = maxChildIndex;
            } else {
                break;
            }
        }
        heap[index] = temp;
    }

    // Utility to print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the heap
    public static void main(String[] args) {
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2); // 2^2 = 4 children per node

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(100);
        heap.insert(60);
        heap.insert(1);

        heap.printHeap();

        System.out.println("Max popped: " + heap.popMax());
        heap.printHeap();
    }
}
