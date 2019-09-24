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
            else{
                hideMovie[i] = ' ';
            }
        }
        return new String(hideMovie);
    }

    public void playerGuess() throws Exception {
        String selectedMovie = this.chosenMovie();
        String hiddenMovie = this.hideGuess(selectedMovie);
        Scanner scanner = new Scanner(System.in);

        for(int i = 10; i > 0; i--){
            System.out.println(hiddenMovie);
            //print out selectedMovie line
            char guess = scanner.next().charAt(0);
            guess = Character.toLowerCase(guess);
            if (Character.isLetter(guess)){
                System.out.println(selectedMovie.indexOf(guess));
            }
            else{
                System.out.println("Please input a valid letter");
            }
        }
    }

}
