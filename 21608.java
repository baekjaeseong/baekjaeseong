import java.util.*;
class Main{
	static int[][] stu_favor;      // i번의 학생이 4명의 학생을 좋아하는 번호
	static int[] dx = {0,0,1,-1};  
	static int[] dy = {1,-1,0,0};
	static boolean[][] full ;      // map의 자리가 찼는지 안 찼는지 확인용
	static int[] order;		// 처음부터 자리에 들어갈 순서
	static int stu_num;		// 전체 학생 수
	static int[][] map;
	static int[][][] favor_num;
	static int[][][] favor_num_2;
	static int[][][] mapping_zero; //2번용

	static void find_2sol(int number_of_stu,int max){
		int num =0;
		int x=0; int y=0;
		for(int i = 1; i<=stu_num;i++){
			for(int j = 1; j<=stu_num;j++){
				if(full[i][j]==false){
				if(max==mapping_zero[number_of_stu][i][j])
				{
					num++;
					y=i;x=j;
				}	
				}
			}
		}
		if(num==1){
			full[y][x] = true;
			map[y][x] = number_of_stu;

		}
		else
		{
		for(int i = 1; i<=stu_num;i++){
			for(int j = 1; j<=stu_num;j++){
				if(max==mapping_zero[number_of_stu][i][j]&&full[i][j]==false)
				{
					full[i][j] = true;
					map[i][j] = number_of_stu;
					return;		
				}	
			}
		}
			
		}

				
		
	}
	static void select(int number_of_stu){  //1번 조건 파악용
		int max = 0;
		int[] num = new int[5];
		int q = 0;
		int w = 0;
		for(int i = 1; i<=stu_num;i++){
			for(int j = 1; j<=stu_num;j++){
				if(full[i][j]==false){
				int x =favor_num[number_of_stu][i][j];
				if(x>=max){
					max=x;
					q =i;
					w = j;
				}
				num[x]++;
				}
			}
		}
		if(num[max]==1){
			full[q][w] = true;
			map[q][w] = number_of_stu;
			//	if(number_of_stu==4){
				//	System.out.println(max+"dddddd "+q+" "+w);
			//	}
		}
		else //2번용
		{
			int max_zero = 0 ;
			int numm;
			for(int i = 1; i<=stu_num;i++){
				for(int j = 1; j<=stu_num;j++){
					if(full[i][j]==false){
						numm = 0 ;
						if(favor_num[number_of_stu][i][j]==max){
							for(int k = 0; k<4;k++){
								int y = i+dy[k]; int x = j+dx[k];
								if(y>0&&y<=stu_num&&x>0&&x<=stu_num){
									if(full[y][x]==false)
										numm++;
								}
							}
						}
						mapping_zero[number_of_stu][i][j]=numm;
						if(numm>max_zero)
							max_zero = numm;
					}
				}
			}
			find_2sol(number_of_stu,max_zero);
			
		}


	}
	static void find(int number_of_stu){   // 1번 조건에대해서 파악하기용
		for(int i = 1; i<=stu_num;i++){
			for(int j = 1; j<=stu_num;j++){
				if(full[i][j] == false){
					for(int k = 0; k<4;k++){
						int y = i+dy[k]; int x = j+dx[k];
						if(y>0&&y<=stu_num&&x>0&&x<=stu_num){
							for(int s = 0; s<4;s++){
								if(map[y][x] ==stu_favor[number_of_stu][s])
									favor_num[number_of_stu][i][j]++;
							}
						}
					}
				}
			}
		}
		select(number_of_stu);
	}
	static int cal(int number_of_stu){
		int su =0;
		for(int i = 1; i<=stu_num;i++){
			for(int j = 1; j<=stu_num;j++){
				if(map[i][j] == number_of_stu){
					int x = favor_num_2[number_of_stu][i][j];
					if(x==0)
						su=0;
					else if(x==1)
						su=1;
					else if(x==2)
						su=10;
					else if(x==3)
						su = 100;
					else if(x==4)
						su = 1000;
					i = stu_num; j = stu_num;
				}
			}
		}
		return su;


		
	}
	static void update_favor(int number_of_stu){
		for(int i = 1; i<=stu_num;i++){
			for(int j = 1; j<=stu_num;j++){
				if(map[i][j] == number_of_stu){
					for(int k = 0; k<4;k++){
						int y = i+dy[k]; int x = j+dx[k];
						if(y>0&&y<=stu_num&&x>0&&x<=stu_num){
							for(int s = 0; s<4;s++){
								if(map[y][x] ==stu_favor[number_of_stu][s])
									favor_num_2[number_of_stu][i][j]++;
							}
						}
					}
					return;
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in);
		stu_num = sc.nextInt();
		stu_favor = new int[stu_num*stu_num+1][4];
		full = new boolean[stu_num+1][stu_num+1];
		order = new int[stu_num*stu_num+1];
		map = new int[stu_num+1][stu_num+1];
		favor_num = new int [stu_num*stu_num+1][1+stu_num][1+stu_num];
		favor_num_2 = new int [stu_num*stu_num+1][1+stu_num][1+stu_num];
		mapping_zero = new int [stu_num*stu_num+1][1+stu_num][1+stu_num];
		for(int i = 1 ; i<=stu_num*stu_num;i++){
			order[i] = sc.nextInt();
			for(int j = 0 ; j<4;j++){
				stu_favor[order[i]][j] = sc.nextInt();
			}
		}
		for(int i = 1; i<=stu_num*stu_num;i++){
			find(order[i]);
		}
		int sum = 0;
		for(int i = 1; i<=stu_num*stu_num;i++){
			update_favor(order[i]);
		}

		for(int i = 1; i<=stu_num*stu_num;i++){
			sum+=cal(order[i]);
		}
		System.out.println(sum);	
	}
}
