import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        int selection;
        Movie[] movies = new Movie[10];
        int[] ratings = new int[10];
        Comment[] comments = new Comment[10];
        boolean found;
        int nextIDNumber = 1;
        String adminUsername, adminPassword;
        String title, description, actor1, actor2, director, producer, studio, rating, usercomment;
        int released, gross, userrating, id, chosenid, commentid, numRat, sumRat;
        double average;
        int numLikes;

        do
        {
            // display menu
            System.out.println("Movie Rating System (MRS)");
            System.out.println("MAIN MENU");
            System.out.println("1) Admin Menu");
            System.out.println("2) User Menu");
            System.out.println("3) Display all movies");
            System.out.println("4) Exit");
            System.out.println("Please enter the number of your selection: ");
            // get user choice
            selection = input.nextInt();
            //while the user enters a number that is not 1-4
            while (selection < 1 || selection > 4)
            {
                System.out.println("Invalid option. Please enter a different selection: ");
                selection = input.nextInt();
            }
            //if the user selects the admin menu
            if (selection == 1)
            {
                //LOG IN TO ADMIN
                Scanner login = new Scanner(System.in);
                System.out.println("ADMIN username: ");
                // get user input
                adminUsername = login.nextLine();
                //keep asking user for username/password until they get it right
                while (!adminUsername.equals("admin"))
                {
                    System.out.println("Wrong Username. Please re-enter the username:");
                    adminUsername = login.nextLine();
                }
                System.out.println("ADMIN password: ");
                adminPassword = login.nextLine();
                while (!adminPassword.equals("password"))
                    {
                        System.out.println("Wrong Password. Please re-enter the password:");
                        adminPassword = login.nextLine();
                    }

                //DISPLAY ADMIN MENU
                System.out.println("ADMIN MENU");
                System.out.println("1) Add new movie");
                System.out.println("2) Update movie");
                System.out.println("3) Delete movie");
                System.out.println("4) Return to main menu");
                selection = input.nextInt();
                //while the user enters a number that is not 1-4
                while (selection < 1 || selection > 4)
                {
                    System.out.println("Invalid option. Please enter a different selection: ");
                    selection = input.nextInt();
                }
                
                switch(selection)
                {
                    case 1:
                        //ADD NEW MOVIE
                        Scanner admin = new Scanner(System.in);
                        System.out.println("Enter the movie title: ");
                        title = admin.nextLine();
                        System.out.println("Enter the movie description: ");
                        description = admin.nextLine();
                        System.out.println("Enter the name of actor #1: ");
                        actor1 = admin.nextLine();
                        System.out.println("Enter the name of actor #2: ");
                        actor2 = admin.nextLine();
                        System.out.println("Enter the name of the director: ");
                        director = admin.nextLine();
                        System.out.println("Enter the name of the producer: ");
                        producer = admin.nextLine();
                        System.out.println("Enter the name of the studio: ");
                        studio = admin.nextLine();
                        System.out.println("Enter the MPAA rating (PG, PG13, R): ");
                        rating = admin.nextLine();
                        System.out.println("Enter the year it was released: ");
                        released = admin.nextInt();
                        System.out.println("Enter the gross box office (rounded to the nearest whole number): ");
                        gross = admin.nextInt();

                        // set found to false
                        found = false;
                        // loop through array
                        for (int i = 0; i < movies.length; i++)
                        {
                            // if this is not a valid object
                            if (movies[i] == null)
                            {
                                // create new Movie object and assign to current array element
                                movies[i] = new Movie(nextIDNumber++, title, description, actor1, actor2, director, producer, studio, released, rating, gross);
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // if not found, give error message
                        if (!found)
                        {
                            System.out.println("No more room to add a movie!");
                        }
                        // break out of switch statement
                        break;
                    case 2:
                        //UPDATE MOVIE
                        // get id number to update
                        System.out.println("Please enter the ID Number of the movie you'd like to update: ");
                        id = input.nextInt();
                        while (id < 0 || id > 10)
                        {
                            System.out.println("Invalid movie id, please enter a different number: ");
                            id = input.nextInt();
                        }
                        // set found to false
                        found = false;
                        // loop through array
                        for (int i = 0; i < movies.length; i++)
                        {
                            // if this is a valid object and the correct object
                            if (movies[i] != null && movies[i].GetID() == id)
                            {
                                //Display movie details
                                System.out.print(" Movie Title:" + movies[i].Gett() + " \nDescription:" + movies[i].Getdes() + "\nActor 1:" + movies[i].Geta1() + "\nActor 2:" + movies[i].Geta2() + "\nDirector:" + movies[i].Getdir() + "\nProducer:" + movies[i].Getp() + "\nStudio:" + movies[i].Gets() + "\nYear Released:" + movies[i].Getrel() + "\nRating:" + movies[i].Getrat() + "\nGross:" + movies[i].Getg());
                                // call UpdateMovie();
                                movies[i].UpdateMovie();
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // if not found, give error message
                        if (!found)
                        {
                            System.out.println("Movie not found!");
                        }
                        break;
                    case 3:
                        //DELETE MOVIE
                        // get id number to delete
                        System.out.println("Please enter the ID Number of the movie you wish to delete: ");
                        id = input.nextInt();
                        while (id < 0)
                        {
                            System.out.println("Invalid id, please enter a different number: ");
                            id = input.nextInt();
                        }
                        // set found to false
                        found = false;
                        // loop through array
                        for (int i = 0; i < movies.length; i++)
                        {
                            // if this is a valid object and the correct object
                            if (movies[i] != null && movies[i].GetID() == id)
                            {
                                // delete object
                                movies[i] = null;
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // if not found, give error message
                        if (!found)
                        {
                            System.out.println("Movie not found!");
                        }
                        // break out of switch statement
                        break;
                    case 4:
                        //RETURN TO MAIN MENU
                        System.out.println("Are you sure you would like to return to the main menu? Enter 1=yes or 0=no: ");
                        // set variable to break out of loop
                        int confirmExit = input.nextInt();
                        if (confirmExit == 1)
                        {
                            break;
                        }
                }
            } else if (selection == 2)
            {
                System.out.println("USER MENU");
                System.out.println("1) Search movie");
                System.out.println("2) Rate movie");
                System.out.println("3) Add comments about movie");
                System.out.println("4) Like a comment about a movie");
                System.out.println("5) Return to main menu");
                selection = input.nextInt();
                //while the user enters a number that is not 1-5
                while (selection < 1 || selection > 5)
                {
                    System.out.println("Invalid option. Please enter a different selection: ");
                    selection = input.nextInt();
                }
                switch (selection){
                    case 1:
                        //SEARCH MOVIE
                        Scanner search = new Scanner(System.in);
                        System.out.println("Please enter the movie ID: ");
                        chosenid = search.nextInt();
                        // set found to false
                        found = false;
                        // loop through array
                        for (int i = 0; i < movies.length; i++)
                        {
                            // if this is a valid object and the correct object
                            if (movies[i] != null && movies[i].GetID() == chosenid)
                            {
                                // display movie info
                                System.out.println("Movie Title: " + movies[i].Gett() + "\nDescription: " + movies[i].Getdes() + "\nActor 1: " + movies[i].Geta1() + "\nActor 2: " + movies[i].Geta2() + "\nDirector: " + movies[i].Getdir() + "\nProducer: " + movies[i].Getp() + "\nStudio: " + movies[i].Gets() + "\nYear Released: " + movies[i].Getrel() + "\nRating: " + movies[i].Getrat() + "\nGross: " + movies[i].Getg());
                                movies[i].SetChosenMovieID(chosenid);
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // if not found, give error message
                        if (!found)
                        {
                            System.out.println("Movie not found!");
                        }
                        break;
                    case 2:
                        //RATE MOVIE
                        Scanner user = new Scanner(System.in);
                        numRat = 0;
                        sumRat =0;
                        int keepGoing = 1;
                        //keep looping until the array is maxed or user wants to stop
                        while (keepGoing == 1 && numRat < ratings.length)
                        {
                            System.out.println("Enter ratings for the movie from 1-10: ");
                            userrating = user.nextInt();
                            sumRat += userrating;
                            numRat++;
                            if(numRat < ratings.length)
                            {
                                System.out.println("Would you like to enter another rating? Enter 1=yes or 0=no");
                                keepGoing = user.nextInt();
                            }
                        }
                        average = sumRat/numRat;
                        System.out.println("The average rating is: " + average);
                        // break out of loop
                        break;
                    case 3:
                        //ADD COMMENT TO MOVIE
                        Scanner comment = new Scanner(System.in);
                        System.out.println("Your Comment: ");
                        usercomment = comment.nextLine();
                        numLikes =0;
                        // set found to false
                        found = false;
                        // loop through array
                        for (int i = 0; i < comments.length; i++)
                        {
                            // if this is not a valid object
                            if (comments[i] == null)
                            {
                                // create new Movie object and assign to current array element
                                comments[i] = new Comment(usercomment, numLikes, i);
                                System.out.println("Your Comment: " + comments[i].GetC());
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // if not found, give error message
                        if (!found)
                        {
                            System.out.println("No more room to add a comment!");
                        }
                        break;
                    case 4:
                        //LIKE A COMMENT
                        //display all comments
                        for (int i = 0; i < comments.length; i++)
                        {
                            // if this is a valid object
                            if (movies[i] != null)
                            {
                                System.out.println("Comment ID: " + comments[i].GetID() + "\nComment: " + comments[i].GetC() + "\nNumber of Likes:" + comments[i].GetNL());
                            }
                        }
                        // get comment id number to like
                        System.out.println("Please enter the ID Number of the comment you want to like: ");
                        commentid = input.nextInt();
                        while (commentid < 0 || commentid > 10)
                        {
                            System.out.println("Invalid comment id, please enter a different number: ");
                            commentid = input.nextInt();
                        }
                        // set found to false
                        found = false;
                        // loop through array
                        for (int i = 0; i < comments.length; i++)
                        {
                            // if this is a valid object and the correct object
                            if (comments[i] != null && comments[i].GetID() == commentid)
                            {
                                //call like comment
                                comments[i].LikeComment();
                                // set found to true
                                found = true;
                                // break out of loop
                                break;
                            }
                        }
                        // if not found, give error message
                        if (!found)
                        {
                            System.out.println("Comment not found!");
                        }
                        break;
                    case 5:
                        //RETURN TO MAIN MENU
                        System.out.println("Are you sure you would like to return to the main menu? Enter 1=yes or 0=no: ");
                        // set variable to break out of loop
                        int confirmExit = input.nextInt();
                        if (confirmExit == 1)
                        {
                            break;
                        }
                }

            } else if (selection == 3)
            {
                //DISPLAY ALL MOVIES
                // print header
                System.out.println("Movies: ");
                // loop through array
                for (int i = 0; i < movies.length; i++)
                {
                    // if this is a valid object
                    if (movies[i] != null)
                    {
                        // display all movie info
                        System.out.println("Movie ID: " + movies[i].GetID() + "\nMovie Name: " + movies[i].Gett() + "\nDescription:" + movies[i].Getdes() + "\nActor 1: " + movies[i].Geta1() + "\nActor 2: " + movies[i].Geta2() + "\nDirector: " + movies[i].Getdir() + "\nProducer: " + movies[i].Getp() + "\nStudio: " + movies[i].Gets() + "\nMPAA Rating: " + movies[i].Getrat() + "\nYear Released: " + movies[i].Getrel() + "\nGross Box Office: " + movies[i].Getg());
                    }
                }

            }else
            {
                //RETURN TO MAIN MENU
                break;
            }

        } while (!exit);
    }
}

import java.util.Scanner;

public class Movie {
    Scanner input = new Scanner(System.in);
    String t, des, a1, a2, dir, p, s, rat;
    int ID, rel, g;
    static int Choice;
    boolean exit = false;


    //constructor
    public Movie(int i, String title, String description, String actor1, String actor2, String director, String producer, String studio, int released, String rating, int gross)
    {
        this.ID = i;
        this.t = title;
        this.des = description;
        this.a1 = actor1;
        this.a2 = actor2;
        this.dir = director;
        this.p = producer;
        this.s = studio;
        this.rel = released;
        this.rat = rating;
        this.g = gross;
    }

    // get+set methods
    public void SetChosenMovieID(int chosenid)
    {
        if (chosenid > 0 )
        {
            this.Choice = chosenid;
        }
    }
    public int GetID()
    {
        return ID;
    }
    public String Gett()
    {
        return t;
    }
    public void Setdes(String description)
    {
        this.des = description;
    }
    public String Getdes()
    {
        return des;
    }
    public void Seta1(String actor1)
    {
        this.a1 = actor1;
    }
    public String Geta1()
    {
        return a1;
    }
    public void Seta2(String actor2)
    {
        this.a2 = actor2;
    }
    public String Geta2()
    {
        return a2;
    }
    public void Setdir(String director)
    {
        this.dir = director;
    }
    public String Getdir()
    {
        return a1;
    }
    public void Setp(String producer)
    {
        this.p = producer;
    }
    public String Getp()
    {
        return p;
    }
    public void Sets(String studio)
    {
        this.s = studio;
    }
    public String Gets()
    {
        return s;
    }
    public void Setrel(int released)
    {
        this.rel = released;
    }
    public int Getrel()
    {
        return rel;
    }
    public void Setrat(String rating)
    {
        this.rat = rating;
    }
    public String Getrat()
    {
        return rat;
    }
    public void Setg(int gross)
    {
        this.g = gross;
    }
    public int Getg()
    {
        return g;
    }
    public void UpdateMovie()
    {
        do
        {
            System.out.println("What would you like to update about the movie? Please enter a number.");
            System.out.println("1) Description");
            System.out.println("2) Actor #1");
            System.out.println("3) Actor #2");
            System.out.println("4) Director");
            System.out.println("5) Producer");
            System.out.println("6) Studio");
            System.out.println("7) Release Year");
            System.out.println("8) MPAA Rating");
            System.out.println("9) Gross Box Office");
            System.out.println("10) Exit");
            System.out.println("Please enter the number of your selection: ");
            int updateChoice = input.nextInt();
            switch (updateChoice)
            {
                case 1:
                    System.out.println("Please enter your new Description: ");
                    des = input.nextLine();
                    Setdes(des);
                    break;
                case 2:
                    System.out.println("Please enter your new Actor #1: ");
                    a1 = input.nextLine();
                    Seta1(a1);
                    break;
                case 3:
                    System.out.println("Please enter your new Actor #2: ");
                    a2 = input.nextLine();
                    Seta2(a2);
                    break;
                case 4:
                    System.out.println("Please enter your new Director: ");
                    dir = input.nextLine();
                    Setdir(dir);
                    break;
                case 5:
                    System.out.println("Please enter your new Producer: ");
                    p = input.nextLine();
                    Setp(p);
                    break;
                case 6:
                    System.out.println("Please enter your new Studio: ");
                    s = input.nextLine();
                    Sets(s);
                    break;
                case 7:
                    System.out.println("Please enter the new Release Year: ");
                    rel = input.nextInt();
                    Setrel(rel);
                    break;
                case 8:
                    System.out.println("Please enter the new MPAA Rating: ");
                    rat = input.nextLine();
                    Setrat(rat);
                    break;
                case 9:
                    System.out.println("Please enter the new Gross Box Office: ");
                    g = input.nextInt();
                    Setg(g);
                    break;
                case 10:
                    System.out.println("Are you sure you would like to exit? Enter 1=yes or 0=no: ");
                    // set variable to break out of loop
                    int confirmExit = input.nextInt();
                    if (confirmExit == 1) {
                        exit = true;
                    } else {
                        exit = false;
                    }
                    break;
            }
        }while (!exit);

    }
}

public class Comment {
    String c;
    int nL, ID;

    public Comment(String usercomment, int numLikes, int i)
    {
        this.c = usercomment;
        this.nL = numLikes;
        this.ID = i;

    }
    public int GetNL()
    {
        return nL;
    }
    public String GetC()
    {
        return c;
    }
    public int GetID()
    {
        return ID;
    }
    public void LikeComment()
    {
        this.nL++;
    }
}
