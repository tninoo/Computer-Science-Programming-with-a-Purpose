import java.awt.Color;

public class KernelFilter {

  private static int format(double v) {
    // If an RGB component of a pixel is less than 0, set it to 0
    if (v < 0) return 0;
    // If is greater than 255, set it to 255
    if (v > 255) return 255;
    //round values
    return (int) Math.round(v);
  }

  // Returns a new picture that applies an arbitrary kernel filter to the given
  // picture.
  private static Picture kernel(Picture picture, double[][] weights) {
    Picture target = new Picture(picture);

    for (int targetCol = 0; targetCol < picture.width(); targetCol++) {
      for (int targetRow = 0; targetRow < picture.height(); targetRow++) {
        double sumRed = 0;
        double sumGreen = 0;
        double sumBlue = 0;
        int weightsLenght = weights.length;
        int center = weightsLenght / 2;

        for (int i = 0; i < weightsLenght; i++) {
          for (int j = 0; j < weightsLenght; j++) {
            double coefficient = weights[i][j];

            
            int scol = Math.floorMod(targetCol - center + i, picture.width());
            int srow = Math.floorMod(targetRow - center + j, picture.height());

            Color color = picture.get(scol, srow);
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            sumRed += r * coefficient;
            sumGreen += g * coefficient;
            sumBlue += b * coefficient;
          }
        }

        Color c = new Color(format(sumRed), format(sumGreen), format(sumBlue));
        target.set(targetCol, targetRow, c);
      }
    }
    return target;
  }

  // Returns a new picture that applies the identity filter to the given picture.
  public static Picture identity(Picture picture) {
    return picture;
  }

  // Returns a new picture that applies a Gaussian blur filter to the given
  // picture.
  public static Picture gaussian(Picture picture) {
    double[][] filter = new double[3][3];
    filter[0][0] = 0.0625 * 1.0;
    filter[1][0] = 0.0625 * 2.0;
    filter[2][0] = 0.0625 * 1.0;
    filter[0][1] = 0.0625 * 2.0;
    filter[1][1] = 0.0625 * 4.0;
    filter[2][1] = 0.0625 * 2.0;
    filter[0][2] = 0.0625 * 1.0;
    filter[1][2] = 0.0625 * 2.0;
    filter[2][2] = 0.0625 * 1.0;

    return kernel(picture, filter);
  }

  // // Returns a new picture that applies a sharpen filter to the given picture.
  public static Picture sharpen(Picture picture) {
    double[][] filter = new double[3][3];
    filter[0][0] = 0.0;
    filter[1][0] = -1.0;
    filter[2][0] = 0.0;
    filter[0][1] = -1.0;
    filter[1][1] = 5.0;
    filter[2][1] = -1.0;
    filter[0][2] = 0.0;
    filter[1][2] = -1.0;
    filter[2][2] = 0.0;

    return kernel(picture, filter);
  }

  // // Returns a new picture that applies an Laplacian filter to the given picture.
  public static Picture laplacian(Picture picture) {
    double[][] filter = new double[3][3];
    filter[0][0] = -1.0;
    filter[1][0] = -1.0;
    filter[2][0] = -1.0;
    filter[0][1] = -1.0;
    filter[1][1] = 8.0;
    filter[2][1] = -1.0;
    filter[0][2] = -1.0;
    filter[1][2] = -1.0;
    filter[2][2] = -1.0;

    return kernel(picture, filter);
  }

  // // Returns a new picture that applies an emboss filter to the given picture.
  public static Picture emboss(Picture picture) {
    double[][] filter = new double[3][3];
    filter[0][0] = -2.0;
    filter[1][0] = -1.0;
    filter[2][0] = -.0;
    filter[0][1] = -1.0;
    filter[1][1] = 1.0;
    filter[2][1] = 1.0;
    filter[0][2] = 0.0;
    filter[1][2] = 1.0;
    filter[2][2] = 2.0;

    return kernel(picture, filter);
  }

  // // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {

      double[][] filter = new double[9][9];

      for (int row = 0; row < 9; row++)
        for (int column = 0; column < 9; column++)
          if (row == column) filter[row][column] = 1./9;

      return kernel(picture, filter);
    }

  // Test client (ungraded).
  public static void main(String[] args) {
    String filename = args[0];
    Picture source = new Picture(filename);
    Picture g = gaussian(source);
    g.show();
    Picture s = sharpen(source);
    s.show();
    Picture i = identity(source);
    i.show();
    Picture lp = laplacian(source);
    lp.show();
    Picture e = emboss(source);
    e.show();
    Picture m = motionBlur(source);
    m.show();

  }
}


