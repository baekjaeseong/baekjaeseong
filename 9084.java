import java.util.*;
class Main{
	static int ans ;
	static int[] dp ;
	static int[] value_of_coin;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int i = 0 ; i<test_case; i++){
			ans = 0;
			int number_of_coin = sc.nextInt();
			value_of_coin = new int[number_of_coin];
			
			for(int j = 0 ; j<number_of_coin;j++){
				value_of_coin[j] = sc.nextInt();
			}
			int goal = sc.nextInt();
			dp = new int[goal+1];
			for(int q = number_of_coin-1;q>=0;q--){
				if(value_of_coin[q]<=goal){
				dp[value_of_coin[q]] ++;
			for(int k = 0; k<=goal;k++){
					if((k-value_of_coin[q])>0){
					dp[k] =dp[k] +dp[k-value_of_coin[q]];
					//System.out.println("k = " + k +" dp[k] ="+dp[k] + " value_of_coin = "+value_of_coin[q]);

					}
				}
			}
			}
			System.out.println(dp[goal]);
		}
	}
}




