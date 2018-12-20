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
}