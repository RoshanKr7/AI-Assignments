import java.math.*;
public class Fitness {
	
	int fitness(int [] a, int[] r)
	{
		int f=0,d,d1;
		int close;
		int n=a.length,c=r.length;
		
		for(int i=0;i<n;i++)
		{
			close=0;
			d1=Math.abs(a[i]-r[0]);
			for(int j=1;j<c;j++)
			{
				d=Math.abs(a[i]-r[j]);
				if(d<d1)
				{
					close=j;
					d1=d;
				}
			}
			f+=(d1*d1);
		}		
		return f;
	}

}
