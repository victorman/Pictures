package se.frand.pictures;

import java.awt.*;

import javax.swing.*;

public class ImageDisplayComponent extends JComponent {

	private static final long serialVersionUID = 5988431619448146005L;
	private static final int SCALE_DIMENSION = -1;
	private Image image;

	public void paintComponent(Graphics g) {
		if(image == null)
			return;
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image.getScaledInstance(getWidth(), SCALE_DIMENSION, image.SCALE_FAST), 0, 0, null);
	}
	
	public void setImage(Image image) {
		this.image = image;
		repaint();
	}
}
