//Raeden
//Thu Mar 6
import javax.swing.JFrame;



public class Main {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
		myFrame.setResizable(false);
		myFrame.setTitle("World");
		
		Window myWindow = new Window();
		myFrame.add(myWindow);
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		myWindow.startGameThread();
		
	}

}
