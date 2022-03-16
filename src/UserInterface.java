import java.util.Scanner;

public class UserInterface {
    Scanner in = new Scanner(System.in);
    Game game = new Game();

    private String playerName;
    private Room currentRoom;

    void gameStartUp() {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME TO: ");
        System.out.println("""
         _______  _______ _________ _______  _______        _______  ______            _______  _       _________          _______  _______\s
        (  ____ )(  ____ \\\\__   __/(  ____ )(  ___  )      (  ___  )(  __  \\ |\\     /|(  ____ \\( (    /|\\__   __/|\\     /|(  ____ )(  ____ \\
        | (    )|| (    \\/   ) (   | (    )|| (   ) |      | (   ) || (  \\  )| )   ( || (    \\/|  \\  ( |   ) (   | )   ( || (    )|| (    \\/
        | (____)|| (__       | |   | (____)|| |   | |      | (___) || |   ) || |   | || (__    |   \\ | |   | |   | |   | || (____)|| (__   \s
        |     __)|  __)      | |   |     __)| |   | |      |  ___  || |   | |( (   ) )|  __)   | (\\ \\) |   | |   | |   | ||     __)|  __)  \s
        | (\\ (   | (         | |   | (\\ (   | |   | |      | (   ) || |   ) | \\ \\_/ / | (      | | \\   |   | |   | |   | || (\\ (   | (     \s
        | ) \\ \\__| (____/\\   | |   | ) \\ \\__| (___) |      | )   ( || (__/  )  \\   /  | (____/\\| )  \\  |   | |   | (___) || ) \\ \\__| (____/\\
        |/   \\__/(_______/   )_(   |/   \\__/(_______)      |/     \\|(______/    \\_/   (_______/|/    )_)   )_(   (_______)|/   \\__/(_______/""");

        helpText();
    }

    void helpText() {
        System.out.println("""
                
        Throughout the game you can write the following commands:
                
        look      = Looking around at the current location
        go east   = Moves player towards east
        go west   = Moves player towards west
        go north  = Moves player towards north
        go south  = Moves player towards south
        help      = Opens help menu
        exit      = Game terminates
                
        """);

    }

    void playerName() {
        System.out.print("Warrior! Whats your name: ");
        playerName = in.nextLine();
        playerName = playerName.toUpperCase();
    }

    void userInterface() {
        String newLoc = "\n" + playerName + ", You walked into a new location!";
        String cantGo = "you can't go that way";

        System.out.print("\n" + playerName + ", what do you want to do: ");
        String playerDecision = in.nextLine();
        playerDecision = playerDecision.toLowerCase();
        switch (playerDecision) {
            case "look", "l" -> System.out.println("\n" + currentRoom);
            case "go north", "north", "go n", "n" -> {
                if (currentRoom.getNorth() != null) {
                    System.out.println(newLoc);
                    currentRoom = currentRoom.getNorth();
                } else {
                    System.out.println(cantGo);
                }
            }
            case "go south", "south", "go s", "s" -> {
                if (currentRoom.getSouth() != null) {
                    System.out.println(newLoc);
                    currentRoom = currentRoom.getSouth();
                } else {
                    System.out.println(cantGo);
                }
            }
            case "go west", "west", "go w", "w" -> {
                if (currentRoom.getWest() != null) {
                    System.out.println(newLoc);
                    currentRoom = currentRoom.getWest();
                } else {
                    System.out.println(cantGo);
                }
            }
            case "go east", "east", "go e", "e" -> {
                if (currentRoom.getEast() != null) {
                    System.out.println(newLoc);
                    currentRoom = currentRoom.getEast();
                } else {
                    System.out.println(cantGo);
                }
            }
            case "help", "h" -> helpMenu();
            case "exit" -> exit();
            default -> invalidAnswer();
        }
    }

    void helpMenu() {
        System.out.println("\nHelp menu:");
        helpText();
        System.out.println("""
        Return to Game [game]
        Return to Main menu [main]
        Exit Game [exit]""");
        System.out.print("\nEnter decision:");
        String helpMenuDecision = in.nextLine();
        helpMenuDecision = helpMenuDecision.toLowerCase();
        switch (helpMenuDecision) {
            case "game", "g" -> userInterface();
            case "main", "m" -> game.mainMenu();
            case "exit", "e" -> exit();
            default -> invalidAnswer();
        }

    }

    void exit() {

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tTHANK YOU FOR PLAYING: ");
        System.out.println("""
         _______  _______ _________ _______  _______        _______  ______            _______  _       _________          _______  _______\s
        (  ____ )(  ____ \\\\__   __/(  ____ )(  ___  )      (  ___  )(  __  \\ |\\     /|(  ____ \\( (    /|\\__   __/|\\     /|(  ____ )(  ____ \\
        | (    )|| (    \\/   ) (   | (    )|| (   ) |      | (   ) || (  \\  )| )   ( || (    \\/|  \\  ( |   ) (   | )   ( || (    )|| (    \\/
        | (____)|| (__       | |   | (____)|| |   | |      | (___) || |   ) || |   | || (__    |   \\ | |   | |   | |   | || (____)|| (__   \s
        |     __)|  __)      | |   |     __)| |   | |      |  ___  || |   | |( (   ) )|  __)   | (\\ \\) |   | |   | |   | ||     __)|  __)  \s
        | (\\ (   | (         | |   | (\\ (   | |   | |      | (   ) || |   ) | \\ \\_/ / | (      | | \\   |   | |   | |   | || (\\ (   | (     \s
        | ) \\ \\__| (____/\\   | |   | ) \\ \\__| (___) |      | )   ( || (__/  )  \\   /  | (____/\\| )  \\  |   | |   | (___) || ) \\ \\__| (____/\\
        |/   \\__/(_______/   )_(   |/   \\__/(_______)      |/     \\|(______/    \\_/   (_______/|/    )_)   )_(   (_______)|/   \\__/(_______/""");

        // gameRunning = false;
    }

    void invalidAnswer() {
        System.out.println("\nYOU ENTERED AN INVALID ANSWER!! TRY AGAIN");

    }
}
