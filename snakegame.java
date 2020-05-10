package snake2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class snakegame extends JFrame implements  KeyListener
{
   int count=0;
   int store=0;
   boolean whole;
   String head;
     int xdir=0;            //to check if snake is facing east or west
     int ydir=0;            //to check if snake is facing north or south
    static int arrayx[];        //to store x point of the snake
    static int arrayy[];            //to store y point of the snake
    public snakegame()
    {
        head="right";
        addKeyListener(this);

        arrayx=new int[10];
        arrayy =new int[10];
        for(int i=0;i<arrayx.length;i++)
        {
            arrayx[i] = 250;
            arrayy[i] = 250;
        }

    }

    public static void main(String args[])
    {
        snakegame jf=new snakegame();
        JFrame j=new JFrame();
        jf.setTitle("Snake game");
        jf.setVisible(true);

        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,500);
        for(int i=0;i<arrayx.length;i++)
        {

            g.setColor(Color.white);
            g.fillRect((arrayx[i]-(5*i)),arrayy[i], 5, 5);
        }

    }



    public void keyTyped(KeyEvent k) {

    }

    public void keyPressed(KeyEvent k)
    {
            if(k.getKeyCode() == KeyEvent.VK_RIGHT && !head.equals("left"))
            {

                if(!(head.equals("right"))) {
                     store=count;
                    count = 0;
                }
                 if(head.equals("up") )
                    xdir=0;

                //when snake is already moving in right(same) direction
                if(xdir>0 && head.equals("right"))
                { System.out.println("hi");
                    for(int i=0;i<arrayx.length;i++) {
                    arrayx[i] += 5;

                }

                }
                //when snake is not in right direction
                else {
                    //REST BODY OF SNAKE
                    if (ydir>0 || head.equals("up")|| head.equals("right") )
                    {
                        for(int i=count+1;i<arrayx.length;i++)
                        arrayy[i] -= 5;             //snake is in north direction
                    }
                    else if( ydir<0 || head.equals("down") )
                    {
                        for(int i=count+1;i<arrayx.length;i++)
                        arrayy[i]+=5;           //snake is in south direction
                    }
;
                    //HEAD OF THE SNAKE
                    for(int i=0;i<=count;i++) {

                        arrayx[i] += 5;
                    }
                    count++;
                    if(count==store)
                    {
                        count=0;
                        xdir=1;
                        ydir=0;

                    }
                }
                System.out.println(xdir);
                head="right";


            }
        else if(k.getKeyCode() == KeyEvent.VK_LEFT && !head.equals("right"))
        {
            if(!(head.equals("left"))) {
                store=count;
                count = 0;
            }

            //when snake is already moving in left(same) direction

            if(xdir<0 && head.equals("left"))
            {
                for(int i=0;i<arrayx.length;i++)
                    arrayx[i] -= 5;


            }
            //when snake is not moving in left direction
            else {
                //BODY OF THE SNAKE
                if ( ydir>0 || head.equals("down") || head.equals("left")) {
                    for(int i=count+1;i<arrayx.length;i++)
                        arrayy[i] += 5;         //snake is facing south
                }
                else if(ydir<0 || head.equals("up"))
                {
                    for(int i=count+1;i<arrayx.length;i++)
                        arrayy[i]-=5;           //snake is facing north
                }
                //Head of the snake
                for(int i=0;i<=count;i++)
                  arrayx[i] -= 5;
                count++;
                if(count==store)
                {
                    count=0;
                    xdir=-1;
                    ydir=0;

                }

            }
            head="left";

        }
        else if(k.getKeyCode() == KeyEvent.VK_UP && !head.equals("down"))        //UP DIRECTION
        {
            if(!(head.equals("up"))) {
                store=count;
                count = 0;
            }
                //if snake is moving in the same direction
            if(ydir>0 && head.equals("up"))
            {
                for(int i=0;i<arrayx.length;i++) {
                    arrayy[i] -= 5;

                }
            }
            //if snake is not moving in the same direction
            else {
                //BODY OF THE SNAKE
                if (xdir>0 || head.equals("right") || head.equals("up")) {
                    for(int i=count+1;i<arrayx.length;i++)
                    arrayx[i] += 5;         //snake is facing right
                }
                else if ( xdir<0 || head.equals("left")) {
                    for(int i=count+1;i<arrayx.length;i++)
                    arrayx[i] -= 5;         //snake is facing left
                }
                //HEAD OF THE SNAKE
                for(int i=0;i<=count;i++) {
                    arrayy[i] -= 5;
                }

                count++;
                if(count==store)
                {
                    count=0;
                    xdir=0;
                    ydir=1;
                }
            }
            head="up";




        }
        else if(k.getKeyCode() == KeyEvent.VK_DOWN && !head.equals("up"))      //DOWN DIRECTION
        {
            if(!(head.equals("down"))) {
                store=count;
                count = 0;
            }
            if(head.equals("right"))
                ydir=0;


            //if snake is moving in same(down) direction
            if(ydir<0 && head.equals("down"))
            {
                for(int i=0;i<arrayx.length;i++)
                    arrayy[i]+=5;


            }
            //if snake is not moving in same direction(Down) direction
            else {
                    //BODY OF THE SNAKE
                if ( xdir>0  || head.equals("down") || head.equals("right")) {
                    for(int i=count+1;i<arrayx.length;i++)//FOR HEAD OF SNAKE
                    arrayx[i] += 5;     //down when snake is facing right
                }
                else if(xdir<0 || head.equals("left")) {
                    for(int i=count+1;i<arrayx.length;i++)
                        arrayx[i] -= 5;
                }//down when snake is facing left
                //HEAD OF THE SNAKE
                for(int i=0;i<=count;i++)
                 arrayy[i] += 5;
                count++;
                if(count==store)
                {
                    count=0;
                    xdir=0;
                    ydir=-1;

                }
            }
            head="down";



        }
        repaint();



    }


    public void keyReleased(KeyEvent k) {

    }


}
