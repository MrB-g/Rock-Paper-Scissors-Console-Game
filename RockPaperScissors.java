import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.Math;

public class RockPaperScissors { 
    private static int indent = 2;

    private static String padLeft(String sentence, int indent){ 
        return " ".repeat(indent) + sentence;
    } 

    private static String decideWinner(String playerChoice, String computerChoice){
        String winner;
        if(playerChoice == "rock" && computerChoice == "scissors"){
            winner = "player";
        } else if(playerChoice == "paper" && computerChoice == "rock"){
            winner = "player";
        } else if(playerChoice == "scissors" && computerChoice == "paper"){
            winner = "player";
        } else if(playerChoice.equals(computerChoice)){ 
            winner = "both";
        } else {
            winner = "computer";
        }
        return winner;
    }

    private static boolean checkArrayInclude(String[] items, String checkItem){
        boolean result = false;
        for(int i=0; i<items.length; i++){
            if(items[i].equals(checkItem)){
               result = true;
               break;
            }
        } 
        return result;
    }

    private static void startTheGame(){
        String[] items = {"rock", "paper", "scissors"};
        int computerChoiceIndex = (int)Math.floor(Math.random() * (2-0+1) + 0);
        String computerChoice = items[computerChoiceIndex];
        String playerChoice;

        Scanner playerInput = new Scanner(System.in);
        System.out.println(padLeft("Please choose your move.", indent));
        System.out.println(padLeft("1. Rock", indent));
        System.out.println(padLeft("2. Paper", indent));
        System.out.println(padLeft("3. Scissors", indent));
        System.out.println("");

        while(true){
            System.out.print(padLeft("Type here to choose : ", indent));
            playerChoice = playerInput.nextLine().trim().toLowerCase();

            try {
                int itemIndex = Integer.parseInt(playerChoice) - 1;
                try { 
                    playerChoice = items[itemIndex];
                    break;
                } catch(Exception error){
                    System.out.println(padLeft("\u001B[31m\u001B[1mPlease type only 1, 2 or 3.\u001B[0m", indent));
                }
            } catch(Exception error){ 
                boolean isInclude = checkArrayInclude(items, playerChoice);
                if(isInclude){
                    break;
                } else {
                    System.out.println(padLeft("\u001B[31m\u001B[1mPlease type only valid items.\u001B[0m", indent));
                }
            }
        }

        String winner = decideWinner(playerChoice, computerChoice);

        System.out.println("");
        System.out.println(padLeft("Computer Choice : " + computerChoice.toUpperCase(), indent));
        System.out.println(padLeft("Player Choice : " + playerChoice.toUpperCase(), indent));
        System.out.println("");

        if(winner == "player"){ 
            System.out.println(padLeft("\u001B[32m\u001B[1mYOU WIN THE GAME.\u001B[0m", indent));
        } else if(winner == "computer"){
            System.out.println(padLeft("\u001B[31m\u001B[1mYOU LOSE THE GAME.\u001B[0m", indent));
        } else if(winner == "both"){
            System.out.println(padLeft("\u001B[33m\u001B[1mGAME IS TIED | CHOOSE AGAIN.\u001B[0m", indent));
            System.out.println("");
            startTheGame();
        }

        System.out.println("");
    }

    public static void main(String[] args){
        System.out.println("");
        System.out.println(padLeft("Welcome to Rock, Paper, Scissors Game!", indent));
        System.out.println("");

        System.out.println(padLeft("How to win the game?", indent));
        System.out.println(padLeft("| Rock beats Scissosrs.", indent));
        System.out.println(padLeft("| Scissors beats Paper.", indent));
        System.out.println(padLeft("| Paper beats Rock.", indent));
        System.out.println("");

        startTheGame();
    }
}
