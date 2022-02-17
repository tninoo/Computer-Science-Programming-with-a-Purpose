public class Clock {
    // private static final int ANGLE = 360;
    private final int hue, sat, bright;
  
    public ColorHSB(int h, int s, int b) {
        hue = h;
        sat = s;
        bright = b;
        if (hue < 0 || hue >= 360)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (sat < 0 || sat > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (bright < 0 || bright > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
  
    }
  
    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }
  
    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (sat == 0 || bright == 0);
    }
  
    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("please input a color");
        int h1 = that.hue;
        int s1 = that.sat;
        int b1 = that.bright;
        int hsquare = (h1 - hue) * (h1 - hue);
        int ssquare = (s1 - sat) * (s1- sat);
        int bsquare = (b1 - bright) * (b1 - bright);
        return Math.min(hsquare,
                        (360 - Math.abs(h1 - hue)) * (360 - Math.abs(h1 - hue)))
                + ssquare + bsquare;
    }
  
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
       ColorHSB color1 = new ColorHSB(h, s, b);
  
      
       String closestName = "";
  
        int closestDistance = Integer.MAX_VALUE;
        ColorHSB closestColor = null;
  
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
        ColorHSB color2 = new ColorHSB(h2, s2, b2);
  
        //calculate distance 
        int distance= color1.distanceSquaredTo(color2);
        if(distance < closestDistance){
          closestDistance = distance;
          closestName = name;
          closestColor = color2;
        }
        }
    
        StdOut.println(closestName + " " + closestColor);
    }
  }