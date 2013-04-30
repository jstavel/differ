package cz.nkp.differ;

import cz.nkp.differ.compare.io.ImageProcessor;
import cz.nkp.differ.compare.io.ImageProcessorResult;
import cz.nkp.differ.compare.metadata.ImageMetadata;
import cz.nkp.differ.exceptions.ImageDifferException;
import cz.nkp.differ.model.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

/**
 *
 * @author xrosecky
 */
public class ImageProcessorTest {

    private ImageProcessor imageProcessor = null;

    public ImageProcessorTest() {
	imageProcessor = Helper.getImageProcessor();
    }

    @Test
    public void testImages() throws ImageDifferException, IOException {
	// FIX: Z - this should be universal path
	File dir = new File("/home/xrosecky/differ");
	Map<File, ImageProcessorResult> images = new HashMap<File, ImageProcessorResult>();
	for (File file : dir.listFiles()) {
	    System.err.println("processing: " + file.getCanonicalPath());
	    Image image = new Image();
	    image.setFile(file);
	    ImageProcessorResult result = imageProcessor.processImage(image.getFile());
	    assert(result.getFullImage() != null);
	    assert(result.getPreview() != null);
	    assert(result.getHistogram() != null);
	    assert(result.getMD5Checksum() != null);
	    assert(result.getType() == ImageProcessorResult.Type.IMAGE);
	    for (ImageMetadata metadata: result.getMetadata()) {
		System.err.println(metadata.getKey() + " " + metadata.getValue() + " " + metadata.getSource());
	    }
	    images.put(file, result);
	}
	for (Entry<File, ImageProcessorResult> entry1 : images.entrySet()) {
	    for (Entry<File, ImageProcessorResult> entry2 : images.entrySet()) {
		if (entry1.getValue().getWidth() == entry2.getValue().getWidth()
			&& entry1.getValue().getHeight() == entry2.getValue().getHeight()) {
		    File file1 = entry1.getKey();
		    Image image1 = new Image();
		    image1.setFile(file1);
		    File file2 = entry2.getKey();
		    Image image2 = new Image();
		    image2.setFile(file2);
		    ImageProcessorResult[] results = imageProcessor.processImages(image1.getFile(), image2.getFile());
		}
	    }
	}
    }
}
