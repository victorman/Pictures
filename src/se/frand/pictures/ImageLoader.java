package se.frand.pictures;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class ImageLoader {

	public static Image loadImage(URL imageURL)
		throws IOException {
		// IOException means what exactly? No image at url? data stream isn't an image?
		// should i return null or throw the exception? We should probably just throw
		// the exception. so the calling code can deal with it e.g. display the appropriate error.
		
		// extract image suffix
		String imgPath = imageURL.getPath();
		int beginSfx = imgPath.lastIndexOf('.') + 1;
		
		// if there is no suffix, or the image name is wrong or we somehow overflow
		// then throw an exception. Which exception is still to be decided.
		if(beginSfx <= 0 || beginSfx >= imgPath.length())
			throw new IllegalArgumentException("Could not determine the file image type");
		
		// we have the suffix! (hopefully)
		String sfx = imgPath.substring(beginSfx, imgPath.length());
		
		HttpURLConnection httpcon = (HttpURLConnection) imageURL.openConnection();
		// 'fool' the server so that we don't get a 403 error
	    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
	    
		InputStream stream = httpcon.getInputStream();
		ImageInputStream imgStream = ImageIO.createImageInputStream(stream);
		
		ImageReader reader = ImageIO.getImageReadersBySuffix(sfx).next();
		if(reader == null)
			throw new IllegalArgumentException("Cannot Decode this file type into an image");
			
		reader.setInput(imgStream);
		
		final Image img = reader.read(0);
		
		// close up shop
		imgStream.close();
		stream.close();
		
		return img;
	}
}
