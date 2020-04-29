
public class Card {
	
	private int value;
	private String rank;
	private String suit;
	private String rankAndSuit;
//	private String cardPicName;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getRankandSuit() {
		return rankAndSuit;
	}
	public void setRankAndSuit(String rankAndSuit) {
		this.rankAndSuit = rankAndSuit;
	}
	
//	public void setCardPicName(String rankAndSuit) {
//		cardPicName = rankAndSuit.toLowerCase() + ".gif";
//	}
	
}
