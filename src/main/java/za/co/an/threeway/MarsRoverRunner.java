package za.co.an.threeway;

public class MarsRoverRunner {
    public static void main(String[] args) {
        if (System.console() != null) {
            System.out.println("");
            System.out.println("-----------------------------------------");
            System.out.println("Welcome to the Mars Rover application!");
            System.out.println("Type \"exit\" to end the programme.");
            System.out.println("-----------------------------------------");
            System.out.println("");
            System.out.println(
                    "Please provide the top coordinates for the Mars plateau in the following format: x y, for example 5 5:");

            Plateau plateau = new Plateau();
            String consoleInput = "";

            while (!(consoleInput = System.console().readLine()).equalsIgnoreCase("exit")) {
                try {
                    if (plateau.getTopCoordinate().getX() == 0 || plateau.getTopCoordinate().getY() == 0) {
                        plateau.initialiseGrid(consoleInput);
                        Utilities.printInstruction(plateau);
                    } else {
                        plateau.processInput(consoleInput);
                        Utilities.printInstruction(plateau);
                    }
                } catch (Exception ex) {
                    System.out.println("An error has occured: " + ex.getMessage());
                    // ex.printStackTrace(); // for debugging only

                    System.out.println("");
                    Utilities.printInstruction(plateau);
                }
            }

            System.out.println("");
            System.out.println("Goodbye!");
        } else {
            System.out.println("Please run this application from a console window");
            System.exit(0);
        }
    }
}
