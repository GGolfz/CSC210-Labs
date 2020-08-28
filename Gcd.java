public class gcd {
    public static void main(String[] args) {
        System.out.println(bruteForceGCD(60, 90));
        System.out.println(highSchoolGCD(60, 90));
        System.out.println(highSchoolGCDwithWhile(60, 90));
        System.out.println(commonFactorsGCD(60, 90));
        int[] arr = new int[100];
        prime(100, arr);
        for (int i : arr) {
            if(i!=0) System.out.print(i+" ");
        }
    }   
    public static int bruteForceGCD(int m,int n){
        int answer =1;
        for(int x =2;x<=Math.max(m,n);x++){
            if(m%x == 0 && n %x == 0){
                answer = x;
            }
        }
        return answer;
    }
    public static int highSchoolGCD(int m,int n){
        int answer = 1;
        int mRemain = m, nRemain =n;
        for(int i  =2;i<= Math.min(mRemain,nRemain);i++){
            if(mRemain %i == 0 && nRemain %i == 0){
                answer *= i;
                mRemain /= i;
                nRemain /= i;
                i-=1;
            }
        }
        return answer;
    }
    public static int commonFactorsGCD(int m, int n){
        int answer= 1;
        int maxFactorsm = (int)(Math.log(m)/Math.log(2));
        int maxFactorsn = (int)(Math.log(n)/Math.log(2));
        int[] factors4m = new int[maxFactorsm+1];
        int[] factors4n = new int[maxFactorsn+1];
        factors(m,factors4m);
        factors(n,factors4n);
        int pointM = 0 , pointN = 0;
        while(factors4m[pointM] != -1 &&
              factors4n[pointN] != -1 &&
              pointM < factors4m.length &&
              pointN < factors4n.length){
            if (factors4m[pointM] == factors4n[pointN]) {
                answer *= factors4m[pointM];
                pointM+=1;
                pointN+=1;
            } else if (factors4m[pointM] < factors4n[pointN]) {
                pointM+=1;
            } else {
                pointN+=1;
            }
        }
        return answer;
    }
    public static void factors(int x,int[] factors){
        int i = 0,remain = x,factor=2;
        while(factor <= remain){
            while(remain % factor == 0){
                remain /= factor;
                factors[i] = factor;
                i++;
            }
            factor++;
        }
        while(i<factors.length){
            factors[i] -=1;
            i+=1;
        }
    }
    public static int highSchoolGCDwithWhile(int m,int n){
        int answer = 1;
        int mRemain = m, nRemain =n;
        for(int i  =2;i<= Math.min(mRemain,nRemain);i++){
            while(mRemain %i == 0 && nRemain %i == 0){
                answer *= i;
                mRemain /= i;
                nRemain /= i;
            }
        }
        return answer;
    }
    public static void prime(int n,int[] L){
        int[] A = new int[n+1];
        A[0] = 0; A[1] = 0;
        for(int p = 0;p<A.length;p++){
            A[p] = p;
        }
        for(int p = 2;p< Math.sqrt(n);p++){
            int j = p*p;
            while(j<=n){
                A[j] = 0;
                j+=p;
            }
        }
        for(int p=2,i = 0 ;p<=n;p++){
            if(A[p] != 0){
                L[i] = A[p];
                i+=1;
            }
        }
    }
}