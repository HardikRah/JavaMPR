public class WeightedQuickUnionUF
{
	private int id[];
	private int sz[];
	public WeightedQuickUnionUF(int n)
	{
		id = new int[n];
		sz= new int [n];
		for(int i=0;i<n;i++)
		{
			id[i]=i;
			sz[i]=1;
		}
	}
	public void union(int m,int n)
	{
		int i=root(m);
		int j=root(n);
		if (i==j)
			return;
		else if(sz[i]<sz[j])
		{
			id[i]=j;
			sz[j]+=sz[i];
		}
		else
		{
			id[j]=i;
			sz[i]+=sz[j];
		}
	}
	private int root(int i)
	{
		while(i!=id[i])
		{
			id[i]=id[id[i]];
			i=id[i];
		}
		return i;
	}
	public boolean connected(int m,int n)
	{
		return(root(m)==root(n));
	}
}
/*class Test
{
	public static void main(String [] args)
	{
		int n=10;
		WeightedQuickUnion wqu = new WeightedQuickUnion(n);
		wqu.union(7,4);
		wqu.union(9,5);
		wqu.union(9,4);
		wqu.union(5,3);
		wqu.union(8,9);
		wqu.union(8,2);
		System.out.println(wqu.connected(7,8));
		System.out.println(wqu.connected(7,2));
		System.out.println(wqu.connected(0,7));
	}
}*/