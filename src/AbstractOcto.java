import processing.core.PImage;

import java.util.List;

public abstract class AbstractOcto extends AbstractMovingEntity {

    private int resourceLimit;
    private int resourceCount;

    public AbstractOcto(Point position,
                        List<PImage> images, int resourceLimit, int resourceCount,
                        int actionPeriod, int animationPeriod) {
        super(position, images, actionPeriod, animationPeriod);
        this.resourceLimit = resourceLimit;
        this.resourceCount = resourceCount;
    }

    protected int getResourceLimit(){return resourceLimit;}
    protected int getResourceCount(){return resourceCount;}
    protected void setResourceCount(int newResourceCount){this.resourceCount = newResourceCount;}

    public Point nextPosition(WorldModel world,
                              Point destPos)
    {
        int horiz = Integer.signum(destPos.getX() - this.getPosition().getX());
        Point newPos = new Point(this.getPosition().getX() + horiz,
                this.getPosition().getY());

        if (horiz == 0 || world.isOccupied(newPos))
        {
            int vert = Integer.signum(destPos.getY() - this.getPosition().getY());
            newPos = new Point(this.getPosition().getX(),
                    this.getPosition().getY() + vert);

            if (vert == 0 || world.isOccupied(newPos))
            {
                newPos = this.getPosition();
            }
        }

        return newPos;
    }
}
