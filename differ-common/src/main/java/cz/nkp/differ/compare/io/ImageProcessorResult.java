package cz.nkp.differ.compare.io;

import cz.nkp.differ.compare.metadata.ImageMetadata;
import java.awt.Image;
import java.util.List;

/**
 *
 * @author xrosecky
 */
public interface ImageProcessorResult {

    enum Type {

	IMAGE,
	COMPARISON
    };

    public Type getType();

    public int[][] getHistogram();

    public Image getPreview();

    public Image getFullImage();

    public String getMD5Checksum();

    public int getWidth();

    public int getHeight();

    // TODO: Z - replace simple List by MetadataTable
    public List<ImageMetadata> getMetadata();
}
