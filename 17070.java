import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
class Main{
	static int[][] arr;
	static int n;
	static int[] dx = {0,1,1};
	static int[] dy = {1,0,1};
	static int ans ;
	static int qqq;
	static void row(int y, int x){
		int check =0;
		if(x==n-1&&y==n-1)
			ans++;
		int qaz =0;
		if(x+1<n&&arr[y][x+1]==0)
			row(y,x+1);
		else qaz++;
		if(qaz==0){
		for(int i = 0 ;i<3;i+=2){
			int xx =x+dx[i];
			int yy =y+dy[i];
			if(xx<n&&yy<n)
			if(arr[yy][xx]==1)
				check = 1;
		}

		if(check==0&&x+1<n&&y+1<n)
			qw(y+1,x+1);
		}
	//	System.out.println(x+" "+y);
	}
	static void le(int y, int x){
		int check =0;
	//	System.out.println(x+" le"+y);
		int qaz =0;
		if(x==n-1&&y==n-1)
			ans++;
		if(y+1<n&&arr[y+1][x]==0)
			le(y+1,x);
		else
			qaz++;
		if(qaz==0){
		for(int i = 1 ;i<3;i++){
			int xx =x+dx[i];
			int yy =y+dy[i];
			if(xx<n&&yy<n)
			if(arr[yy][xx]==1)
				check = 1;
		}

		if(check==0&&x+1<n&&y+1<n)
			qw(y+1,x+1);
		}

	}
	static void qw(int y, int x){
		int check =0;
	//	System.out.println(x+"qw "+y);
		int qaz=0;
		if(x==n-1&&y==n-1)
			ans++;
		if(x+1<n&&arr[y][x+1]==0)
			row(y,x+1);
		else qaz++;
		
		if(y+1<n&&arr[y+1][x]==0)
			le(y+1,x);
		else qaz++;
		if(qaz==0){
			int xx =x+dx[2];
			int yy =y+dy[2];
			if(xx<n&&yy<n)
			if(arr[yy][xx]==1)
				check = 1;

		if(check==0&&x+1<n&&y+1<n)
			qw(y+1,x+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		qqq = Integer.parseInt(br.readLine());
		n = qqq;
		arr = new int[qqq][qqq];
		for(int i = 0 ;i<qqq;i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < qqq; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		row(0,1);
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}	
