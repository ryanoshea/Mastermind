**This is a Java port of the strategy game Mastermind.**

*Currently, the game must be run from the command line with four arguments, or it will crash.*

##Args
	1. Number of digits in the target number, between 1 and 10 (e.g. "4" would give a 4 digit number)
	2. How high each digit can go, between 1 and 9 (e.g. 5 would mean each digit ranges from 1-5)
	3. The number of guesses the player has to guess the target number
	4. The method of playing: 
		"terminal" for a command-line experience
		"GUI" for a graphical experience
		
Sample run config: `java -jar Mastermind.jar 4 5 10 GUI`