class CircularDoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
        }
    }
    private Node head = null;
    private Node tail = null;
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }
    public void deleteNode(int value) {
        if (head == null) return;
        Node current = head;
        do {
            if (current.data == value) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = current.next;
                    }
                    if (current == tail) {
                        tail = current.prev;
                    }
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }
    public void displayListForward() {
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
    public void displayListBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertAtBeginning(5);
        list.insertAtBeginning(15);
        list.insertAtBeginning(25);
        list.insertAtBeginning(35);
        System.out.print("List after inserting at the beginning (forward): ");
        list.displayListForward();
        System.out.print("List after inserting at the beginning (backward): ");
        list.displayListBackward();
        list.insertAtEnd(45);
        list.insertAtEnd(55);
        System.out.print("List after inserting at the end (forward): ");
        list.displayListForward();
        System.out.print("List after inserting at the end (backward): ");
        list.displayListBackward();
        list.deleteNode(15);
        System.out.print("List after deleting node with value 15 (forward): ");
        list.displayListForward();
        System.out.print("List after deleting node with value 15 (backward): ");
        list.displayListBackward();
    }
}

/*
List after inserting at the beginning (forward): 35 25 15 5
List after inserting at the beginning (backward): 5 15 25 35
List after inserting at the end (forward): 35 25 15 5 45 55
List after inserting at the end (backward): 55 45 5 15 25 35
List after deleting node with value 15 (forward): 35 25 5 45 55
List after deleting node with value 15 (backward): 55 45 5 25 35
*/