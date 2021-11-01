import java.util.*;
class Main{
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[m][n];
		int[] ans = new int[10000];
		for(int i = 0 ; i<k;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for(int x = a; x<c;x++){
				for(int y = b; y<d;y++){
					arr[y][x] = 1;
				}
			}
		}
		boolean[][] visit = new boolean[m][n];
		Queue<Integer> q = new LinkedList<Integer>();
		int abc = 0;
		int jjjj=0;
		for(int y =  0; y<m;y++){
			for(int x = 0; x<n;x++){
				int curr = 0;
				if(visit[y][x] ==true||arr[y][x]==1)
					continue;
				q.add(y);
				q.add(x);
				visit[y][x] = true; curr= 1;

				while(!q.isEmpty()){
					int y2 = q.poll();
					int x2 = q.poll();
					for(int j = 0;j<4;j++){
						if(x2+dx[j]>=0&&x2+dx[j]<n&&y2+dy[j]>=0&&y2+dy[j]<m&&arr[y2+dy[j]][x2+dx[j]]==0&&visit[y2+dy[j]][x2+dx[j]]==false){
							visit[y2+dy[j]][x2+dx[j]]=true;
							curr++;
							q.add(y2+dy[j]);
							q.add(x2+dx[j]);
						}
					}
				}
				ans[abc++] = curr;
				jjjj++;
			}
		}
		Arrays.sort(ans);
		System.out.println(jjjj);
		for(int i = ans.length-jjjj; i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}

	}
}

