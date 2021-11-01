import java.util.*;
class Main{

        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int a = sc.nextInt();
                int b = sc.nextInt();
                int[] nu = new int[a];
                int[] nu_2 = new int[b];
                int c = a+b;
                int d = 0;
                for(int i = 0 ; i<a;i++){

                        nu[i] = sc.nextInt();
                }
                for(int i = 0 ; i<b;i++){
                        nu_2[i] = sc.nextInt();
                }
                int k = 0;
                Arrays.sort(nu);
                Arrays.sort(nu_2);
                if(a<b){
                for(int i = 0;i<a;i++){
                        for(int j = k;j<b;j++){
                                if(nu[i]<nu_2[j]){
                                        k=j;
                                        j=b;
                                }
                                else if(nu[i]==nu_2[j]){
                                        k=j;
                                        d++;
                                        j=b;
                                }
                        }
                }

                }
                else{
                for(int i = 0;i<b;i++){
                                            for(int j = 0;j<a;j++){
                                if(nu_2[i]<nu[j]){
                                        k=j;
                                        j=b;
                                }
                                else if(nu[j]==nu_2[i]){
                                        k=j;
                                        d++;
                                        j=b;
                                }
                        }
                }
                }
                System.out.println(c-2*d);
    }
}

