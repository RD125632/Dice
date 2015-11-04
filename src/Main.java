import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Main();
	}

	public Main()
	{
		//Initialize Mainframe
		super("Yahtzee");
		//Center in screen	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		this.setLocation((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new GamePanel());
		this.setSize(830,500);		
		this.setVisible(true);
	}
}
