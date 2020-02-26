public class Animation implements Action {

    private AnimatedEntity entity;
    private int repeatCount;


    public Animation(AnimatedEntity entity, int repeatCount)
    {
        this.entity = entity;
        this.repeatCount = repeatCount;
    }

    public void executeAction(EventScheduler scheduler)
    {
        (this.entity).nextImage();

        if (this.repeatCount != 1)
        {
            scheduler.scheduleEvent(((Entity)this.entity),
                    createAnimationAction(
                            Math.max(this.repeatCount - 1, 0), this.entity),
                    this.entity.getAnimationPeriod());
        }
    }

    public static Animation createAnimationAction(int repeatCount, AnimatedEntity entity)
    {
        return new Animation(entity, repeatCount);
    }


}
