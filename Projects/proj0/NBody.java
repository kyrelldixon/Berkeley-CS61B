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

  /**
   * Draw the background and planets to the universe
   * @param backgroundImg The filename of the background image
   * @param planets All of the planets to be drawn
   */
  public static void drawUniverse(String backgroundImg, Planet[] planets) {
    StdDraw.picture(0, 0, backgroundImg);

    // Draw the planets AFTER the background has been drawn
    // so that the planets aren't covered by the background
    for (Planet planet : planets) {
      planet.draw();
    }
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dT = Double.parseDouble(args[1]);
    String filename = args[2];

    double radius = readRadius(filename);
    Planet[] planets = readPlanets(filename);
    String backgroundImg = "./images/starfield.jpg";
    
    StdDraw.setScale(-radius, radius);

    drawUniverse(backgroundImg, planets);

    StdDraw.enableDoubleBuffering();

    double time = 0;
    while (time < T) {
      double[] xForces = new double[planets.length];
      double[] yForces = new double[planets.length];

      for (int i = 0; i < planets.length; i++) {
        xForces[i] = planets[i].calcNetForceExertedByX(planets);
        yForces[i] = planets[i].calcNetForceExertedByX(planets);
      }

      for (int i = 0; i < planets.length; i++) {
        planets[i].update(dT, xForces[i], yForces[i]);
      }

      drawUniverse(backgroundImg, planets);

      StdDraw.show();
      StdDraw.pause(10);
      time += dT;
    }
  }
}