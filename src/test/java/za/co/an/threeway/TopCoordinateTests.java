package za.co.an.threeway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopCoordinateTests {
    @Test
    void initialiseTopCoordinatesTest() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing initialising top coordinates as 5 5");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");

        System.out.println("Top X = " + plateau.getTopCoordinate().getX());
        System.out.println("Top Y = " + plateau.getTopCoordinate().getY());

        assertEquals(5, plateau.getTopCoordinate().getX(), "top x should be 5");
        assertEquals(5, plateau.getTopCoordinate().getY(), "top y should be 5");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testInvalidInitialisationString() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing invalid top coordinate initialisation string of 5 5 N");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5 N");

        System.out.println("Top X = " + plateau.getTopCoordinate().getX());
        System.out.println("Top Y = " + plateau.getTopCoordinate().getY());

        assertEquals(0, plateau.getTopCoordinate().getX(), "top x should be 0");
        assertEquals(0, plateau.getTopCoordinate().getY(), "top y should be 0");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testInitialisationStringContainingZero() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing top coordinate initialisation string containing 0");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 0");

        System.out.println("Top X = " + plateau.getTopCoordinate().getX());
        System.out.println("Top Y = " + plateau.getTopCoordinate().getY());

        assertEquals(5, plateau.getTopCoordinate().getX(), "top x should be 5");
        assertEquals(0, plateau.getTopCoordinate().getY(), "top y should be 0");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testInitialisationStringContainingNonNumericValue() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing top coordinate initialisation string containing non numeric value");

        Plateau plateau = new Plateau();
        try {
            plateau.initialiseGrid("5 N");
        } catch (Exception ex) {

            System.out.println("Top X = " + plateau.getTopCoordinate().getX());
            System.out.println("Top Y = " + plateau.getTopCoordinate().getY());

            assertEquals(5, plateau.getTopCoordinate().getX(), "top x should be 5");
            assertEquals(0, plateau.getTopCoordinate().getY(), "top y should be 0");
            assertEquals(NumberFormatException.class, ex.getClass(),
                    "Exception should be of type NumberFormatException");
        }

        System.out.println("********************************************");
        System.out.println("");
    }
}
