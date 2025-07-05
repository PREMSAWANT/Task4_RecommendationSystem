import java.util.*;

/**
 * BookRecommender - Simple collaborative filtering book recommendation system.
 * Users can rate books, and the system recommends books based on similar users' ratings.
 */
public class BookRecommender {
    // Sample data: user -> (book -> rating)
    private static final Map<String, Map<String, Integer>> userRatings = new HashMap<>();
    private static final List<String> books = Arrays.asList(
            "The Alchemist", "Atomic Habits", "Clean Code", "1984", "The Pragmatic Programmer");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Book Recommender!");
        System.out.print("Enter your name: ");
        String user = scanner.nextLine().trim();
        if (!userRatings.containsKey(user)) {
            userRatings.put(user, new HashMap<>());
        }
        while (true) {
            System.out.println("\n1. Rate a book");
            System.out.println("2. Get recommendations");
            System.out.println("3. View your ratings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    rateBook(scanner, user);
                    break;
                case "2":
                    recommendBooks(user);
                    break;
                case "3":
                    viewRatings(user);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // User rates a book
    private static void rateBook(Scanner scanner, String user) {
        System.out.println("Available books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.print("Enter book number: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine()) - 1;
            if (idx < 0 || idx >= books.size()) {
                System.out.println("Invalid book number.");
                return;
            }
            String book = books.get(idx);
            System.out.print("Enter your rating (1-5): ");
            int rating = Integer.parseInt(scanner.nextLine());
            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be 1-5.");
                return;
            }
            userRatings.get(user).put(book, rating);
            System.out.println("Rating saved!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        }
    }

    // Recommend books based on similar users
    private static void recommendBooks(String user) {
        Map<String, Integer> myRatings = userRatings.get(user);
        if (myRatings.isEmpty()) {
            System.out.println("Rate some books first!");
            return;
        }
        // Find the most similar user (highest overlap in ratings)
        String bestMatch = null;
        int maxCommon = 0;
        for (String other : userRatings.keySet()) {
            if (other.equals(user)) continue;
            int common = 0;
            for (String book : myRatings.keySet()) {
                if (userRatings.get(other).containsKey(book)) {
                    common++;
                }
            }
            if (common > maxCommon) {
                maxCommon = common;
                bestMatch = other;
            }
        }
        if (bestMatch == null) {
            System.out.println("No similar users found yet. Ask a friend to use the system!");
            return;
        }
        // Recommend books rated highly by the best match but not yet rated by the user
        Map<String, Integer> matchRatings = userRatings.get(bestMatch);
        List<String> recommendations = new ArrayList<>();
        for (String book : matchRatings.keySet()) {
            if (!myRatings.containsKey(book) && matchRatings.get(book) >= 4) {
                recommendations.add(book + " (" + matchRatings.get(book) + "/5 by " + bestMatch + ")");
            }
        }
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations at this time. Try rating more books!");
        } else {
            System.out.println("Recommended for you:");
            for (String rec : recommendations) {
                System.out.println("- " + rec);
            }
        }
    }

    // View user's ratings
    private static void viewRatings(String user) {
        Map<String, Integer> ratings = userRatings.get(user);
        if (ratings.isEmpty()) {
            System.out.println("You haven't rated any books yet.");
            return;
        }
        System.out.println("Your ratings:");
        for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "/5");
        }
    }
} 