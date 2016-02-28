package se.frand.pictures;

import java.awt.Image;
import java.io.IOException;
import java.net.*;
import java.util.Hashtable;
import java.util.concurrent.*;

public class ImageDownloadManager implements ImageDownloadManagerCallback {
	
	private static final int POOL_SIZE = 2;
	
	private Hashtable<URL, ImageDisplayComponent> components;
	private ExecutorService es;
	
	public ImageDownloadManager() {
		// at least for now the pool size and the table size only needs to be 2
		components = new Hashtable<URL, ImageDisplayComponent>(POOL_SIZE);
		this.es = Executors.newFixedThreadPool(POOL_SIZE);
	}
	
	public void downloadImage(String img, ImageDisplayComponent component) {
		try {
			URL imageURL = new URL(img);
			ImageLoader iloader = new ImageLoader(imageURL);
			iloader.setDownloadManager(this);
			components.put(imageURL, component);
			Future future = es.submit(iloader);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void downloadComplete(Image image, URL url) throws Exception {
		ImageDisplayComponent component = components.get(url);
		
		if(component == null)
			throw new Exception("No component found");
		
		component.setImage(image);
	}

}
