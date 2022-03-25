import javax.swing.*;

public class ProgressBarD extends JPanel {

	
	JProgressBar progressBar;

	
	public ProgressBarD() {

		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);

	
		add(progressBar);

	}


	public void progress(int value) {

		progressBar.setValue(value);

	}

	public static void main(String args[]) {


		final ProgressBarD progressBarDemo = new ProgressBarD();
		JFrame frame = new JFrame("Progress Bar Demo");

		frame.setSize(200, 100);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		frame.setContentPane(progressBarDemo);

		frame.pack();

		frame.setVisible(true);
		for (int i = 0; i <= 100; i++) {
			final int updateCompleted = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						progressBarDemo.progress(updateCompleted);
					}
				});
				
				Thread.sleep(100);
			} catch (InterruptedException e) {;}
		} 
	}
}