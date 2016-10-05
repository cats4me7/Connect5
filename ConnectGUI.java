import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class GameOfLife - write a description of the class here
 *
 * @author (your name)
 * @version (a version number)
 */
public class ConnectGUI extends JApplet
{
    // instance variables - replace the example below with your own
     Color MenuColor = new Color(245,222,179);
    
    
    //End variables
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Graphics g = getGraphics();
            
        }
    }
     

    ButtonListener aButtonListener = new ButtonListener();

    private class ClearButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //This is the action for the action button
        }
     }
     
    ClearButtonListener clear = new ClearButtonListener();
    
    private class MousePressedListener implements MouseListener
    {
        public void mousePressed(MouseEvent e)
        {
            

        }

        public void mouseReleased(MouseEvent e)
        {
        }

        public void mouseClicked(MouseEvent e)
        {
        }

        public void mouseEntered(MouseEvent e)
        {
        }

        public void mouseExited(MouseEvent e)
        {
        }
     }

    MousePressedListener myListener = new MousePressedListener();

    JFrame myFrame = new JFrame();
    JPanel aPanel = new JPanel();
    JButton aButton = new JButton("TEMP");
    JButton clearButton = new JButton("TEMP");

     /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first
     * time that the start method is called.
     */
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do
        // not allow access to the AWT system event queue which JApplets do
        // on startup to check access. May not be necessary with your browserJRootPane rootPane = this.getRootPane();
        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        this.setSize(1002,602);
        aButton.setSize(150,150);
        aButton.addActionListener(aButtonListener);
        clearButton.addActionListener(clear);
        rootPane.add(aButton);
        aButton.setBounds(10,4000,100,100);
        rootPane.add(clearButton);
        clearButton.setBounds(10,5000,100,100);
        this.addMouseListener(myListener);
       

        // provide any initialisation necessary for your JApplet
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * should start its execution. It is called after the init method and
     * each time the JApplet is revisited in a Web page.
     */
    public void start()
    {
        // provide any code requred to run each time
        // web page is visited
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed.
     */
    public void stop()
    {
        // provide any code that needs   to be run when page
        // is replaced by another page or before JApplet is destroyed
    }

    /**
     * Paint method for applet.
     *
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
        // simple text displayed on applet
        //Base board
        g.setColor(MenuColor);
        g.fillRect(0,0,1000,1000);
        //The Top Row
        g.setColor(Color.black);
        g.drawRect(0,0,200,200);
        g.drawRect(200,0,200,200);
        g.drawRect(400,0,200,200);
        g.drawRect(600,0,200,200);
        g.drawRect(800,0,200,200);
        g.drawRect(0,0,1000,600);
        
        //The Bottom Row
        g.setColor(Color.black);
        g.drawRect(0,200,200,200);
        g.drawRect(200,200,200,200);
        g.drawRect(400,200,200,200);
        g.drawRect(600,200,200,200);
        g.drawRect(800,200,200,200);
        
        //The control Box - menu options.
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawRect(800,400,200,200);
        g.drawLine(400,400,400,600);
        g.drawString("Please Click a slpot to the right!",450,430);
        g.drawString("--------------------------------->",450,450);
        
        //Players
        g.setColor(Color.red);
        g.fillRect(10,420,20,20);
        g.drawString("Player 1",35,435);
        
        g.setColor(Color.green);
        g.fillRect(10,450,20,20);
        g.drawString("Player 2",35,465);
        
        g.setColor(Color.blue);
        g.fillRect(10,480,20,20);
        g.drawString("Player 3",35,495);
        
        g.setColor(Color.yellow);
        g.fillRect(10,510,20,20);
        g.drawString("Player 4",35,525);
        
        g.setColor(Color.orange);
        g.fillRect(10,540,20,20);
        g.drawString("Player 5",35,555);
    }

    


    }
