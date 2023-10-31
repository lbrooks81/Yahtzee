/*
 * Name: [Logan Brooks]
 * South Hills Username: [lbrooks81]
 */

import java.util.Random;
import java.util.Scanner;

 public class Main
    {
        public static Scanner input = new Scanner(System.in);
        public static int diceOneValue = 0;
        public static int diceTwoValue = 0;
        public static int diceThreeValue = 0;
        public static int diceFourValue = 0;
        public static int diceFiveValue = 0;
        public static boolean oneHasBeenUsed = false;
        public static boolean twoHasBeenUsed = false;
        public static boolean threeHasBeenUsed = false;
        public static boolean fourHasBeenUsed = false;
        public static boolean fiveHasBeenUsed = false;
        public static boolean sixHasBeenUsed = false;
        public static int playerScore = 0;
        public static void main(String[] args)
        {
            System.out.println("---------Yahtzee!---------");
            wait(1000);
            while(!outOfCategories())
            {
                logicLoop();
            }
            System.out.println("You ran out of categories to choose, ending the game. Your final score was: " + playerScore);
            while(playAgain() )
            {
                while(!outOfCategories())
                {
                    logicLoop();
                }
            }
            if(playAgain() && outOfCategories())
            {
                System.out.println("You ran out of categories to choose, ending the game. Your final score was: " + playerScore);
            }
            else
            {
                System.out.println("Thanks for playing!");
            }
        }
        public static boolean outOfCategories()
        {
            return oneHasBeenUsed  && twoHasBeenUsed && threeHasBeenUsed && fourHasBeenUsed && fiveHasBeenUsed && sixHasBeenUsed;
        }
        public static boolean playerChoice()
        {
            System.out.print("If you would like to stop rolling and choose a category, type \"stop\", or type \"roll\" to roll again: ");
            String choice = input.nextLine();
            while(!choice.equalsIgnoreCase("stop") && !choice.equalsIgnoreCase("roll"))
            {
                System.out.println("Invalid input.");
                System.out.print("If you would like to stop rolling and choose a category, type \"stop\", or type \"roll\" to roll again: ");
                choice = input.nextLine();
            }
            return !choice.equalsIgnoreCase("stop");
        }
        public static void logicLoop()
        {
            boolean reroll = true;
            int numberOfRolls = 0;
            while(numberOfRolls < 3 && reroll)
            {
                rollDice();
                wait(1000);
                numberOfRolls++;
                reroll = playerChoice();
            }
            if(numberOfRolls == 3 && reroll)
            {
                System.out.println("You ran out of rolls and now must choose a category.");
            }
            getPlayerScore(categoryChoice());
        }
        public static void wait(int ms)
        {
            try
            {
                Thread.sleep(ms);
            }
            catch(InterruptedException e)
            {
                //Thread.currentThread().interrupt();
            }
        }
        public static void rollDice()
        {
            Random rand = new Random();
            diceOneValue = rand.nextInt(1,7);
            System.out.print(diceOneValue+", ");
            diceTwoValue = rand.nextInt(1,7);
            System.out.print(diceTwoValue+", ");
            diceThreeValue = rand.nextInt(1,7);
            System.out.print(diceThreeValue+", ");
            diceFourValue = rand.nextInt(1,7);
            System.out.print(diceFourValue+", ");
            diceFiveValue = rand.nextInt(1,7);
            System.out.print(diceFiveValue+". ");
        }
        public static int categoryChoice()
        {
            System.out.print("Enter the number for the category you would like to use: ");
            int categoryNumber = input.nextInt();
            while(categoryNumber == 1 && oneHasBeenUsed)
            {
                System.out.println("This category has already been picked. ");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            while(categoryNumber == 2 && twoHasBeenUsed)
            {
                System.out.println("This category has already been picked. ");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            while(categoryNumber == 3 && threeHasBeenUsed)
            {
                System.out.println("This category has already been picked. ");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            while(categoryNumber == 4 && fourHasBeenUsed)
            {
                System.out.println("This category has already been picked. ");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            while(categoryNumber == 5 && fiveHasBeenUsed)
            {
                System.out.println("This category has already been picked. ");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            while(categoryNumber == 6 && sixHasBeenUsed)
            {
                System.out.println("This category has already been picked. ");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            while(categoryValidation(categoryNumber))
            {
                System.out.println("Invalid input.");
                System.out.print("Enter the number for the category you would like to use: ");
                categoryNumber = input.nextInt();
            }
            input.nextLine();
            switch(categoryNumber)
            {
                case 1:
                    oneHasBeenUsed = true;
                    return 1;
                case 2:
                    twoHasBeenUsed = true;
                    return 2;
                case 3:
                    threeHasBeenUsed = true;
                    return 3;
                case 4:
                    fourHasBeenUsed = true;
                    return 4;
                case 5:
                    fiveHasBeenUsed = true;
                    return 5;
                default:
                    sixHasBeenUsed = true;
                    return 6;
            }
        }
        public static boolean categoryValidation(int catChoice)
        {
            return catChoice != 1 && catChoice != 2 && catChoice != 3 && catChoice != 4 && catChoice != 5 && catChoice != 6;
        }
        public static void getPlayerScore(int categoryChoice)
        {
            int subtotal = 0;
            if(diceOneValue == categoryChoice)
            {
                subtotal += categoryChoice;
            }
            if(diceTwoValue == categoryChoice)
            {
                subtotal += categoryChoice;
            }
            if(diceThreeValue == categoryChoice)
            {
                subtotal += categoryChoice;
            }
            if(diceFourValue == categoryChoice)
            {
                subtotal += categoryChoice;
            }
            if(diceFiveValue == categoryChoice)
            {
                subtotal += categoryChoice;
            }
                playerScore += subtotal;
                System.out.println(subtotal + " added to total since "+ translateNumberToCard(categoryChoice) +  " category was used. Your total score is " + playerScore);
            }
        public static String translateNumberToCard (int catChoice)
        {
            return switch(catChoice)
            {
                case 1 -> "aces";
                case 2 -> "twos";
                case 3 -> "threes";
                case 4 -> "fours";
                case 5 -> "fives";
                default -> "sixes";
            };
        }
        public static boolean playAgain()
        {

            System.out.println("If you would like to play again, type \"yes\": ");
            String confirmation = input.nextLine();
            if(confirmation.equalsIgnoreCase("yes"))
            {
                oneHasBeenUsed = false;
                twoHasBeenUsed = false;
                threeHasBeenUsed = false;
                fourHasBeenUsed = false;
                fiveHasBeenUsed = false;
                sixHasBeenUsed = false;
                playerScore = 0;
                return true;
            }
            else
            {
                input.close();
                return false;
            }
        }
    }