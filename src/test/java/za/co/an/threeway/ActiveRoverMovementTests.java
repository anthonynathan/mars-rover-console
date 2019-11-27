package za.co.an.threeway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActiveRoverMovementTests {
    @Test
    void moveFirstRoverTest() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing instruction LMLMLMLMM to first rover");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N");
        plateau.processInput("LMLMLMLMM");

        System.out.println(
                "First Rover Final X = " + plateau.getOccupiedCoordinates().get("1-3").getXyCoordinate().getX());
        System.out.println(
                "First Rover Final Y = " + plateau.getOccupiedCoordinates().get("1-3").getXyCoordinate().getY());
        System.out.println(
                "First Rover Final Orientation = " + plateau.getOccupiedCoordinates().get("1-3").getOrientation());

        assertEquals(1, plateau.getOccupiedCoordinates().get("1-3").getXyCoordinate().getX(),
                "final x coordinate should be 1");
        assertEquals(3, plateau.getOccupiedCoordinates().get("1-3").getXyCoordinate().getY(),
                "final y coordinate should be 3");
        assertEquals("N", plateau.getOccupiedCoordinates().get("1-3").getOrientation(),
                "final orientation should be N");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void moveSecondRoverTest() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing instruction MMRMMRMRRM to second rover");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("3 3 E");
        plateau.processInput("MMRMMRMRRM");

        System.out.println(
                "Second Rover Final X = " + plateau.getOccupiedCoordinates().get("5-1").getXyCoordinate().getX());
        System.out.println(
                "Second Rover Final Y = " + plateau.getOccupiedCoordinates().get("5-1").getXyCoordinate().getY());
        System.out.println(
                "Second Rover Final Orientation = " + plateau.getOccupiedCoordinates().get("5-1").getOrientation());

        assertEquals(5, plateau.getOccupiedCoordinates().get("5-1").getXyCoordinate().getX(),
                "final x coordinate should be 5");
        assertEquals(1, plateau.getOccupiedCoordinates().get("5-1").getXyCoordinate().getY(),
                "final y coordinate should be 1");
        assertEquals("E", plateau.getOccupiedCoordinates().get("5-1").getOrientation(),
                "final orientation should be E");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testInvalidMoveInstruction() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing invalid move instruction namely LMMRMMCLM");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N");
        plateau.processInput("LMMRMMCLM");

        System.out.println("Active Rover Final X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Final Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("First Rover Final Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "final x coordinate should be 1");
        assertEquals(2, plateau.getActiveRover().getXyCoordinate().getY(), "final y coordinate should be 2");
        assertEquals("N", plateau.getActiveRover().getOrientation(), "final orientation should be N");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testMovingIntoPositionOccupiedByAnotherRover() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing moving rover into position occupied by another rover");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N");
        plateau.processInput("LMLMLMLMM");
        plateau.processInput("1 5 W");
        plateau.processInput("LMMMLMM");

        System.out.println("Active Rover Final X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Final Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("First Rover Final Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "final x coordinate should be 1");
        assertEquals(5, plateau.getActiveRover().getXyCoordinate().getY(), "final y coordinate should be 5");
        assertEquals("W", plateau.getActiveRover().getOrientation(), "final orientation should be W");

        System.out.println("********************************************");
        System.out.println("");
    }

    @Test
    void testMovingOutsideBoundariesOfPlateau() {
        System.out.println("");
        System.out.println("********************************************");
        System.out.println("Testing moving rover outside the boundaries of the plateau");

        Plateau plateau = new Plateau();
        plateau.initialiseGrid("5 5");
        plateau.processInput("1 2 N");
        plateau.processInput("LMMMRMM");

        System.out.println("Active Rover Final X = " + plateau.getActiveRover().getXyCoordinate().getX());
        System.out.println("Active Rover Final Y = " + plateau.getActiveRover().getXyCoordinate().getY());
        System.out.println("First Rover Final Orientation = " + plateau.getActiveRover().getOrientation());

        assertEquals(1, plateau.getActiveRover().getXyCoordinate().getX(), "final x coordinate should be 1");
        assertEquals(2, plateau.getActiveRover().getXyCoordinate().getY(), "final y coordinate should be 2");
        assertEquals("N", plateau.getActiveRover().getOrientation(), "final orientation should be N");

        System.out.println("********************************************");
        System.out.println("");
    }
}
