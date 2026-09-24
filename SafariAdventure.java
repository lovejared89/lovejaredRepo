import java.util.Random;
import java.util.Scanner;

public class SafariAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalPoints = 0;
        boolean survived = true;

        System.out.println("🌄 Welcome to Safari Adventure!");

        // Using a for loop for each day of the exploration each iteration is one day
        for (int day = 1; day <= 5; day++) {
            System.out.println("\nDay " + day + ": Where would you like to explore? (Jungle, River, Desert, Mountains): ");
            
            String area = "";
            
            // Do while loop that ensures that a valid location is input
            do {
                if (!area.isEmpty()) {
                    System.out.print("Invalid area. Please choose again: ");
                }
                area = scanner.nextLine().trim();
                if (area.equalsIgnoreCase("Jungle")) {
                    area = "Jungle";
                    break;
                } else if (area.equalsIgnoreCase("River")) {
                    area = "River";
                    break;
                } else if (area.equalsIgnoreCase("Desert")) {
                    area = "Desert";
                    break;
                } else if (area.equalsIgnoreCase("Mountains")) {
                    area = "Mountains";
                    break;
                } else {
                    area = "INVALID"; 
                }
            } while (area.equals("INVALID"));

            System.out.println("You chose: " + area);
            System.out.println("Exploring " + area + "...");

            int dailyPoints = 0;
            int eventCount = 0;
            boolean dayEndedEarly = false;

            // While loop that simulates up to 3 events
            while (eventCount < 3 && !dayEndedEarly) {
                eventCount++;
                int eventType = random.nextInt(4); 

                System.out.print("Event " + eventCount + ": ");

                // Making different event types that allow for different outcomes each time the program is run
                if (eventType == 0) {
                    System.out.println("You spotted a bird. 🐦 (Too small to track. Moving on.)");
                    continue; 
                } 
                // Event type 1: Find resources (edible berries / rare minerals)
                else if (eventType == 1) {
                    int pointsEarned = 15 + random.nextInt(11); // 15 to 25 points
                    System.out.println("You found valuable resources! (+" + pointsEarned + " points)");
                    dailyPoints += pointsEarned;
                } 
                // Event type 2: Weather hazard
                else if (eventType == 2) {
                    System.out.println("A sudden dust storm/heavy downpour hits! (-10 points safety penalty)");
                    dailyPoints -= 10;
                } 
                // Establishing a break to escape from a dangerous animal and ending the day early
                else if (eventType == 3) {
                    System.out.println("A dangerous animal appears! 😱 Type 'run' to escape: ");
                    String action = scanner.nextLine().trim();
                    
                    if (action.equalsIgnoreCase("run")) {
                        System.out.println("You escaped safely, ending the day early.");
                        dayEndedEarly = true;
                        break; 
                    } else {
                        System.out.println("You were forced to retreat and lost some time!");
                        dailyPoints -= 20;
                    }
                }
            }

            totalPoints += dailyPoints;
            System.out.println("Day Summary: " + dailyPoints + " points earned.");
            System.out.println("-----------------------------------");
        }

        // Final Game Summary
        System.out.println("\n🎉 Safari Complete! You collected " + totalPoints + " points!");
        if (totalPoints >= 100 && survived) {
            System.out.println("You survived and completed the adventure!");
        } else {
            System.out.println("You survived, but didn't reach the 100-point goal. Better luck next time!");
        }

        scanner.close();
    }
}