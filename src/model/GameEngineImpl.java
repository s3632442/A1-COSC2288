package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import model.bet.Bet;
import model.bet.ScoreBetImpl;
import model.bet.SuitBetImpl;
import model.card.Suit;
import view.ConsoleLoggerCallback;
import view.GameCallback;
import view.GameCallbackCollection;

public class GameEngineImpl implements GameEngine, GameCallbackCollection {

	private Set<Player> players = new HashSet<>();
	private ArrayList<Bet> bets = new ArrayList<>();

	public GameEngineImpl() {
		// TODO Auto-generated method stub
	}

	@Override
	public void registerCallback(GameCallback callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCallback(GameCallback callback) {
		// TODO Auto-generated method stub
	}

	@Override
	// ATTN - check exception implementation
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException {
		try {
			
			players.add(player);
			ConsoleLoggerCallback.LOGGER.info(player.toString());
		} catch (NullPointerException e) {
			System.out.println("ATTN - player parameter is null");
		} catch (IllegalArgumentException e) {
			System.out.println("ATTN - player supplied already exists");
		}
		
	}

	@Override
	// ATTN - check exception implementation
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException {
		try {

			if (searchPlayerById(playerId) != null) {
				players.remove(searchPlayerById(playerId));
			}
		} catch (NullPointerException e) {
			System.out.println("ATTN - supplied player id is null");
		} catch (IllegalArgumentException e) {
			System.out.println("ATTN - no player with that Id");
		}

	}

	private Object searchPlayerById(String playerId) {
		for (Player player : players) {
			if (player.getId().equals(playerId)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players;
	}

	@Override
	// ATTN - check exception implementation
	public void placeBet(String playerId, int amount) throws NullPointerException, IllegalArgumentException {
		try {
			Player player = (Player) searchPlayerById(playerId);
			if (player != null) {
				if (bets.size() < 1) {
					bets.add(new ScoreBetImpl(player, amount));
				} else {
					for (int i = bets.size() - 1; i >= 0; i--) {
						Bet bet = bets.get(i);
						if (bet.getAmount() < amount) {
							bets.add(i, new ScoreBetImpl(player, amount));
						}
					}
				}
			} else {

			}

		} catch (NullPointerException e) {
			System.out.println("ATTN - playerId or Suit Param are null");
		} catch (IllegalArgumentException e) {
			System.out.println("ATTN - 付here is no current player with the supplied playerId \r\n"
					+ "付he supplied amount is not a positive number \r\n"
					+ "付he supplied player is does not have enough points toplace the bet \r\n"
					+ "品f, when replacing an existing bet, the bet amount is notgreater the existing bet\r\n");
		}

	}

	@Override
	// ATTN - check exception implementation
	public void placeBet(String playerId, int amount, Suit suit) throws NullPointerException, IllegalArgumentException {
		try {
			Player player = (Player) searchPlayerById(playerId);
			if (player != null) {
				if (bets.size() < 1) {
					bets.add(new SuitBetImpl(player, amount, suit));
				} else {
					for (int i = bets.size() - 1; i >= 0; i--) {
						Bet bet = bets.get(i);
						if (bet.getAmount() < amount) {
							bets.add(i, new SuitBetImpl(player, amount, suit));
						}

					}
				}
			} else {

			}

		} catch (NullPointerException e) {
			System.out.println("ATTN - playerId or Suit Param are null");
		} catch (IllegalArgumentException e) {
			System.out.println("ATTN - 付here is no current player with the supplied playerId \r\n"
					+ "付he supplied amount is not a positive number \r\n"
					+ "付he supplied player is does not have enough points toplace the bet \r\n"
					+ "品f, when replacing an existing bet, the bet amount is notgreater the existing bet\r\n");
		}

	}

	@Override
	public void dealPlayer(String playerId, int delay)
			throws NullPointerException, IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetAllBetsAndHands() {
		// TODO Auto-generated method stub

	}

}
