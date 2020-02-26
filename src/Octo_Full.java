import processing.core.PImage;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Octo_Full extends AbstractOcto {



    public Octo_Full(Point position,
                  List<PImage> images, int resourceLimit,
                  int actionPeriod, int animationPeriod) {
        super(position, images, resourceLimit, resourceLimit, actionPeriod, animationPeriod);

    }


    public void executeActivity(WorldModel world,
                                        ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> fullTarget = world.findNearest(this.getPosition(),
                Atlantis.class);

        if (fullTarget.isPresent() &&
                moveTo(world, fullTarget.get(), scheduler)) {
            //at atlantis trigger animation
            ((Atlantis)fullTarget.get()).scheduleActions(scheduler, world, imageStore);

            //transform to unfull
            transformFull(world, scheduler, imageStore);
        } else {
            scheduler.scheduleEvent(this,
                    Activity.createActivityAction(world, imageStore, this),
                    this.getActionPeriod());
        }
    }


    public void transformFull(WorldModel world,
                              EventScheduler scheduler, ImageStore imageStore)
    {
        Octo_Not_Full octo = EntityFactory.createOctoNotFull(this.getResourceLimit(), this.getPosition(),
                this.getActionPeriod(), this.getAnimationPeriod(),
                this.getImages());

        world.removeEntity(this);
        scheduler.unscheduleAllEvents(this);

        world.addEntity(octo);
        octo.scheduleActions(scheduler, world, imageStore);
    }

    public boolean moveTo(WorldModel world,
                              Entity target, EventScheduler scheduler)
    {
        if (this.getPosition().adjacent(target.getPosition()))
        {
            return true;
        }
        else
        {
            Point nextPos = nextPosition(world, target.getPosition());

            if (!this.getPosition().equals(nextPos))
            {
                Optional<Entity> occupant = world.getOccupant(nextPos);
                if (occupant.isPresent())
                {
                    scheduler.unscheduleAllEvents(occupant.get());
                }

                world.moveEntity(this, nextPos);
            }
            return false;
        }
    }


}
