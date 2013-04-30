package cz.nkp.differ.compare.io.external;

import cz.nkp.differ.compare.io.ImageProcessorResult;
import cz.nkp.differ.compare.io.pure.PureImageProcessor;
import cz.nkp.differ.compare.io.pure.PureImageProcessorResult;
import cz.nkp.differ.compare.metadata.ImageMetadata;
import cz.nkp.differ.compare.metadata.MetadataExtractors;
import cz.nkp.differ.compare.metadata.external.ExternalMetadataExtractor;
import cz.nkp.differ.exceptions.ImageDifferException;
import cz.nkp.differ.images.ImageLoader;
import cz.nkp.differ.listener.ProgressListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xrosecky
 */
public class ExternalImageProcessor extends PureImageProcessor {

    private ExternalMetadataExtractor extractor;

    public ExternalImageProcessor(ImageLoader imageLoader, MetadataExtractors extractors) {
	super(imageLoader, extractors);
    }

    @Override
    public PureImageProcessorResult processImage(File image, ProgressListener callback) throws ImageDifferException {
	PureImageProcessorResult result = super.processImage(image, callback);
	return result;
    }

    @Override
    public ImageProcessorResult[] processImages(File a, File b, ProgressListener callback) throws ImageDifferException {
	ImageProcessorResult[] result = super.processImages(a, b, callback);
	if (result.length == 3) {
	    Map<String, String> attributes = new HashMap<String, String>();
	    attributes.put("{file1}", a.getAbsolutePath());
	    attributes.put("{file2}", b.getAbsolutePath());
	    
	    // TODO: Z - use MetadataTable
	    List<ImageMetadata> metadata = extractor.getMetadata(attributes);
	    result[2].getMetadata().addAll(metadata);
	}
	return result;
    }

    public ExternalMetadataExtractor getExtractor() {
	return extractor;
    }

    public void setExtractor(ExternalMetadataExtractor extractor) {
	this.extractor = extractor;
    }

}
