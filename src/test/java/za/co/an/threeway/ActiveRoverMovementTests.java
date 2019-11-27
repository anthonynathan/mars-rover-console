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
}
