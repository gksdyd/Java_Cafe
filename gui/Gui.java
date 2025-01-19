package cafe_project.gui;

import javax.swing.JFrame;

public class Gui extends JFrame {

	private static final String TITLE = "STAR CAFE";
	
	private final int WIDTH = 500;
	private final int HEIGHT = 800;
	
	public Gui() {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
}
