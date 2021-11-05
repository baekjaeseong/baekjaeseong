import java.util.*;
class Main{
	static int N,M,goal;
	static int[][] Ti;
	static int[] min;
	static int[][] TTi;
	static void solve(int number_of_per,boolean[] visit,int go,int sum,int start){
		//System.out.println(sum);
		if(TTi[number_of_per][go]>0&& number_of_per!=go&&visit[go]==false){
			solve(go,visit,go,sum+TTi[number_of_per][go],start);
		}
		if(number_of_per == go){
			if(start==go){
				if(sum<min[start])
					min[start] = sum;
				return;
			}
			else
			{
				boolean[] visi = new boolean[N+1];
				solve(number_of_per,visi,start,sum,start);
			}
		}
		
		for(int i =1; i<N+1;i++){
			if(visit[i]==false)
			{
				if(Ti[number_of_per][i]>0)
				{
//					System.out.println(number_of_per+" "+i);
					visit[number_of_per] = true;
					solve(i,visit,go,sum+Ti[number_of_per][i],start);
					visit[number_of_per] = false;
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		goal = sc.nextInt();
		Ti = new int[N+1][N+1];
		TTi = new int[N+1][N+1];
		for(int i = 0; i<M;i++){
			int y = sc.nextInt();
			int x = sc.nextInt();
			Ti[y][x] = sc.nextInt();
			
		}
		
		boolean[] visit;
		min = new int[N+1];
		int sum = 0;
		for(int i = 1; i<N+1;i++)
		{	
			visit = new boolean[N+1];
			min[i] = 999999999;
			solve(i,visit,goal,sum,i);
			TTi[i][goal] = min[i];	
		}
		int max = 0;
		for(int i = 1;i<N+1;i++){
			
		//	System.out.println(min[i]);
			if(max<min[i])
				max = min[i];
		}
		System.out.println(max);
	}
}

