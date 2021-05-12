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
   * This function prints a magic square should one be found.
   *
   * @param printList
   */
  static void printSquare(final int[] printList) {
    // Printing a magic square
    for (int printCounter = 0; printCounter < printList.length;
         printCounter++) {
      System.out.print(printList[printCounter] + " ");
      // Checking if three numbers are on a line
      if ((printCounter + 1) % THREE == 0) {
        System.out.println("");
      } else {
        continue;
      }
    }
    System.out.println("*****");
  }

  /**
   * This function finds and prints all 3 by 3 magic number sets that add to 15.
   *
   * @param numberList
   * @param indexList
   * @param index
   */
  static void solveSquares(final int[] numberList, final int[] indexList,
                          final int index) {
    // This loop itterates to fill out a square of numbers
    for (int counter = 0; counter < numberList.length; counter++) {
      // Checking if a slot in the square has been occupied
      if (indexList[counter] == 0) {
        numberList[counter] = index;
        indexList[counter] = 1;

        // Checking if the index is less than nine
        if (index < NINE) {
          // Calling function again to continue creating square
          solveSquares(numberList, indexList, index + 1);
        } else {
          // Checking if every linear combination of three numbers adds to 15
          if (isSquareMagic(numberList)) {
            // Printing out the square that was found
            printSquare(numberList);
          }
        }

        // Reseting part of the square to 0 so it can be filled again
        indexList[counter] = 0;
      }
    }
  }

  /**
   * This function determines whether or not a square is a magic square.
   *
   * @param possibleSquare
   * @return magicnum
   */
  static boolean isSquareMagic(final int[] possibleSquare) {
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
   * This function passes variables into a function that will find print all
   * 3 by 3 magic number sets that add to 15.
   *
   * @param args
   */
  public static void main(final String[] args) {
    // Initializing the list that will be used in determining the magic squares
    int[] firstList = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    int[] secondList = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Printing the inital dividing line
    System.out.println("All Possible Magic Squares (3x3):");
    System.out.println("*****");

    // Calling the function that will solve the magic squares
    solveSquares(firstList, secondList, 1);
    System.out.println("Done");
  }
}
