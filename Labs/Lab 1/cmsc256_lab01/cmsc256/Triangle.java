//Shon Bennett
//CMSC 256 Sect 901 (Prof. Duke)
//Triangle.java --- allows the user to input side lengths for a triangle object. the classify() method will tell the user
// what type of triangle they created
//
//I used this website to remind me of the properties of triangles: https://e-gmat.com/blogs/properties-of-triangles/#1-properties-of-a-triangle
/* MLA Citation:
   Ashutosh. “Properties of Triangle - Types &amp; Formulas [Video &amp; Practice].”
   e-GMAT, 30 Nov. 2021, e-gmat.com/blogs/properties-of-triangles/#1-properties-of-a-triangle.
 */
package cmsc256;

/** 
  Determines if three doubles can be sides of triangle. 
*/
public class Triangle  {

   /** Length of side 1. */
   private double sideA;

   /** Length of side 2. */
   private double sideB;

   /** Length of side 3. */
   private double sideC;

   /**
    * Creates a Triangle.
    *
    * @param aIn length of side 1.
    * @param bIn length of side 2.
    * @param cIn length of side 3.
    */
   public Triangle(double aIn, double bIn, double cIn) {
      
      if (aIn <= 0 || bIn <= 0 || cIn <= 0) {
         throw new IllegalArgumentException("Sides: " + aIn + " " + bIn + " " + cIn
            + " you have passed in a(n) arguemenrt(s) that is either less than zero, or equal to zero, which is not possible for a triangle.");       // add an explanation why this exception is being thrown.
      }
     
      if ((aIn >= bIn + cIn) || (bIn >= aIn + cIn) || (cIn >= aIn + bIn)) {
         throw new IllegalArgumentException("Sides: "
            + aIn + " " + bIn + " " + cIn
            + " the sum of any two sides of your triangle should be bigger than the length of the third side. Please provide new side lengths.");      // add an explanation why this exception is being thrown.
      }
     
      sideA = aIn;
      sideB = bIn;
      sideC = cIn;
   }

   /**
    *  Classifies a triangle based on the lengths of the three sides.
    *  The classifications are either: "equilateral", "scalene", "isosceles", 
    *  or "not a triangle". The returned string must match one of these.Tri
    * 
    * @return the triangle classification.
    */
   public String classify() {
      String result = "";
      //equilateral means all sides are equal
      if ((sideA == sideB) && (sideB == sideC)){
            result += "equilateral";
      }
      //scalene triangle means all sides are different
      else if (
              (sideA != sideB) && (sideA != sideC) && (sideB != sideA) && (sideB != sideC) && (sideC != sideA) && (sideC != sideB)
      ) {
         result += "scalene";
      }
      //isoceles triangle means two sides are the same and the third is different
      else if (
              (((sideA == sideB) && (sideA != sideC)) || ((sideA == sideC) && (sideA != sideB))) ||
                      (((sideB == sideA) && (sideB != sideC)) || ((sideB == sideC) && (sideB != sideA))) ||
                           (((sideC == sideA) && (sideC != sideB)) || ((sideC == sideB) && (sideC != sideA)))
      ){
         result += "isosceles";
      }
      else {
         result += "not a triangle";
      }
      return result;
   }

}
