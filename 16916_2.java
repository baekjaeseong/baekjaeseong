import java.util.*;
class Main{
        static int ans;
        static int[] dp;
        static void abc(String S){
                int i = 0;
                for(int j = 1 ; j<dp.length;j++){
                        if(S.charAt(i)==S.charAt(j)){
                                dp[j] = dp[j-1]+1;
                                i++;
                        }
                        else
                        {

                                i=0;
                                if(S.charAt(i)==S.charAt(j)){
                                        dp[j] = 1;
                                        i++;
                                }
                                else
                                dp[j] = 0;
                        }

                }
//              for(i = 0 ; i<dp.length;i++)
//                      System.out.println(dp[i]);

        }
        static int kmp(String P, String S){
                abc(S);
                int j = 0;
                for(int i = 0; i<P.length();i++){
			while(j>0&&P.charAt(i)!=S.charAt(j)) j=dp[j-1];
                        if(P.charAt(i) == S.charAt(j)){
                                j++;
                        }
                //      System.out.println("i ="+i+" j ="+j);
                        if(j== S.length())
                                return 1;
                }
                return 0;
        }
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                String P = sc.next();
                String S = sc.next();
                dp = new int[S.length()];
                ans = kmp(P,S);
                System.out.println(ans);
        }
}
                                       

