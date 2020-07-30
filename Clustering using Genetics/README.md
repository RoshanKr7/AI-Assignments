# How to Compile

Can be open using any java IDE and compile Genetics.java file.
Input can be given through Input1 file.


# Input Format

The First line contains No. of Students(n) and No. of Clusters(m)
Next line will contain marks of each student.
Then, next 4 line will contain m numbers in each line.
Any number can be there from students marks as cluster center of the respective cluster.


# Output

Contains 'm' numbers as the cluster centers of their respective cluster.

# Note

To get the clusters as output add the code mentioned below in the main function of Genetics Class:

--------------------------------------------------------------------------------------------------
ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
	
for(int i=0;i<c;i++) {

	output.add(new ArrayList<Integer>());
}

for(int i=0;i<n;i++)
{

	int close=0;
	int d1=Math.abs(a[i]-bestp[0]);
	for(int j=1;j<c;j++)
	{
		int d=Math.abs(a[i]-bestp[j]);
		if(d<d1)
		{
			close=j;
			d1=d;
		}
	}
	output.get(close).add(a[i]);
}

for(int i=0;i<c;i++) {

	System.out.print("Cluster "+(i+1)+ " : " + output.get(i) + "\n");
}

--------------------------------------------------------------------------------------------------
