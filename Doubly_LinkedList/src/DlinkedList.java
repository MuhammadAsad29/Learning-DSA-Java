class JavaApplication8 {
    public static void main(String[] args) {
        DList mylist = new DList();

        mylist.Display();
        mylist.addFirst(new DNode(10,null,null));
        mylist.Display();
        mylist.addFirst(new DNode(20,null,null));
        mylist.Display();
    }
}
class DList {
    protected int size;
    protected DNode head, tail;

    void addFirst(DNode n){
        if (head==null) {
            head = tail = n;
            n.setPrev(null);
            n.setNext(null);
        }
        else {
            n.setNext(head);
            n.setPrev(null);
            head.setPrev(n);
            head = n;
        }
        System.out.println(n.getElement()+" Added in Doubly Linked List");
    }

    void Display(){
        System.out.println("head - > "+head);
        System.out.println("tail - > "+tail);

        if(head != null)
        {
            System.out.println("head.getNext() - > "+head.getNext());
            System.out.println("head.getPrev() - > "+head.getPrev());
            System.out.println("head.getElement() - > "+head.getElement());
        }
        if(tail != null)
        {
            System.out.println("tail.getNext() - > "+tail.getNext());
            System.out.println("tail.getPrev() - > "+tail.getPrev());
            System.out.println("tail.getElement() - > "+tail.getElement());
        }
    }
    void addLast(DNode n){}
    void delete(DNode n){
    }
}
class DNode {
    protected int element;
    protected DNode next, prev;
    public DNode(int e, DNode p, DNode n) {
        element = e;
        prev = p;
        next = n;
    }
    public int getElement() { return element; }
    public DNode getPrev() { return prev; }
    public DNode getNext() { return next; }
    public void setElement(int newElem) { element = newElem; }
    public void setPrev(DNode newPrev) { prev = newPrev; }
    public void setNext(DNode newNext) { next = newNext; }
}

/*
head - > null
tail - > null
10 Added in Doubly Linked List
head - > DNode@34a245ab
tail - > DNode@34a245ab
head.getNext() - > null
head.getPrev() - > null
head.getElement() - > 10
tail.getNext() - > null
tail.getPrev() - > null
tail.getElement() - > 10
20 Added in Doubly Linked List
head - > DNode@7cc355be
tail - > DNode@34a245ab
head.getNext() - > DNode@34a245ab
head.getPrev() - > null
head.getElement() - > 20
tail.getNext() - > null
tail.getPrev() - > DNode@7cc355be
tail.getElement() - > 10
*/