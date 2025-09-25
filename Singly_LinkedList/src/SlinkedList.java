class JavaApplication3 {
    public static void main(String[] args) {
        // TODO code application logic here
        SLinkedList llist = new SLinkedList();
        llist.AddFirst(10);
        llist.AddFirst(20);
        llist.AddFirst(30);
        llist.AddLast(40);
        llist.AddLast(50);
        llist.RemoveFirst();
        llist.RemoveFirst();
        llist.Display();
    }
}
class Node{
    private int data;
    private Node next;
    public Node(int d,Node n)
    {
        data= d;
        next = n;
    }
    public void SetData (int d)
    {
        data = d;
    }
    public void SetNext (Node n)
    {
        next = n;
    }
    public int GetData ()
    {
        return data;
    }
    public Node GetNext ()
    {
        return next;
    }
}
class SLinkedList{
    private Node head;
    private int size;
    public SLinkedList(){
        head= null;
        size=0;
    }
    public void AddFirst(int data){
        Node n = new Node(data,null);
        n.SetNext(head);
        head = n;
        size++;
    }
    public void AddLast(int data){
        Node ptr = head;

        while(ptr.GetNext() !=null)
        {
            ptr = ptr.GetNext();
        }
        Node n = new Node(data, null);
        ptr.SetNext(n);
        size++;
    }
    public void insertAfter(Node v, Node n)
    {
        n.SetNext(v.GetNext());
        v.SetNext(n);
        size++;
    }
    public void RemoveFirst(){
        if(head.GetNext() != null)
            head = head.GetNext();
    }
    public void RemoveLast(){
        Node ptr = head;
        while(ptr.GetNext().GetNext() !=null)
        {
            ptr = ptr.GetNext();
        }
        ptr.SetNext(null);
    }
    public Node Search(int i){
        Node ptr = head;
        while(ptr.GetData() != i)
        {
            ptr = ptr.GetNext();
        }
        return ptr;
    }
    public void Display()
    {
        Node n = head;
        while(n !=null)
        {
            System.out.println(n.GetData());
            n = n.GetNext();
        }
    }
}


// 10
// 40
// 50