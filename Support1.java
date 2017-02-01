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
    
    
    public static String normalizeString(String s){
        char array[]=s.toCharArray();
        for(int i=0;i<array.length;i++){
            array[i]=(char)((int)array[i]-96);
            //System.out.printf("%d ",(int)array[i]);
        }
        String str=new String(array);
        return str;
        
    }
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
    public static long eValue(){
       long a=0;
       long max1=2;
       long max2=2;
       for(long i=10;i<100;i++){
           if(millerRabin(i)){
               max1=i;
           }
       }
       for(long i=10;i<200;i++){
           if(millerRabin(i)){
               max1=i;
           }
       }
       a=(max1-1)*(max2-1);
       long e=2;
       for(long i=2;i<a;i++){
          
       }
       
       
       return a;
    }
    public static String permutaion(String string){
        int table[]=new int[]{32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,31,31,32,01};
        char array[]=string.toCharArray();
        char array1[]=new char[48];
        //int length=array.length;
        for(int i=0;i<array1.length;i++){
               array1[i]=array[table[i]-1];
        }
        String str=new String(array1);
        return str;
        
       }
    
    public static String binaryString(String s){
        char array[]=s.toCharArray();
        int length=0; 
        String str=new String();
        
        String str2=new String();
        String empty=new String();
        for(int i=0;i<array.length;i++){
            str2=empty;
            str2=Integer.toBinaryString((int)array[i]);
            length=str2.length();
            if(length<8)
            {
                for(int j=0;j<8-length;j++){
                    str2="0"+str2;
                }
            }
            str=str+str2;
            
            
            
        }
        
        
        return str;
    }
    public static String xor(String s,String k){
        
        char array1[]=s.toCharArray();
        char array2[]=k.toCharArray();
        char array3[]=new char[array2.length];
        for(int i=0;i<s.length();i++){
            if((array1[i]=='0'&&array2[i]=='0')||(array1[i]=='1'&&array2[i]=='1'))
                array3[i]='0';
            else
                array3[i]='1';
                
            
        }
         /*for(int i=0;i<s.length();i++){
          System.out.printf("%d",(int)array3[i]);
                
            
        }*/
        String str=new String(array3);
        
        return str;
        
        
        
        
        
        
    }
    
    
    
    public static String DES(String str,String k){
        String string=new String();
        string=binaryString(normalizeString(str));
        
        
        
        
       
        
        
        
        
        
        return str;
    }
        
        
        
        
    
}
