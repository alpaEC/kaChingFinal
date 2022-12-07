/* Implementation for the following usecase:
In this exercise, you will implement a popular kids counting game in Java.
The rules of the game are as follows:

In turns, the players start counting upwards beginning with "1".
For every multiple of 3, instead of calling the number itself, the player has to call out "ka"
For every multiple of 5, instead of calling the number itself, the player has to call out "ching!"
Which leads to every multiple of 15 being called out as "ka-ching!"

The first 18 steps of the game thus sound as follows: "1", "2", "ka", "4", ching!", "6", "7", "8", "ka", "ching!", "11", "ka", "13", "14", "ka-ching!", "16", "17", "ka"...

Implement this game in Java such that, when run, it executes the rules of the game as outlined above.

First one tells the app how many users are going to participate.
Creates the users, and alternately asks the users to input their value.
The app stops, when the user enters "exit"

 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class KaChing {
    public static void main(String[] args){

        int numberOfPlayers = 0;
        int currentNumber = 0;
        int userInt = 0;
        boolean gameOver = false;
        boolean isString = false;
        Scanner sc = new Scanner(System.in);

        ArrayList<Player> p = new ArrayList<>();

        System.out.println("Welcome to Ka-Ching!");
        System.out.println("How many Players?: ");
        numberOfPlayers = sc.nextInt();             //get # of players
        sc.nextLine();                              //flush the buffer

        for(int i = 0; i < numberOfPlayers; i ++){  //add players to array list
            p.add(new Player());
            System.out.println("Player " + (i+1) + " of " + numberOfPlayers + " Please Enter your Name: ");
            p.get(i).setName(sc.nextLine());
        }

        System.out.println(numberOfPlayers + " Registered Users: "); //list ammount and names of registered users
        for(int i = 0; i < numberOfPlayers; i ++){
          System.out.println(p.get(i).getName());
        }

        while(!gameOver && currentNumber < Integer.MAX_VALUE){          //as long as exit is not typed in, or current number not out of bound exception
            currentNumber++;
            System.out.println("Current count: " + currentNumber);

            for(int i = 0; i < numberOfPlayers && !gameOver; ++i ){
                System.out.println(p.get(i).getName() + " (Type exit to end Game): ");
                String userInput = sc.nextLine();
                if(userInput.contains("exit")) gameOver = true;

                // check for ka, ching! and ka-ching! conditions
                if(userInput.contains("ka-ching!") && currentNumber % 15 == 0) p.get(i).correctAnswer();
                else if(userInput.contains("ching!") && currentNumber % 5 == 0) p.get(i).correctAnswer();
                else if(userInput.contains("ka") && currentNumber % 3 == 0) p.get(i).correctAnswer();

                //typecast the string content into an int (if an int was typed)
                try{
                    userInt = Integer.parseInt(userInput);

                    if(currentNumber == userInt && userInt % 15 != 0 && userInt % 5 != 0 && userInt % 3 != 0) p.get(i).correctAnswer();
                    else p.get(i).wrongAnswer();

                }
                catch (NumberFormatException ex){
                //    ex.printStackTrace();
                }
                //show current player stats
                System.out.println("Correct: " + p.get(i).getCorrectAnswers() + " Wrong: " + p.get(i).getWrongAnswers());
            }


        }

    }

}
