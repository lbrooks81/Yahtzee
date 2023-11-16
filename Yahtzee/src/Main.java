/*
 * Name: [Logan Brooks]
 * South Hills Username: [lbrooks81]
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

 public class Main
    {
        public static Scanner input = new Scanner(System.in);
        public static boolean[] categoryIsChosen = new boolean[8];
        public static String[] categoryNames =
                {
                        "Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Chance", "Yahtzee"
                };
        public static int playerScore = 0;
        public static void main(String[] args)
        {
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
        public static void printInstructions()
        {
            System.out.println("---------Yahtzee!---------");
            wait(1000);
            System.out.println("5 dice will be rolled. When you choose to stop, you will pick a category.");
            wait(2000);
            System.out.println("This will add the total of all dice sharing that category number. ");
            wait(2000);
            System.out.println("You cannot use the same category twice and are limited to three rolls before you must choose a category");
            wait(2000);
            System.out.println("Additionally, you can type 7 to call Chance, which will add the total of all dice together.");
            wait(2000);
            System.out.println("If all 5 dice are the same value, type 8 to call Yahtzee, which will add 50 points to your score.");
            wait(2000);
        }
        public static boolean outOfCategories()
        {
            for(int i = 0; i < categoryIsChosen.length; i++)
            {
                if(!categoryIsChosen[i])
                {
                    return false;
                }
            }
            return true;
        }
        public static boolean playerChoice(int rollNumber)
        {
            if(rollNumber == 3)
            {
                System.out.println("You ran out of rolls and now must choose a category.");
                return false;
            }
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
            int YAHTZEE_CALL = 8;
            int CHANCE_CALL = 7;
            boolean reroll = true;
            int numberOfRolls = 0;
            int[]diceValues = new int[5];
            while(numberOfRolls < 3 && reroll)
            {
                numberOfRolls++;
                diceValues = rollDice(numberOfRolls);
                wait(1000);
                reroll = playerChoice(numberOfRolls);
            }
            int categoryChoice = categoryChoice();
            for(int i = 0; i < 7; i++)
            {
                if(categoryIsChosen[i])
                {
                    categoryIsChosen[7] = true;
                }
            }
            if(categoryChoice == CHANCE_CALL)
            {
                chanceCheck(diceValues);
            }
            if(categoryChoice == YAHTZEE_CALL)
            {
                yahtzeeCheck(diceValues);
            }
            if(categoryChoice <= 6)
            {
                getPlayerScore(categoryChoice, diceValues);
            }
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
        public static int[]rollDice(int rollNumber)
        {

            System.out.println("Roll "+ rollNumber +": ");
            Random rand = new Random();
            int[]diceValues = new int[5];
            String diceAsString = "";
            for(int i = 0; i < (diceValues.length); i++)
            {
                diceValues[i] = rand.nextInt(1,7);
                diceAsString += diceValues[i] + ", ";
            }
            diceAsString = diceAsString.substring(0, diceAsString.length() - 2);
            System.out.println(diceAsString);
            return diceValues;
        }
        public static void chanceCheck(int[]diceValues)
        {
            int subtotal = 0;
            // int sum = Arrays.stream(diceValues).sum();
            for(int diceValue : diceValues)
            {
                subtotal += diceValue;
            }
            playerScore += subtotal;
            System.out.println(subtotal + " added to score. Your total score is " + playerScore);
            categoryIsChosen[7] = true;
        }
        public static void yahtzeeCheck(int[]diceValues)
        {
            final int YAHTZEE_SCORE = 50;
            for(int i = 0; i < diceValues.length; i++)
            {
                if(diceValues[4] != diceValues[i])
                {
                    System.out.println("Not a Yahtzee, nice try tho.");
                    return;
                }

            }
            playerScore += YAHTZEE_SCORE;
            System.out.println("Yahtzee! You gain 50 points. Your total is now " + playerScore);
            categoryIsChosen[6] = true;
        }
        public static int categoryChoice()
        {
            System.out.print("Enter the number for the category you would like to use: ");
            int categoryNumber = input.nextInt();
            while(categoryIsChosen[(categoryNumber - 1)])
            {
                System.out.println(categoryNames[(categoryNumber - 1)] + " category has already been picked. ");
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
            if(categoryNumber < 9)
            {
                categoryIsChosen[(categoryNumber - 1)] = true;
            }
            return categoryNumber;
        }

        public static boolean categoryValidation(int catChoice)
        {
            if(catChoice > 9)
            {
                return true;
            }
            return false;
        }
        public static void getPlayerScore(int categoryChoice, int[]diceValues)
        {
            int subtotal = 0;
            for(int i = 0; i < diceValues.length; i++)
            {
                if(diceValues[i] == categoryChoice)
                {
                    subtotal += categoryChoice;
                }
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
                for(int i = 0; i < categoryIsChosen.length; i++)
                {
                    categoryIsChosen[i] = false;
                }
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