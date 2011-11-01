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
public class Mastermind {
    
    //LOADER Class
    
    static int nDigits, range, nGuesses;

    public static void main(String[] args){
		
		GameConfig config = new GameConfig();
		config.setVisible(true);
		while (config.nGuesses == 0) {}
		nDigits = config.getNDigits();
		range = config.getRange();
		nGuesses = config.getNGuesses();
		GUIPlayer player = new GUIPlayer();
		config.setVisible(false);
		player.setVisible(true);
		Game game = new Game(player, nDigits, range, nGuesses);
		game.play();
	
//	String playerType = args[3];
//
//	if ("terminal".equals(playerType)){
//		TerminalPlayer player = new TerminalPlayer();
//		Game game = new Game(player, Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
//		game.play();
//
//	} else if ("GUI".equals(playerType)) {
//		GUIPlayer player = new GUIPlayer();
//		player.setVisible(true);
//		Game game = new Game(player, Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
//		game.play();
//	} 
        
    }
}
