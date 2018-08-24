import java.util.Scanner;

public class HangmanApplication {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//Rules and greetings
        System.out.println("Hello in my first game. This game is HANGMAN!");
        System.out.println("You will have only 6 times to guess the my word from dictionary");
        System.out.println("So, good look and fun!");
        System.out.println("===================================================================================");



        boolean isWantToPlayInGame = true;
//Allows for multiple games
        while (isWantToPlayInGame){
// Setting up the game
//            while (!game.isOver){
// Playing the game
//            }

            System.out.println();
            System.out.println("Do you want play, darling loser? If you do, please input answer \"Y\"");
            Character responce = in.nextLine().toUpperCase().charAt(0);
            isWantToPlayInGame = (responce == 'Y');

        }




    }
}
