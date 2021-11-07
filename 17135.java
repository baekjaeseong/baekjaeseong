import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		int[][] enemy = new int[N][M];
		for(int i= 0; i<N;i++){
			for(int j= 0; j<M;j++){
				enemy[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<M;i++){
			for(int j=i+1; j<M;j++){
				for(int k =j+1; k<M;k++){
					for(int y = 0 ; y<N;y++){
						for(int x = 0; x<M;x++){
							int dis1 = 

