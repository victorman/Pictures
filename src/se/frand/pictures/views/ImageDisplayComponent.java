package se.frand.pictures.views;

import java.awt.*;
import javax.swing.*;

public class ImageDisplayComponent extends JComponent {

	private static final long serialVersionUID = 5988431619448146005L;
	private static final int SCALE_DIMENSION = -1;
	private Image image;
	
	public ImageDisplayComponent() {
		super();
	}

	public synchronized void paintComponent(Graphics g) {
		if(image == null)
			return;
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image.getScaledInstance(getWidth(), SCALE_DIMENSION, Image.SCALE_FAST), 0, 0, null);
	}
	
	public synchronized void setImage(Image image) {
		this.image = image;
		repaint();
	}
}
