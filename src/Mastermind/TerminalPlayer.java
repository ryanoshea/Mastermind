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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TerminalPlayer implements Player {
    GameState gs;
    
    public void acceptGameState(GameState gs) {
        this.gs = gs;
    }

    public int[] getNextGuess() {
        int[] guess;
        char[] inputCharArray;
        String input = new String();

        gs.playerDump(false);

        System.out.println("Type your Guess: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            input = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TerminalPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        guess = new int[gs.nDigits];


        inputCharArray = new char[gs.nDigits];
        inputCharArray = input.toCharArray();

        for(int i = 0; i< gs.nDigits; i++) {
            guess[i] = Integer.parseInt(String.valueOf(inputCharArray[i]));
        }

        return guess;
    }
}
