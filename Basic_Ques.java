public class Basic_Ques{
    
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         int[] arr = new int[n + 1];
         int n = Integer.parseInt(br.readLine());
         int[][] arr2=new int[n][m];
        //  System.out.println(fibonacciMemo(n, arr));
        //climStairdp(n);
        //climStairVariableJump(arr);
        //climbStairMinJumps(arr);  
        //minCostMazeTraversal(arr2,n,m);  
        //goldMine(arr2,n,m);
    }
    //fibonacci_Memoization
    public static int fibonacciMemo(int n , int[] dp){
        if(n==0||n==1){
            return n;
        }
        if(dp[n]!=0) return dp[n];
        int fib1=fibonacciMemo(n-1,dp);
        int fib2=fibonacciMemo(n-2,dp);
        int fib=fib1+fib2;
        dp[n]=fib;
        return fib;
    }
    //ClimStair Dp
    public static int climStairdp(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1) {
                dp[i]=dp[i-1];
            }
            else if(i==2){
                dp[i]+=dp[i-1]+dp[i-2];
            }
            else{
                dp[i]+=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
    //climStair Vairable Jumps DP
    public static void climStairVariableJump(int[] arr){
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>0){
            for(int j=1;j<=arr[i]&&i+j<dp.length;j++){
                dp[i]+=dp[i+j];
            }
            }
        }
        System.out.println(dp[0]);
    }
    //climbStairMinJumps
    public static void climbStairMinJumps(int[] arr){
    dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>0){
                int min=(int)1e8;
                for(int j=1;j<=arr[i]&&i+j<dp.length;j++){
                if(dp[i+j]!=null) 
                    { min=Math.min(min,dp[i+j]);}
                }
                if(min!=(int)1e8){
                    dp[i]=min+1;
                }
            }
        }
        System.out.println(dp[0]);
        
    }
    
    //minCostMazeTraversal
    public static void minCostMazeTraversal(int arr, int n, int m)// n=row,m=col;
    {int[][] dp=new int[n][m];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1&&j==dp[0].length-1){
                    dp[i][j]=arr[i][j];
                }
                else if(i==dp.length-1){
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                else if(j==dp[0].length-1){
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i][j+1],dp[i+1][j])+arr[i][j];
                }
            }
        }
       System.out.println(dp[0][0]);
    }
    
    //GoldMine
    public static void goldMine(int[][] arr, int n, int m){
    int[][] dp = new int[n][m];
        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + arr[i][j];
                } else if (i == arr.length - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + arr[i][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        int max = dp[0][0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i][0]);
        }
        System.out.println(max);
    }
}