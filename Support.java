/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5;
import java.lang.Math.*;
/**
 *
 * @author user1
 */
public class Support {
    
    public static long mod(long n,long k){
        if(n>=0)
        return n%k;
        else
        return (n%k)+k;
        
}
    public static long gcd(long n,long k){
        long r1=n,r2=k,r,t1=0,t2=1,t,q;
        while(r2>0){
            q=r1/r2;
            r=r1-(q*r2);
            r1=r2;
            r2=r;
            t=t1-(t2*q);
            t1=t2;
            t2=t;
            }
        return r1;
    }
    public static long fastMod(long a,long b,long n){
        long c=0,f=1;
        
        String str=Integer.toBinaryString((int)b);
        char binary[]=str.toCharArray();
        long  c1[]= new long[binary.length];
        c1[0]=0;
        long  f1[]=new long[binary.length];
        f1[0]=1;
        
        for(int i=0;i<binary.length;i++){
            if(i==0){
               if(binary[i]=='0'){
                   //System.out.println(c1[i]+" "+f1[i]+" 1");
                   c1[i]=c1[i]*2;
                   f1[i]=mod((f1[i]*f1[i]),n);
                  // System.out.println(c1[i]+" "+f1[i]+"  1");
               }
               if(binary[i]=='1'){
                 //  System.out.println(c1[i]+" "+f1[i]+" 2");
                   c1[i]=(c1[i]*2)+1;
                   f1[i]=mod((f1[i]*f1[i]*a),n);
                  // System.out.println(c1[i]+" "+f1[i]+" 2");
               }
            }
            else{
                 if(binary[i]=='0'){
                    // System.out.println(c1[i]+" "+f1[i]+" 3");
                   c1[i]=c1[i-1]*2;
                   f1[i]=mod((f1[i-1]*f1[i-1]),n);
                  // System.out.println(c1[i]+" "+f1[i]+" 3");
               }
               if(binary[i]=='1'){
                  // System.out.println(c1[i]+" "+f1[i]+" 4");
                   c1[i]=c1[i-1]*2+1;
                   f1[i]=mod((f1[i-1]*f1[i-1]*a),n);
                  // System.out.println(c1[i]+" "+f1[i]+" 4");
               }
            }
        }
        
        
        return f1[f1.length-1];
        
      
    }
    public static boolean millerRabin(long n){
        long k=0;
        long  m=n-1; 
       while(m%2==0){
           m=m/2;
           k++;
           
       } 
       
        
        
        /*long p=(long)(Math.log10(n-1)/Math.log10(2));
        long m=(long)(Math.pow(2, p));
        long k=(long)(Math.log10((n-1)/m)/Math.log10(2));*/
        //System.out.println(m+" "+k);
        long T=fastMod(2,m,n);
        //System.out.println(T);
        if(T==1||T==-1)
            return true;
        
        for(int i=0;i<=k-1;i++){
            T=mod(T*T,n);
            //System.out.println(T);
            if(T==1||T==-1)
            return true;
        }
        
        
        
        
        
        
        
        
        return false;
    }
        
        
        
        
    
}
