import java.util.Arrays;
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
    Color WIN = new Color(125,15,105);
    Color Bars = new Color(234, 147, 249);
    // These control the Solvers!
    int X;
    int Y;
    int Z;
    char Team = 'R';
    int TempX;
    int TempY;
    int TempZ;
    int SearchValue = 0;
    int tracker;
    boolean Searching;
    Leaf LeafTree[] = new Leaf[500];
    public char[][][] simulation = new char[10][10][10];
    int counter = 0;
    public int turn = 0;
    int S = 1;
    int TIME = 0;
    int AI1 = 0;
    int AI2 = 0;
    int AI3 = 0;
    int AI4 = 0;
    int AI5 = 0;
    int BoardSize = 10;
    boolean AIDone = false;
    int boot = 0;
    
    // CHECKER VARIABLES
    private Stack data = new Stack(5);
    private int rows=10;
    private int col=10;
    private int depth=10;
    private boolean valid = true;
    
    boolean ThisGame = true;
    //End variables
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Graphics g = getGraphics();
            String boardSize = JOptionPane.showInputDialog(myFrame, "Enter A floor Size ( 5 - 10)");
            BoardSize = Integer.parseInt(boardSize);
            simulation = Arrays.copyOf(simulation, BoardSize);
        }
    }
          

    ButtonListener aButtonListener = new ButtonListener();

    private class ClearButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AIDone = false;
            turn = 0;
            for(Z = 0;Z < BoardSize; Z++)
            {
                for(X = 0;X < BoardSize;X++)
                {
                    for(Y = 0; Y < BoardSize; Y++)
                    {
                        simulation[X][Y][Z] = '#';
                    }
                }
            }
            AIDone = false;
            repaint();
        }
    }
     
    ClearButtonListener clear = new ClearButtonListener();
    
    private class MousePressedListener implements MouseListener
    {
        
        public void mousePressed(MouseEvent e)
        {
            int i = e.getX();
            int j = e.getY();



            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
            //if(i < 800 && j < 400)
            //{
            i = i - 800;
            j = j - 400;
            i = i / 20;
            j = j / 20;
            int z = 0;
            int h = i;
            int c = j;
            if(AIDone == false)
            {
                if(turn == 0)
                {
                    Team = 'R';
                    if(AI1 == 0)
                    {
                        if(AI('R'))
                        {
                            AIDone = true;
                        }
                        else
                        {
                            turn = 1;
                        }
                    }
                    else if(AI1 == 1)
                    {
                        if(simulation[h][c][z] == '#')
                        {
                            ThisGame = false;
                            simulation[h][c][z] = Team;
                            if(check(h,c,z,Team))
                            {
                                simulation[h][c][z] = 'W';
                                repaint();
                                AIDone = true;
                            }
                            else
                            {
                                turn = 1;
                            }
                        }
                        else if(simulation[h][c][z] != '#' && z < BoardSize)
                        {
                            while(simulation[h][c][z] != '#' && z < BoardSize)
                            {
                                z = z + 1;
                            }
                            if(z != BoardSize)
                            {
                                simulation[h][c][z] = Team;
                                if(check(h,c,z,Team))
                                {
                                    simulation[h][c][z] = 'W';
                                    repaint();
                                    AIDone = true;
                                }
                                else
                                {
                                    turn = 1;
                                }
                            }
                        }
                        else
                        {
                            //simulation[0][1][1] = 'R';
                            
                        }
                    }
                    else
                    {
                        turn = 1;
                    }
                }
                else if(turn == 1)
                {
                    Team = 'G';
                    if(AI2 == 0)
                    {
                        if(AI('G'))
                        {
                            AIDone = true;
                        }
                        else
                        {
                            turn = 2;
                        }
                    }
                    else if(AI2 == 1)
                    {
                        if(simulation[h][c][z] == '#')
                        {
                            ThisGame = false;
                            simulation[h][c][z] = Team;
                            if(check(h,c,z,Team))
                            {
                                simulation[h][c][z] = 'W';
                                repaint();
                                AIDone = true;
                            }
                            else
                            {
                                turn = 2;
                            }
                        }
                        else if(simulation[h][c][z] != '#' && z < BoardSize)
                        {
                            while(simulation[h][c][z] != '#' && z < BoardSize)
                            {
                                z = z + 1;
                            }
                            if(z != BoardSize)
                            {
                                simulation[h][c][z] = Team;
                                if(check(h,c,z,Team))
                                {
                                    AIDone = true;
                                }
                                else
                                {
                                    turn = 2;
                                }
                            }
                        }
                        else
                        {
                            //simulation[0][1][1] = 'R';
                        }
                    }
                    else
                    {
                        turn = 2;
                    }
                }
                else if(turn == 2)
                {
                    Team = 'B';
                    if(AI3 == 0)
                    {
                        if(AI('B'))
                        {
                            AIDone = true;
                        }
                        else
                        {
                            turn = 3;
                        }
                    }
                    else if(AI3 == 1)
                    {
                        if(simulation[h][c][z] == '#')
                        {
                            ThisGame = false;
                            simulation[h][c][z] = Team;
                            if(check(h,c,z,Team))
                            {
                                simulation[h][c][z] = 'W';
                                repaint();
                                AIDone = true;
                            }
                            else
                            {
                                turn = 3;
                            }
                        }
                        else if(simulation[h][c][z] != '#' && z < BoardSize)
                        {
                            while(simulation[h][c][z] != '#' && z < BoardSize)
                            {
                                z = z + 1;
                            }
                            if(z != BoardSize)
                            {
                                simulation[h][c][z] = Team;
                                if(check(h,c,z,Team))
                                {
                                    AIDone = true;
                                }
                                else
                                {
                                    turn = 3;
                                }
                            }
                        }
                        else
                        {
                            //simulation[0][1][1] = 'R';
                        }
                    }
                    else
                    {
                        turn = 3;
                    }
                }
                else if(turn == 3)
                {
                    Team = 'Y';
                    if(AI4 == 0)
                    {
                        if(AI('Y'))
                        {
                            AIDone = true;
                        }
                        else
                        {
                            turn = 4;
                        }
                    }
                    else if(AI4 == 1)
                    {
                        if(simulation[h][c][z] == '#')
                        {
                            ThisGame = false;
                            simulation[h][c][z] = Team;
                            if(check(h,c,z,Team))
                            {
                                simulation[h][c][z] = 'W';
                                repaint();
                                AIDone = true;
                            }
                            else
                            {
                                turn = 4;
                            }
                        }
                        else if(simulation[h][c][z] != '#' && z < BoardSize)
                        {
                            while(simulation[h][c][z] != '#' && z < BoardSize)
                            {
                                z = z + 1;
                            }
                            if(z != BoardSize)
                            {
                                simulation[h][c][z] = Team;
                                if(check(h,c,z,Team))
                                {
                                    simulation[h][c][z] = 'W';
                                    repaint();
                                    AIDone = true;
                                }
                                else
                                {
                                    turn = 4;
                                }
                            }
                        }
                        else
                        {
                            //simulation[0][1][1] = 'R';
                        }
                    }
                    else
                    {
                        turn = 4;
                    }
                }
                else
                {
                    Team = 'O';
                    if(AI5 == 0)
                    {
                        if(AI('O'))
                        {
                            AIDone = true;
                        }
                        else
                        {
                            turn = 0;
                        }
                    }
                    else if(AI5 == 1)
                    {
                        if(simulation[h][c][z] == '#')
                        {
                            ThisGame = false;
                            simulation[h][c][z] = Team;
                            if(check(h,c,z,Team))
                            {
                                simulation[h][c][z] = 'W';
                                repaint();
                                AIDone = true;
                            }
                            else
                            {
                                turn = 0;
                            }
                        }
                        else if(simulation[h][c][z] != '#' && z < BoardSize)
                        {
                            while(simulation[h][c][z] != '#' && z < BoardSize)
                            {
                                z = z + 1;
                            }
                            if(z != BoardSize)
                            {
                                simulation[h][c][z] = Team;
                                if(check(h,c,z,Team))
                                {
                                    simulation[h][c][z] = 'W';
                                    repaint();
                                    AIDone = true;
                                }
                                else
                                {
                                    turn = 0;
                                }
                            }
                        }
                        else
                        {
                            //simulation[0][1][1] = 'R';
                        }
                    }
                    else
                    {
                        turn = 0;
                    }
                }
                repaint();
                
            }
            if(AIDone == true)
            {
                g.setColor(WIN);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
                g.drawString("WIN!!!!!!",350,300);
            }
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
     
    private class AI1ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Graphics g = getGraphics();
            if(AI1 == 0)
            {
                AI1 = 1;
            }
            else if(AI1 == 1)
            {
                AI1 = 2;
            }
            else
            {
                AI1 = 0;
            }
            repaint();
            
        }
        
    }
    AI1ButtonListener AI1mode = new AI1ButtonListener();

    private class AI2ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Graphics g = getGraphics();
            if(AI2 == 0)
            {
                AI2 = 1;
            }
            else if(AI2 == 1)
            {
                AI2 = 2;
            }
            else
            {
                AI2 = 0;
            }
            repaint();
            
        }
        
    }
    AI2ButtonListener AI2mode = new AI2ButtonListener();
    
    private class AI3ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Graphics g = getGraphics();
            if(AI3 == 0)
            {
                AI3 = 1;
            }
            else if(AI3 == 1)
            {
                AI3 = 2;
            }
            else
            {
                AI3 = 0;
            }
            repaint();
            
        }
        
    }
    AI3ButtonListener AI3mode = new AI3ButtonListener();
    
    
    private class AI4ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Graphics g = getGraphics();
            if(AI4 == 0)
            {
                AI4 = 1;
            }
            else if(AI4 == 1)
            {
                AI4 = 2;
            }
            else
            {
                AI4 = 0;
            }
            repaint();
            
        }
        
    }
    AI4ButtonListener AI4mode = new AI4ButtonListener();
    
    private class AI5ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Graphics g = getGraphics();
            if(AI5 == 0)
            {
                AI5 = 1;
            }
            else if(AI5 == 1)
            {
                AI5 = 2;
            }
            else
            {
                AI5 = 0;
            }
            repaint();
            
        }
        
    }
    AI5ButtonListener AI5mode = new AI5ButtonListener();
    
    JFrame myFrame = new JFrame();
    JPanel aPanel = new JPanel();
    JButton aButton = new JButton("Set simulation Size");
    JButton clearButton = new JButton("REFRESH!");
    JButton AI1Button = new JButton("Player - AI/Player/None");
    JButton AI2Button = new JButton("Player - AI/Player/None");
    JButton AI3Button = new JButton("Player - AI/Player/None");
    JButton AI4Button = new JButton("Player - AI/Player/None");
    JButton AI5Button = new JButton("Player - AI/Player/None");

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
        AI1Button.addActionListener(AI1mode);
        AI2Button.addActionListener(AI2mode);
        AI3Button.addActionListener(AI3mode);
        AI4Button.addActionListener(AI4mode);
        AI5Button.addActionListener(AI5mode);
        rootPane.add(aButton);
        aButton.setBounds(450,450,200,50);
        rootPane.add(clearButton);
        clearButton.setBounds(450,550,200,50);
        rootPane.add(AI1Button);
        AI1Button.setBounds(120,420,200,20);
        rootPane.add(AI2Button);
        AI2Button.setBounds(120,450,200,20);
        rootPane.add(AI3Button);
        AI3Button.setBounds(120,480,200,20);
        rootPane.add(AI4Button);
        AI4Button.setBounds(120,510,200,20);
        rootPane.add(AI5Button);
        AI5Button.setBounds(120,540,200,20);
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
        //Base simulation
        g.setColor(MenuColor);
        g.fillRect(0,0,1000,1000);
        if(boot == 0)
        {
            for(Z = 0;Z < BoardSize; Z++)
            {
                for(X = 0;X < BoardSize;X++)
                {
                    for(Y = 0; Y < BoardSize; Y++)
                    {
                        simulation[X][Y][Z] = '#';
                    }
                }
            }
            boot = 1;
        }
        boot = 1;
        //Move Updater - Needs to be second.
        for(X = 0;X < BoardSize; X++)
        {
            for(Y = 0;Y < BoardSize;Y++)
            {
                for(Z = 0; Z < BoardSize; Z++)
                {
                    if(simulation[X][Y][Z] == 'R')
                    {
                        g.setColor(Color.red);
                        if(Z < 5)
                        {
                            g.fillRect((X * 20) + (Z * 200), Y * 20,20,20);
                        }
                        else
                        {
                            int TZ = Z - 5;
                            g.fillRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                        }
                    }
                    else if(simulation[X][Y][Z] == 'G')
                    {
                        g.setColor(Color.green);
                        if(Z < 5)
                        {
                            g.fillRect((X * 20) + (Z * 200), Y * 20,20,20);
                        }
                        else
                        {
                            int TZ = Z - 5;
                            g.fillRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                        }
                    }
                    else if(simulation[X][Y][Z] == 'B')
                    {
                        g.setColor(Color.blue);
                        if(Z < 5)
                        {
                            g.fillRect((X * 20) + (Z * 200), Y * 20,20,20);
                        }
                        else
                        {
                            int TZ = Z - 5;
                            g.fillRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                        }
                    }
                    else if(simulation[X][Y][Z] == 'Y')
                    {
                        g.setColor(Color.yellow);
                        if(Z < 5)
                        {
                            g.fillRect((X * 20) + (Z * 200), Y * 20,20,20);
                        }
                        else
                        {
                            int TZ = Z - 5;
                            g.fillRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                        }
                    }
                    else if(simulation[X][Y][Z] == 'O')
                    {
                        g.setColor(Color.orange);
                        if(Z < 5)
                        {
                            g.fillRect((X * 20) + (Z * 200), Y * 20,20,20);
                        }
                        else
                        {
                            int TZ = Z - 5;
                            g.fillRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                        }
                    }
                    else if(simulation[X][Y][Z] == 'W')
                    {
                        g.setColor(WIN);
                        if(Z < 5)
                        {
                            g.fillRect((X * 20) + (Z * 200), Y * 20,20,20);
                        }
                        else
                        {
                            int TZ = Z - 5;
                            g.fillRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                        }
                    }
                    else
                    {
                        
                    }
                }
            }
        }

        //Grid for the display
        for(Z = 0;Z < 10; Z++)
        {
            for(X = 0;X < 10;X++)
            {
                for(Y = 0; Y < 10; Y++)
                {
                    g.setColor(Color.black);
                    if(Z < 5)
                    {
                        g.drawRect((X * 20) + (Z * 200), Y * 20,20,20);
                    }
                    else
                    {
                        int TZ = Z - 5;
                        g.drawRect((X * 20) + (TZ * 200),((Y * 20) + 200),20,20);

                    }
                }
            }
        }
        for(int x = 0; x < 10; x++)
        {
            for(int y = 0; y < 10; y++)
            {
                g.setColor(Color.black);
                g.drawRect(x * 20 + 800,y * 20 + 400,20,20);
            }
        }

        //The Top Row
        g.setColor(Color.black);
        g.fillRect(199,0,3,400);
        g.fillRect(399,0,3,800);
        g.fillRect(599,0,3,400);
        g.fillRect(799,0,3,800);
        g.fillRect(999,0,3,800);
        g.fillRect(0,199,1000,3);
        g.fillRect(0,399,1000,3);
        g.fillRect(0,599,1000,3);
        g.fillRect(0,0,1000,2);
        g.fillRect(0,0,2,600);
        //The Bottom Row



        //The control Box - menu options.
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawRect(800,400,200,200);
        g.drawLine(400,400,400,600);
        g.drawString("Please Click a spot to the right!",450,430);
        g.drawString("--------------------------------->",450,450);
        g.drawString("Click for every move ( AI included )",450,530);


        //Players
        g.setColor(Color.red);
        g.fillRect(10,420,20,20);
        g.drawString("Player 1",35,435);
        if(AI1 == 0)
        {
            g.drawString("AI",330,435);
        }
        else if(AI1 == 1)
        {
            g.drawString("Player",330,435);
        }
        else
        {
            g.drawString("NONE",330,435);
        }

        g.setColor(Color.green);
        g.fillRect(10,450,20,20);
        g.drawString("Player 2",35,465);
        if(AI2 == 0)
        {
            g.drawString("AI",330,465);
        }
        else if(AI2 == 1)
        {
            g.drawString("Player",330,465);
        }
        else
        {
            g.drawString("NONE",330,465);
        }

        g.setColor(Color.blue);
        g.fillRect(10,480,20,20);
        g.drawString("Player 3",35,495);
        if(AI3 == 0)
        {
            g.drawString("AI",330,495);
        }
        else if(AI3 == 1)
        {
            g.drawString("Player",330,495);
        }
        else
        {
            g.drawString("NONE",330,495);
        }

        g.setColor(Color.yellow);
        g.fillRect(10,510,20,20);
        g.drawString("Player 4",35,525);
        if(AI4 == 0)
        {
            g.drawString("AI",330,525);
        }
        else if(AI4 == 1)
        {
            g.drawString("Player",330,525);
        }
        else
        {
            g.drawString("NONE",330,525);
        }

        g.setColor(Color.orange);
        g.fillRect(10,540,20,20);
        g.drawString("Player 5",35,555);
        if(AI5 == 0)
        {
            g.drawString("AI",330,555);
        }
        else if(AI5 == 1)
        {
            g.drawString("Player",330,555);
        }
        else
        {
            g.drawString("NONE",330,555);
        }
    }
    
     char getAt(int x, int y, int z) {
        return simulation[x][y][z];
    }

    boolean Legal(int x , int y)
    {
        if(simulation[x][y][(BoardSize-1)] == '#')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean Place(int x, int y, char Team)
    {
        int zed = 0;
        while(zed < BoardSize && simulation[x][y][zed] != '#')
        {
            zed = zed + 1;
        }
        if(zed < BoardSize)
        {
            simulation[x][y][zed] = Team;
            return true;
        }
        else
        {
            return false;
        }
    }

    int FindZ(int x, int y)
    {
        int zed = 0;
        while(zed < BoardSize && simulation[x][y][zed] != '#' )
        {
            zed = zed + 1;
        }
        return zed;
    }

    //Very Simple AI, just does boardSize. Its a start.
    boolean AI(char Team)
    {
        Graphics g = getGraphics();
        int TestValue = 1;
        int FinalValue = 0;
        int FX = 0;
        int FY = 0;
        int FZ = 0;
        int zed = 0;
        for(int AIX = 0; AIX < BoardSize; AIX = AIX + 1)
        {
            for(int AIY = 0; AIY < BoardSize; AIY = AIY + 1)
            {
                if(Legal(AIX,AIY))
                {
                    zed = FindZ(AIX,AIY);
                    TestValue = TestValue + LeftFind(AIX,AIY,zed,Team) + RightFind(AIX,AIY,zed,Team) + UpFind(AIX,AIY,zed,Team) + DownFind(AIX,AIY,zed,Team) + UpRightFind(AIX,AIY,zed,Team)
                            + UpLeftFind(AIX,AIY,zed,Team) + DownRightFind(AIX,AIY,zed,Team) + DownLeftFind(AIX,AIY,zed,Team);
                    if(TestValue > FinalValue)
                    {
                        FinalValue = TestValue;
                        FX = AIX;
                        FY = AIY;
                        FZ = zed;
                    }
                }
            }
        }
        Place(FX,FY,Team);
        repaint();
        if(check(FX,FY,FZ,Team))
        {
            simulation[FX][FY][FZ] = 'W';
            repaint();
            return true;
        }
        else
        {
            return false;
        }
    }

    int LeftFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if(x - 1 > 0)
        {
            if((x - 1) > 0)
            {
                while(x > 0 && simulation[z][x - 1][y] == Team)
                {
                    SearchValue = SearchValue + 1;
                    x = x - 1;
                    if(x == 0)
                    {
                        return SearchValue;
                    }
                }
            }
            else
            {
                return SearchValue;
            }
        }
        return SearchValue;
    }

    int RightFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if((x + 1) < BoardSize)
        {
            while(x < (BoardSize-1) && simulation[z][x + 1][y] == Team)
            {
                if(x+1 < BoardSize)
                {
                    SearchValue = SearchValue + 1;
                    x = x + 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;
    }


    int UpFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if((y + 1) < BoardSize)
        {
            while( y < (BoardSize-1) && simulation[z][x][y + 1] == Team)
            {
                if((y + 1) < BoardSize)
                {
                    SearchValue = SearchValue + 1;
                    y = y + 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;
    }

    int DownFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if((y - 1) > 0)
        {
            while(y > 0 && simulation[z][x][y - 1] == Team)
            {
                if((y - 1) > 0)
                {
                    SearchValue = SearchValue + 1;
                    y = y - 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;
    }

    int UpLeftFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if(((y - 1) >= 0) && ((x - 1) >= 0))
        {
            while((y > 0 && x > 0) && simulation[z][x - 1][y - 1] ==Team)
            {
                if(((y - 1) > 0) && ((x - 1) > 0))
                {
                    SearchValue = SearchValue + 1;
                    x = x - 1;
                    y = y - 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;
    }

    int UpRightFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if(((y - 1) >= 0) && ((x + 1) < BoardSize))
        {
            while((x < (BoardSize-1) && y > 0) && simulation[z][x + 1][y - 1] == Team)
            {
                if(((y - 1) > 0) && ((x + 1) < BoardSize))
                {
                    SearchValue = SearchValue + 1;
                    x = x + 1;
                    y = y - 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;

    }
    int DownLeftFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if(((y + 1) < BoardSize) && ((x - 1) > 0))
        {
            while(( y < (BoardSize-1) && x > 0) && simulation[z][x - 1][y + 1] == Team)
            {
                if(((y + 1) < BoardSize) && ((x - 1) > 0))
                {
                    SearchValue = SearchValue + 1;
                    x = x - 1;
                    y = y + 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;
    }

    int DownRightFind(int x, int y, int z, char Team)
    {
        SearchValue = 0;
        if(((y + 1) < BoardSize) && ((x + 1) < BoardSize))
        {
            while((y < (BoardSize-1) && x < (BoardSize-1)) && simulation[z][x + 1][y + 1] == Team)
            {
                if(((y + 1) < BoardSize) && ((x + 1) < BoardSize))
                {
                    SearchValue = SearchValue + 1;
                    x = x + 1;
                    y = y + 1;
                }
                else
                {
                    return SearchValue;
                }
            }
        }
        return SearchValue;
    }

    //CHECKER STUFF
    public int getASize() {return data.getSize();}

    public boolean isAdjacent(int x, int y, int z, char c) {
        try{
            if (simulation[x][y][z] == c) {
                return true;
            }
            else return false;
        }
        catch (ArrayIndexOutOfBoundsException ex){return false;}
    }

    public boolean isOut(int x, int y, int z){
        if (x>=BoardSize || x<0)return true;
        else if (y>=BoardSize || y<0) return true;
        else if (z>=BoardSize || z<0) return true;
        else return false;
    }

    /*
    Checks the x direction for a win condition.
     */
    public boolean checkX(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), y, z, c)) {
                data.push(simulation[(x + a)][y][z]);
            }
            else if (isOut((x+a),y,z)){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getASize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(t,y,z,c)){
                    data.push(simulation[t][y][z]);
                }
            }
        }
        if (getASize()==5) {return true;}
        else {
            int temp = getASize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x - b), y, z, c)) {
                    data.push(simulation[(x - b)][y][z]);
                }
                else if (isOut((x-b),y,z)){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track==2){
                temp = getASize();
                for(int t = (BoardSize-1); t>((BoardSize-1)-(5-temp));t--){
                    if (isAdjacent(t,y,z,c)){
                        data.push(simulation[t][y][z]);
                    }
                }
            }
            if (getASize() == 5) return true;
            else {
                data.clear();
                data.push(simulation[x][y][z]);
                return false;
            }
        }
    }

    /*
    Checks y direction for win condition.
     */
    public boolean checkY(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent(x, (y+a), z, c)) {
                data.push(simulation[x][(y+a)][z]);
            }
            else if (isOut(x,(y+a),z)){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getASize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(x,t,z,c)){
                    data.push(simulation[x][t][z]);
                }
            }
        }
        if (getASize()==5) return true;
        else {
            int temp = getASize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent(x, (y-b), z, c)) {
                    data.push(simulation[x][(y-b)][z]);
                }
                else if (isOut(x,(y-b),z)){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track==2){
                temp = getASize();
                for(int t = (BoardSize-1); t>((BoardSize-1)-(5-temp));t--){
                    if (isAdjacent(x,t,z,c)){
                        data.push(simulation[x][t][z]);
                    }
                }
            }
            if (getASize() == 5) return true;
            else {
                data.clear();
                data.push(simulation[x][y][z]);
                return false;
            }
        }
    }

    /*
    Checks z direction for win condition.
     */
    public boolean checkZ(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent(x, y, (z-a), c)) {
                data.push(simulation[x][y][(z-a)]);
            }
            else break;
        }

        if (getASize()==5) return true;
        else {
            int temp = getASize();
            if (isOut(x,y,(z+1))){
                for (int b = 0; b<(5-temp); b++){
                    if (isAdjacent(x,y,b,c)){
                        data.push(simulation[x][y][b]);
                    }
                }
            }
            if(getASize()==5) return true;
            else{
                data.clear();
                data.push(simulation[x][y][z]);
                return false;
            }
        }
    }

    /*
    Checks diagonal directions for win condition.
     */
    public boolean checkXD(int x, int y, int z, char c) {
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), y, (z + a), c)) {
                data.push(simulation[(x + a)][y][(z + a)]);
            }
            else if (isOut((x+a),y,z) && isOut(x,y,(z+a))){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getASize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(t,y,t,c)){
                    data.push(simulation[t][y][t]);
                }
                else break;
            }
        }
        if (getASize() == 5) return true;
        else {
            int temp = getASize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x - b), y, (z-b), c)) {
                    data.push(simulation[(x - b)][y][(z-b)]);
                }
                else if (isOut((x-b),y,z) && isOut(x,y,(z-b))){
                    track = 2;
                    break;
                }
                else break;
            }
            if(track==2){
                for(int t = (BoardSize-1); t > ((BoardSize-1)-(5-temp));t++){
                    if(isAdjacent(t,y,t,c)){
                        data.push(simulation[t][y][t]);
                    }
                    else break;
                }
            }
            if (getASize() == 5) return true;
            else {
                data.clear();
                data.push(simulation[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    if (isAdjacent((x + a), y, (z - a), c)) {
                        data.push(simulation[(x + a)][y][(z - a)]);
                    }
                    else if (isOut((x+a),y,z) && isOut(x,y,(z-a))){
                        track = 3;
                    }
                    else break;
                }
                if (track == 3){
                    for(int t = (BoardSize-1); t > ((BoardSize-1)-(5-temp));t++){
                        if(isAdjacent(t,y,t,c)){
                            data.push(simulation[t][y][t]);
                        }
                        else break;
                    }
                }
                if (getASize() == 5) return true;
                else {
                    temp = getASize();
                    for (int b = 1; b <= (5-temp); b++) {
                        if (isAdjacent((x - b), y, (z+b), c)) {
                            data.push(simulation[(x - b)][y][(z+b)]);
                        }
                    }
                }
                if (getASize() == 5) return true;
                else return false;
            }
        }
    }

    public boolean checkYD(int x, int y, int z, char c) {
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent(x + a, (y+a), (z + a), c)) {
                data.push(simulation[x][(y+a)][(z + a)]);
            }
            else if (isOut(x,(y+a),z) && isOut(x,y,(z+a))){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getASize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(x,t,t,c)){
                    data.push(simulation[x][t][t]);
                }
                else break;
            }
        }
        if (getASize() == 5) return true;
        else {
            int temp = getASize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent(x, (y-b), (z-b), c)) {
                    data.push(simulation[x][(y-b)][(z-b)]);
                }
                else if (isOut(x,(y-b),z) && isOut(x,y,(z-b))){
                    track = 2;
                    break;
                }
                else break;
            }
            if(track==2){
                for(int t = (BoardSize-1); t< ((BoardSize-1)-(5-temp));t++){
                    if(isAdjacent(x,t,t,c)){
                        data.push(simulation[x][t][t]);
                    }
                    else break;
                }
            }
            if (getASize() == 5) return true;
            else {
                data.clear();
                data.push(simulation[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    if (isAdjacent(x, (y+a), (z - a), c)) {
                        data.push(simulation[x][(y+a)][(z - a)]);
                    }
                    else if (isOut(x,(y+a),z) && isOut(x,y,(z-a))){
                        track = 3;
                    }
                    else break;
                }
                if (getASize() == 5) return true;
                else {
                    temp = getASize();
                    for (int b = 1; b <= (5-temp); b++) {
                        if (isAdjacent(x, (y-b), (z+b), c)) {
                            data.push(simulation[x][(y-b)][(z+b)]);
                        }
                        else break;
                    }
                }
                if (getASize() == 5) return true;
                else return false;
            }
        }
    }


    

        public boolean checkXY(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), (y+a), z, c)) {
                data.push(simulation[(x + a)][(y+a)][z]);
            }
            else if (isOut((x+a),y,z) && isOut(x,(y+a),z)){
                track = 1;
                break;
            }
            else break;
        }
        if (track == 1){
            int temp = getASize();
            for(int t = 0; t<(5-temp);t++){
                if (isAdjacent(t,t,z,c)){
                    data.push(simulation[t][t][z]);
                }
                else break;
            }
        }
        if (getASize()==5) {return true;}
        else {
            int temp = getASize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x - b), (y-b), z, c)) {
                    data.push(simulation[(x - b)][(y-b)][z]);
                }
                else if (isOut((x-b),y,z) && isOut(x,(y-b),z)){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track==2){
                temp = getASize();
                for(int t = (rows-1); t>((rows-1)-(5-temp));t--){
                    if (isAdjacent(t,t,z,c)){
                        data.push(simulation[t][t][z]);
                    }
                    else break;
                }
            }
            if (getASize() == 5) return true;
            else {
                data.clear();
                data.push(simulation[x][y][z]);
                for(int a =1;a<=4;a++){
                    if(isAdjacent((x+a),(y-a),z,c)){
                        data.push(simulation[(x+a)][(y-a)][z]);
                    }
                    else if (isOut((x+a),y,z) && isOut(x,(y-a),z)){
                        track = 3;
                        break;
                    }
                    else break;
                }
                if (track==3){
                    int tempX = 0;
                    for (int t = (rows-1);t>((rows-1)-(5-temp));t--){
                        if(isAdjacent(tempX,t,z,c)) {
                            data.push(simulation[tempX][t][z]);
                            tempX++;
                        }
                        else break;
                    }
                }
                if (getASize()==5) return true;
                else {
                    for(int b =1;b<=(5-temp);b++){
                        if (isAdjacent((x-b),(y+b),z,c)){
                            data.push(simulation[(x-b)][(y+b)][z]);
                        }
                        else if (isOut((x-b),y,z) && isOut(x,(y+b),z)){
                            track = 4;
                            break;
                        }
                        else break;
                    }
                    if (track == 4){
                        int tempY = 0;
                        for(int t = (rows-1); t>(rows-1)-(5-temp);t--){
                            if(isAdjacent(t,tempY,z,c)){
                                data.push(simulation[t][tempY][z]);
                                tempY++;
                            }
                            else break;
                        }
                    }
                    if (getASize()==5) return true;
                    else {
                        data.clear();
                        data.push(simulation[x] [y][z]);
                        return false;
                }
            }
        }
    }
}
    
    public int getDepth(){return depth;}

     public boolean checkXYD(int x, int y, int z, char c){
        int track = 0;
        for (int a = 1; a <= 4; a++) {
            if (isAdjacent((x + a), (y+a), (z + a), c)) {
                data.push(simulation[(x + a)][(y+a)][(z + a)]);
            }
            else if (isOut((x+a),y,z) && isOut(x,(y+a),z) && isOut(x,y,(z+a))){
                track = 1;
                break;
            }
            else break;
        }
        if (track==1){
            int temp = getASize();
            for(int t=0;t<(5-temp);t++){
                if(isAdjacent(t,t,t,c)){
                    data.push(simulation[t][t][t]);
                }
                else break;
            }
        }
        if (getASize() == 5) return true;
        else {
            int temp = getASize();
            for (int b = 1; b <= (5-temp); b++) {
                if (isAdjacent((x-b),(y-b),(z-b), c)) {
                    data.push(simulation[(x-b)][(y-b)][(z-b)]);
                }
                else if (isOut((x-b),y,z) && isOut(x,(y-b),z) && isOut(x,y,(z-b))){
                    track = 2;
                    break;
                }
                else break;
            }
            if (track == 2){
                temp = getASize();
                for(int t=(rows-1);t>((rows-1)-(5-temp));t--){
                    if(isAdjacent(t,t,t,c)){
                        data.push(simulation[t][t][t]);
                    }
                    else break;
                }
            }
            if (getASize() == 5) return true;
            else {
                data.clear();
                data.push(simulation[x][y][z]);
                for (int a = 1; a <= 4; a++) {
                    if (isAdjacent((x+a),(y+a),(z-a), c)) {
                        data.push(simulation[(x+a)][(y+a)][(z-a)]);
                    }
                    else if (isOut((x+a),y,z) && isOut(x,(y+a),z) && isOut(x,y,(z-a))){
                        track = 3;
                    }
                    else break;
                }
                if (track == 3){
                    temp = getASize();
                    int tempD=getDepth();
                    for(int t=0;t<(5-temp);t++) {
                        tempD--;
                        if(isAdjacent(t,t,tempD,c)){
                            data.push(simulation[t][t][tempD]);
                        }
                        else break;
                    }
                }
                if (getASize() == 5) return true;
                else {
                    temp = getASize();
                    for (int b = 1; b <= (5-temp); b++) {
                        if (isAdjacent((x-b),(y-b),(z+b), c)) {
                            data.push(simulation[(x-b)][(y-b)][(z+b)]);
                        }
                        else if (isOut((x-b),y,z) && isOut(x,(y-b),z) && isOut(x,y,(z+b))){
                            track = 4;
                            break;
                        }
                        else break;
                    }
                }
                if (track == 4){
                    int tempD = 0;
                    for(int t = (rows-1); t>((rows-1)-(5-temp));t--){
                        if(isAdjacent(t,t,tempD,c)){
                            data.push(simulation[t][t][tempD]);
                            tempD++;
                        }
                        else break;
                    }
                }
                if (getASize() == 5) return true;
                else {
                    data.clear();
                    data.push(simulation[x][y][z]);
                    for (int a = 1; a <= 4; a++) {
                        if (isAdjacent((x+a),(y-a),(z+a), c)) {
                            data.push(simulation[(x+a)][(y-a)][(z+a)]);
                        }
                        else if (isOut((x+a),y,z) && isOut(x,(y-a),z) && isOut(x,y,(z+a))){
                            track = 5;
                            break;
                        }
                        else break;
                    }
                    if (track == 5){
                        int tempX = 0;
                        for(int t = (col-1); t>((col-1)-(5-temp));t--){
                            if(isAdjacent(tempX,t,tempX,c)){
                                data.push(simulation[tempX][t][tempX]);
                                tempX++;
                            }
                            else break;
                        }
                    }
                    if (getASize() == 5) return true;
                    else {
                        temp = getASize();
                        for (int b = 1; b <= (5-temp); b++) {
                            if (isAdjacent((x-b),(y+b),(z-b), c)) {
                                data.push(simulation[(x-b)][(y+b)][(z-b)]);
                            }
                            else if (isOut((x-b),y,z) && isOut(x,(y+b),z) && isOut(x,y,(z-b))){
                                track = 6;
                                break;
                            }
                            else break;
                        }
                    }
                    if (track == 6){
                        int tempY = 0;
                        for(int t = (rows-1);t>((rows-1)-(5-temp));t--){
                            if(isAdjacent(t,tempY,t,c)){
                                data.push(simulation[t][tempY][t]);
                                tempY++;
                            }
                            else break;
                        }
                    }
                    if (getASize() == 5) return true;
                    else{
                        data.clear();
                        data.push(simulation[x][y][z]);
                        for (int a = 1; a <= 4; a++) {
                            if (isAdjacent((x-a),(y+a),(z+a), c)) {
                                data.push(simulation[(x-a)][(y+a)][(z+a)]);
                            }
                            else if (isOut((x-a),y,z) && isOut(x,(y+a),z) && isOut(x,y,(z+a))){
                                track = 7;
                                break;
                            }
                            else break;
                        }
                        if(track == 7){
                            int tempD = 0;
                            for(int t = (rows - 1);t>((rows - 1)-(5-temp));t--){
                                if(isAdjacent(t,tempD,tempD,c)){
                                    data.push(simulation[t][tempD][tempD]);
                                    tempD++;
                                }
                                else break;
                            }
                        }
                        if (getASize() == 5) return true;
                        else {
                            temp = getASize();
                            for (int b = 1; b <= (5-temp); b++) {
                                if (isAdjacent((x+b),(y-b),(z-b), c)) {
                                    data.push(simulation[(x+b)][(y-b)][(z-b)]);
                                }
                                else if (isOut((x+b),y,z) && isOut(x,(y-b),z) && isOut(x,y,(z-b))){
                                    track = 8;
                                    break;
                                }
                                else break;
                            }
                        }
                        if(track == 8){
                            int tempX=0;
                            for(int t = (col-1);t>((col-1)-(5-temp));t--){
                                if(isAdjacent(tempX,t,t,c)){
                                    data.push(simulation[tempX][t][t]);
                                    tempX++;
                                }
                                else break;
                            }
                        }
                        if (getASize() == 5) return true;
                        else return false;
                    }
                }
            }
        }
    }

    /*
    Uses previous methods to check all directions for win condition.
    */
    public boolean check(int x, int y, int z, char c) {
        try {
            if (simulation[x][y][z] == c) {
                data.push(simulation[x][y][z]);
                if (checkX(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else if (checkY(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else if (checkXY(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else if (checkXD(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else if (checkYD(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else if (checkXYD(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else if (checkZ(x, y, z, c)) {
                    data.clear();
                    return true;
                }
                else {
                    data.clear();
                    return false;
                }
            } else {
                data.clear();
                return false;
            }
        }catch(ArrayIndexOutOfBoundsException ex){return false;}
    }


}

    

