import java.awt.*;  
import javax.swing.*;  
 import java.util.*; 
class MyGridLayout{  
JFrame f;  
MyGridLayout(){
Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
int i;
    f=new JFrame(); 
System.out.println("Enter rows and columns"); 
      for(i=1;i<n*n;i++)
{
    JButton b1=new JButton(" ");  
          
    f.add(b1);
}
    f.setLayout(new GridLayout(n,n));  
    //setting grid layout of 3 rows and 3 columns  
  
    f.setSize(300,300);  
    f.setVisible(true); 
}  
public static void main(String[] args) {  
System.out.println("Enter rows and columns"); 
    
new MyGridLayout();  
}  
}  
