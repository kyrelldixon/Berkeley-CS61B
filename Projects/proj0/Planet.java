/**
 * Planet
 */
public class Planet {

  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  static final double GRAVITATION = 6.67e-11;

  public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
  }

  public Planet(Planet p) {
    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass = p.mass;
    this.imgFileName = p.imgFileName;
  }

  /**
   * Calculates the distance between this planet and p
   * @param p the other planet
   */
  public double calcDistance(Planet p) {
    double dx = p.xxPos - this.xxPos;
    double dy = p.yyPos - this.yyPos;
    
    return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
  }

  /**
   * Calculates the force exerted by p onto this planet
   * @param p the other planet
   * @return
   */
  public double calcForceExertedBy(Planet p) {
    double force = (GRAVITATION * p.mass * this.mass) / Math.pow(calcDistance(p), 2);
    // double force = (6.77e-11 * p.mass * this.mass); // / Math.pow(calcDistance(p), 2);
    return force;
  }
}