package acsse.csc2a.fantasy.model;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player>{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//Attributes of the Player class
		private String ID;
		private String role;
		private  int prowess;
		private double mana;
		
		//Parameterized constructor
		public Player(String ID, String role, int prowess, double mana) {
			super();
			this.ID = ID;
			this.role = role;
			this.prowess = prowess;
			this.mana = mana;
		}

		@Override
		public String toString() {
			return String.format("%sID: %s\nRole: %s\nProwess: %s\nMana:", ID , role , prowess, mana);
		}

		@Override
		public int compareTo(Player o) {
			if(prowess < o.prowess) return -1;
			else if(prowess > o.prowess) return 1;
			else if (mana < o.mana) return -1;
			else if (mana > o.mana) return 1;
			
			return 0;
		}

		
			

}
