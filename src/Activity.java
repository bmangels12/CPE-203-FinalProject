import com.sun.source.doctree.EntityTree;

public class Activity implements Action{

    private AbstractActiveEntity entity;
    private WorldModel world;
    private ImageStore imageStore;

    public Activity(AbstractActiveEntity entity, WorldModel world,
                    ImageStore imageStore)
    {
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
    }

    public void executeAction(EventScheduler scheduler) {
        (this.entity).executeActivity(this.world,
                this.imageStore, scheduler);
    }

    public static Activity createActivityAction(WorldModel world,
                                       ImageStore imageStore, AbstractActiveEntity entity) {
        return new Activity(entity, world, imageStore);
    };

}
