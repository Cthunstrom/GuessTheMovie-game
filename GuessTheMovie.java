import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String [] args) throws Exception{
        GameLogic game = new GameLogic();

        System.out.println("I have chosen a movie at random.");
        System.out.println("It is your job to guess it.");
        System.out.println("You have 10 guesses.");
        game.playerGuess();
    }
}
