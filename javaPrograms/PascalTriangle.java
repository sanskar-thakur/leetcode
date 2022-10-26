import java.util.*;
import java.lang.Math;

class PascalTriangle{

	static int[][] dp;
    
    public static void init(){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
    }
    
    public static void print2Darray(int[][] arr){
    	for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }

	public static int compute(int i, int j){
		if(j < 0 || j > i) return 0;
		if(i == 0 && j == 0) return 1;
		if(dp[i][j] == -1){
			dp[i][j] = compute(i-1,j-1) + compute(i-1,j);
		}
		return dp[i][j];
        /*if(dp[i-1][j-1] == -1){
            if(dp[i-1][j] == -1){
                dp[i][j] = compute(i-1,j-1) + compute(i-1,j);
            }
            else{
                dp[i][j] = compute(i-1,j-1) + dp[i-1][j];
            }
        }
        else{
            if(dp[i-1][j] == -1){
                dp[i][j] = dp[i-1][j-1] + compute(i-1,j);    
            }            
            else{
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];    
            }
        }                        
        return dp[i][j];*/
		//return compute(i-1,j-1) + compute(i-1,j);
	}

	public static void main(String[] args){
		System.out.println("Pascals's triangle");
		//System.out.println(compute(3,3));
		int rowIndex = 1;
		dp = new int[rowIndex+1][rowIndex+1];
		init();
		print2Darray(dp);
		List<Integer> result = new ArrayList<Integer>();
        int j = 0;
        while(j <= rowIndex){
            int element = compute(rowIndex, j);
            result.add(element);
            j++;
        }
		for(Integer item : result){
			System.out.println(item);
		}
	}
}
