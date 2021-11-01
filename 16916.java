import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		int ans = 0;
		int x =0;
		int y = 0;
		for(int i = 0; i<=S.length()-P.length();i++){
			int k = 0;
			int j = 0 ;
			if(P.charAt(j)==S.charAt(i)){
				x=1;
				y=1;
				for(j = 0; j<P.length();j++){
					ans = 1;
					if(j!=0){
						if(y==1&&P.charAt(j)!=P.charAt(j-1)){
							x=j+1;
						}
						if(y==1&&P.charAt(j)==P.charAt(j-1))
							k=j+1;
						else
							y=1;
				//		System.out.println(x);
					}
					if(P.charAt(j)!=S.charAt(i+j)){
						ans = 0;
						if(k==0)
						j = S.length();
						else
							j +=k-1;
						if(k==0)
							i+=x-1;
						else
							i+=x;
					}


				//	System.out.println("j = "+j + " i ="+i + " ans = "+ans);
				}
				if(ans ==1)
					i = S.length();
			}
		}
		System.out.println(ans);
	}
}
