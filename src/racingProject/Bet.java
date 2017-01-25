package racingProject;

public class Bet {
	private Player player1;
	private Player player2;
	private double wager;
	private String winner;

	public Bet(Player p1, Player p2, double w) {
		player1 = p1;
		player2 = p2;
		wager = w;
		
	}

	public void Race() {
		//If player 1 loses
		if (player1.getVehicle().getQuarterMileTime() > player2.getVehicle().getQuarterMileTime()) {
			player1.setCash(player1.getCash() - wager);
			player2.setCash(player2.getCash() + wager);
			winner = "Player 2 Won!";
		} else {
		//If Player 2 loses	s
			player2.setCash(player2.getCash() - wager);
			player1.setCash(player1.getCash() + wager);
			winner = "Player 1 Won!";
		}
	}
	
	
	public String getWinner(){
		return winner;
	}

}
