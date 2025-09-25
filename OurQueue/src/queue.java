class queue {
    private int front;
    private int rear;
    private int[] queuearray;
    private int size;
    private int currentsize;
    public queue(int size){
        this.size=size;
        this.queuearray=new int[size];
        this.currentsize=0;
        this.front=0;
        this.rear=-1;
    }
    public boolean isFull() {
        return currentsize == size;
    }public boolean isEmpty() {
        return currentsize == 0;
    } public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1);
        queuearray[rear] = item;
        currentsize++;
        System.out.println(item + " enqueued to the queue.");
    }public int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        }
        int temp=queuearray[front];
        for(int i=0;i<=currentsize-1;i++){
            queuearray[i]=queuearray[i+1];
        }
        currentsize--;
        rear--;
        System.out.println("item dequeued:"+temp);
        return temp;
    }public int peek(){
        if(isEmpty()){
            System.out.println("is empty");
        }
        return queuearray[front];
    }
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue elements:");
        for (int i = front; i <= rear; i++ ) {
            System.out.print(queuearray[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        queue obj=new queue(5);
        obj.enqueue(2);
        obj.enqueue(4);
        obj.enqueue(5);
        obj.enqueue(14);
        obj.dequeue();
        obj.displayQueue();

        System.out.println(obj.peek());
        while(!obj.isEmpty()){
            obj.dequeue();
        }
        obj.displayQueue();
    }
}

/*
2 enqueued to the queue.
4 enqueued to the queue.
5 enqueued to the queue.
14 enqueued to the queue.
item dequeued:2
Queue elements:
4 5 14
4
item dequeued:4
item dequeued:5
item dequeued:14
Queue is empty.
*/