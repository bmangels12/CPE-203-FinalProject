import processing.core.PImage;

import java.util.List;

public abstract class AbstractMovingEntity extends AbstractAnimatedEntity implements MovingEntity{

    public AbstractMovingEntity(Point position,
                     List<PImage> images,
                     int actionPeriod, int animationPeriod) {
        super(position, images, actionPeriod, animationPeriod);
    }

    public abstract Point nextPosition(WorldModel world,
                                          Point destPos);

    public abstract boolean moveTo(WorldModel world,
                               Entity target, EventScheduler scheduler);


}
