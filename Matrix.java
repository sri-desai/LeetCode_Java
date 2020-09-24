
public class Matrix 
{
	static int[][] numberOfPaths;

    static boolean isValid(int m, int n)
    {
        return m >= 0 && n < numberOfPaths.length && n >= 0 && n < numberOfPaths[0].length;
    }
     
     static void getNumberOfPaths(int[][] arr, int m, int n)
     {         
         if(m == 0 && n == 0)
         {
             numberOfPaths[m][n] = 1;
             
             return;
         }
         
         if(arr[m][n] == 0)
         {
             numberOfPaths[m][n] = 0;
             
             return;
         }
         
         if(isValid(m - 1, n) && arr[m - 1][n] == 1)
         {
             if(numberOfPaths[m - 1][n] != -1)
             {
                numberOfPaths[m][n] = numberOfPaths[m][n] == -1 ? numberOfPaths[m - 1][n] : numberOfPaths[m][n] + numberOfPaths[m - 1][n];
             }
             else
             {
                 getNumberOfPaths(arr, m - 1, n);
                 
                 numberOfPaths[m][n] = numberOfPaths[m][n] == -1 ? numberOfPaths[m - 1][n] : numberOfPaths[m][n] + numberOfPaths[m - 1][n];
             }
         }
         
         if(isValid(m, n - 1) && arr[m][n - 1] == 1)
         {
             if(numberOfPaths[m][n - 1] != -1)
             {
                numberOfPaths[m][n] = numberOfPaths[m][n] == -1 ? numberOfPaths[m][n - 1] : numberOfPaths[m][n] + numberOfPaths[m][n - 1];
             }
             else
             {
                 getNumberOfPaths(arr, m, n - 1);
                 
                 numberOfPaths[m][n] = numberOfPaths[m][n] == -1 ? numberOfPaths[m][n - 1] : numberOfPaths[m][n] + numberOfPaths[m][n - 1];
             }
         }
         
         if(numberOfPaths[m][n] == -1) numberOfPaths[m][n] = 0;
         
     }
     
     public static void main(String[] args)
     {
    	 int[][] a = {{1, 1, 1, 1},
    			 		   {1, 1, 1, 1},
    			 		   {1, 1, 1, 1},
    			 		   {1, 1, 1, 1}
    			          };
    	 
    	 int m = a.length;
         
         int n = a[0].length;
         
         numberOfPaths = new int[m][n];
         
         for(int i = 0; i < m; ++i)
             for(int j = 0; j < n; ++j)
             numberOfPaths[i][j] = -1;
             
         getNumberOfPaths(a, m - 1, n - 1);
         
         
         System.out.println(numberOfPaths[m - 1][n - 1]);
     }
}
