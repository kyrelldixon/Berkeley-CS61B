/**
 * NBody
 */
public class NBody {

  /**
   * Takes a file and finds the radius
   * @param filename The full file path for the file
   * @return radius The radius of the universe
   */
  
  public static double readRadius(String filename) {
    In in = new In(filename);
    
    // Read in the first line, number of planets, and throw it away
    in.readInt();
    double radius = in.readDouble();
    return radius;
  }
}