package acsse.csc2a.fantasy.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import acsse.csc2a.fantasy.model.Player;

public class PlayerFileHandler {

	public static ArrayList<Player> readPlayerData(File file)
	{
		//Array list of players (List of Players)
		ArrayList<Player> players = new ArrayList<>();
		
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file))))
		{
			//get num of players
			int numPlayers = dis.readInt();
			
			String ID;
			String role;
			int prowess;
			double mana;
			
			for(int i=0; i < numPlayers; i++)
			{
				 ID = dis.readUTF();
				 role = dis.readUTF();
				 prowess = dis.readInt();
				 mana = dis.readDouble();
				 
				 players.add(new Player(ID, role, prowess, mana));
				
			}
					
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		//returning players
		return players;
		
	}
	
	
	public static void writePlayerObj(File file, ArrayList<Player> players)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
		{
			for(Player p : players)
			{
				oos.writeObject(p);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("Finished writing");
		
	}
	
	
	
	
}
