CP132 Lab 4

In this lab, you’ll get some practice in writing methods and loops.

Specifications
Yahtzee is a dice game in which players aim to achieve the highest possible score by rolling five six-
sided dice. In this simplified version, the player is limited to only six rolls, unlike the full game with
thirteen rolls. Additionally, in our version, players cannot keep any dice frozen; all five dice must be
rolled in each turn.

On a player's turn, they can roll the dice up to three times but have the option to stop and score after
their first or second roll. When they choose to stop rolling, they must select a category in which to
score their dice. We have six predefined categories for this lab:

Category       What to score
Aces (Ones)    Total of Aces only
Twos           Total of Twos only
Threes         Total of Threes only
Fours          Total of Fours only
Fives          Total of Fives only
Sixes          Total of Sixes only

For example, after their third turn, a player might have rolled: 3, 1, 3, 1, 5. If they decide to use the fifth
category (Fives), they would receive 10 points, which is the sum of the fives rolled. If the player
chooses the first category (Aces), they would earn two points.

Another scenario: on their first turn, a player rolls 1, 4, 3, 5, 6. They decide to roll again and get the
following dice: 6, 6, 5, 4, 6. Choosing to stop on their second turn, assuming the user then chooses the
be scored in the sixth category (Sixes), they would receive 18 points.

It's important to note that once a category is used, it cannot be selected again. When all categories have
been used, the game concludes, and the player's final score should be displayed on the terminal.

This lab's functionality serves as the foundation for the next lab, which will build upon these concepts.
Completing this lab is a prerequisite for the next one.

Constraints
 The variable(s) used to represent the dice should be globals.
 The variable(s) used to implement the status of whether a category has been used or not should
be globals.
 The variable to used to represent the player’s points should be global.
 The Scanner variable should be global.
 There should be no globals variables besides constants and the globals listed above.
 All inputs should be validated. Do not allow invalid inputs.
 The logic that handles “rolling the dice” should be contained in its own method.
 Print the values of the dice on the same line after every roll.
 The logic that handles getting an input from the user and validating the input should be in its
own method.
◦ Since there are two different inputs (whether to stop rolling and choosing a category), there
should be two methods with their own input validation.
 A method must complete only one task. Remember that instructions should be cohesive.
 There should not be methods with only one instruction.
 Do not use a counter to decide when the game ends. Only end the game after checking if all
categories have been used.
 Prompt the user before every input.
◦ Ex: “Enter a category to use: ”
 Echo every input.
◦ Ex: “12 points added to total since sixes category was used.”
 Close the input Scanner when there are no more inputs.

Extra Credit Opportunity
 (1 pt) Implement a way to let the user to choose to play again.
 (3 pts) This extra credit opportunity is extremely difficult. Attempt this only after
completing the base specifications.
Use the binary pattern of single integer to represent the category chosen. Utilize bitwise
operations to mark a category as used or unused. For example: you may have this binary:
100101
This would represent that the aces, threes, and sixes category has been used already. This table
representation of the previous bit pattern may help:
Category Sixes  Fives  Fours Threes Twos  Ones
Bit        1      0      0     1      0    1
Usage    Used  Unused  Unused Used Unused Used
◦ Hint: Create a method that takes an integer as input and returns a boolean value indicating
whether the corresponding bit represents a used category.
◦ Resources:
▪ https://www.baeldung.com/java-binary-numbers
▪ https://www.geeksforgeeks.org/bitwise-operators-in-java/

Scoring Rubric
11/11 Program meets specifications and code is formatted and clean.
10/11 Program meets specifications.
9-6/11 Program does not meet specifications but there was noticeable effort.
5-0/11 Program does not meet specifications and there was little effort put in.

Submission
The submission for this lab is the commit ID you want to be graded. You will submit it via the Canvas
assignment.
Tips
 Utilize code folding in your IDE to make your source code file easier to traverse.
 Frequently test your logic. Test edge cases to ensure your logic holds up well.

Recommended Order of Implementation
1. Define globals and constants at the top of the class. Take into consideration the constraints of
this lab to help you.
2. Write the method to roll the dice. Test this method using your main().
3. Write a method that asks the user whether to re-roll or stop rolling and choose a category.
Consider if this method should return anything, and if so, what?
4. Create a method that will keep calling the method that rolls the dice until the user indicate they
want to stop. After each roll, the user should be asked if they wish to stop. This should not be
your main(). Modify your loop condition to also not allow the user to roll more than three times.
5. Create a method that asks the user what category they want to use for scoring. Utilize input
validation. Do not allow the user to choose a category that has already been chosen. After the
user chooses a valid category, mark the category as chosen. Add the correct value of points to
the total score. This logic can easily get messy if not structured well. Expect to write a lot of
selection structures.
6. The instructions right after when the user has stopped rolling should be asking the user to
choose a category. This should just be a method call.
7. Create a method that you can use to determine if every category has been used or not.
8. In your main() method, call the method described in step 4 until all categories have been used.
Utilize the method described in the last step for this.
