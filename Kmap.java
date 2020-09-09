package Sample;


import java.util.*;



 class Kmap{

public static void main(String args[])
{
  
  int[][] table = new int[2][4];
  
  for(int i=0;i<=1;i++)
       {
         
         for(int j=0;j<=3;j++)
         {
           
             table[i][j]=0;
             
          }
       }
  
  int[] minterm = new int[8];
  
  Scanner input= new Scanner(System.in);
  
  System.out.println("Give the number of min term");
  System.out.print("\n");
  Scanner NumberOfTerm= new Scanner(System.in);
  int n=NumberOfTerm.nextInt();
  
  
  System.out.print("give minterm");
  System.out.print("\n");
  for(int q=0;q<=n-1;q++)
  {
  minterm[q]=input.nextInt();
  }
  
  for(int k=0;k<n;k++)
  {
  switch(minterm[k])
  {
    case 0:
       table[0][0]=1;
       break ;
    case 1:
       table[0][1]=1;
       break ;
    case 2:
       table[0][3]=1;
       break;
    case 3:
       table[0][2]=1;
    case 4:
       table[1][0]=1;
       break ;
    case 5:
       table[1][1]=1;
       break ;
    case 6:
       table[1][3]=1;
       break;
    case 7:
       table[1][2]=1;
     }
       
   }
        
 System.out.print("YOUR KMAP IS:") ;
 System.out.print("\n\n");
for(int i=0;i<=1;i++)
{
System.out.println(table[i][0]+" "+table[i][1]+" "+table[i][2]+" "+table[i][3]);
System.out.print("\n");
}
System.out.print("Binary reprentation of your input are:");
System.out.print("\n");
String[] s = new String[n];
ArrayList<String> late = new ArrayList<String>();
for(int i=0;i<=n-1;i++){
String result = Integer.toBinaryString(minterm[i]);
String resultWithPadding = String.format("%3s", result).replaceAll(" ", "0");  
s[i]=resultWithPadding;
System.out.println(resultWithPadding);
}
ArrayList<String> dup= new ArrayList<String>(Arrays.asList(s));
for(int i=0;i<s.length;i++)
{
for(int j=i+1;j<=s.length-1;j++)
{
String a=s[i];
String b=s[j];
int count=0;
for(int k=0;k<=2;k++)
{
if(a.charAt(k)!=b.charAt(k))
{
StringBuilder sb = new StringBuilder(a);
sb.setCharAt(k, '*');
a=sb.toString();
a=a.substring(0,3);
count++;
}
 }
if(count==1)
{
dup.remove(s[i]);
dup.remove(s[j]);
late.add(a);
}
}	
}
  
String[] lte=late.toArray(new String[late.size()]);
ArrayList<String> dup1= new ArrayList<String>(Arrays.asList(lte));
ArrayList<String> late1 = new ArrayList<String>();
for(int i=0;i<lte.length;i++)
{
for(int j=i+1;j<=lte.length-1;j++)
{
String a=lte[i];
String b=lte[j];
int count=0;
for(int k=0;k<=2;k++)
{
if(a.charAt(k)!=b.charAt(k))
 {
    	      
    	      		StringBuilder sb = new StringBuilder(a);
    sb.setCharAt(k,'*');
    
    	      		a=sb.toString();
    	      		a=a.substring(0,3);
    	      		
    	      		count++;
    	      	}
    	 }
    	      	if(count==1)
    	      	{
    	      		 dup1.remove(lte[i]);
    	      	 dup1.remove(lte[j]);
    	      		late1.add(a);
    	      	}
    	 
    	
    }	
    }  
    Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(late1);
      late1.clear();
      late1.addAll(primesWithoutDuplicates);

    dup.addAll(dup1);
    late1.addAll(dup);
        
  String[] le=late1.toArray(new String[late1.size()]);

   
System.out.println("Reduced expression is");
   System.out.print("\n");
   for(int h=0;h<le.length;h++)
     { 
     String answer=le[h];
   for(int k=0;k<=2;k++)
    {
         char d= answer.charAt(k);
    	switch(d)
    	{
    		
    		case '0':
    		                         if(k==0)
    		                          {System.out.print("a");}
    		                          else
    		                        if(k==1)
    		                         { System.out.print("b");}
    		                          else
    		                     if(k==2)
    		                         { System.out.print("c");}
    		              
    		              break;
    		 case '1':
    		               if(k==0)
    		                          {System.out.print("A");}
    		                          else
    		                        if(k==1)
    		                         { System.out.print("B");}
    		                          else
    		                     if(k==2)
    		                         { System.out.print("C");}
    		              
    		              break;
    		 
    		 
    	}
 
    			
    			
    			if(k==2)
    			{System.out.print("\n");}
    		
    }
}

  input.close();
  NumberOfTerm.close();

}
}