import java.util.*;
public class Leaf
{
    public int positionX;
    public int positionY;
    public int positionZ;
    public int value;
    private int maxSize;
    public int location;
    public Leaf(int positionX , int positionY , int positionZ , int value )
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
}
