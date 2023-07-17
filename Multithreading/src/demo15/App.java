package demo15;

import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		//MainFrame frame = new MainFrame("Swing");
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MainFrame("SwingWorker Demo");
			}
		});
	}

}
