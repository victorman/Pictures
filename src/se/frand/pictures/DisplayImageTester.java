package se.frand.pictures;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

// test image:
// http://faculty.lmu.edu/timothyshanahan/wp-content/uploads/sites/15/2014/06/Roy-Dove-Painting-by-Tom-Ralston.jpg
public class DisplayImageTester {
	
	private static final String TEST_IMAGE1 = "http://faculty.lmu.edu/timothyshanahan/wp-content/uploads/sites/15/2014/06/Roy-Dove-Painting-by-Tom-Ralston.jpg";
	private static final String TEST_IMAGE2 = "http://www.likecool.com/Gear/Pic/Little%20wolf%20kitten/Little-wolf-kitten.jpg";
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Show some Images");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
		
		ImageDisplayComponent imgComponent1 = new ImageDisplayComponent();
		ImageDisplayComponent imgComponent2 = new ImageDisplayComponent();
		
		frame.add(imgComponent1);
		frame.add(imgComponent2);
		
		frame.setSize(1000, 600);
		frame.setVisible(true);
		
		ImageDownloadManager mgr = new ImageDownloadManager();
		mgr.downloadImage(TEST_IMAGE1, imgComponent1);
		mgr.downloadImage(TEST_IMAGE2, imgComponent2); 
	}
	
}
