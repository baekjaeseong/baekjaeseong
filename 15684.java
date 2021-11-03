import java.util.*;
class Main{
	static int N,M,H;
	static int[][] map;
	static int[] ans;
	static int[] arr;
	static int min;
	static int find(int num){
		if(min==0){
			return 0;
		}
		int x = 0 ;
		int y = num;
		while(x<H){
			if(map[y][x]==0) x++;
			else{
				y+=map[y][x];
				x++;
			}
		}
		if(y==num)
			return 1;
		else return 0;
	}
	static void visi_check(int num,int yy){
		if(min==0)
			return;
		int i = yy;
		for(int j = 0 ;j<H;j++){
			if(map[i][j]==0&&map[i+1][j]==0){
				map[i][j] = 1; map[i+1][j] = -1; arr[i] ++;
				recursive(num+1);
				map[i][j] = 0; map[i+1][j] = 0; arr[i] --;
			}
		}

	}
	static void recursive(int num){
		if(min==0)
			return;
		if(num>=min)
			return;
		int temp=0;
		if(num+1==min){
			for(int i = 0; i<N-1;i++){
				if(arr[i]%2!=0)
					return;
			}
		}
		if(num+1<min){
			for(int i = 0; i<N-1;i++){

				visi_check(num,i);

			}
		}
		for(int i = 0 ;i<N;i++){
			if(find(i)==0)
				return;
		}
		if(num<min)
			min = num;


	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[N][H];
		ans = new int[N];
		arr = new int[N-1];
		int y,x;
		min  = 4;
		for(int i = 0; i<M;i++){
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			map[y][x] = 1;
			map[y+1][x] = -1;
			arr[y]++;
		}
		recursive(0);
		if(min ==4)
			System.out.println(-1);
		else
			System.out.println(min);

	}
}


