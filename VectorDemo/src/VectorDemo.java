
import java.util.*;

public class VectorDemo {

    public static void main(String args[]) {
        Vector<Number> v = new Vector<>(3, 2);
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());

        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);
        System.out.println("Capacity after four additions: " + v.capacity());

        v.addElement(5.45);
        System.out.println("Current capacity: " + v.capacity());

        v.addElement(6.08);
        v.addElement(7);
        System.out.println("Current capacity: " + v.capacity());

        v.addElement(9.4f);
        v.addElement(10);
        System.out.println("Current capacity: " + v.capacity());

        v.addElement(11);
        v.addElement(12);

        System.out.println("First element: " + v.firstElement());
        System.out.println("Last element: " + v.lastElement());

        if (v.contains(3)) {
            System.out.println("Vector contains 3.");
        }

        Enumeration<Number> vEnum = v.elements();
        System.out.println("\nElements in vector:");

        while (vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
        System.out.println();
    }
}

// Initial size: 0
// Initial capacity: 3
// Capacity after four additions: 5
// Current capacity: 5
// Current capacity: 7
// Current capacity: 9
// First element: 1
// Last element: 12
// Vector contains 3.
//
// Elements in vector:
// 1 2 3 4 5.45 6.08 7 9.4 10 11 12
