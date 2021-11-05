import java.util.*;
class Main{
	static int N,M;
	static int[][] map;
	static int[][] ans;
	static int min;
	static int R;
	static void find(int num,int y, int x,int rr){
		int yy = y;
		int xx = x;
		for(int i=0; i<rr;i++){
			if(y==(N-num-1)){
				if(x==(M-num-1))
					y--;
				else
					x++;
			}
			else if(y==num){
				if(x==num)
					y++;
				else
					x--;
			}
			else if(x==num)
			{
				y++;
			}
			else if(x==(M-1-num)){
				y--;
			}
		}
		ans[y][x] = map[yy][xx];

	}
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][M];
		for(int i = 0; i<N;i++){
			for(int j = 0; j<M;j++){
				map[i][j] = sc.nextInt();
			}
		}
		min = N>M?M:N;
		min++;
		min/=2;
		ans = new int[N][M];
		int nn= N; int mm = M;
		for(int i = 0; i<min;i++){
			int rr = R;
			int mi = (nn*2+mm*2)-4;
//			System.out.println(rr+" "+mi+ " "+min+ " "+i);
			while(rr>mi){
				rr-=mi;
			}
//			System.out.println(rr+" "+mi);
			for(int j = i; j<N-i;j++){
				for(int k = i; k<M-i;k++){
					if(j==i ||j==(N-1-i))
					find(i,j,k,rr);
					else if(k==i || k==(M-1-i))
					find(i,j,k,rr);
				}
			}
			nn-=2;
			mm-=2;
		}
		for(int i = 0; i<N;i++){
			for(int j = 0; j<M;j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
			
