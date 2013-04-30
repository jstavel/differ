package cz.nkp.differ.compare.io.pure;

import cz.nkp.differ.compare.metadata.ImageMetadata;
import cz.nkp.differ.compare.io.ImageProcessorResult;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xrosecky
 */
@XmlRootElement(name="result")
public class PureImageProcessorResult implements ImageProcessorResult {

    @XmlTransient
    private BufferedImage fullImage;
    @XmlTransient
    private Image preview;
    private int[][] histogram;
    private String checksum;
    private Type type;
    private int width;
    private int height;
    private List<ImageMetadata> metadata = new ArrayList<ImageMetadata>();

    public PureImageProcessorResult() {
	
    }

    public PureImageProcessorResult(BufferedImage fullImage, Image preview) {
	this.fullImage = fullImage;
	this.preview = preview;
    }

    @Override
    public BufferedImage getFullImage() {
	return fullImage;
    }

    public void setFullImage(BufferedImage fullImage) {
	this.fullImage = fullImage;
    }

    @Override
    public int[][] getHistogram() {
	return histogram;
    }

    public void setHistogram(int histogram[][]) {
	this.histogram = histogram;
    }

    @Override
    public Image getPreview() {
	return preview;
    }

    public void setPreview(Image preview) {
	this.preview = preview;
    }

    @Override
    public String getMD5Checksum() {
	return checksum;
    }

    public void setMD5Checksum(String checksum) {
	this.checksum = checksum;
    }

    @Override
    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    @Override
    public List<ImageMetadata> getMetadata() {
	return metadata;
    }
}
