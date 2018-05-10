
import java.util.*;
/**
*All one needs to know to solve the challenge is that the center of the 3x3 magic square is always 5 
* and the corners are always an even number. Knowing this, a person can generate an iteration through 
* all possible 8 variants of the 3x3 magic square without the need of creating in advance lists, double arrays 
* or whatever with the eight possible 3x3 magic squares.
*/

public class Solution {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int[][] grid = new int[3][3];

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				grid[row][column] = reader.nextInt();
			}
		}
		System.out.println(getResults(grid));
	}

	public static int getResults(int[][] grid) {
		TreeSet<Integer> listOfAbsoluteSums = new TreeSet<Integer>();
		for (int i = 2; i <= 8; i += 2) {
			LinkedList<Integer> corners = new LinkedList<Integer>();
			for (int j = 2; j <= 8; j += 2) {
				corners.add(j);
			}
			int absoluteSum = 0;
			int upperLeft = i;
			int lowerRight = (15 - 5 - i);
			absoluteSum += Math.abs(grid[1][1] - 5);
			absoluteSum += Math.abs(grid[0][0] - upperLeft);
			absoluteSum += Math.abs(grid[2][2] - lowerRight);
			corners.remove(corners.indexOf(upperLeft));
			corners.remove(corners.indexOf(lowerRight));

			int interimSumFirstVariant = 0;
			int upperRight = corners.get(0);
			int lowerLeft = corners.get(1);
			interimSumFirstVariant += Math.abs(grid[0][2] - upperRight);
			interimSumFirstVariant += Math.abs(grid[2][0] - lowerLeft);
			interimSumFirstVariant += Math.abs(grid[0][1] - (15 - upperLeft - upperRight));
			interimSumFirstVariant += Math.abs(grid[2][1] - (15 - lowerLeft - lowerRight));
			interimSumFirstVariant += Math.abs(grid[1][0] - (15 - upperLeft - lowerLeft));
			interimSumFirstVariant += Math.abs(grid[1][2] - (15 - lowerRight - upperRight));
			interimSumFirstVariant += absoluteSum;
			listOfAbsoluteSums.add(interimSumFirstVariant);

			int interimSumSecondVariant = 0;
			upperRight = corners.get(1);
			lowerLeft = corners.get(0);
			interimSumSecondVariant += Math.abs(grid[0][2] - upperRight);
			interimSumSecondVariant += Math.abs(grid[2][0] - lowerLeft);
			interimSumSecondVariant += Math.abs(grid[0][1] - (15 - upperLeft - upperRight));
			interimSumSecondVariant += Math.abs(grid[2][1] - (15 - lowerLeft - lowerRight));
			interimSumSecondVariant += Math.abs(grid[1][0] - (15 - upperLeft - lowerLeft));
			interimSumSecondVariant += Math.abs(grid[1][2] - (15 - lowerRight - upperRight));
			interimSumSecondVariant += absoluteSum;
			listOfAbsoluteSums.add(interimSumSecondVariant);
		}

		int minimun = listOfAbsoluteSums.pollFirst();
		return minimun;
	}
}
