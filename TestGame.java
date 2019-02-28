/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;
//Noor AlDin Khaleel Zakarneh
//21520012
//
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class Test extends JFrame{
 int flag =0; // x or y starting with x 
 int counter =0;// after inserting 9 blocks the game will end 
    Test(){
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Xo Game ");
        Toolkit kit=Toolkit.getDefaultToolkit();// binding 
        Dimension dim = new Dimension(kit.getScreenSize());
       
    
        this.setLocation(dim.width/4, dim.height/4);
        this.setSize(dim.width/2,dim.height/2);
        this.setVisible(true);
        
         Container c = this.getContentPane();
        c.add(new MyPanel());
      
    }
    
    private class MyPanel extends JPanel{
        JFrame frame;
        
       JButton [][] B= new JButton[3][3];
       
       
        MyPanel(){
         //   this.frame=frame;
         
         GridLayout t= new GridLayout(3,3);
         this.setLayout(t);

         for (int i=0 ; i<3;i++)
             for (int j=0 ;j<3;j++)
             {B[i][j]= new JButton();
              B[i][j].setText(" ");
              
              this.add(B[i][j]);
                 B[i][j].addActionListener( new AL(this));
             }   
              
   
        }
        
         
     private class AL implements ActionListener{
        
         JPanel panel;
         AL(JPanel p){
             panel=p;
         }
     public void actionPerformed(ActionEvent e) {
        JButton press =(JButton )e.getSource();
        press.setFont(new Font("Arial",Font.PLAIN,40));
       if (flag == 0){
           
       if( press.getText().equals(" ")){
           press.setForeground(Color.red);
        
           press.setText("X");
        flag++;
        counter ++;
       }
        
        
       }  
       else
       if (flag==1){
      
       
           if( press.getText().equals(" ")){
              
               press.setForeground(Color.blue);
           
               press.setText("O");
        flag--;
        counter++;
          }
      
       
       }
       
       if (Win()== true && flag ==1) 
           {JOptionPane.showMessageDialog(null, "X won the game", "The Winner", JOptionPane.ERROR_MESSAGE);
            setDefault();
            counter=0;
           }
        if (Win()== true && flag ==0) 
       { JOptionPane.showMessageDialog(null, "O won the game", "The Winner", JOptionPane.ERROR_MESSAGE);
         setDefault();
         counter=0;
       }
        
        if ( counter==9){
         JOptionPane.showMessageDialog(null, "No One ", "The Winner", JOptionPane.WARNING_MESSAGE);
         setDefault();
         counter=0;
        }
        
     }
     
     
     }
     
     
     public boolean vertical(){
         for(int i=0 ; i<3;i++)
         if
         ( !(B[i][0].getText().equals(" "))&&B[i][1].getText().equals(B[i][0].getText())&&(B[i][2].getText().equals(B[i][0].getText())))
         return true;
         
         
         return false;
              
         
     }
     
     
     public boolean horizental(){
         for(int i=0 ; i<3;i++)
         if
         (!(B[0][i].getText().equals(" "))&&(B[1][i].getText().equals(B[0][i].getText()))&&((B[2][i].getText().equals(B[0][i].getText()))))
         return true;
         
         return false;
         
     }
     
     
     public boolean diagonals(){
         
                if(                    
                        (!(B[0][0].getText().equals(" "))&&(B[0][0].getText().equals(B[1][1].getText())&&(B[0][0].getText().equals(B[2][2].getText()))))
                     
                    ||
                               (((!B[0][2].getText().equals(" "))&&(B[0][2].getText().equals(B[1][1].getText())&&(B[0][2].getText().equals(B[2][0].getText()))))))
                        return true ;
                else return false;
     }
     
     
        public boolean Win (){
                     if(vertical()||horizental()||diagonals()      )                   
                         return true;
                      else
            return false;
        }
        
        
        public void setDefault(){
            for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                B[i][j].setText(" ");
                
        }
                   
       }
     }
    

public class TestGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         new Test();
        
    }
    
}

