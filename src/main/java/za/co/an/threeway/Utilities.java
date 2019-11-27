package za.co.an.threeway;

import java.util.Arrays;

public class Utilities {
    static int parseInteger(String strInt) {
        int integer;

        try {
            integer = Integer.parseInt(strInt);
        } catch (NumberFormatException nfEx) {
            System.err.println(String.format("%s is not a valid integer", strInt));
            throw nfEx;
        }

        return integer;
    }

    static boolean validOrientation(String orientation) {
        if (Arrays.stream("N,S,E,W".split(",")).anyMatch(item -> item.equalsIgnoreCase(orientation)))
            return true;
        else
            return false;
    }

    static boolean validInstruction(String instruction) {
        if (Arrays.stream(instruction.trim().split("")).anyMatch(
                item -> !item.equalsIgnoreCase("L") && !item.equalsIgnoreCase("R") && !item.equalsIgnoreCase("M")))
            return false;
        else
            return true;
    }

    static String generateMapKey(Rover activeRover) {
        return activeRover.getXyCoordinate().getX() + "-" + activeRover.getXyCoordinate().getY();
    }

    static void printInstruction(Plateau plateau) {
        if (plateau.getTopCoordinate().getX() == 0 || plateau.getTopCoordinate().getY() == 0)
            System.out.println(
                    "Please provide the top coordinates for the Mars plateau in the following format: x y, for example 5 5:");
        else if (plateau.getActiveRover().getOrientation().isEmpty())
            System.out.println(
                    "Please provide the rover's initial coordinates and orientation in the following format: x y orientation, for example 1 2 N:");
        else
            System.out.println(
                    "Please provide an instruction to the rover consisting of the letters L R and M, for example LMLMLMLMM:");
    }
}
