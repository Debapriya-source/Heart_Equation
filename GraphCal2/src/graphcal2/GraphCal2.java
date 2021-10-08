
package graphcal2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;


public class GraphCal2 extends JFrame{
    
    private int WIDTH=800,HEIGHT=800;
     private int scale=80,start=-3,end=3;
    double x= start,y=0,a=1,oldX,oldY;
   
    Random rand = new Random();
    
    GraphCal2(){
         setSize(WIDTH,HEIGHT);
        setTitle("HeartGraph");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        
    }
    @Override
    public void paint(Graphics g){
        g.translate(WIDTH/2, HEIGHT/2);
        
        if(x<=-1.78) y=f(-1.78);
        else if(x>=1.78) y=f(1.78);
        else  y=f(x);
        if(x==start){
             g.setColor(Color.BLACK);
                g.fillRect(-WIDTH, -HEIGHT, WIDTH*2, HEIGHT*2);
        }
         if(x>end){
             
                g.setColor(Color.BLACK);
                g.fillRect(-WIDTH, -HEIGHT, WIDTH*2, HEIGHT*2);
                /*oldX=x;
                oldY=y;*/
                /* if(a<=500)
                a-=100;
                else
                a+=100;*/
                a+=scale;
                x=start;
            }
       float red= rand.nextFloat(),green=rand.nextFloat(),blue=rand.nextFloat();
       
        Color newColor = new Color(red,green,blue);
        g.setColor(newColor);
        g.fillOval((int)(scale*x), (int)(y*scale), 3, 3);
       
        
        
        run();
        
        repaint();
        
    }
    public void run(){
        try {
            Thread.sleep(0);
            
            if(x>=start && x<=end){
                /*oldX=x;
                oldY=y;*/
                x+=.0001;         
            }
            /* if(x>5){
            
            oldX=x;
            oldY=y;
            x=-5;
            }*/
            //System.out.println(x+","+y);
        } catch (InterruptedException e) {
            System.out.println("Error!!!");
        }
        
    }
    double f(double x){
        return -1*(Math.pow(Math.abs(x), 2.0/3.0)+((0.9*Math.sqrt(3.3-(x*x)))*(Math.sin(a*3.14*x*(3.14/180))))); //Heart Wave
        
    }
    
    public static void main(String[] args) {
        new GraphCal2();
    }
    
}
