package com.asml;

import static org.junit.jupiter.api.Assertions.fail;

import com.asml.model.Direction;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    private final App appUnderTest = new App();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    void fourByFourMatrixShouldPrintCorrectValues()
    {   
        // Given
        int[][] arrayToTest =  {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        // When
        appUnderTest.navigateMatrix(arrayToTest);
        // Then
        Assertions.assertEquals("1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11, 10", outputStream.toString().trim());
    }

    @Test
    void fiveByFiveMatrixShouldPrintCorrectValues()
    {   
        // Given
        int[][] arrayToTest =  {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        // When
        appUnderTest.navigateMatrix(arrayToTest);
        // Then
        Assertions.assertEquals("1,2,3,4,5, 10,15,20,25, 24,23,22,21, 16,11,6, 7,8,9, 14,19, 18,17, 12, 13", outputStream.toString().trim());
    }

    @Test
    void SixByFiveMatrixShouldPrintCorrectValues()
    {   
        // Given
        int[][] arrayToTest =  {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30}
        };
        // When
        appUnderTest.navigateMatrix(arrayToTest);
        // Then
        Assertions.assertEquals("1,2,3,4,5,6, 12,18,24,30, 29,28,27,26,25, 19,13,7, 8,9,10,11, 17,23, 22,21,20, 14, 15,16", outputStream.toString().trim());
    }

    @Test
    void emptyMatrixShouldThrowIllegalArgumentException()
    {   
        // Given
        int[][] arrayToTest = null;
        // When
        try {
            appUnderTest.navigateMatrix(arrayToTest);
        } catch (IllegalArgumentException e) {
            // Then
            Assertions.assertEquals("No matrix was passed", e.getMessage());
        }
    }
}
