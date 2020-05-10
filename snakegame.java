package snake2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class snakegame extends JFrame implements  KeyListener, ActionListener
{

   String head;
     int xdir=0;

     static ArrayList<Integer>  arrayx;      //to store x point of the snake
     static ArrayList<Integer> arrayy;//to store y point of the snake
    Timer timer;
    int delay=100;
    public snakegame() {
        head = "right";
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
        arrayx = new ArrayList<Integer>();
        arrayy =  new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayx.add(250-5*i);

        }
        for (int i = 0; i < 10; i++)
        {
            arrayy.add(250);
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
        System.out.println(arrayx.size());

        for(int i=0;i<arrayx.size();i++)
        {

            g.setColor(Color.white);
            g.fillRect(arrayx.get(i),arrayy.get(i), 5, 5);
        }

    }



    public void keyTyped(KeyEvent k) {

    }

    public void keyPressed(KeyEvent k)
    {
            if(k.getKeyCode() == KeyEvent.VK_RIGHT && !head.equals("left"))
            {
                    //
                    for (int i = arrayx.size() - 1; i >= 1; i--) {

                        arrayx.set(i, arrayx.get(i - 1));
                    }
                    for (int i = arrayy.size() - 1; i >= 1; i--) {
                        arrayy.set(i, arrayy.get(i - 1));
                    }
                    //head of the snake
                    arrayx.set(0, arrayx.get(0) + 5);
                    head = "right";





            }
        else if(k.getKeyCode() == KeyEvent.VK_LEFT && !head.equals("right"))
        {


                for (int i = arrayx.size() - 1; i >= 1; i--) {

                    arrayx.set(i, arrayx.get(i - 1));
                }
                for (int i = arrayy.size() - 1; i >= 1; i--) {
                    arrayy.set(i, arrayy.get(i - 1));
                }
                //head of the snake

                arrayx.set(0, arrayx.get(0) - 5);

                head = "left";



        }
        else if(k.getKeyCode() == KeyEvent.VK_UP && !head.equals("down"))        //UP DIRECTION
        {


            for(int i=arrayx.size()-1;i>=1;i--) {

                arrayx.set(i,arrayx.get(i-1));
            }
            for(int i=arrayy.size()-1;i>=1;i--)
            {
                arrayy.set(i,arrayy.get(i-1));
            }
            //head of the snake

            arrayy.set(0,arrayy.get(0)-5);
            head="up";






        }
        else if(k.getKeyCode() == KeyEvent.VK_DOWN && !head.equals("up"))      //DOWN DIRECTION
        {

            for(int i=arrayx.size()-1;i>=1;i--) {

                arrayx.set(i,arrayx.get(i-1));
            }
            for(int i=arrayy.size()-1;i>=1;i--)
            {
                arrayy.set(i,arrayy.get(i-1));
            }
            //head of the snake

            arrayy.set(0,arrayy.get(0)+5);
            head="down";





        }
        repaint();



    }


    public void keyReleased(KeyEvent k) {

    }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();

    }
}
