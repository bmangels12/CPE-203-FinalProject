import processing.core.PImage;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Quake extends  AbstractAnimatedEntity {


    private static final int QUAKE_ANIMATION_REPEAT_COUNT = 10;
    private static final int QUAKE_ACTION_PERIOD = 1100;
    private static final int QUAKE_ANIMATION_PERIOD = 100;

    public Quake(Point position,
                  List<PImage> images,
                  int actionPeriod, int animationPeriod) {
        super(position, images, actionPeriod, animationPeriod);

    }

    public static int getQuakeActionPeriod() {
        return QUAKE_ACTION_PERIOD;
    }
    public static int getQuakeAnimationPeriod() { return QUAKE_ANIMATION_PERIOD; }


    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        scheduler.unscheduleAllEvents(this);
        world.removeEntity(this);
    }


    public void scheduleActions(EventScheduler scheduler,
                                WorldModel world, ImageStore imageStore)
    {
        scheduler.scheduleEvent(this,
                Activity.createActivityAction(world, imageStore, this),
                this.getActionPeriod());
        scheduler.scheduleEvent(this,
                Animation.createAnimationAction(QUAKE_ANIMATION_REPEAT_COUNT, this),
                this.getAnimationPeriod());

    }
    public static Optional<Entity> nearestEntity(List<Entity> entities,
                                                 Point pos) {
        if (entities.isEmpty()) {
            return Optional.empty();
        } else {
            Entity nearest = entities.get(0);
            int nearestDistance = nearest.getPosition().distanceSquared(pos);

            for (Entity other : entities) {
                int otherDistance = other.getPosition().distanceSquared(pos);

                if (otherDistance < nearestDistance) {
                    nearest = other;
                    nearestDistance = otherDistance;
                }
            }

            return Optional.of(nearest);
        }
    }
}
