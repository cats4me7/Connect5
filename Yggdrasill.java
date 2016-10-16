
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
       int value;
       int O = 0;
       
       int I = 0;
       int J = 0;
       
       for(Z = 0;Z < 10; Z++)
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
                    if(simulation[Z][X][Y] == 'R')
                    {
                        value = 1;
                    }
                    else
                    {
                       value = 5;
                    }
                    Leaf myLeaf = new Leaf(Z,X,Y,value);
                    LeafTree[tracker] = myLeaf;
                    System.out.println(LeafTree[tracker].getZ() + " " + LeafTree[tracker].getX() + " " + LeafTree[tracker].getY() + " " + LeafTree[tracker].getValue());
                }
           }
       }
    }
}
