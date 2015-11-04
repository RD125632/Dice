import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Dice 
{   
    private static final int MAX_NUMBER = 6;
    private Random numberGenerator;
    private int currentValue;
    private BufferedImage dice;
    private Point position;
    private Graphics2D g2;
    
    public Dice(int x, int y) 
    {
        numberGenerator = new Random();
        currentValue = 0;
        position = new Point(x,y);
        dice = new BufferedImage(800, 500, BufferedImage.TYPE_INT_ARGB);
    	g2 = dice.createGraphics();
    }
        
    public void throwDice() 
    {
        currentValue = (numberGenerator.nextInt(MAX_NUMBER) + 1);
    }
    
    public BufferedImage getDice()
    {
    	return dice;
    }
    
    public void drawDice() 
    {
    	// Clear
    	g2.setColor(Color.WHITE);
    	g2.fillRect((int)position.getX(), (int)position.getY(), 120, 120);
    	
    	g2.setColor(Color.BLACK);
    	g2.setStroke(new BasicStroke(3.0f));
    	g2.drawRoundRect((int)position.getX(), (int)position.getY(), 120, 120, 15, 15); 
    	
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	
    	switch (currentValue)
    	{
    		case 0:
    			break;
    		case 1 :
    			g2.fillOval((int)position.getX() + 50, (int)position.getY() + 50, 20, 20);
    			break;
    		case 2 :
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 50, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 50, 20, 20);
    			break;    			
    		case 3 :
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 50, 20, 20);
    			g2.fillOval((int)position.getX() + 50, (int)position.getY() + 50, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 50, 20, 20);
    			break;
    		case 4 :
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 20, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 80, 20, 20);
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 80, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 20, 20, 20);
    			break;
    		case 5 :
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 20, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 80, 20, 20);
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 80, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 20, 20, 20);
    			g2.fillOval((int)position.getX() + 50, (int)position.getY() + 50, 20, 20);
    			break;
    		case 6 :
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 20, 20, 20);
    			g2.fillOval((int)position.getX() + 50, (int)position.getY() + 20, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 20, 20, 20);
    			g2.fillOval((int)position.getX() + 80, (int)position.getY() + 80, 20, 20);
    			g2.fillOval((int)position.getX() + 50, (int)position.getY() + 80, 20, 20);
    			g2.fillOval((int)position.getX() + 20, (int)position.getY() + 80, 20, 20);
    			break;
    	}
    	
    }
    
    public int getValue() {
        return currentValue;
    }
}
