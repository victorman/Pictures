package se.frand.pictures.image;

import java.awt.Image;
import java.io.IOException;
import java.net.*;
import java.util.Hashtable;
import java.util.concurrent.*;

import se.frand.pictures.ImageController;

public class ImageDownloadManager
	implements ImageDownloadManagerCallback {
	
	private static final int POOL_SIZE = 3;
	
	private ImageController controller;
	private ExecutorService es;
	
	public ImageDownloadManager() {
		// at least for now the pool size
		this.es = Executors.newFixedThreadPool(POOL_SIZE);
	}
	
	public void downloadImage(String img) {
		try {
			URL imageURL = new URL(img);
			ImageLoader iloader = new ImageLoader(imageURL);
			iloader.setDownloadManager(this);
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
		// notify our controller
		controller.imageDownloadedNotify(image, url);
	}

	public ImageController getController() {
		return controller;
	}

	public void setController(ImageController controller) {
		this.controller = controller;
	}

}
