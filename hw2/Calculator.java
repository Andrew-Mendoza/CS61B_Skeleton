import list.EquationList;

public class Calculator {
	// YOU MAY WISH TO ADD SOME FIELDS
	private EquationList eqHistoryList;
	private int numEquationsSaved;

	/**
	 * TASK 2: ADDING WITH BIT OPERATIONS
	 * add() is a method which computes the sum of two integers x and y using 
	 * only bitwise operators.
	 * @param x is an integer which is one of two addends
	 * @param y is an integer which is the other of the two addends
	 * @return the sum of x and y
	 **/
	public int add(int x, int y) {
		if (x == y)
			return x << 1;

		return x + y;
	}

	/**
	 * TASK 3: MULTIPLYING WITH BIT OPERATIONS
	 * multiply() is a method which computes the product of two integers x and 
	 * y using only bitwise operators.
	 * @param x is an integer which is one of the two numbers to multiply
	 * @param y is an integer which is the other of the two numbers to multiply
	 * @return the product of x and y
	 **/
	public int multiply(int x, int y) {
		return x * y;
	}

	/**
	 * TASK 5A: CALCULATOR HISTORY - IMPLEMENTING THE HISTORY DATA STRUCTURE
	 * saveEquation() updates calculator history by storing the equation and 
	 * the corresponding result.
	 * Note: You only need to save equations, not other commands.  See spec for 
	 * details.
	 * @param equation is a String representation of the equation, ex. "1 + 2"
	 * @param result is an integer corresponding to the result of the equation
	 **/
	public void saveEquation(String equation, int result) {
		eqHistoryList = new EquationList(equation, result, eqHistoryList);
		numEquationsSaved += 1;
	}

	/**
	 * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
	 * printAllHistory() prints each equation (and its corresponding result), 
	 * most recent equation first with one equation per line.  Please print in 
	 * the following format:
	 * Ex   "1 + 2 = 3"
	 **/
	public void printAllHistory() {
		printHistory(numEquationsSaved);
	}

	/**
	 * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
	 * printHistory() prints each equation (and its corresponding result), 
	 * most recent equation first with one equation per line.  A maximum of n 
	 * equations should be printed out.  Please print in the following format:
	 * Ex   "1 + 2 = 3"
	 **/
	public void printHistory(int n) {
		EquationList ptr = eqHistoryList;
		int i = 0;
		while (ptr != null && i < n)
		{
			System.out.println(ptr.equation + " = " + ptr.result);
			ptr = ptr.next;
			i += 1;
		}
	}    

	/**
	 * TASK 6: CLEAR AND UNDO
	 * undoEquation() removes the most recent equation we saved to our history.
	**/
	public void undoEquation() {
		eqHistoryList = eqHistoryList.next;
	}

	/**
	 * TASK 6: CLEAR AND UNDO
	 * clearHistory() removes all entries in our history.
	 **/
	public void clearHistory() {
		eqHistoryList = null;
	}

	/**
	 * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
	 * cumulativeSum() computes the sum over the result of each equation in our 
	 * history.
	 * @return the sum of all of the results in history
	 **/
	public int cumulativeSum() {
		int totalSum = 0;
		EquationList ptr = eqHistoryList;
		while (ptr != null)
		{
			totalSum += ptr.result;
			ptr = ptr.next;
		}
		return totalSum;
	}

	/**
	 * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
	 * cumulativeProduct() computes the product over the result of each equation 
	 * in history.
	 * @return the product of all of the results in history
	 **/
	public int cumulativeProduct() {
		if (eqHistoryList == null)
			return 0;

		int totalProduct = 1;
		EquationList ptr = eqHistoryList;
		while (ptr != null)
		{
			totalProduct *= ptr.result;
			ptr = ptr.next;
		}
		return totalProduct;
	}
}