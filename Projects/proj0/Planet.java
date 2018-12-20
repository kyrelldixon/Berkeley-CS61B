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
   */
  public double calcForceExertedBy(Planet p) {
    double force = (GRAVITATION * p.mass * this.mass) / Math.pow(calcDistance(p), 2);
    return force;
  }

  /**
   * Calculates the X component of force exerted by p onto this planet
   * @param p the other planet
   */
  public double calcForceExertedByX(Planet p) {
    double dx = p.xxPos - this.xxPos;
    double force = (calcForceExertedBy(p) * dx) / calcDistance(p);
    return force;
  }

  /**
   * Calculates the Y component of force exerted by p onto this planet
   * @param p the other planet
   */
  public double calcForceExertedByY(Planet p) {
    double dy = p.yyPos - this.yyPos;
    double force = (calcForceExertedBy(p) * dy) / calcDistance(p);
    return force;
  }

  /**
   * Calculates the net X component of force exerted by all other planets
   * @param planets all the planets in the system
   */
  public double calcNetForceExertedByX(Planet[] planets) {
    double netForce = 0;
    for (Planet p : planets) {
      if (!p.equals(this)) {
        netForce += this.calcForceExertedByX(p);
      }
    }
    return netForce;
  }

  /**
   * Calculates the net Y component of force exerted by all other planets
   * @param planets all the planets in the system
   */
  public double calcNetForceExertedByY(Planet[] planets) {
    double netForce = 0;
    for (Planet p : planets) {
      if (!p.equals(this)) {
        netForce += this.calcForceExertedByY(p);
      }
    }
    return netForce;
  }
}