package com.asml;

import java.lang.StringBuilder;
import com.asml.model.Direction;


public class App {
    public static void main(String[] args)
    {
        int[][] arrayToTest =  {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        App app = new App();
        app.navigateMatrix(arrayToTest);
        
    }

    public void navigateMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("No matrix was passed");
        }
        // First, determine the size of the matrix.
        int amountOfRows = matrix.length;
        int amountOfColumns = matrix[0].length;
        
        // Set the parameters at initial values
        Direction direction = Direction.RIGHT;
        int iteration = 0;
        int charactersWritten = 0;
        StringBuilder result = new StringBuilder();

        // Stop when all characters are written
        while (charactersWritten < (amountOfRows * amountOfColumns)) {
            switch (direction) {
                case RIGHT:
                    // Traverse a top row. Each iteration moves 1 row and column from the edge, and runs 1 less column
                    for (int i = 0 + iteration; i < amountOfColumns - iteration; ++i) {
                        result.append(matrix[0+iteration][i] + ",");
                        charactersWritten++;
                    }
                    result.append(" "); 
                    direction = getNextClockwiseDirection(direction);
                    break;
                case DOWN:
                    // Traverse the right column. Each iteration moves 1 row and column from the edge, and runs 1 less row
                    for (int i = 1 + iteration; i <= amountOfRows - 1 - iteration; ++i) {
                        result.append(matrix[i][amountOfColumns - 1 - iteration] + ",");
                        charactersWritten++;
                    }
                    result.append(" "); 
                    direction = getNextClockwiseDirection(direction);
                    break;
                case LEFT:
                    // Traverse the bottom row. Each iteration moves 1 row and column from the edge, and runs 1 less column
                    for (int i = amountOfColumns - 2 - iteration; i >= 0 + iteration; --i) {
                        result.append(matrix[amountOfRows - 1 - iteration][i] + ",");
                        charactersWritten++;
                    }
                    result.append(" "); 
                    direction = getNextClockwiseDirection(direction);
                    break;
                case UP:
                    // Traverse the left column. Each iteration moves 1 row and column from the edge, and runs 1 less row
                    for (int i = amountOfRows - 2 - iteration; i >= 1 + iteration; --i) {
                        result.append(matrix[i][0 + iteration] + ",");
                        charactersWritten++;
                    }
                    result.append(" "); 
                    direction = getNextClockwiseDirection(direction);
                    iteration++;
                    break;
            }
        }
        // Remove the trailing comma and space and print the output;
        System.out.println(result.toString().substring(0, result.length() - 2));
    }

    /**
     * Returns the next direction in a clockwise movement.
     *
     * @param      direction  the current direction
     * @throws     IllegalArgumentException  if the direction argument is not DOWN, LEFT, UP or DOWN (i.e. null).
     */
    private Direction getNextClockwiseDirection(Direction direction) {
        switch (direction) {
            case RIGHT: return Direction.DOWN;
            case DOWN: return Direction.LEFT;
            case LEFT: return Direction.UP;
            case UP: return Direction.RIGHT;
            default: throw new IllegalArgumentException("Unknown direction " + direction);
        }
    }
}
