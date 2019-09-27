import java.io.File;
import java.util.Scanner;

public class GameLogic {

    /***
     * This function will parse a .txt file and return the number of lines in it, used to determine possible
     * outcomes of a random selection.
     * @return number of lines as int
     */
    public int listSize() throws Exception{
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            count += 1;
        }
        return count;
    }

    /***
     * This function uses listSize() to select a random line from a .txt file and return it as the listed line.
     * @return line item as a String
     */
    public String chosenMovie() throws Exception{
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        int randomNumber = (int) (Math.random() * 100 % this.listSize());
        for(int i = 0; i <= randomNumber; i++){
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    /***
     * This function converts a string to underscores to mask the original contents of the string.
     * @return A line of underscores and spaces as a string
     */
    public String hideGuess(String movieName){
        char[] hideMovie = movieName.toCharArray();
        for(int i = 0; i < movieName.length(); i++){
            if(Character.isLetter(hideMovie[i])){
                hideMovie[i] = '_';
            }
        }
        return new String(hideMovie);
    }

    /***
     * This function converts the player guess to unmask the hidden movie when compared to the chosen movie.
     * @param currentMovie is the current chosen movie
     * @param guessedMovie is the current hidden movie
     * @param guess is the players guess
     * @return the guessed movie with players guess unmasked
     */
    public String playerGuess(String currentMovie, String guessedMovie, char guess){
        char[] guessedMovieArray = guessedMovie.toCharArray();
        boolean containsLetters = true;
        int count = 0;
        while(containsLetters){
            if(currentMovie.indexOf(guess) >= 0 && count <= currentMovie.lastIndexOf(guess)){
                guessedMovieArray[currentMovie.indexOf(guess, count)] = guess;
                count += 1;
            }
            else{
                containsLetters = false;
            }
        }
        return new String(guessedMovieArray);
    }


    public void gameLoop() throws Exception {
        String selectedMovie = this.chosenMovie();
        String hiddenMovie = this.hideGuess(selectedMovie);
        Scanner scanner = new Scanner(System.in);
        char[] guessedLetters = new char[26];
        int numberOfGuessedLetters = 0;
        int guesses = 10;

        while(guesses > 0){
            System.out.println(hiddenMovie);
            System.out.println(guessedLetters);
            System.out.println("You have " + guesses + " remaining.");

            char guess = scanner.next().charAt(0);
            guess = Character.toLowerCase(guess);
            ////make case?////

            if (new String(guessedLetters).indexOf(guess) > 0){
                System.out.println("Please guess a letter you have not already guessed.");
            }
            else if (selectedMovie.indexOf(guess) < 0){
                System.out.println("That character is not in the movie title.");
                guesses -= 1;
                guessedLetters[numberOfGuessedLetters] = guess;
                numberOfGuessedLetters += 1;
            }
            else if (Character.isLetter(guess)){
                hiddenMovie = playerGuess(selectedMovie, hiddenMovie, guess);
                guessedLetters[numberOfGuessedLetters] = guess;
                numberOfGuessedLetters += 1;
                if (hiddenMovie.equals(selectedMovie)){
                    System.out.println("You win the game!");
                    break;
                }
            }
            else System.out.println("Please input a valid letter");
        }

        if (guesses == 0){
            System.out.println("You failed to guess the movie.");
            System.out.println("The correct movie was " + selectedMovie + ".");
        }

        System.out.println("Would you like to play again? Y/N");

        char guess = scanner.next().charAt(0);
        guess = Character.toUpperCase(guess);

        if(guess == 'Y') {
            gameLoop();
        }
    }

}
