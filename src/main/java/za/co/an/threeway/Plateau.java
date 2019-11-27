package za.co.an.threeway;

import java.util.*;

class Plateau {
    private XYCoordinate topCoordinate = new XYCoordinate(0, 0);
    private Map<String, Rover> occupiedCoordinates = new HashMap<>();
    private Rover activeRover = new Rover();
    private Map<String, String> lMap = new HashMap<>();
    private Map<String, String> rMap = new HashMap<>();

    Plateau() {
        initialiseMaps();
    }

    XYCoordinate getTopCoordinate() {
        return topCoordinate;
    }

    public Map<String, Rover> getOccupiedCoordinates() {
        return occupiedCoordinates;
    }

    Rover getActiveRover() {
        return activeRover;
    }

    void initialiseGrid(String consoleInput) {
        String[] consoleInputArray = consoleInput.trim().split(" ");
        if (consoleInputArray.length == 2) {
            topCoordinate.setX(Utilities.parseInteger(consoleInputArray[0]));
            topCoordinate.setY(Utilities.parseInteger(consoleInputArray[1]));
            if (topCoordinate.getX() == 0 || topCoordinate.getY() == 0)
                System.out.println("The top coordinates cannot contain 0");
            System.out.println("");
        } else {
            System.out.println("");
        }
    }

    void processInput(String consoleInput) {
        if (activeRover.getOrientation().isEmpty()) {
            String[] consoleInputArray = consoleInput.trim().split(" ");
            if (consoleInputArray.length == 3) {
                activeRover.getXyCoordinate().setX(Utilities.parseInteger(consoleInputArray[0]));
                activeRover.getXyCoordinate().setY(Utilities.parseInteger(consoleInputArray[1]));
                if (!occupiedCoordinates.containsKey(Utilities.generateMapKey(activeRover))) {
                    if (activeRover.getXyCoordinate().getX() >= 0 &&
                            activeRover.getXyCoordinate().getX() <= topCoordinate.getX() &&
                            activeRover.getXyCoordinate().getY() >= 0 &&
                            activeRover.getXyCoordinate().getY() <= topCoordinate.getY()) {
                        if (Utilities.validOrientation(consoleInputArray[2]))
                            activeRover.setOrientation(consoleInputArray[2].toUpperCase());
                        else
                            System.out.println("Please provide a valid orientation, ie N, S, E or W");
                    } else {
                        System.out.println(
                                "The rover's initial coordinates are outside the boundaries of the plateau. Please select different starting coordinates.");
                    }
                } else {
                    System.out.println(
                            "The rover's initial coordinates are already occupied by another rover. Please select different starting coordinates.");
                }
            }
        } else {
            if (Utilities.validInstruction(consoleInput)) {
                XYCoordinate startingCoordinates =
                        new XYCoordinate(activeRover.getXyCoordinate().getX(), activeRover.getXyCoordinate().getY());
                String startingOrientation = activeRover.getOrientation();

                String[] consoleInputArray = consoleInput.trim().split("");
                for (String instruction : consoleInputArray) {
                    moveActiveRover(instruction);
                    if (occupiedCoordinates.containsKey(Utilities.generateMapKey(activeRover))) {
                        System.out.println(String.format(
                                "The rover is trying to enter a position already occupied by another rover, namely (%s %s). Please issue a different instruction.",
                                activeRover.getXyCoordinate().getX(),
                                activeRover.getXyCoordinate().getY()));
                        activeRover.setXyCoordinate(startingCoordinates);
                        activeRover.setOrientation(startingOrientation);
                        return;
                    }
                    if (activeRover.getXyCoordinate().getX() < 0 ||
                            activeRover.getXyCoordinate().getX() > topCoordinate.getX() ||
                            activeRover.getXyCoordinate().getY() < 0 ||
                            activeRover.getXyCoordinate().getY() > topCoordinate.getY()) {
                        System.out.println(String.format(
                                "The rover has moved outside the boundaries of the plateau at (%s %s). Please issue a different instruction.",
                                activeRover.getXyCoordinate().getX(),
                                activeRover.getXyCoordinate().getY()));
                        activeRover.setXyCoordinate(startingCoordinates);
                        activeRover.setOrientation(startingOrientation);
                        return;
                    }
                }
                System.out.println(String.format("Rover movement: %s %s %s --> %s %s %s",
                        startingCoordinates.getX(),
                        startingCoordinates.getY(),
                        startingOrientation,
                        activeRover.getXyCoordinate().getX(),
                        activeRover.getXyCoordinate().getY(),
                        activeRover.getOrientation()));
                System.out.println("");
                occupiedCoordinates
                        .put(Utilities.generateMapKey(activeRover), activeRover);
                activeRover = new Rover();
            } else {
                System.out.println("Instructions to the rover can only consist of the letter L R and M");
            }
        }
    }

    private void initialiseMaps() {
        lMap.put("N", "W");
        lMap.put("W", "S");
        lMap.put("S", "E");
        lMap.put("E", "N");

        rMap.put("N", "E");
        rMap.put("E", "S");
        rMap.put("S", "W");
        rMap.put("W", "N");
    }

    private void moveActiveRover(String instruction) {
        switch (instruction) {
            case "L":
                activeRover.setOrientation(lMap.get(activeRover.getOrientation()));
                break;
            case "R":
                activeRover.setOrientation(rMap.get(activeRover.getOrientation()));
                break;
            case "M": {
                switch (activeRover.getOrientation()) {
                    case "N":
                        activeRover.getXyCoordinate().setY(activeRover.getXyCoordinate().getY() + 1);
                        break;
                    case "E":
                        activeRover.getXyCoordinate().setX(activeRover.getXyCoordinate().getX() + 1);
                        break;
                    case "S":
                        activeRover.getXyCoordinate().setY(activeRover.getXyCoordinate().getY() - 1);
                        break;
                    case "W":
                        activeRover.getXyCoordinate().setX(activeRover.getXyCoordinate().getX() - 1);
                        break;
                }
            }
        }
    }
}
