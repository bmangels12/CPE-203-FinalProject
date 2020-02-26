import processing.core.PImage;

import java.util.List;

public abstract class AbstractEntity implements Entity{

    private Point position;
    private List<PImage> images;
    private int imageIndex;

    public AbstractEntity(Point position,
                     List<PImage> images) {
        this.position = position;
        this.images = images;
        this.imageIndex = 0;
    }

    public Point getPosition(){return this.position;};
    protected List<PImage> getImages(){return this.images;}
    public PImage getCurrentImage() {
        return (this).images.get(imageIndex);
    }
    protected int getImageIndex() { return this.imageIndex; }
    protected void setImageIndex(int imageIndex) { this.imageIndex = imageIndex; }
    public void setPosition(Point pos) { this.position = pos; }


}
