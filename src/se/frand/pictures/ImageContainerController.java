package se.frand.pictures;

import java.awt.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import se.frand.pictures.image.ImageDownloadManager;
import se.frand.pictures.views.ImageDisplayComponent;

/*
 * This class is called from the main controller (DisplayImageTest)
 * given a Container and any number of URL's of images, it creates a ImageDisplayComponent
 * adds the component to the Container and initiates the download via the ImageDownloadManager.
 * ImageDownloadManager should notify the controller when the image download is ready.
 */
public class ImageContainerController implements ImageController {

	private Container container;
	private Hashtable<String, ImageDisplayComponent> components;
	private ImageDownloadManager mgr;

	public ImageContainerController(Container container) {
		this.container = container;
		this.container.setVisible(true);
		this.mgr = new ImageDownloadManager();
		this.mgr.setController(this);
		this.components = new Hashtable<String, ImageDisplayComponent>(5);
	}
	
	public void downloadImage(String img) {
		ImageDisplayComponent component =  new ImageDisplayComponent();
		components.put(img, component);
		container.add(component);
		mgr.downloadImage(img);
	}

	@Override
	public void imageDownloadedNotify(Image image, URL url) throws Exception {
		ImageDisplayComponent component = components.get(url.toString());
		
		if(component == null)
			throw new Exception("No component found");
		
		component.setImage(image);
		container.revalidate();
	}
}
