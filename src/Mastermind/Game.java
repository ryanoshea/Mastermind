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

public class Game {
    GameState gs;
    Player player;

    int nRed;
    int nWhite;

    Game(Player player, int nDigits, int range, int nGuesses) {
        this.player = player;
        gs = new GameState(nDigits, range, nGuesses);
    }

    public void play() {
        player.acceptGameState(gs);
        
        //while(!gs.isComplete()) {
		while(1<2) {
            int[] guess = player.getNextGuess();

            nRed = 0;
            nWhite = 0;
            
            //Logic for determining red return
            for(int i = 0; i < gs.nDigits; i++) {
                if(guess[i] == gs.actual[i]) {
                    nRed++;
                }
            }

            //Logic for determining white return, based on: Weisstein, Eric W. "Mastermind." From MathWorld--A Wolfram Web Resource. http://mathworld.wolfram.com/Mastermind.html
            for(int i = 1; i <= gs.range; i++) {
                int numGuess = 0;
                int numActual = 0;
                int increment = 0;

                for(int k = 0; k < gs.nDigits; k++) {
                    if(guess[k] == i) {
                        numGuess++;
                    }
                    if(gs.actual[k] == i) {
                        numActual++;
                    }
                }

                if(numGuess <= numActual) {
                    increment = numGuess;
                } else if(numActual < numGuess) {
                    increment = numActual;
                }

                nWhite = nWhite + increment;
            }

            nWhite = nWhite - nRed;
            
            gs.processGuess(guess, nRed, nWhite);
            player.displayResult();

            if (nRed == gs.nDigits) {
                player.dumpGameState(true, true);
                //break;
            } else if (gs.idxGuess >= gs.nGuesses) {
                player.dumpGameState(true, false);
                //break;
            }
            
        }

        //System.out.println("Game Completed!");
    }
}
