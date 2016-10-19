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
    Color Bars = new Color(234, 147, 249);
    // These control the Solvers!
    int X;
    int Y;
    int Z;
    char Team;
    int TempX;
    int TempY;
    int TempZ;
    int SearchValue = 0;
    int tracker;
    boolean Searching;
    Leaf LeafTree[] = new Leaf[500];
    public char[][][] simulation = new char[10][10][10];
    int FinalX = 0;
    int FinalY = 0;
    int FinalZ = 0;
    int FinalValue = 0;
    
    
    
    
    
    
    //End variables
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Graphics g = getGraphics();
            for(int Q = 0; Q < 1000; Q++)
            {
                BestMove('R');
                BestMove('G');
                BestMove('B');
                BestMove('Y');
                BestMove('O');
                //repaint();
            }
        }
    }
     

    ButtonListener aButtonListener = new ButtonListener();

    private class ClearButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for(Z = 0;Z < 10; Z++)
            {
                for(X = 0;X < 10;X++)
                {
                    for(Y = 0; Y < 10; Y++)
                    {
                        simulation[Z][X][Y] = '#';
                    }
                }
            }
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
            //if(i < 800 && j < 400)
            //{
                i = i - 800;
                j = j - 400;
                i = i / 20;
                j = j / 20;
                int z = 0;
                int h = i;
                int c = j;
                if(simulation[z][c][h] == '#')
                {
                    simulation[z][c][h] = 'R';
                }
                else if(simulation[z][c][h] != '#' && z < 10)
                {
                    while(simulation[z][c][h] != '#' && z < 10)
                    {
                        z = z + 1;
                    }
                    simulation[z][c][h] = 'R';
                }
                else
                {
                    //simulation[0][1][1] = 'R';
                }
            //}
            repaint();
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
    JButton aButton = new JButton("PLAY!");
    JButton clearButton = new JButton("REFRESH!");

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
        aButton.setBounds(450,450,200,50);
        rootPane.add(clearButton);
        clearButton.setBounds(450,500,200,50);
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
        
        //Move Updater - Needs to be second.
        for(Z = 0;Z < 10; Z++)
       {
           for(X = 0;X < 10;X++)
           {
               for(Y = 0; Y < 10; Y++)
               {
                   if(simulation[Z][Y][X] == 'R')
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
                   else if(simulation[Z][Y][X] == 'G')
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
                   else if(simulation[Z][Y][X] == 'B')
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
                   else if(simulation[Z][Y][X] == 'Y')
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
                   else if(simulation[Z][Y][X] == 'O')
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
    
    char getAt(int x, int y, int z) {
        return simulation[z][y][x];
    }

    // Gets the best move and executes it.
    public void BestMove(char Team)
    {
       this.Team = Team;
       tracker = 0;
           for(X = 0;X < 10;X++)
           {
                for(Y = 0; Y < 10; Y++)
                {
                    int S = 0;
                    if(simulation[S][Y][X] != '#')
                       {
                           while(S < 9 && simulation[S][Y][X] != '#')
                           {
                              // Z = Z + 1;
                               S = S + 1;
                           }
                       }
                    if(S == 0)
                    {
                       TempX = X;
                       TempY = Y;
                       TempZ = S;
                       
                       SearchValue = 1;
                       Searching = false;
                       while(Searching != true)
                       {
                           //System.out.println("TEST!");
                           if(Y != 0)
                           {
                               while (TempY > 0 && getAt(X, TempY - 1, S) == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while( TempX > 0 && TempY > 0 && simulation[TempZ][TempY - 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while(TempY > 0 && TempX < 9 && simulation[TempZ][TempY - 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX + 1;
                                }
                                TempX = X;
                                TempY = Y;
                                TempZ = S;
                           }
                           if(X != 0)
                           {
                               while(TempX > 0  && simulation[TempZ][TempY][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while(TempY < 9 && TempX > 0 && simulation[TempZ][TempY + 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   TempX = TempX - 1;
                                }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                           }
                           if(Y < 9)
                           {
                               while(TempY < 9 && simulation[TempZ][TempY + 1][TempX] == Team )
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   //TempX = TempX - 1;
                                }
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           if(X < 9)
                           {
                               while(TempX < 9 && simulation[TempZ][TempY][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                }     
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           if(X < 9 && Y < 9)
                           {
                               while(TempX < 9 && TempY < 9 && simulation[TempZ][TempY + 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                   TempY = TempY + 1;
                                }
                            }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           //System.out.println("TEST " + Z);
                           //FinalValue = SearchValue;
                           Leaf myLeaf = new Leaf(S,Y,X,SearchValue);
                           LeafTree[tracker] = myLeaf;
                           if(simulation[S][Y][X] == '#')
                           {
                               if(SearchValue >= FinalValue)
                               {
                                   FinalX = X;
                                   FinalY = Y;
                                   FinalZ = S; 
                                   FinalValue = SearchValue;
                               }
                               else
                               {
                                   
                               }
                           }
                           //System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                           Searching = true;
                       }
                    }
                    else
                    {
                       TempX = X;
                       TempY = Y;
                       TempZ = S;
                       SearchValue = 1;
                       Searching = false;
                       while(Searching != true)
                       {
                           
                           if(Y != 0)
                           {
                               while(TempY > 0 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while( TempX > 0 && TempY > 0 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while(TempY > 0 && TempX < 9 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX + 1;
                                }
                                TempX = X;
                                TempY = Y;
                                TempZ = S;
                           }
                           if(X != 0)
                           {
                               while(TempX > 0  &&TempZ > 0 && simulation[TempZ - 1][TempY][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while(TempY < 9 && TempX > 0 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   TempX = TempX - 1;
                                }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                           }
                           if(Y < 9)
                           {
                               while(TempY < 9 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX] == Team )
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   //TempX = TempX - 1;
                                }
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           if(X < 9)
                           {
                               while(TempX < 9 && TempZ > 0 && simulation[TempZ - 1][TempY][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                }     
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           if(X < 9 && Y < 9)
                           {
                               while(TempX < 9 && TempY < 9 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                   TempY = TempY + 1;
                                }
                            }
                         
                           
                           //Current Level
                           
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           SearchValue = 1;
                           Searching = false;
                           //System.out.println("TEST!");
                           if(Y != 0)
                           {
                               while(TempY > 0 && simulation[TempZ][TempY - 1][TempX] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while( TempX > 0 && TempY > 0 && simulation[TempZ][TempY - 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while(TempY > 0 && TempX < 9 && simulation[TempZ][TempY - 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX + 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                           }
                           if(X != 0)
                           {
                               while(TempX > 0  && simulation[TempZ][TempY][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S;
                               while(TempY < 9 && TempX > 0 && simulation[TempZ][TempY + 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = S ;
                           }
                           if(Y < 9)
                           {
                               while(TempY < 9 && simulation[TempZ][TempY + 1][TempX] == Team )
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   //TempX = TempX - 1;
                               }
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           if(X < 9)
                           {
                               while(TempX < 9 && simulation[TempZ][TempY][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                               }     
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           if(X < 9 && Y < 9)
                           {
                               while(TempX < 9 && TempY < 9 && simulation[TempZ][TempY + 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                   TempY = TempY + 1;
                               }
                           }
                           TempX = X;
                           TempY = Y;
                           TempZ = S;
                           //System.out.println("TEST" + Z);
                           //FinalValue = SearchValue;
                           Leaf myLeaf = new Leaf(S,Y,X,SearchValue);
                           //System.out.println(myLeaf.getX());
                           LeafTree[tracker] = myLeaf;
                           if(simulation[S][Y][X] == '#')
                           {
                               if(SearchValue >= FinalValue)
                               {
                                   FinalX = X;
                                   FinalY = Y;
                                   FinalZ = S; 
                                   FinalValue = SearchValue;
                               }
                               else
                               {
                                   
                               }
                           }
                           //System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                           Searching = true;
                       }
                    }
                }
            }
       simulation[FinalZ][FinalY][FinalX] = this.Team;
       repaint();
    }


    }
