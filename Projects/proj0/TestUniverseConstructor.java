/**
 * Tests the Universe constructor.
 */
public class TestUniverseConstructor {

  /**
   * Tests the Universe constructor to make sure it's working correctly.
   */
  public static void main(String[] args) {
    checkUniverseConstructor();
  }

  /**
   * Checks whether or not two Doubles are equal and prints the result.
   *
   * @param expected Expected double
   * @param actual   Double received
   * @param label    Label for the 'test' case
   */
  private static void checkEquals(double expected, double actual, String label) {
    if (expected == actual) {
      System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
    } else {
      System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
    }
  }

  /**
   * Checks whether or not two Strings are equal and prints the result.
   * 
   * @param expected Expected String
   * @param actual   String received
   * @param label    Label for the 'test' case
   */
  private static void checkStringEquals(String expected, String actual, String label) {
    if (expected.equals(actual)) {
      System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
    } else {
      System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
    }
  }

  /**
   * Checks Universe constructors to make sure they are setting instance variables
   * correctly.
   */
  private static void checkUniverseConstructor() {
    System.out.println("Checking first Universe constructor...");

    double radius = 100.0;
    Planet[] planets = new Planet[] {
      new Planet(1.0, 2.0, 3.0, 4.0, 5.0, "jupiter.gif"),
      new Planet(1.0, 3.0, 5.0, 7.0, 7.0, "earth.gif"),
      new Planet(2.0, 4.0, 6.0, 8.0, 10.0, "mars.gif")
    };
    String backgroundImgFileName = "./images/starfield.jpg";

    Universe u = new Universe(radius, planets, backgroundImgFileName);

    checkEquals(radius, u.radius, "radius");

    boolean notNull = true, lengthMatch = true;
    /* Check the simple things: */
    if (u.planets == null) {
      System.out.println("FAIL: u.planets; null output");
      notNull = false;
    }
    if (u.planets.length != 3) {
      System.out.println("FAIL: u.planets.length: Expected 3 and you gave " + u.planets.length);
      lengthMatch = false;
    }
    if (notNull && lengthMatch) {
      System.out.println("PASS: u.planets; Congrats! This was the hardest test!");
    }

    checkStringEquals(backgroundImgFileName, u.backgroundImgFileName, "path to background image");

    System.out.println("Checking second Universe constructor...");

    Universe u2 = new Universe(radius, planets);

    checkEquals(radius, u2.radius, "radius");
  
    boolean notNull2 = true, lengthMatch2 = true;
    /* Check the simple things: */
    if (u2.planets == null) {
      System.out.println("FAIL: u.planets; null output");
    }
    if (u2.planets.length != 3) {
      System.out.println("FAIL: u.planets.length: Expected 3 and you gave " + u2.planets.length);
    }
    if (notNull2 && lengthMatch2) {
      System.out.println("PASS: u.planets; Congrats! This was the hardest test!");
    }

    checkStringEquals(backgroundImgFileName, u2.backgroundImgFileName, "path to background image");
  }
}
