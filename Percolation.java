import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.*;
public class Percolation
{
    private int n;
    private int grid [];
    private boolean gridbool[];
    private int open;
    private int gridsize;
    //private final int top,bottom;
    private WeightedQuickUnionUF wqu;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n1)
    {
      int n = n1;
      int open=0;
      this.gridsize = n*n;
      this.grid = new int [gridsize+2];
      this.gridbool = new boolean[gridsize];
      this.wqu = new WeightedQuickUnionUF(gridsize+2);
      for(int i=0;i<grid.length;i++)
          grid[i]=i;
        int i;
        for(i = 1; i<=n; i++)
      {
          wqu.union(grid[i],grid[0]);
          wqu.union(grid[(n*(n-1))+i],grid[(n*n) + 1]);
      }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if(row==1)
        {
            if(col==1)
            {
                if(isOpen(row,col+1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col+1)]);
                if(isOpen(row+1,col))
                    wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+col]);
            }
            else if(col==n)
            {
                if(isOpen(row+1,col))
                    wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+col]);
                if(isOpen(row,col-1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+(col-1)]);
            }
            else
            {
                if(isOpen(row,col+1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col+1)]);
                if(isOpen(row+1,col))
                    wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+col]);
                if(isOpen(row,col-1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+(col-1)]);
            }

        }
        else if(row==n)
        {
            if(col==1)
            {
                if(isOpen(row,col+1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col+1)]);
                if(isOpen(row-1,col))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-2)*n)+col]);
            }
            else if(col==n)
            {
                if(isOpen(row-1,col))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-2)*n)+col]);
                if(isOpen(row,col-1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col-1)]);
            }
            else
            {
                if(isOpen(row,col+1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col+1)]);
                if(isOpen(row-1,col))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-2)*n)+col]);
                if(isOpen(row,col-1))
                    wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col-1)]);
            }

        }
        else if(col==1)
        {
            if(isOpen(row+1,col))
                wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+col]);
            if(isOpen(row-1,col))
                wqu.union(grid[((row-1)*n)+col],grid[((row-2)*n)+col]);
            if(isOpen(row,col+1))
                wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col+1)]);
        }
        else if(col==n)
        {
            if(isOpen(row+1,col))
                wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+col]);
            if(isOpen(row-1,col))
                wqu.union(grid[((row-1)*n)+col],grid[((row-2)*n)+col]);
            if(isOpen(row,col-1))
                wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col-1)]);
        }
        else
        {
            if(isOpen(row+1,col))
                wqu.union(grid[((row-1)*n)+col],grid[((row)*n)+col]);
            if(isOpen(row-1,col))
                wqu.union(grid[((row-1)*n)+col],grid[((row-2)*n)+col]);
            if(isOpen(row,col-1))
                wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col-1)]);
            if(isOpen(row,col+1))
                wqu.union(grid[((row-1)*n)+col],grid[((row-1)*n)+(col+1)]);
        }
        gridbool[((row - 1) * n) + (col-1)]= true;
        open++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        return (gridbool[((row - 1) * n) + (col - 1)]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        return (!gridbool[(row - 1) * n + (col - 1)] && wqu.connected(grid[((row-1)*n)+col],grid[0]));
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return open;
    }
    // does the system percolate?
    public boolean percolates()
    {
        return wqu.connected(grid[0],grid[(n*n)+1]);
    }

    // test client (optional)
    //public static void main(String[] args)
}