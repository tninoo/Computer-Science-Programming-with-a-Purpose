public class BandMatrix {
    public static void main(String[] args) {
    
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        //row
        for (int i = 0; i < n; i++) { 
            //column
            for (int j = 0; j < n; j++) { 
                // to keep the grid 
                if (Math.abs(j - i) > width) System.out.print("0  ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }
}