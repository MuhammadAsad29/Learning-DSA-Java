class CircularSinglyLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head = null;
    private Node tail = null;
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void deleteNode(int value) {
        if (head == null) return;
        Node current = head;
        Node previous = null;
        do {
            if (current.data == value) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtBeginning(40);
        System.out.print("List after inserting at the beginning: ");
        list.displayList();
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        System.out.print("List after inserting at the end: ");
        list.displayList();
        list.deleteNode(30);
        System.out.print("List after deleting node with value 30: ");
        list.displayList();
    }
}

// List after inserting at the beginning: 40 30 20 10
// List after inserting at the end: 40 30 20 10 50 60
// List after deleting node with value 30: 40 20 10 50 60