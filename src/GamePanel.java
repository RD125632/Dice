import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

class GamePanel extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private int totalEyeThrown;
    private List<Dice> diceList;
    
    public GamePanel() 
    {        
    	this.setBackground(Color.WHITE);
    	
        JButton btnRoll = new JButton("Throw");
        btnRoll.addActionListener(this);
        btnRoll.setFocusPainted(false);
        btnRoll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRoll.setMargin(new Insets(10, 100, 10, 100));
        btnRoll.setBackground(Color.WHITE);
        
        totalEyeThrown = 0;
        
        diceList = new ArrayList<Dice>(); 
        diceList.add(new Dice(50, 200));
        diceList.add(new Dice(200, 200));
        diceList.add(new Dice(350, 200));
        diceList.add(new Dice(500, 200));
        diceList.add(new Dice(650, 200));

        add(btnRoll);
    }
    
    public void actionPerformed(ActionEvent arg0) 
    {
    	int temp = 0;
    			
    	for(Dice dice : diceList)
    	{
    		dice.throwDice();
    		temp += dice.getValue();
    	}
    	
    	totalEyeThrown = temp;
    	
    	repaint();
	}
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;       
        
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(new Font ("ARIAL", Font.BOLD , 40));
        g2.drawString(totalEyeThrown + "", (super.getWidth() / 2) - 20, 120);
        
        for(Dice dice : diceList)
        {
        	dice.drawDice();
            g2.drawImage(dice.getDice(), null, 0, 0);
        }        
    }
}