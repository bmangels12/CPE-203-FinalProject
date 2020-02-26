import processing.core.PImage;

import java.util.List;

public class EntityFactory {


    public static Atlantis createAtlantis(Point position,
                                        List<PImage> images)
    {
        return new Atlantis(position, images,
                 0, 0);
    }

    public static Octo_Full createOctoFull(int resourceLimit,
                                        Point position, int actionPeriod, int animationPeriod,
                                        List<PImage> images)
    {
        return new Octo_Full(position, images,
                resourceLimit, actionPeriod, animationPeriod);
    }

    public static Octo_Not_Full createOctoNotFull(int resourceLimit,
                                           Point position, int actionPeriod, int animationPeriod,
                                           List<PImage> images)
    {
        return new Octo_Not_Full(position, images,
                resourceLimit, 0, actionPeriod, animationPeriod);
    }

    public static Obstacle createObstacle(Point position,
                                        List<PImage> images)
    {
        return new Obstacle(position, images);
    }

    public static Fish createFish(Point position, int actionPeriod,
                                    List<PImage> images)
    {
        return new Fish(position, images,
                actionPeriod);
    }

    public static Crab createCrab(Point position,
                                    int actionPeriod, int animationPeriod, List<PImage> images)
    {
        return new Crab(position, images,
                actionPeriod, animationPeriod);
    }

    public static Quake createQuake(Point position, List<PImage> images)
    {
        return new Quake(position, images,
                Quake.getQuakeActionPeriod(), Quake.getQuakeAnimationPeriod());
    }

    public static SGrass createSgrass(Point position, int actionPeriod,
                                      List<PImage> images)
    {
        return new SGrass(position, images,
                actionPeriod);
    }

}
