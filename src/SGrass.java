import processing.core.PImage;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SGrass extends  AbstractActiveEntity {

    private static final int FISH_CORRUPT_MIN = 20000;
    private static final int FISH_CORRUPT_MAX = 30000;

    private static final Random rand = new Random();

    public SGrass(Point position, List<PImage> images, int actionPeriod) {
        super(position, images, actionPeriod);
    }


    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Point> openPt = world.findOpenAround(this.getPosition());

        if (openPt.isPresent()) {
            Fish fish = EntityFactory.createFish(openPt.get(), FISH_CORRUPT_MIN +
                            rand.nextInt(FISH_CORRUPT_MAX - FISH_CORRUPT_MIN),
                    imageStore.getImageList(WorldModel.getFishKey()));
            world.addEntity(fish);
            fish.scheduleActions(scheduler, world, imageStore);
        }
        scheduler.scheduleEvent(this,
                Activity.createActivityAction(world, imageStore, this),
                this.getActionPeriod());
    }

}
