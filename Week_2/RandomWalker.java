public class RandomWalker {
    public static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        
        int min = 0;
        int max = 0;
        int steps = 0;
    
        //print this cordinate first
        System.out.println("(0, 0)");

        while (Math.abs(min) + Math.abs(max) != distance) {
//random direction (north,east, west, south)
            double random = Math.random();
            if (random < 0.25) min++;
            else if (random < 0.5) min--;
            else if (random < 0.75) max++;
            else max--;
        //print the rest of the cordinates
            System.out.println("(" + min + ", " + max + ")");
           // count
             steps++;
        }
        //total amount of steps 
        System.out.println("steps = " + steps);
    }
}
