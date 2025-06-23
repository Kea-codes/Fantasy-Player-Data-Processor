import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import acsse.csc2a.fantasy.file.PlayerFileHandler;
import acsse.csc2a.fantasy.model.Player;

public class Main {

	public static void main(String[] args) {
		
		String[] files = {
				"data/fantasy-small.dat",
				"data/fantasy-medium.dat",
				"data/fantasy-large.dat",
		};
		
		//Create a new File 
		String newFilename;
		//List of players
		ArrayList<Player> players = null;
		
		for(String file: files)
		{
			newFilename = file.substring(0, file.lastIndexOf(".")) + "_objects.dat";
			players = PlayerFileHandler.readPlayerData(new File(file));
			
			Collections.sort(players);
			
			PlayerFileHandler.writePlayerObj(new File(newFilename), players);
		}
		
		for(Player p: players)
		{
			System.out.print(p);
		}
		
		
	}

}
