import java.util.*;
class Main{
	static int N,M;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] person = new int[N+1][M+1];
		int a = sc.nextInt();
		int[] liar;
		int[] k = new int[M+1];
		boolean[] visit = new boolean[M+1];
		boolean[] check = new boolean[N+1];
		int[][] z = new int[M][N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		if(a!=0){
			liar = new int[a];
			for(int j = 0 ;j<a;j++){
				liar[j] = sc.nextInt();
				q.add(liar[j]);
				check[liar[j]] = true;
			}
			for(int i = 0 ; i<M;i++){
				k[i] = sc.nextInt();
				for(int j = 0 ; j<k[i];j++){
					z[i][j] = sc.nextInt();
					person[z[i][j]][i] = 1;
				}
			}
		}
		if(a!=0){
			while(!q.isEmpty()){
				int pe = q.poll();
				//System.out.println(pe);
				for(int i = 0;i<M;i++){
					if(person[pe][i]==1){
						visit[i] = true;
//						System.out.println(visit[i]);
						for(int j = 0 ; j<k[i];j++){
							if(check[z[i][j]]==false){
								check[z[i][j]] = true;
								q.add(z[i][j]);
							}
						}
					}
				
				}
			}
			
		}
		int sum = M;
//		System.out.println(sum);
		for(int i = 0 ; i<M;i++){
			if(visit[i]==true){
				sum--;
			}
		}
		System.out.println(sum);
	

	}
}

