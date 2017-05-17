/**
 *
 * Description: This program demonstrates an inheritance relationship between
 *              different classes. The most difficult part was setting up the
 *              constructors of the the Cone and Cylinder Class. I initially tried
 *              declaring a RoundShape object in each, which complicated the process
 *              and ended up causing problems in the getArea/getVolume/toString
 *              methods because, I was calling those methods on a RoundShape instance
 *              object in each class. After some debugging I Was able to simplify
 *              the program by making use of the "this" keyword, which produced
 *              the desired results.
 *
 * Completion time: approximately 4 hours
 *
 *
 *
 * @author Joshua Ortiz
 *
 * @version 1.0
 *
 */
package main;

import java.lang.Math;

public class ORTIZ_HW4Q1 {

    public static class RoundShape {

        private double radius;
        private double height;
        static final double pi = 3.14;

        public RoundShape() {
            this(0.0, 0.0);
        }

        public RoundShape(double r, double h) {
            radius = r;
            height = h;
        }

        public double getRadius() {
            return radius;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double h) {
            height = h;
        }

        public void setRadius(double r) {
            radius = r;
        }

        public double getArea() {
            return ((pi * radius * radius));
        }

        public double getVolume() {
            return ((pi * radius * radius * height));
        }
    }

    public static class Cylinder extends RoundShape {

        public Cylinder(double r, double h) {
            this.setRadius(r);
            this.setHeight(h);
        }

        @Override
        public double getArea() {
            double cylinderArea = ((2.0 * pi * this.getRadius() * this.getHeight())
                    + (2.0 * pi * this.getRadius() * this.getRadius()));
            return cylinderArea;
        }

        @Override
        public String toString() {

            // Note the "this" keyword is used to refer to the current object when
            // the to string is called.
            String formattedToString = String.format("A cylinder of radius %1$.2f, area %2$.2f, and volume %3$.2f ",
                    this.getRadius(), this.getArea(), this.getVolume());
            return formattedToString;
        }
    }

    public static class Cone extends RoundShape {

        public Cone(double r, double h) {
            this.setRadius(r);
            this.setHeight(h);

        }

        @Override
        public double getVolume() {
            double coneVolume = (pi * this.getRadius() * this.getRadius() * (this.getHeight() / 3.0));
            return coneVolume;

        }

        @Override
        public double getArea() {
            double coneArea
                    = (pi * this.getRadius() * (this.getRadius()
                    + Math.sqrt((this.getHeight() * this.getHeight())
                            + (this.getRadius() * this.getRadius()))));
            return coneArea;
        }

        @Override
        public String toString() {

            //Again note that the "this" keyword is used to specify that the
            // Formatted string accesses the variable of the current object.
            // The incorrect valuese will be output if for example we tried to
            // use myCone.getRadius, because it would return the initially declared
            // value
            String coneToString = String.format("A cone of radius %1$.2f, area %2$.2f, and volume %3$.2f ",
                    this.getRadius(), this.getArea(), this.getVolume());
            return coneToString;
        }

    }

    public static void main(String[] args) {
        //Create cones and Cylinders
        Cylinder c1 = new Cylinder(2.0, 3.0);
        Cylinder c2 = new Cylinder(3.0, 4.0);
        Cone cone1 = new Cone(3.0, 3.0);
        Cone cone2 = new Cone(4.0, 4.0);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("**********************************************");
        System.out.println(cone1.toString());
        System.out.println(cone2.toString());
        System.out.println("**********************************************");

        c1.setRadius(10.0);
        c2.setRadius(11.0);
        cone1.setRadius(12.0);
        cone2.setRadius(13.0);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(cone1.toString());
        System.out.println(cone2.toString());
    }

}
