package se.frand.pictures;

import java.awt.*;

import javax.swing.*;

import se.frand.pictures.image.*;
import se.frand.pictures.views.*;


public class DisplayImageTester {
	
	private static final String TEST_IMAGE1 =
			"http://faculty.lmu.edu/timothyshanahan/wp-content/uploads/sites/15/2014/06/Roy-Dove-Painting-by-Tom-Ralston.jpg";
	private static final String TEST_IMAGE2 = "http://www.likecool.com/Gear/Pic/Little%20wolf%20kitten/Little-wolf-kitten.jpg";
	private static final String TEST_IMAGE3 = "https://pbs.twimg.com/profile_images/623253223437004800/85wFpTrM.jpg";
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Show some Images");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
		frame.setSize(1000, 600);
		
		frame.setVisible(true);

		ImageContainerController controller = new ImageContainerController(frame.getContentPane());
		
		controller.downloadImage(TEST_IMAGE1);
		controller.downloadImage(TEST_IMAGE2); 
		controller.downloadImage(TEST_IMAGE3);
	}
	
}
