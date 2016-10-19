import java.util.*;
public class Leaf
{
    public int positionX;
    public int positionY;
    public int positionZ;
    public int value;
    private int maxSize;
    public int location;
    
    // Variables for Best Value
    int X;
    int Y;
    int Z;
    char Team;
    int TempX;
    int TempY;
    int TempZ;
    int SearchValue;
    int tracker;
    boolean Searching;
    Leaf LeafTree[] = new Leaf[500];
    char[][][] simulation = new char[10][10][10];
    //Best move variables
    int FinalX = 0;
    int FinalY = 0;
    int FinalZ = 0;
    int FinalValue = 0;
    
    public Leaf(int positionZ , int positionX , int positionY , int value )
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.value = value;
    }
    public int ValueReturn()
    {
        return value;
    }
    public int getValue()
    {
        return value;
    }
    public int getX()
    {
        return positionX;
    }
    public int getY()
    {
        return positionY;
    }
    public int getZ()
    {
        return positionZ;
    }
    public void BestMove(char Team)
    {
       this.Team = Team;
        for(Z = 0;Z < 1; Z++)
       {
           for(X = 0;X < 10;X++)
           {
                for(Y = 0; Y < 10; Y++)
                {
                    if(Z == 0)
                    {
                       TempX = X;
                       TempY = Y;
                       TempZ = Z;
                       int S = 1;
                       if(simulation[S][X][Y] != '#')
                       {
                           while(S < 9 && simulation[S][X][Y] != '#')
                           {
                               Z = Z + 1;
                               S = S + 1;
                           }
                       }
                       SearchValue = 1;
                       Searching = false;
                       while(Searching != true)
                       {
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
                               TempZ = Z;
                               while( TempX > 0 && TempY > 0 && simulation[TempZ][TempY - 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY > 0 && TempX < 9 && simulation[TempZ][TempY - 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX + 1;
                                }
                                TempX = X;
                                TempY = Y;
                                TempZ = Z;
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
                               TempZ = Z;
                               while(TempY < 9 && TempX > 0 && simulation[TempZ][TempY + 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   TempX = TempX - 1;
                                }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
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
                           TempZ = Z;
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
                           TempZ = Z;
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
                           TempZ = Z;
                           //System.out.println("TEST " + Z);
                           value = SearchValue;
                           Leaf myLeaf = new Leaf(Z,X,Y,value);
                           LeafTree[tracker] = myLeaf;
                           if(SearchValue > FinalValue)
                           {
                               FinalX = X;
                               FinalY = Y;
                               FinalZ = Z; 
                               FinalValue = SearchValue;
                           }
                           System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                           Searching = true;
                       }
                    }
                    else
                    {
                       TempX = X;
                       TempY = Y;
                       TempZ = Z;
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
                               TempZ = Z;
                               while( TempX > 0 && TempY > 0 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY > 0 && TempX < 9 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX + 1;
                                }
                                TempX = X;
                                TempY = Y;
                                TempZ = Z;
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
                               TempZ = Z;
                               while(TempY < 9 && TempX > 0 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   TempX = TempX - 1;
                                }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
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
                           TempZ = Z;
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
                           TempZ = Z;
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
                           TempZ = Z;
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
                               TempZ = Z;
                               while( TempX > 0 && TempY > 0 && simulation[TempZ][TempY - 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY > 0 && TempX < 9 && simulation[TempZ][TempY - 1][TempX + 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX + 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
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
                               TempZ = Z;
                               while(TempY < 9 && TempX > 0 && simulation[TempZ][TempY + 1][TempX - 1] == Team)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
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
                           TempZ = Z;
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
                           TempZ = Z;
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
                           TempZ = Z;
                           //System.out.println("TEST" + Z);
                           value = SearchValue;
                           Leaf myLeaf = new Leaf(Z,X,Y,value);
                           //System.out.println(myLeaf.getX());
                           LeafTree[tracker] = myLeaf;
                           if(SearchValue > FinalValue)
                           {
                               FinalX = X;
                               FinalY = Y;
                               FinalZ = Z; 
                               FinalValue = SearchValue;
                           }
                           System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                           Searching = true;
                       }
                    }
                }
           }
       }
       simulation[FinalZ][FinalX][FinalY] = Team;
       System.out.println(simulation[FinalZ][FinalX][FinalY]);
    }
}

