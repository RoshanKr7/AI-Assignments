import java.io.*;
import java.util.*;

public class Start {

	
		public static void main(String[] args) {
			
			Scanner scanner;
			try {
				scanner = new Scanner(new File("input1.txt"));
				
				int no_City = scanner.nextInt();;
				int [][] cost = new int[no_City][no_City];
				
				for(int i = 0; i < no_City; i++)
					for(int j = 0; j < no_City && scanner.hasNextInt(); j++){
						int nxtInt = scanner.nextInt();
						if(nxtInt < 0)							//not connected
							cost[i][j] = Integer.MAX_VALUE;
						else
							cost[i][j] = nxtInt;
					}
			/*	for(int i=0;i< no_City;i++ )							//to verify input
				{
					for(int j=0;j< no_City; j++)
						System.out.println(i + " " + j + " " + cost[i][j]);
					System.out.println();
				}*/
					   
				
				AstarAlgo astar = new AstarAlgo(cost, no_City, 0);
				System.out.println("Using A* Search:");
				astar.printPath();
				System.out.println();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

	}

}
