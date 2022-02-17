public class WorldMap {
        public static void main(String[] args) {
          int width = StdIn.readInt();
          int height = StdIn.readInt();

          //Call StdDraw.setCanvasSize() to set the size of the canvas to be
          //width-by-height pixels SetCanvasSize(width,  height);
          StdDraw.setCanvasSize(width, height);

          // Call StdDraw.setXscale() and StdDraw.setYscale() so that x-coordinates
          // of the canvas range from 0 to width and the y-coordinates range from
          // 0 to height.
          StdDraw.setXscale(0.0, (double) width);
          StdDraw.setYscale(0.0, (double) height);
      
          while (!StdIn.isEmpty()) {
            StdIn.readString();

            int n = StdIn.readInt();

            //polygon(double[] x, double[] y)
             // declare the arrays
            double[] x = new double[n];
            double[] y = new double[n];
            
            for (int i = 0; i < n; i++) {   
                // initialize arrays

              x[i] = StdIn.readDouble();
              y[i] = StdIn.readDouble();
            }
            // Call StdDraw.polygon() to draw each polygon.
            StdDraw.polygon(x, y);
          }
        }
      }
