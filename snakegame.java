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

   String head;     //direction of head
     int foodx;         //x point of the food
     int foody;         //y point of the food

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

        arrayx = new ArrayList<Integer>();
        arrayy =  new ArrayList<Integer>();
        foodx= (int) (Math.random()*90+1)*5;
        foody=(int) (Math.random()*90+1)*5;
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
        if(arrayx.get(0)==foodx && arrayy.get(0)==foody) {
            foodx= (int) (Math.random()*90+1)*5;
            foody=(int) (Math.random()*90+1)*5;

            arrayy.add(arrayy.get(arrayy.size()-1));
            arrayx.add(arrayx.get(arrayx.size()-1));

        }

        for(int i=0;i<arrayx.size();i++)
        {

            g.setColor(Color.white);
            g.fillRect(arrayx.get(i),arrayy.get(i), 5, 5);
        }



        g.fillRect(foodx,foody,5,5);


    }



    public void keyTyped(KeyEvent k) {

    }

    public void keyPressed(KeyEvent k)
    {
        timer.start();
            if(k.getKeyCode() == KeyEvent.VK_RIGHT && !head.equals("left"))
            {
                    head = "right";
            }
        else if(k.getKeyCode() == KeyEvent.VK_LEFT && !head.equals("right"))
        {
                head = "left";
        }
        else if(k.getKeyCode() == KeyEvent.VK_UP && !head.equals("down"))        //UP DIRECTION
        {
            head="up";

        }
        else if(k.getKeyCode() == KeyEvent.VK_DOWN && !head.equals("up"))      //DOWN DIRECTION
        {
            head="down";

        }




    }


    public void keyReleased(KeyEvent k) {

    }




    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {



        if(head.equals("right"))
        {
           // timer.start();

            for (int i = arrayx.size() - 1; i >= 1; i--)
            {

                arrayx.set(i, arrayx.get(i - 1));
            }
            for (int i = arrayy.size() - 1; i >= 1; i--)
            {
                arrayy.set(i, arrayy.get(i - 1));
            }
            //head of the snake

            arrayx.set(0, arrayx.get(0) + 5);
            repaint();

        }
        if(head.equals("left"))
        {
            for (int i = arrayx.size() - 1; i >= 1; i--) {

                arrayx.set(i, arrayx.get(i - 1));
            }
            for (int i = arrayy.size() - 1; i >= 1; i--) {
                arrayy.set(i, arrayy.get(i - 1));
            }
            //head of the snake

            arrayx.set(0, arrayx.get(0) - 5);
            repaint();

        }
        if(head.equals("up"))
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
            repaint();

        }
        if(head.equals("down"))
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
            repaint();

        }

    }
}
