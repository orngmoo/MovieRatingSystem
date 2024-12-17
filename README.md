# 🎥 Movie Rating System (MRS)

## Description  
The **Movie Rating System (MRS)** is an interactive Java application that allows administrators and users to manage and interact with a movie database. Admins can add, update, or delete movies, while users can search for movies, rate them, leave comments, and like comments. This project demonstrates core programming concepts, such as object-oriented design, input validation, and interactive menu-driven systems.

## Features  

### **1. Admin Menu**  
- **Add New Movie**: Enter details such as title, description, actors, director, producer, studio, rating, release year, and gross box office earnings.  
- **Update Movie**: Modify specific movie attributes like description, actors, or gross earnings.  
- **Delete Movie**: Remove a movie from the database by its ID.  
- **Return to Main Menu**: Navigate back to the main menu.

### **2. User Menu**  
- **Search for a Movie**: View details of a movie by its ID.  
- **Rate a Movie**: Provide ratings for movies and see the average rating.  
- **Add Comments**: Leave comments on movies.  
- **Like Comments**: "Like" comments by specifying the comment ID.  
- **Return to Main Menu**: Navigate back to the main menu.

### **3. Display All Movies**  
- View all movies, including details like title, description, actors, rating, release year, and gross box office earnings.

### **4. Exit**  
- Safely exit the application.

---

## Example Workflow  

1. **Admin Logs In**:  
   - Admin enters the username (`admin`) and password (`password`) to access the admin menu.  
2. **Add a Movie**:  
   - Admin adds a new movie, providing details like title, description, and actors.  
3. **User Rates a Movie**:  
   - A user searches for a movie by its ID and submits ratings, which are used to calculate the average score.  
4. **User Adds a Comment**:  
   - A user leaves a comment on a movie, which gets stored in the system.  
5. **View Movies**:  
   - Admin or users can view all stored movies and their details.  



## Technologies Used  

- **Java**: Core programming language.  
- **Scanner**: For user input.  



## How to Run  

1. Clone the repository:  
   ```bash
   git clone https://github.com/yourusername/movie-rating-system.git
   ```
2. Open the project in any Java IDE (e.g., IntelliJ IDEA, Eclipse) or use a terminal.  
3. Compile the program:  
   ```bash
   javac Main.java
   ```
4. Run the program:  
   ```bash
   java Main
   ```
5. Follow the on-screen prompts to interact with the system.



## Limitations  

- **Non-Persistent Storage**: Data is not saved to a database or file; it exists only during runtime.  
- **Fixed Array Size**: The number of movies, comments, and ratings is limited by predefined array sizes.  
- **Hardcoded Admin Credentials**: Username (`admin`) and password (`password`) are hardcoded.  


## Contact  

**Orng Moo**  
- [LinkedIn](https://www.linkedin.com/in/orng-moo-77a85a277/)  
- [GitHub](https://github.com/orngmoo)  

