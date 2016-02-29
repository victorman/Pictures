package se.frand.pictures;

import java.awt.Image;
import java.net.URL;

public interface ImageController {
	public void imageDownloadedNotify(Image image, URL url) throws Exception;
}
