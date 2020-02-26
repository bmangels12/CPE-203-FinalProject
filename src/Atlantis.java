import processing.core.PImage;

import java.util.List;
import java.util.Random;

public class Atlantis extends AbstractAnimatedEntity {


    private static final int ATLANTIS_ANIMATION_REPEAT_COUNT = 7;

    public Atlantis(Point position,
                  List<PImage> images,
                  int actionPeriod, int animationPeriod) {
        super(position, images, actionPeriod, animationPeriod);

    }


    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        scheduler.unscheduleAllEvents(this);
        world.removeEntity(this);
    }

    public void scheduleActions(EventScheduler scheduler,
                                WorldModel world, ImageStore imageStore)
    {
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(ATLANTIS_ANIMATION_REPEAT_COUNT, this),
                this.getAnimationPeriod());

    }
}
