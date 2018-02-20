import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Ap extends JApplet implements MouseListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9,submit,reset;
    JPanel l1, l2;
    JButton swap1,temp;
    static int sum=0,count=0;
    public void init() {
        GridLayout gl = new GridLayout(3,3);
        l2     = new JPanel(gl);
        b1     = new JButton("1");
        b2     = new JButton("2");
        b3     = new JButton("3");
        b4     = new JButton("4");
        b5     = new JButton("5");
        b6     = new JButton("6");
        b7     = new JButton("7");
        b8     = new JButton("8");
        b9     = new JButton("9");
        GridLayout g2=new GridLayout(1,2);
        l1 =new JPanel(g2);
        submit=new JButton("SUBMIT");
        reset=new JButton("RESET");
        l1.add(submit);
        l1.add(reset);
        l2.add(b1);
        l2.add(b2);
        l2.add(b3);
        l2.add(b4);
        l2.add(b5);
        l2.add(b6);
        l2.add(b7);
        l2.add(b8);
        l2.add(b9);
        BorderLayout bl=new BorderLayout();
        setLayout(bl);
        add(l2,BorderLayout.CENTER);
        add(l1,BorderLayout.NORTH);
        submit.addMouseListener(this);
        reset.addMouseListener(this);
        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        b4.addMouseListener(this);
        b5.addMouseListener(this);
        b6.addMouseListener(this);
        b7.addMouseListener(this);
        b8.addMouseListener(this);
        b9.addMouseListener(this);
        b1.setBackground(Color.cyan);
        b2.setBackground(Color.cyan);
        b3.setBackground(Color.cyan);
        b4.setBackground(Color.cyan);
        b5.setBackground(Color.cyan);
        b6.setBackground(Color.cyan);
        b7.setBackground(Color.cyan);
        b8.setBackground(Color.cyan);
        b9.setBackground(Color.cyan);
    }
    void swap(JButton a,JButton b){
       if(a==null||b==null){}
       else{
       String s1=b.getLabel();
       String s2=a.getLabel();
       b.setLabel(s2);
       a.setLabel(s1);
       }
    }
    
    public void mousePressed(MouseEvent me){
     if((JButton)me.getSource()==submit||(JButton)me.getSource()==reset||(JButton)me.getSource()==temp){}
     else{
      if(temp!=null){
          temp.setBackground(Color.cyan);
          count++;
      }
      ((JButton)(me.getSource())).setBackground(Color.orange);
      swap1=(JButton)me.getSource();
      swap(temp,swap1);
      temp=swap1;
      
      }
     }
      
   
    public void mouseReleased(MouseEvent me){
        if(me.getSource()==reset){
            count=0;
            b1.setLabel("1");
            b2.setLabel("2");
            b3.setLabel("3");
            b4.setLabel("4");
            b5.setLabel("5");
            b6.setLabel("6");
            b7.setLabel("7");
            b8.setLabel("8");
            b9.setLabel("9");
        }
        
        else if(me.getSource()==submit){
            StringBuffer sb=new StringBuffer();
            sb.append(b1.getLabel());
            sb.append(b2.getLabel());
            sb.append(b3.getLabel());
            sb.append(b4.getLabel());
            sb.append(b5.getLabel());
            sb.append(b6.getLabel());
            sb.append(b7.getLabel());
            sb.append(b8.getLabel());
            sb.append(b9.getLabel());
            String ss=sb.toString();
            sum=0;
            int r=result(ss);
            if(r==0){
                JOptionPane.showMessageDialog(null,"Congrats! You solved it in "+count+" steps");
                count=0;
            }else{
                float d=100-(r*0.5f);
                JOptionPane.showMessageDialog(null,"You are "+d+"%"+" close to a correct configuration");
            }
        }
        }
    public void mouseEntered(MouseEvent me){}
    public void mouseClicked(MouseEvent me){}
    public void mouseExited(MouseEvent me){}

    int result(String s){
    String str[]={"816357492","618753294","492357816","294753618","834159672","438951276","672159834","276951438"};
    byte brr[];                                   
    brr=s.getBytes();             
    int crr[];                                     
    crr=new int[8];
    for(int i=0;i<8;i++){
        byte drr[];
        drr=str[i].getBytes();                               
        for(int j=0;j<9;j++){
            sum=sum+Math.abs((drr[j])-(brr[j]));   
        }
        crr[i]=sum;                                
        sum=0;
    }
    Arrays.sort(crr);
    return crr[0];                  
    }
}