public class GreatCircle {
    public static void main (String [] args){
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        
        int radius = 6371;
        double radiusby2 = radius * 2;
        double square =  Math.pow(Math.sin((x2-x1)/2), 2) + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);
        double distance = radiusby2 * Math.asin(Math.min(1, Math.sqrt(square)));
        double distance2 = 60 * distance;
        System.out.println(distance + " kilometers"); 
    }
}

