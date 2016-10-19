
/**
 * Will run the AI - named after the norse world tree.
 * 
 * Justin Cavender
 * .42
 */
public class YggdrasillMK2
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
       Leaf myLeaf = new Leaf(0,0,0,0);
       //VARIABLES FOR SEARCHING!
       int TempX = 0;
       int TempY = 0;
       int TempZ = 0;
       int SearchValue = 1;
       boolean Searching = false;
       
       for(Z = 0;Z < 10; Z++)
       {
           for(X = 0;X < 10;X++)
           {
               for(Y = 0; Y < 10; Y++)
               {
                   if(Z > 4 && Z < 10)
                   {
                        simulation[Z][X][Y] = '#';
                   }
                   else if(X == 0 || X == 2 || X == 4 || X == 6 || X == 8)
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
                   System.out.println(simulation[Z][X][Y]);
               }
           }
       }
       
       
       // This was the value determiner
         
            myLeaf.BestMove('R');
       }
    }

