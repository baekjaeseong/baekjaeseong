import java.util.*;
class Main{
        static int N,M;
        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};
        public static void main(String[] args){
                Scanner sc =new Scanner(System.in);
                N = sc.nextInt();
                M = sc.nextInt();
                char[][] arr = new char[M][N];
                boolean[][] check = new boolean[M][N];
                for(int i = 0; i<M;i++){
                        String q = sc.next();
                        for(int j = 0; j<N;j++){
                                arr[i][j] = q.charAt(j);
                        }
                }
                Queue<Character> q = new LinkedList<Character>();
                Queue<Integer> q_ = new LinkedList<Integer>();
                q.add(arr[0][0]);
                q_.add(0);
                q_.add(0);
                check[0][0] = true;
                int w = 0;
                int b = 0;
                int w_ = 0;
                int b_ = 0;
                int num = 1;
                int a = 0;
                int c = 0;
                while(!q.isEmpty()){
                        char fre = q.poll();
                        int x_ =q_.poll();
                        int y_ =q_.poll();
                        int x= x_;
                        int y= y_;
                        for(int i = 0; i<4;i++){
                                if((x_+dx[i]>=0)&&(x_+dx[i]<N)&&(y_+dy[i]>=0)&&(y_+dy[i]<M)){
//                                      if(fre=='B')
                                    //                                      System.out.println(x+ " "+y+" "+check[y][x]+" fre = "+fre);
                                        x = x_+dx[i];
                                        y = y_+dy[i];
                                        if(check[y][x] ==false){
                                                if(arr[y][x] ==fre){
                                                        num++;
                                                        check[y][x] = true;
                                                        q.add(arr[y][x]);
                                                        q_.add(x);
                                                        q_.add(y);
                                                //      if(arr[y][x]=='B')
                                                //      System.out.println(x+" "+y+" num = "+num);
                                                }
                                        }
                                }

                        }
                        if(q.isEmpty()){
                                if(fre=='W')
                                        w+=num*num;
                                else if(fre=='B')
                                        b+=num*num;
                                while(c<M&&a<N){
                                        if(a<N)
                                                a++;
                                        if(a==N&&c<M)
                                        {
                                                a=0;
                                                c++;
                                        }
                                        if(c<M&&check[c][a]==false){
                                                check[c][a] =true;
                                                q.add(arr[c][a]);
                                                q_.add(a);
                                                q_.add(c);
                                                num=1;
                                                break;
                                        }
                                                                
                                                                            }

                                }

                        }
                }
                System.out.println(w+" "+b);
        }
}




