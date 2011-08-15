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
public interface Player {
    public void acceptGameState(GameState gs);  //called once at beginning of Game
    public int[] getNextGuess();                //should return player's next guess
                                                //can assume that only last return code of GameState has changed since last called
}
