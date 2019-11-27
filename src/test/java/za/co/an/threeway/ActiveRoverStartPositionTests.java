package za.co.an.threeway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActiveRoverStartPositionTests {
    @Test
    void setFirstActiveRoverStartPosition() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing setting the first active rover's start position to 1 2 N");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N");

        System.out.println("First Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("First Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("First Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 1");
        assertEquals(2, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 2");
        assertEquals("N", plateau.getActiveRover().getOrientation(), "initial orientation should be N");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void setSecondActiveRoverStartPosition() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing setting the second active rover's start position to 3 3 E");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("3 3 E");

        System.out.println("Second Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Second Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("Second Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(3, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 3");
        assertEquals(3, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 3");
        assertEquals("E", plateau.getActiveRover().getOrientation(), "initial orientation should be E");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testActiveRoverInvalidStartPosition() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing invalid active rover start position string of 1 2 N E");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N E");

        System.out.println("Active Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("Active Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(0, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 0");
        assertEquals(0, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 0");
        assertEquals("", plateau.getActiveRover().getOrientation(), "initial orientation should be empty");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testActiveRoverStartPositionContainingNonNumericValue() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing active rover start position string containing non numeric value, ie 1 N E");

        Plateau plateau = new Plateau();
        try {
            plateau.initialiseGrid("5 5");
            plateau.processInput("1 N E");
        } catch (Exception ex) {

            System.out.println("Active Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
            System.out.println("Active Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
            System.out.println("Active Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

            assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 1");
            assertEquals(0, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 0");
            assertEquals("", plateau.getActiveRover().getOrientation(), "initial orientation should be empty");
            assertEquals(NumberFormatException.class, ex.getClass(),
                    "Exception should be of type NumberFormatException");
        }

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testActiveRoverConflictingStartPosition() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing conflicting active rover start position string of 1 3 E");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N");
        plateau.processInput("LMLMLMLMM");
        plateau.processInput("1 3 E");

        System.out.println("Active Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("Active Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 1");
        assertEquals(3, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 3");
        assertEquals("", plateau.getActiveRover().getOrientation(), "initial orientation should be empty");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testActiveRoverStartPositionOutsidePlateau() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing active rover start position outside the boundaries of the plateau at 1 6 E");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 6 E");

        System.out.println("Active Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("Active Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 1");
        assertEquals(6, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 6");
        assertEquals("", plateau.getActiveRover().getOrientation(), "initial orientation should be empty");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testActiveRoverInvalidStartOrientation() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing active rover invalid start orientation of 1 2 North");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 North");

        System.out.println("Active Rover Initial X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Initial Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("Active Rover Initial Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "initial x coordinate should be 1");
        assertEquals(2, plateau.getActiveRover().getXyCoordinate().getY(), "initial y coordinate should be 6");
        assertEquals("", plateau.getActiveRover().getOrientation(), "initial orientation should be empty");

        System.out.println("********************************************");
        System.out.println("");
    }
}
