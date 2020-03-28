import java.io.*;
import java.util.*;

public class Genetics {
	
	public static int pop = 4;
	
	public static void main(String[] args) throws FileNotFoundException {
		int n,c;
		Scanner sc = new Scanner(new File("input1.txt"));
		Random rand= new Random();
		n=sc.nextInt();
		c=sc.nextInt();
		int[] a= new int[n];
		int[][] r= new int[pop][c];
		
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		for(int i=0;i<pop;i++)
			for(int j=0;j<c;j++)
				r[i][j]=sc.nextInt();
		
		int[] bestp=new int[c];
		int bestf=Integer.MAX_VALUE;
		
		Fitness ft= new Fitness();
		int [] f=new int[pop];
	
		
		int[] sel= new int[pop];
		for(int i=0;i<pop;i++)
		{
			sel[i]=i;
		}
		
		int[][] parent= new int[pop][c];
		int round=(pop*(pop+1))/2;
		
		int t=500;
		while(t-->0)
		{
			for(int i=0;i<pop;i++)
			{
				f[i]=ft.fitness(a, r[i]);
				if(f[i]<bestf)
				{
					for(int j=0;j<c;j++)
						bestp[j]=r[i][j];
					bestf=f[i];
				}
			}
			
			for(int i=0;i<pop-1;i++)			//Selection
				for(int j=1;j<pop;j++)
				{
					if(f[sel[i]]>f[sel[j]])
					{
						int tp=sel[i];
						sel[i]=sel[j];
						sel[j]=tp;
					}
				}
			for(int i=0;i<pop;i++)
			{
				int rmd=rand.nextInt(round)+1;
				int t1=(int)Math.sqrt(2*rmd);
				t1=(2*rmd)-t1;
				t1=(int)Math.sqrt(t1)-1;
				for(int j=0;j<c;j++)
					parent[i][j]=r[t1][j];
			}
			
			for(int i=0;i<pop;i+=2)				//CrossOver
			{
				int rmd=rand.nextInt(c);
				for(int j=0;j<rmd;j++)
				{
					r[i][j]=parent[i][j];
					r[i+1][j]=parent[i+1][j];
				}
				for(int j=rmd;j<c;j++)
				{
					r[i][j]=parent[i][j];
					r[i+1][j]=parent[i+1][j];
				}
			}
			
			for(int i=0;i<pop;i++)				//Mutation
			{
				int rmd=rand.nextInt(c);
				int mut=rand.nextInt(n);
				r[i][rmd]=a[mut];
			}
			
		}
		for(int i=0;i<c;i++)
		{
			System.out.print(bestp[i] + " ");
		}

	}

}
