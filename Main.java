import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
  //Function to retrieve random movie
 /* public String getMovie(){



    return movieString;
  }*/

  public static void main(String[] args) throws FileNotFoundException {

    File file = new File("movieList.txt");
    Scanner fileScanner = new Scanner(file);
    int count = 0;
    String[] movieList;

    while(fileScanner.hasNextLine()){
      fileScanner.nextLine();
      count++;
      System.out.println(count);
    }
/*
    int randomNumber = (int) ((Math.random() * 100 ) + 1 ) % count;
    
    String[] chosenMovie = new String[count];
    chosenMovie = movieList[randomNumber];
    System.out.println(chosenMovie);

 
    String[] guessedMovie = new String
    guessedMovie[] = chosenMovie;
    System.out.println(guessedMovie);

    for(int i = 0; i < chosenMovie.length; i++){
      if(i == " "){
        guessedMovie[i] = " ";
      }
      else{
       guessedMovie[i] = "_";
      }
    }

    System.out.println("I have chosen a movie at random.");
    System.out.println("It is your job to guess it.");
    System.out.println("You have 10 guesses to solve my riddle.");
    //main loop, print out string with underscore for missing letters.
    for(int i = 10; i > 0; i--){
      for(int j = 0;j < String length here; j++){
        
      }
    //allows user to guess

    //compares guess to string, if letter matches replace and tell
    //If guess wrong, inform user
    }*/
  }