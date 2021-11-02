import java.util.*;
class Main{
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static char[][] map ;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[12];
		map = new char[12][6];
		for(int i =0; i<12;i++){
			arr[i] = sc.next();
			for(int j =0; j<6;j++){
				map[11-i][j] = arr[i].charAt(j);
			}
		}
		int ans = 0 ;
		int curr = 0;
		int before = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		while(curr!=before){
			if(curr==0)
				before = 0;
			else{
				before = before+1;
				curr=before;
			}
			boolean[][] visit = new boolean[12][6];
			int[] ar = new int[6];
			for(int i = 0 ;i <12;i++){

				for(int j = 0 ; j<6;j++){
					char x ;
					int[] number_of_fung = new int[6];
					if(map[i][j] =='.'){
						j++;
						continue;
					}
					else if(visit[i][j]!=true)
					{
						
						x = map[i][j];
						visit[i][j] = true;
						q.add(i);q.add(j);
						int ww = 1;
						int[] abc = new int[6];
						while(!q.isEmpty()){
							int yy = q.poll();
							int xx = q.poll();
							for(int test = 0 ; test<4;test++){
								
								if((yy+dy[test]<12)&&(yy+dy[test]>=0)&&(xx+dx[test]>=0)&&(xx+dx[test]<6)){
									if(visit[yy+dy[test]][xx+dx[test]]==false &&map[yy+dy[test]][xx+dx[test]]==x){
									visit[yy+dy[test]][xx+dx[test]]=true;
									q.add(yy+dy[test]);
									q.add(xx+dx[test]);
									ww++;
									abc[xx+dx[test]]++;
									}
								}
							}
						}
						if(ww>=4){
							curr++;
							q.add(i); q.add(j);
							while(!q.isEmpty()){
								int yy = q.poll();
								int xx = q.poll();
								for(int test = 0 ; test<4;test++){
								if((yy+dy[test]<12)&&(yy+dy[test]>=0)&&(xx+dx[test]>=0)&&(xx+dx[test]<6)){
									if(visit[yy+dy[test]][xx+dx[test]]==true &&map[yy+dy[test]][xx+dx[test]]==x){
										visit[yy+dy[test]][xx+dx[test]] = false;
										map[yy+dy[test]][xx+dx[test]]='.';
										q.add(yy+dy[test]);
										q.add(xx+dx[test]);
										
									}
								}

								}
								
							}
						}
						
					}
				}
			}
			for(int i = 0; i<11;i++){
				for(int j = 0; j<6;j++){
					if(map[i][j] =='.'){
						int y = i+1;
						while(y<12){
							if(map[y][j]!='.')
								break;
							else
								y++;
						}
						if(y<12){
							char temp = map[y][j];
							map[i][j] =temp;
							map[y][j]= '.';
						}
					}
				}
			}
			/*if(curr>1){
				for(int we = 0; we<12;we++){
					for(int er = 0; er<6;er++){
						System.out.print(map[11-we][er]);
					}
					System.out.println();
				}
			}
			System.out.println(curr);*/
		}
		System.out.println(curr);
	}
}
