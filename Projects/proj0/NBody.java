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

  /**
   * Takes a file of planet data and returns an array of planets
   * 
   * @param filename The full file path for the file
   * @return radius The radius of the universe
   */

  public static Planet[] readPlanets(String filename) {
    In in = new In(filename);

    int numberPlanets = in.readInt();

    // Read in the universe radius and throw it away since we don't
    // need it to populate planets
    in.readDouble();

    Planet[] planets = new Planet[numberPlanets];
    for (int i = 0; i < numberPlanets; i++) {
      
      double xPos = in.readDouble();
      double yPos = in.readDouble();
      double xVel = in.readDouble();
      double yVel = in.readDouble();
      double mass = in.readDouble();
      String imgFileName = in.readString();

      planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
    }

    return planets;
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dT = Double.parseDouble(args[1]);
    String filename = args[2];

    double radius = readRadius(filename);
    Planet[] planets = readPlanets(filename);

    // Sets scale for and draws the background to a window
    String background = "./images/starfield.jpg";
    StdDraw.setScale(-100, 100);
    StdDraw.clear();
    StdDraw.picture(0, 0, background);
  }
}