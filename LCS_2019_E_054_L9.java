//2019e054
import java.util.*;

public class LCS_2019_E_054_L9 {	
	
	public static void main(String[] args)
		 {

		Scanner sc = new Scanner(System.in); 

		System.out.println("\tThe Longest Common Subsequence");

		System.out.print("\nEnter first string: "); //get the user input for first word
		
		String A = sc.nextLine();

		System.out.print("Enter second string: "); //get the user input for second word
		String B = sc.nextLine();

		int n = A.length();
		int m = B.length();

		//create a 2D array to store the values
		int table[][] = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			table[i][0] = 0;		//initialize the first column to 0
		}
		for (int j = 1; j < m + 1; j++) {
			table[0][j] = 0;		//initialize the first row to 0
		}

		for (int i = 1; i < n + 1; i++) 
		{
			for (int j = 1; j < m + 1; j++) 
			{
				if (A.charAt(i - 1) == B.charAt(j - 1)) 
				{
					//if the characters are equal, add 1 to the diagonal element
					table[i][j] = 1 + table[i - 1][j - 1];
				}	
				else if (table[i - 1][j] >= table[i][j - 1]) 
				{
				 //if the previous row is greater than the previous column, add the previous row
					table[i][j] = table[i - 1][j];
				}
				else 
				{
				//if the previous column is greater than the previous row, add the previous column
					table[i][j] = table[i][j - 1];
				}		
			}
		}

		int x = n, y = m;
		String s = "";
		
		
		while (x>0 && y > 0) 
		{
			if (A.charAt(x - 1) == B.charAt(y - 1)) 
			{
				//if the characters are equal, add the character to the string
				s = A.charAt(x - 1) + s;
				x--;
				y--;
			}
			else if (table[x - 1][y] >= table[x][y - 1]) 
			{
				//if the previous row is greater than or equal the previous column, decrease the row index
				x--;
			}
			else 
			{
				//if the previous column is greater than or equal the previous row, decrease the column index
				y--;
			}
		}
		
		//user print the longest common subsequence string
		System.out.print("\nThe Longest Common Subsequence is: ");
		System.out.println(s);		

	}

}
