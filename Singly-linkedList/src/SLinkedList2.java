class JavaApplication4 {
    public static void main(String[] args) {
        SLinkedList2 slist = new SLinkedList2();
        slist.AddFirst(10);
        slist.AddFirst(20);
        slist.AddFirst(30);
        slist.AddLast(40);
        slist.AddLast(50);
        slist.RemoveFirst();
        slist.RemoveFirst();
        slist.RemoveFirst();
        slist.Display();
    }
}
class Node{
    public int data;
    public Node next;
    public Node(int d, Node n)
    {
        data= d;
        next = n;
    }
}
class SLinkedList2{
    private Node head;
    private Node tail;
    private int size;

    public SLinkedList2()
    {
        head = tail= null;
        size= 0;
    }

    public void AddFirst(int value)
    {
        Node n = new Node(value,head);
        head = n;
        if(tail == null)
            tail = n;
    }

    public void RemoveFirst()
    {
        if(head != null)
            head = head.next;
    }

    public void AddLast(int value)
    {
        Node n = new Node(value,null);
        if(tail == null)
            head = tail = n;
        else{
            tail.next = n;
            tail = n;
        }

    }

    public void RemoveLast()
    {
        Node n = head;

        while(n.next !=tail)
        {
            n =n.next;
        }

        n.next = null;
        tail = n;
    }

    public void Display(){
        Node n = head;
        while(n !=null)
        {
            System.out.println(n.data);
            n =n.next;
        }
    }
}


// 40
// 50