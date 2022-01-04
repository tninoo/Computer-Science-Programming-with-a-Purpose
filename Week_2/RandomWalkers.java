public class RandomWalkers {
    public static void main(String[] args) {
//args
        int distance = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double n = trials;
        int count = 0;

        //loops
        for (int j = 0; j < trials; j++) {
            int min = 0;
            int max = 0;
            int step = 0;

            while (Math.abs(min) + Math.abs(max) != distance) {
                double random = Math.random();
                if (random < 0.25) min++;
                else if (random < 0.5) min--;
                else if (random < 0.75) max++;
                else max--;
                step++;
            }
            // count
            count += step;
        }
        double totalCount = count;
        double steps = totalCount / n;
        System.out.println("average number of steps = " + steps);

    }
}