import processing.core.PImage;

import java.util.List;

public abstract class AbstractAnimatedEntity extends AbstractActiveEntity implements AnimatedEntity{

    private int animationPeriod;

    public AbstractAnimatedEntity(Point position,
                                List<PImage> images,
                                int actionPeriod, int animationPeriod) {

        super(position, images, actionPeriod);
        this.animationPeriod = animationPeriod;
    }

    public int getAnimationPeriod(){return animationPeriod;}


    public void scheduleActions(EventScheduler scheduler,
                                WorldModel world, ImageStore imageStore)
    {
        super.scheduleActions(scheduler, world, imageStore);
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(0, this), this.getAnimationPeriod());
    }

    public void nextImage() {
        this.setImageIndex((this.getImageIndex() + 1) % this.getImages().size());
    }

}
