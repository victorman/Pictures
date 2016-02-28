package se.frand.pictures;

import java.awt.Image;
import java.net.URL;

public interface ImageDownloadManagerCallback {

	public void downloadComplete(Image image, URL url) throws Exception;
}
