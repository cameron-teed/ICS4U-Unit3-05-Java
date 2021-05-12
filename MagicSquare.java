/*
* This program uses recursion to find all the magic 
* squares of a 3x3 square in java.
*
* @author  Cameron Teed
* @version 1.0
* @since   2021-05-11
* Class MagicSquare.
*/

final class MagicSquare {
  private MagicSquare() {
    // Prevent instantiation
    // Optional: throw an exception e.g. AssertionError
    // if this ever *is* called
    throw new IllegalStateException("Cannot be instantiated");
  }

  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int THREE = 3;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int FOUR = 4;
  /**
  * The number to help calculate the perfect sqaure..
  */
  public static final int FIVE = 5;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int SIX = 6;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int SEVEN = 7;
  /**
  * The number to help calculate the perfect sqaure..
  */
  public static final int EIGHT = 8;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int NINE = 9;
  /**
  * The number the sqaure need to add up too.
  */
  public static final int FITEN = 15;
  /**
   * Recursive function runs through all possible random numbers with 9 digits
   * and picks out all the numbers with more than 1 instance
   * of the same number.
   *
   * @param magicBox
   * @param recursionVal
   * @return genSquare
   */
  public static String genSquare(final int[] magicBox, final int recursionVal) {

    // Nested for loops to run through every number.
    for (int counter1 = 1; counter1 <= NINE; counter1++) {
      for (int counter2 = 1; counter2 <= NINE; counter2++) {
        for (int counter3 = 1; counter3 <= NINE; counter3++) {
          for (int counter4 = 1; counter4 <= NINE; counter4++) {
            for (int counter5 = 1; counter5 <= NINE; counter5++) {
              for (int counter6 = 1; counter6 <= NINE; counter6++) {
                for (int counter7 = 1; counter7 <= NINE; counter7++) {
                  for (int counter8 = 1; counter8 <= NINE; counter8++) {

                    // sets counters to array values
                    magicBox[0] = recursionVal;
                    magicBox[1] = counter1;
                    magicBox[2] = counter2;
                    magicBox[THREE] = counter3;
                    magicBox[FOUR] = counter4;
                    magicBox[FIVE] = counter5;
                    magicBox[SIX] = counter6;
                    magicBox[SEVEN] = counter7;
                    magicBox[EIGHT] = counter8;

                    /*
                    * Eliminates all numbers with more than one instance of the
                    * same number.
                    */
                    if (recursionVal != counter1 && recursionVal != counter2
                        && recursionVal != counter3 && recursionVal != counter4
                        && recursionVal != counter5 && recursionVal != counter6
                        && recursionVal != counter7 && recursionVal != counter8
                        && counter1 != counter2 && counter1 != counter3
                        && counter1 != counter4 && counter1 != counter5
                        && counter1 != counter6 && counter1 != counter7
                        && counter1 != counter8 && counter2 != counter3
                        && counter2 != counter4 && counter2 != counter5
                        && counter2 != counter6 && counter2 != counter7
                        && counter2 != counter8 && counter3 != counter4
                        && counter3 != counter5 && counter3 != counter6
                        && counter3 != counter7 && counter3 != counter8
                        && counter4 != counter5 && counter4 != counter6
                        && counter4 != counter7 && counter4 != counter8
                        && counter5 != counter6 && counter5 != counter7
                        && counter5 != counter8 && counter6 != counter7
                        && counter6 != counter8 && counter7 != counter8) {

                      // checks the magic box to determine if its a magic box
                      if (isMagic(magicBox)) {
                        // Printing out the square that was found
                        printMagicSquare(magicBox);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    // Checks if it found all the magic squares
    if (recursionVal == NINE) {
      System.out.print("Done");
      return ("complete");
    }
    // Uses recursion to find the magic box
    return (genSquare(magicBox, (recursionVal + 1)));
  }

  /**
   * This function checks if its magic.
   *
   * @param possibleSquare
   * @return magiNum
   */
  public static boolean isMagic(final int[] possibleSquare) {
    // Returns true or false for whether or not inputted array is a magic square
    int magicnum = FITEN;
    int row1 = possibleSquare[0] + possibleSquare[1] + possibleSquare[2];
    int row2 = possibleSquare[THREE] + possibleSquare[FOUR]
              + possibleSquare[FIVE];
    int row3 = possibleSquare[SIX] + possibleSquare[SEVEN]
              + possibleSquare[EIGHT];
    int col1 = possibleSquare[0] + possibleSquare[THREE] + possibleSquare[SIX];
    int col2 = possibleSquare[1] + possibleSquare[FOUR]
              + possibleSquare[SEVEN];
    int col3 = possibleSquare[2] + possibleSquare[FIVE]
              + possibleSquare[EIGHT];
    int diag1 = possibleSquare[0] + possibleSquare[FOUR]
              + possibleSquare[EIGHT];
    int diag2 = possibleSquare[2] + possibleSquare[FOUR] + possibleSquare[SIX];

    return (row1 == magicnum && row2 == magicnum && row3 == magicnum
        && col1 == magicnum && col2 == magicnum && col3 == magicnum
        && diag1 == magicnum && diag2 == magicnum);
  }

  /**
   * function used to print out the found magic square.
   *
   * @param outputSquare
   */
  public static void printMagicSquare(final int[] outputSquare) {
    // prints inputted array in a magic square format
    System.out.println("*****");
    for (int count = 0; count < outputSquare.length; count++) {
      if (count == THREE || count == SIX) {
        System.out.println();
        System.out.print(outputSquare[count] + " ");
      } else {
        System.out.print(outputSquare[count] + " ");
      }
    }
    System.out.println("\n*****");
  }

  /**
   * main function to begin the game.
   *
   * @param args
   */
  public static void main(final String[] args) {
    // sets initial values of all 9 segments
    int[] magicBox = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};

    // sets value of recursive
    int recursionVal = 1;
    // calls magicBox function
    System.out.print("All Possible Magic Squares (3x3):");
    System.out.print("\n");
    genSquare(magicBox, recursionVal);
  }
}
