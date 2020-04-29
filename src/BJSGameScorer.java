/**
 * The purpose of this class is to score the game. 
 * @author myThinkTank
 *
 */
public class BJSGameScorer {
	
	/**
	 * This function is a helper that is used to check for an ACE card
	 * If the total is above 21, and the aceCount is > 0, the ACE value
	 * is changed to 1, and the process repeats until there are no more 
	 * ACEs, or the total is <= 21, whichever comes first.
	 * @param rowColTotal
	 * @param aceCount
	 * @return
	 */
	private int aceModifier(int rowColTotal, int aceCount) {
		if (rowColTotal > 21){
			while((rowColTotal > 21) && (aceCount > 0)){
				rowColTotal = rowColTotal - 10;
			  		aceCount--;
			}
		}
		return rowColTotal;
	}
	
	/**
	 * This function is a helper that counts the number of ACEs in the
	 * column elements that will be totaled.
	 * @param val1
	 * @param val2
	 * @param val3
	 * @param val4
	 * @return
	 */
	private int colAceCounter(int val1, int val2, int val3, int val4) {
		int aceCount = 0;
		int[] vals = {val1, val2, val3, val4};
		for (int element: vals) {
			if (element == 11) {
				aceCount++;
			}
		}
		return aceCount;
	}
	
	
	/**
	 * This function totals the points for
	 * the rows, then the columns, and lastly
	 * it sums all of them up to present the user 
	 * with a final score.
	 * @param grid
	 */
	public int totalPoints(Card[][] grid) {
		int aceCount = 0;
		int gameTotal = 0;
		int[] finalTotal = new int[9];
		int rowTotal = 0;
		int row1Total = 0;
		int row2Total = 0;
		int row3Total = 0;
		int row4Total = 0;
		int col1Total = 0;
		int col2Total = 0;
		int col3Total = 0;
		int col4Total = 0;
		int col5Total = 0;
		int[] row1 = new int[5];
		int[] row2 = new int[5];
		int[] row3 = new int[5];
		int[] row4 = new int[5];
		
		
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				if(i < 2) {
					if(i == 0) {
						row1[j] = grid[i][j].getValue();
					}
					if(i == 1) {
						row2[j] = grid[i][j].getValue();
					}
				}
				if(i == 2) {
					if(j < 3) {
						row3[j] = grid[i][j].getValue();
					}else {
						row4[j-3] = grid[i][j].getValue();
					}
				}
				if(i == 3) {
					if(j == 0) {
						row4[j+2] = grid[i][j].getValue();
					}
				}
				Card currentCard = grid[i][j];
				rowTotal = rowTotal + currentCard.getValue();
			}
		}
		
		/*
		 * To handle the ACE Card, the approach will be to 
		 * 1. total all of the rows and columns.
		 * 2. Iterate back through, or on the first iteration, create a counter to keep track of any ACEs.
		 * 3. If the counter is not 0 in the end, and the total is higher than 21 then change then 
		 *    mulitply 10 * the counter value and subtract it from the total. This will both remove the 11 value and add a 1.
		 * 4. Maybe even remove 1 first, then check the score to see if it is above 21, then remove each additional one in succession until you get under 21.
		 * 5. Ok, so the final logic is:
		 * 	count = number of 11s in row.
		 * 	After the total is completed:
		 * 	if (total > 21){
		 * 		while((total > 21) && (count > 0)){
		 * 			total = total - 10;
		 * 			count--;
		 * 		}
		 * 	}	
		 */
		
		for(int element: row1) {
			if(element == 11) {
				aceCount++;
			}
			row1Total = row1Total + element;
		}
		row1Total = aceModifier(row1Total, aceCount);
		finalTotal[0] = row1Total;
		aceCount = 0;
//		System.out.println("Row 1 Total: "+row1Total);
		
		for(int element: row2) {
//			System.out.println("Row 2 Element: " + element);
			if(element == 11) {
				aceCount++;
			}
			row2Total = row2Total + element;
		}
//		System.out.println("Row2 Ace Count: " + aceCount);
		row2Total = aceModifier(row2Total, aceCount);
		finalTotal[1] = row2Total;
		aceCount = 0;
//		System.out.println("Row 2 Total: "+row2Total);
		
		for(int element: row3) {
			
			if(element == 11) {
				aceCount++;
			}
			row3Total = row3Total + element;
		}
		
		row3Total = aceModifier(row3Total, aceCount);
		finalTotal[2] = row3Total;
		aceCount = 0;
//		System.out.println("Row 3 Total: "+row3Total);
		
		for(int element: row4) {
			if(element == 11) {
				aceCount++;
			}
			row4Total = row4Total + element;
		}
		row4Total = aceModifier(row4Total, aceCount);
		finalTotal[3] = row4Total;
		aceCount = 0;
//		System.out.println("Row 4 Total: "+row4Total);
		col1Total = row1[0] + row2[0];
		aceCount = colAceCounter(row1[0], row2[0], 0, 0);
		col1Total = aceModifier(col1Total, aceCount);
		finalTotal[4] = col1Total;
		aceCount = 0;
//		System.out.println("Col 1 Total: "+col1Total);
		col2Total = row1[1] + row2[1] + row3[0] + row4[0];
		aceCount = colAceCounter(row1[1], row2[1], row3[0], row4[0]);
		col2Total = aceModifier(col2Total, aceCount);
		finalTotal[5] = col2Total;
		aceCount = 0;
//		System.out.println("Col 2 Total: "+col2Total);
		col3Total = row1[2] + row2[2] + row3[1] + row4[1];
		aceCount = colAceCounter(row1[2], row2[2], row3[1], row4[1]);
		col3Total = aceModifier(col3Total, aceCount);
		finalTotal[6] = col3Total;
		aceCount = 0;
//		System.out.println("Col 3 Total: "+col3Total);
		col4Total = row1[3] + row2[3] + row3[2] + row4[2];
		aceCount = colAceCounter(row1[3], row2[3], row3[2], row4[2]);
		col4Total = aceModifier(col4Total, aceCount);
		finalTotal[7] = col4Total;
		aceCount = 0;
//		System.out.println("Col 4 Total: "+col4Total);
		col5Total = row1[4] + row2[4];
		aceCount = colAceCounter(row1[4], row2[4], 0, 0);
		col5Total = aceModifier(col5Total, aceCount);
		finalTotal[8] = col5Total;
		aceCount = 0;
//		System.out.println("Col 5 Total: "+col5Total);
		
		for (int i = 0; i < 9; i++) {
			if (((i == 4) || (i == 8)) && (finalTotal[i] == 21)) {
				gameTotal = gameTotal + 10;
				continue;
			}
			if (finalTotal[i] <= 16) {
				gameTotal = gameTotal + 1;
				continue;
			}
			if (finalTotal[i] > 21) {
				gameTotal = gameTotal + 0;
				continue;
			}
			if (finalTotal[i] == 21) {
				gameTotal = gameTotal + 7;
				continue;
			}
			if (finalTotal[i] == 20) {
				gameTotal = gameTotal + 5;
				continue;
			}
			if (finalTotal[i] == 19) {
				gameTotal = gameTotal + 4;
				continue;
			}
			if (finalTotal[i] == 18) {
				gameTotal = gameTotal + 3;
				continue;
			}
			if (finalTotal[i] == 17) {
				gameTotal = gameTotal + 2;
				continue;
			}
		}
		return gameTotal;
	}

}
