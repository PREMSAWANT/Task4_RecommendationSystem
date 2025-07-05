JAVA-PROGRAMMING-TASK

COMPANY: CODTECH IT SOLUTIONS PVT. LTD

NAME: PREM ANANDRAO SAWANT

INTERN ID: CT04DH1720

DOMAIN: JAVA PROGRAMMING

DURATION: 4 WEEKS (5th July 2025 to 5th August 2025)

MENTOR: NEELA SANTHOSH


📌 Task 4: Book Recommender System – Collaborative Filtering in Java

📝 Description of the Task:

This task involved building a console-based collaborative filtering book recommender system using Java. The application allows users to rate books, view their ratings, and receive personalized book recommendations based on ratings provided by other users with similar preferences.

The system implements a very basic user-based collaborative filtering algorithm to determine similar users and recommend books that the user has not yet rated but were highly rated by their "best match."

💡 What I Learned:

From this project, I gained a strong understanding of:

User-based collaborative filtering

Handling nested data structures in Java using HashMap<String, HashMap<String, Integer>>

Implementing recommendation logic without using external ML libraries

User interaction flows using console prompts

List manipulation, data comparison, and personalized filtering

The importance of clean and readable user interfaces even in CLI-based systems

This task gave me practical experience in designing basic recommendation algorithms and understanding how popular platforms like Amazon, Netflix, and Goodreads might work at a foundational level.

🛠 Technologies Used:

Java (Core Java SDK)

HashMap, List, and Scanner classes from the Java Collections Framework

Basic console I/O

Algorithmic thinking (comparison, filtering, and matching)

🔍 Features Implemented:

Book Rating System: Users can rate any book from a predefined list with a score from 1 to 5.

Recommendation Engine: Suggests books highly rated by users who have similar preferences.

Similarity Matching: Identifies the most similar user by comparing overlapping book ratings.

Personalization: Ensures users only get book suggestions they haven't already rated.

Rating Review: Users can view all their ratings anytime.

Input Validation: Ensures valid book selection and rating entry.

🧠 Code Explanation:

At the core of the application is a Map<String, Map<String, Integer>>, where each user has a nested map of books and their corresponding ratings. This structure allows dynamic storage of individual user preferences.

When a user logs in:

They can choose to rate a book, view their ratings, or get personalized recommendations.

In recommendation mode, the system calculates which other user has the highest number of rated books in common with the current user.

It then looks for books the matched user rated 4 or above that the current user hasn’t rated yet.

These books are presented as recommendations, clearly stating who rated them and what the rating was.

Edge cases such as "no similar users found" or "no high-rated books left to recommend" are also handled gracefully with friendly messages.

⚠️ Challenges Faced:

The biggest challenge was figuring out how to compare user preferences efficiently and determine a best match based on common rated books. This required careful use of nested Map structures and clear logic for filtering out books already rated by the current user.

Another area of complexity was ensuring valid inputs. If the user entered an invalid book number or an out-of-range rating, the system needed to respond intelligently without crashing or misbehaving.

Additionally, I had to maintain clean and user-friendly console outputs to make the experience as smooth and intuitive as possible.

🚀 How to Run the Code:

Open a Java-supported IDE or terminal.

Save the file as BookRecommender.java.

Compile the code using:

javac BookRecommender.java

Run it with:

java BookRecommender

Interact with the menu:

Option 1: Rate books

Option 2: Get recommendations

Option 3: View your ratings

Option 4: Exit

Try running the program with multiple users to simulate a real recommendation scenario.

📦 Sample Output:

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/d2e87eb8-f3cb-4d45-805e-bcea6f18b8fc" />

Sample recommendation:


Recommended for you:
- The Alchemist (5/5 by Ankita)
- Atomic Habits (4/5 by Ankita)


🌱 Future Improvements:

Allow users to add new books dynamically

Implement content-based filtering in addition to collaborative

Introduce weightage and similarity scoring instead of just count-based matching

Store user data permanently using files or databases

Introduce a GUI for ease of interaction

✅ Conclusion:

This task was a fun and informative experience that allowed me to implement the basics of a recommender system, which is one of the most used features in tech products today. While the current version is basic and runs in the console, the logic behind matching users based on ratings is powerful and directly applicable in real-world applications.

It gave me insight into both data structures and algorithmic design, and I now feel more confident building beginner-level AI logic in plain Java.
