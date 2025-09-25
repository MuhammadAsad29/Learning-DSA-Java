public class JavaApplication1 {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] ad = {10,30,45,78,33};
        System.out.println("a = " + a);
        System.out.println("a.length = " + a.length);
        System.out.println("a[0] = " + a[0]);

        int[][] b = new int[3][5];
        int[][] bd = {
                {1,2,3},
                {5,6,7,5,6,9},
                {8}
        };
        System.out.println("bd = " +bd);
        System.out.println("bd.length = " +bd.length);
        System.out.println("bd[0] = " +bd[0]);
        System.out.println("bd[0].length = " +bd[0].length);
        System.out.println("bd[1].length = " +bd[1].length);
        System.out.println("bd[2].length = " +bd[2].length);
        System.out.println("b[0][0] = " +b[0][0]);
        System.out.println("b = " +b);
        System.out.println("b.length = " +b.length);
        System.out.println("b[0] = " +b[0]);
        System.out.println("b[0].length = " +b[0].length);
        System.out.println("b[0][0] = " +b[0][0]);

        int[][][] c = new int[3][4][5];
        int[][][] cd = {
                {
                        {1,2,3},
                        {5,6,7,5,6,9},
                        {8}
                },
                {
                        {1,2,3},
                        {5,6,7,5,6,9},
                        {8}
                }
        };
        System.out.println("c = " +c);
        System.out.println("c.length = " +c.length);
        System.out.println("c[0] = " +c[0]);
        System.out.println("c[0].length = " +c[0].length);
        System.out.println("c[0][0] = " +c[0][0]);
        System.out.println("c[0][0].length = " +c[0][0].length);
        System.out.println("c[0][0][0]  = " +c[0][0][0]);
    }
}

/*
a = [I@15aeb7ab
a.length = 5
a[0] = 0
bd = [[I@1d81eb93
bd.length = 3
bd[0] = [I@7291c18f
bd[0].length = 3
bd[1].length = 6
bd[2].length = 1
b[0][0] = 0
b = [[I@34a245ab
b.length = 3
b[0] = [I@7cc355be
b[0].length = 5
b[0][0] = 0
c = [[[I@6e8cf4c6
c.length = 3
c[0] = [[I@12edcd21
c[0].length = 4
c[0][0] = [I@34c45dca
c[0][0].length = 5
c[0][0][0]  = 0
*/