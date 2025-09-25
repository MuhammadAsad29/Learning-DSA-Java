public class JavaApplication3 {
    public static void main(String[] args) {
        double a[] = {1, 3, 4, 6, 7, 7, 9,12,14,18,56,67,89,100};

        int result = binarysearch(a,120);

        if(result == -1)
            System.out.println("Not Found");
        else
            System.out.println("Found at "+result);
    }
    public static int binarysearch (double a[], double target) {
        int start, end, middle;
        start = 0;
        end = a.length-1;
        while (start <=end) {
            middle = (start + end)/2;
            if (target == a[middle])
                return middle;
            if (target < a[middle])
                end = middle-1;
            if (target > a[middle])
                start = middle +1;
        }
        return -1;
    }
}

// Not Found