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

  /**
   * Updates the planet's position, xVelocity, and yVelocity based on
   * the change in time and the X and Y components of force
   * @param dt
   * @param fX
   * @param fY
   */
  public void update(double dt, double fX, double fY) {
    // Calculate the acceleration using the provided x- and y -forces.
    double ax = fX / this.mass;
    double ay = fY / this.mass;
    // Calculate the new velocity by using the acceleration and current velocity. 
    // Recall that acceleration describes the change in velocity per unit time,
    // so the new velocity is (vx+dt⋅ax,vy+dt⋅ay)
    this.xxVel = this.xxVel + dt * ax;
    this.yyVel = this.yyVel + dt * ay;
    // Calculate the new position by using the velocity computed in step 2
    // and the current position. The new position is (px+dt⋅vx,py+dt⋅vy)
    this.xxPos = this.xxPos + dt * this.xxVel;
    this.yyPos = this.yyPos + dt * this.yyVel;
  }
}