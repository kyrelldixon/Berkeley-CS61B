/**
 * Universe
 */
public class Universe {

  double radius;
  Planet[] planets;
  String backgroundImgFileName;

  public Universe(double r, Planet[] p, String img) {
    this.radius = r;
    this.planets = p;
    this.backgroundImgFileName = img;
  }

  public Universe(double r, Planet[] p) {
    this.radius = r;
    this.planets = p;
    this.backgroundImgFileName = "./images/starfield.jpg";
  }

  /**
   * Draw the background and planets to the universe
   * 
   * @param backgroundImg The filename of the background image
   * @param planets       All of the planets to be drawn
   */
  public void draw() {
    StdDraw.setScale(-radius, radius);
    StdDraw.picture(0, 0, this.backgroundImgFileName);

    // Draw the planets AFTER the background has been drawn
    // so that the planets aren't covered by the background
    for (Planet planet : planets) {
      planet.draw();
    }
  }

  /**
   * Simulates the universe running
   * @param dT Time increment of simulation
   * @param T Total amount of time to run the simulation
   */
  public void animate(double dT, double T) {
    StdDraw.enableDoubleBuffering();

    double time = 0;
    while (time < T) {
      double[] xForces = new double[this.planets.length];
      double[] yForces = new double[this.planets.length];

      for (int i = 0; i < this.planets.length; i++) {
        xForces[i] = this.planets[i].calcNetForceExertedByX(this.planets);
        yForces[i] = this.planets[i].calcNetForceExertedByX(this.planets);
      }

      for (int i = 0; i < this.planets.length; i++) {
        this.planets[i].update(dT, xForces[i], yForces[i]);
      }

      this.draw();

      StdDraw.show();
      StdDraw.pause(10);
      time += dT;
    }
  }
}