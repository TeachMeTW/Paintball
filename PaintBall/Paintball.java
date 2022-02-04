
public class Paintball implements Bruh{
//The level of difficulty on AI
  private int dificulty;
//Where the player shoots
  private int playerShoot;
//Where the play wants to move
  private int playerMove;
//Where the AI shoots
  private int aiShoot;
//Where the AI will move
  private int aiMove;
//Ai HP
	private int aiHP;
//PLayer HP
	private int playerHP;


//Default difficulty
  public Paintball(){
    this.dificulty = 1;
		this.playerHP = 5;
		this.aiHP = 5;
  }
  
//Choice difficulty of the AI 1 being the easiest & 3 being the hardest
  public Paintball(int x){
    if(x <= 3 && x > 0){
      this.dificulty = x;
      } else {
      this.dificulty = 1;
    }
		this.playerHP = 5;
		this.aiHP = 5;
  }
  //Player get's the option of where to move & where to shoot
  public void shootNMove(int shoot, int move){
    this.playerShoot = shoot;
    this.playerMove = move;
  }
  //Chooses how the AI will play
  public void aiSNM(){
		//Changes play style based on difficulty
    if(dificulty == 1){
      this.aiShoot = (int) ((Math.random()*3)+1);
      this.aiMove = (int) ((Math.random()*3)+1);
    } else if( dificulty == 2){
      if((int) (Math.random()*4) == 0){
        this.aiShoot = this.playerMove;
      } else {
        this.aiShoot = (int) ((Math.random()*3)+1);
      }

      if((int) (Math.random()*4) == 0){
        if(this.playerShoot != 1){
          this.aiMove = playerShoot -1;
        } else {
          this.aiMove = playerShoot +1;
        }
      } else {
        this.aiMove = (int) ((Math.random()*3)+1);
      }

    }else if( dificulty == 3){
      //Hardest AI, practically cheats
      this.aiShoot = this.playerMove;

      if(playerShoot != 1){
        this.aiMove = playerShoot -1;
      } else {
        this.aiMove = playerShoot +1;
      }
      
    }
  }
  //recursive timer
  public boolean timer(int time) throws InterruptedException{
    if(time >= 0){
			Thread.sleep(50);
       return timer(time-1);
    } else {
      return true;
    }
  }
//interface BRUH
  public String bruh(int bruh){
    String temp = "";
    for(int i = 0; i < bruh; i++){
      temp += "Bruh";
    }
    return temp;
  }
//Checks for the win/end of game
	public boolean win(){
		//Checks if game hasn't already ended
		if(playerHP == 0||aiHP == 0){
			if(playerHP == 0 && aiHP == 0){
				System.out.println("The Game has ended in a Draw!");
				return true;
			} else if(playerHP == 0){
				System.out.println("The AI has killed the Player!");
				return true;
			} else if(aiHP == 0){
				System.out.println("The Player has killed the AI!");
				return true;
			}
			return true;
		} else {
			//checks who shot who
			if(aiShoot == playerMove){
				playerHP -= 1;
				System.out.println("The Player has been shot, " + playerHP +" lives remaining.");
				if(playerHP == 0){
					System.out.println("The AI has killed the Player!");	
					return true;
				}
			}
			if(playerShoot == aiMove){
				aiHP -= 1;
				System.out.println("The AI has been shot, " + aiHP +" lives remaining.");
				if(aiHP == 0){
					System.out.println("The Player has killed the AI!");
					return true;
				}
			}
			return false;
		}
	}
//sets HP
	public void setHP(int x){
		playerHP = x;
		aiHP = x;
	}
//Returns HP
	public int returnHP(int x){
		if(x == 0){
			return playerHP;

		}else{
			return aiHP;
	}

	}

}