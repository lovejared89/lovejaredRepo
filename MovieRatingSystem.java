import java.util.Scanner;

public class MovieRatingSystem {
    // Taking User input 
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ", Use this system to store and rate movies you have seen!");

        // Initilizing names and ratings of the movies
        int numMovies = 5;
        String[]movieNames = new String[numMovies];
        int[]movieRatings = new int[numMovies];

        for (int i = 0; i < numMovies; i++){
            System.out.print("Enter the name of the movie: ");
            movieNames[i] = scanner.nextLine();

            int rating = 0;
            //Loop to make sure that a valid rating is recevied (1-10)
            while(true){
                System.out.print("Rate '" + movieNames[i] + "' on a scale from 1 to 10: ");
                if (scanner.hasNextInt()){
                    rating = scanner.nextInt();
                    if (rating >= 1 && rating <= 10) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Invalid input, please enter a number between 1 and 10.");
            }
            movieRatings[i] = rating;
            scanner.nextLine();
            System.out.println();
        }
        // Calculating the average rating
        double totalRating = 0;
        for (int rating : movieRatings) {
            totalRating += rating;
        }
        double averageRating = totalRating / numMovies;
        System.out.println("Your average movie rating is: " + averageRating);

        // If else statements that implement a rating classification system

        if (averageRating >= 9 && averageRating <= 10){
            System.out.println("You are a cinephile!");
        } else if (averageRating >= 7 && averageRating < 9){
            System.out.println("You enjoy movies quite a bit.");
        } else if (averageRating >= 5 && averageRating < 7){
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        //Checking for a favorite movie

        boolean hasMasterpiece = false;
        boolean hasTrash = false;

        for(int rating : movieRatings){
            if(rating == 10){
                hasMasterpiece = true;
            }
            if(rating < 4){
                hasTrash = true;
            }
        }
        if (hasMasterpiece){
            System.out.println("Wow! You found a masterpiece.");
        }

        //Finding consistent ratings in movies
        boolean highRatings = true;
        boolean lowRatings = false;

        for(int rating : movieRatings){
            if(!(rating >= 7)){
                highRatings = false;
            }
            if(rating < 3){
                lowRatings = true;
            }
    }


        if(highRatings){
            System.out.println("You seem to enjoy most movies");
        } else if (lowRatings){
            System.out.println("You have strong opinions on movies!");
        }
        //Switch statement for genre preferences and displaying a response
        System.out.println("List of popular genres: Action, Comedy, Horror, Drama, Sci-fi");
        System.out.print("Enter your favorite movie genre: ");
        String genre = scanner.nextLine();

        switch(genre){
            case "Action":
                System.out.println("You love excitement and thrills!");
                break;
            case "Comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "Horror":
                System.out.println("You have a taste for fear!");
                break;
            case "Drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "Sci-fi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
        }
        // Conditional operator for a movie recomendation
        String recommendation = genre.equalsIgnoreCase("Sci-fi") ? "Interstellar" : 
                                genre.equalsIgnoreCase("Horror") ? "Paranormal Activity" : 
                                genre.equalsIgnoreCase("Action") ? "Fast and Furious" :
                                genre.equalsIgnoreCase("Comedy") ? "Pitch Perfect" :
                                genre.equalsIgnoreCase("Drama") ? "Sleepless in Seattle" : 
                                "The Dark Knight";
        System.out.println("I recommend you watch " + recommendation + " if you haven't seen it!");

        scanner.close();
    }
}
