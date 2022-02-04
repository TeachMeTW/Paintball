//Imports scanner
import java.util.*;

class Main {
  public static void main(String[] args) throws InterruptedException{
  //Clears Console
		System.out.print("\033[H\033[2J");  
    System.out.flush();  
	
	//Sets up scanner system
		Scanner in = new Scanner(System.in);
		String n = "";
		String m = "";

	//starts game
		boolean bool = true;
	//Intro To Game
		System.out.print("Welcome ");
		Thread.sleep(20);
		System.out.println("To");
		Thread.sleep(20);

		/**

         __
				|  |                |   |          | |
				|__/  __   o   _  --|-- |__   __   | |
				|    /  || | |/ |   |   |  \ /  \| | |
				|		 |__/| | |  |   |   |__/ \__/| | |  
		**/

		Thread.sleep(100);
		System.out.println("|  |   __            |   |          | |");
		Thread.sleep(100);
		System.out.println("|__/  /  | o ||  | --|-- |__   __   | |");
		Thread.sleep(100);
		System.out.println("|    |___| | | | |   |   |  | /  || | |");
		Thread.sleep(100);
		System.out.println("|    |   | | |  ||   |   |__/ |__/| | |");
		Thread.sleep(100);
		System.out.println("________________~____________________________");
	//Game Start
		while(bool){
		//Sets up difficulty of the game
			System.out.println("What difficulty would you like to play against? (1/2/3)");
			n = in.next();

		//Sets up the game and HP
			int dif = Integer.valueOf(n);
			Paintball game = new Paintball(dif);
			boolean bool2 = false;
			game.setHP(5);

		//Clears Console
			System.out.print("\033[H\033[2J");  
    	System.out.flush();

		//Game start
			while(!bool2){
			//UI Elements
				System.out.println("Player Lives: "+ game.returnHP(0) +" -- AI Lives: "+game.returnHP(1) + " -- Difficulty: "+ dif);
				System.out.println("------------------------------------------------------------------------------");

			//Board of the Game
				System.out.println("[1]|[2]|[3] AI Side\n");
				System.out.println("[1]|[2]|[3] Player Side");

			//Player options
				System.out.println("Where would you like to shoot? (1/2/3)");
				n = in.next();

				System.out.println("\n\nWhere would you like to move? (1/2/3)");
				m = in.next();

			//Logging Player turn
				game.shootNMove(Integer.valueOf(n),Integer.valueOf(m));
			
			//Console Clear
				System.out.print("\033[H\033[2J");  
    		System.out.flush();

			//AI Turn
				System.out.print("Taking AI turn.");
				game.aiSNM();
				for(int j = 0; j < 10; j++){
					System.out.print(".");
					game.timer(2);
				}
				System.out.print("\033[H\033[2J");  
    		System.out.flush();  

			//Checks win
				bool2 = game.win();
				

			}
		//Asks If player wants to play again
			System.out.println("Would you like to play again? (y/n)");
			n = in.next();

			System.out.print("\033[H\033[2J");  
    	System.out.flush();

			if(!n.equals("y")){
				bool = false;
			}
		}

  }
}