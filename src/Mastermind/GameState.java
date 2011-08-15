package Mastermind;

/**
 * @author Ryan O'Shea
 *
 * Copyright © 2009-2011 Ryan O'Shea
 *
 * Copying Permissions: 
 * 	This file is part of Mastermind.
 *
 * 	Mastermind is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 * 
 * 	Mastermind is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 *
 * 	You should have received a copy of the GNU General Public License
 *  along with Mastermind (see the "COPYING" file).  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Random;
public class GameState {
    int nDigits;        //length of sequence
    int range;          //range (1-4, 1-5, 1-6) of numbers to guess from
    int nGuesses;       //number of guesses available to player
    int[] actual;       //computer's choice

    int idxGuess = 0;   //number of current guess

    int[][] recGuesses; //record of all player guesses
    int[] recRed;       //record of red returns
    int[] recWhite;     //record of white returns

    //////////////////////////////////////////////////////////////////
    
    GameState(int nDigits, int range, int nGuesses, int[] actual) {  //with provided actual
        recGuesses = new int[nGuesses][nDigits];
        recRed = new int[nGuesses];
        recWhite = new int[nGuesses];

        this.actual = actual;
        this.nDigits = nDigits;
        this.nGuesses = nGuesses;
        this.range = range;
    }
    
    GameState(int nDigits, int range, int nGuesses) {           //generates random actual
        recGuesses = new int[nGuesses][nDigits];
        recRed = new int[nGuesses];
        recWhite = new int[nGuesses];

        actual = new int[nDigits];
        Random actualGenerator = new Random();
        for(int i = 0; i < nDigits; i++) {
            actual[i] = actualGenerator.nextInt(range) + 1;
        }

        this.nDigits = nDigits;
        this.nGuesses = nGuesses;
        this.range = range;
    }
    
    public void processGuess(int[] guess, int nRed, int nWhite) {
        for(int i = 0; i < nDigits; i++) {
            recGuesses[idxGuess][i] = guess[i];
        }

        for(int i = 0; i < nGuesses; i++) {
            recRed[idxGuess] = nRed;
            recWhite[idxGuess] = nWhite;
        }
        
        idxGuess++;
    }

    public boolean isComplete() {
        return idxGuess >= nGuesses;
    }

    public void playerDump(boolean gOver) {
        if(gOver == false) {
            System.out.println("\n");
            System.out.println("Current Game: ");
            System.out.println("\t# of Digits: " + nDigits);
            System.out.println("\tRange: 1-" + range);
            System.out.println("\t# of Guesses Left: " + (nGuesses - idxGuess) + " of " + nGuesses);
            System.out.println("\n Your Guesses & Returns: ");
                for(int i = 0; i < idxGuess; i++) {
                    System.out.print("\t\t");

                    for(int k = 0; k < nDigits; k++) {
                        System.out.print(recGuesses[i][k]);
                    }

                    System.out.print("\t" + recRed[i] + "\t" + recWhite[i]);
                    System.out.print("\n");
                }
        } else if(gOver == true) {
            System.out.println("\nYou Won!!\n");
            System.out.println("Game Stats: ");
            System.out.println("\t# of Digits: " + nDigits);
            System.out.println("\tRange: 1-" + range);
            System.out.println("\n Your Guesses & Returns: ");
                for(int i = 0; i < idxGuess; i++) {
                    System.out.print("\t\t");

                    for(int k = 0; k < nDigits; k++) {
                        System.out.print(recGuesses[i][k]);
                    }

                    System.out.print("\t" + recRed[i] + "\t" + recWhite[i]);
                    System.out.print("\n");
                }
        }
    }

    public void dump() {
        System.out.println("Current Game State:");
        System.out.println("\tnDigits: " + nDigits);
        System.out.println("\tRange: " + range);
        System.out.println("\tnGuesses: " + nGuesses);
        System.out.println("\tactual: ");
            System.out.print("\t\t");
            for(int i = 0; i < nDigits; i++) {
                System.out.print(actual[i]);
            }
            System.out.print("\n");
        System.out.println("\tidxGuess: " + idxGuess);
        System.out.println("\trecGuesses: ");
            for(int i = 0; i < idxGuess; i++) {
                System.out.print("\t\t");
                for(int k = 0; k < nDigits; k++) {
                    System.out.print(recGuesses[i][k]);
                }
                System.out.print("\n");
            }
        System.out.println("\trecRed: ");
            for(int i = 0; i < idxGuess; i++) {
                System.out.println("\t\t" + recRed[i]);
            }
        System.out.println("\trecWhite: ");
            for(int i = 0; i < idxGuess; i++) {
                System.out.println("\t\t" + recWhite[i]);
            }
    }
}
