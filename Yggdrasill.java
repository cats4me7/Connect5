
/**
 * Will run the AI - named after the norse world tree.
 * 
 * Justin Cavender
 * .42
 */
public class Yggdrasill
{
   public static void main (String args[]) 
   {
       Leaf LeafTree[] = new Leaf[500];
       int X = 0;
       int Y = 0;
       int Z = 0;
       int simVal = 1;
       int SimX = 0;
       int SimY = 0;
       int SimZ = 0;
       char[][][] simulation = new char[10][10][10];
       int tracker = 0;
       int positionX;
       int positionY;
       int positionZ;
       int value = 0;
       int O = 0;
       char player1 = 'R';
       char player2 = 'B';
       int I = 0;
       int J = 0;
       
       //VARIABLES FOR SEARCHING!
       int TempX = 0;
       int TempY = 0;
       int TempZ = 0;
       int SearchValue = 1;
       boolean Searching = false;
       
       for(Z = 0;Z < 4; Z++)
       {
           for(X = 0;X < 10;X++)
           {
               for(Y = 0; Y < 10; Y++)
               {
                   if(X == 0 || X == 2 || X == 4 || X == 6 || X == 8)
                   {
                       simulation[Z][X][Y] = 'R';
                   }
                   else
                   {
                       simulation[Z][X][Y] = 'B';
                   }
               }
           }
       }
    
       //Print Everything!!!
         
       for(Z = 0;Z < 10; Z++)
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
                       SearchValue = 1;
                       Searching = false;
                       while(Searching != true)
                       {
                           System.out.println("TEST!");
                           if(Y != 0)
                           {
                               while(TempY > 0 && simulation[TempZ][TempY - 1][TempX] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while( TempX > 0 && TempY > 0 && simulation[TempZ][TempY - 1][TempX - 1] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY > 0 && TempX < 9 && simulation[TempZ][TempY - 1][TempX + 1] == player1)
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
                               while(TempX > 0  && simulation[TempZ][TempY][TempX - 1] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY < 9 && TempX > 0 && simulation[TempZ][TempY + 1][TempX - 1] == player1)
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
                               while(TempY < 9 && simulation[TempZ][TempY + 1][TempX] == player1 )
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
                               while(TempX < 9 && simulation[TempZ][TempY][TempX + 1] == player1)
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
                               while(TempX < 9 && TempY < 9 && simulation[TempZ][TempY + 1][TempX + 1] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                   TempY = TempY + 1;
                                }
                            }
                           TempX = X;
                           TempY = Y;
                           TempZ = Z;
                           System.out.println("TEST@");
                           value = SearchValue;
                           Leaf myLeaf = new Leaf(Z,X,Y,value);
                           LeafTree[tracker] = myLeaf;
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
                           System.out.println("TEST!");
                           if(Y != 0)
                           {
                               while(TempY > 0 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while( TempX > 0 && TempY > 0 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX - 1] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempY = TempY - 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY > 0 && TempX < 9 && TempZ > 0 && simulation[TempZ - 1][TempY - 1][TempX + 1] == player1)
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
                               while(TempX > 0  &&TempZ > 0 && simulation[TempZ - 1][TempY][TempX - 1] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX - 1;
                               }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               while(TempY < 9 && TempX > 0 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX - 1] == player1)
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
                               while(TempY < 9 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX] == player1 )
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
                               while(TempX < 9 && TempZ > 0 && simulation[TempZ - 1][TempY][TempX + 1] == player1)
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
                               while(TempX < 9 && TempY < 9 && TempZ > 0 && simulation[TempZ - 1][TempY + 1][TempX + 1] == player1)
                               {
                                   SearchValue = SearchValue + 1;
                                   TempX = TempX + 1;
                                   TempY = TempY + 1;
                                }
                            }
                           TempX = X;
                           TempY = Y;
                           TempZ = Z;
                           System.out.println("TEST@");
                           value = SearchValue;
                           Leaf myLeaf = new Leaf(Z,X,Y,value);
                           LeafTree[tracker] = myLeaf;
                           System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                           Searching = true;
                       }
                           
                           //Current Level
                           
                       TempX = X;
                       TempY = Y;
                       TempZ = Z;
                       SearchValue = 1;
                       Searching = false;
                       while(Searching != true)
                            {
                                System.out.println("TEST!");
                                if(Y != 0)
                                {
                                   while(TempY > 0 && simulation[TempZ][TempY - 1][TempX] == player1)
                                   {
                                       SearchValue = SearchValue + 1;
                                       TempY = TempY - 1;
                                   }
                                   TempX = X;
                                   TempY = Y;
                                   TempZ = Z;
                                   while( TempX > 0 && TempY > 0 && simulation[TempZ][TempY - 1][TempX - 1] == player1)
                                   {
                                       SearchValue = SearchValue + 1;
                                       TempY = TempY - 1;
                                       TempX = TempX - 1;
                                   }
                                   TempX = X;
                                   TempY = Y;
                                   TempZ = Z;
                                    while(TempY > 0 && TempX < 9 && simulation[TempZ][TempY - 1][TempX + 1] == player1)
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
                                   while(TempX > 0  && simulation[TempZ][TempY][TempX - 1] == player1)
                                   {
                                       SearchValue = SearchValue + 1;
                                       TempX = TempX - 1;
                                   }
                                   TempX = X;
                                   TempY = Y;
                                   TempZ = Z;
                                   while(TempY < 9 && TempX > 0 && simulation[TempZ][TempY + 1][TempX - 1] == player1)
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
                                   while(TempY < 9 && simulation[TempZ][TempY + 1][TempX] == player1 )
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
                                   while(TempX < 9 && simulation[TempZ][TempY][TempX + 1] == player1)
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
                                   while(TempX < 9 && TempY < 9 && simulation[TempZ][TempY + 1][TempX + 1] == player1)
                                   {
                                       SearchValue = SearchValue + 1;
                                       TempX = TempX + 1;
                                       TempY = TempY + 1;
                                    }
                                }
                               TempX = X;
                               TempY = Y;
                               TempZ = Z;
                               System.out.println("TEST@");
                               value = SearchValue;
                               Leaf myLeaf = new Leaf(Z,X,Y,value);
                               LeafTree[tracker] = myLeaf;
                               System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                               Searching = true;
                           }
                       }
                   }
                }
           }
       }
    }

