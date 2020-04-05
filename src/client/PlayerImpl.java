package client;

import model.Player;
import model.bet.Bet;
import model.card.Hand;

public class PlayerImpl implements Player {
	
	private String Id;
	private String Name;
	private int Points;

	public PlayerImpl(String Id, String Name, int Points) throws NullPointerException, IllegalArgumentException {
		this.Id = Id;
		this.Name = Name;
		this.Points = Points;
	}

	@Override
	public String getId() {
		return this.Id;
	}

	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public int getPoints() {
		return this.Points;
	}

	@Override
	public int getTotalPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void assignBet(Bet bet) {
		// TODO Auto-generated method stub

	}

	@Override
	public Bet getBet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hand getHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyBetResult(Hand houseHand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub

	}

}
