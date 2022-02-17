public class Huntingtons {

  // Returns the maximum number of consecutive repeats of CAG in the DNA string.
  public static int maxRepeats(String dna) {
    int count = 0;
        int max = 0;

        for (int i = 0; i < dna.length() - 2; i++) {
            String codon = dna.substring(i, i + 3);

            if (!codon.equals("CAG")) {
                count = 0;
            }
            else {
                count++;
                i = i + 2;
                max = Math.max(count, max);
            }
        }
        return max;
    }

  // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
  public static String removeWhitespace(String s) {
    String newstring1 = s.replace("\n", "");
    String newstring2 = newstring1.replace("\t", "");
    String newstring3 = newstring2.replace(" ", "");
    return newstring3;
  }

  public static String diagnose(int maxRepeats) {
    String diagnose = "";
    if ((maxRepeats >= 0 && maxRepeats <= 9) || (maxRepeats >= 181)) diagnose =
      "not human";
    if (maxRepeats >= 10 && maxRepeats <= 35) diagnose = "normal";
    if (maxRepeats >= 36 && maxRepeats <= 39) diagnose = "high risk";
    if (maxRepeats >= 40 && maxRepeats <= 180) diagnose = "Huntington's";
    return diagnose;
  }

  // Sample client (see below).
  public static void main(String[] args) {
    String name = args[0];
    In in = new In(name);
    String s = in.readAll();
    String dna = removeWhitespace(s);
    
    int maxRepeats = maxRepeats(dna);
    System.out.println("max repeats = " + maxRepeats);
    System.out.println(diagnose(maxRepeats));
  }
}
