public class WorldFactory {

    private static final String OCTO_KEY = "octo";
    private static final int OCTO_NUM_PROPERTIES = 7;
    private static final int OCTO_ID = 1;
    private static final int OCTO_COL = 2;
    private static final int OCTO_ROW = 3;
    private static final int OCTO_LIMIT = 4;
    private static final int OCTO_ACTION_PERIOD = 5;
    private static final int OCTO_ANIMATION_PERIOD = 6;

    private static final String OBSTACLE_KEY = "obstacle";
    private static final int OBSTACLE_NUM_PROPERTIES = 4;
    private static final int OBSTACLE_ID = 1;
    private static final int OBSTACLE_COL = 2;
    private static final int OBSTACLE_ROW = 3;

    private static final String FISH_KEY = "fish";
    private static final int FISH_NUM_PROPERTIES = 5;
    private static final int FISH_ID = 1;
    private static final int FISH_COL = 2;
    private static final int FISH_ROW = 3;
    private static final int FISH_ACTION_PERIOD = 4;

    private static final String ATLANTIS_KEY = "atlantis";
    private static final int ATLANTIS_NUM_PROPERTIES = 4;
    private static final int ATLANTIS_ID = 1;
    private static final int ATLANTIS_COL = 2;
    private static final int ATLANTIS_ROW = 3;

    private static final String SGRASS_KEY = "seaGrass";
    private static final int SGRASS_NUM_PROPERTIES = 5;
    private static final int SGRASS_ID = 1;
    private static final int SGRASS_COL = 2;
    private static final int SGRASS_ROW = 3;
    private static final int SGRASS_ACTION_PERIOD = 4;

    public static boolean parseOcto(String[] properties, ImageStore imageStore, WorldModel world) {
        if (properties.length == OCTO_NUM_PROPERTIES) {
            Point pt = new Point(Integer.parseInt(properties[OCTO_COL]),
                    Integer.parseInt(properties[OCTO_ROW]));
            Octo_Not_Full octo_not_full = EntityFactory.createOctoNotFull(
                    Integer.parseInt(properties[OCTO_LIMIT]), pt,
                    Integer.parseInt(properties[OCTO_ACTION_PERIOD]),
                    Integer.parseInt(properties[OCTO_ANIMATION_PERIOD]),
                    imageStore.getImageList(OCTO_KEY));
            tryAddEntity(world, octo_not_full);
        }

        return properties.length == OCTO_NUM_PROPERTIES;
    }

    public static boolean parseObstacle(String[] properties, ImageStore imageStore, WorldModel world) {
        if (properties.length == OBSTACLE_NUM_PROPERTIES) {
            Point pt = new Point(
                    Integer.parseInt(properties[OBSTACLE_COL]),
                    Integer.parseInt(properties[OBSTACLE_ROW]));
            Obstacle obstacle = EntityFactory.createObstacle(pt,
                    imageStore.getImageList(OBSTACLE_KEY));
            tryAddEntity(world, obstacle);
        }

        return properties.length == OBSTACLE_NUM_PROPERTIES;
    }

    public static boolean parseFish(String[] properties, ImageStore imageStore, WorldModel world) {
        if (properties.length == FISH_NUM_PROPERTIES) {
            Point pt = new Point(Integer.parseInt(properties[FISH_COL]),
                    Integer.parseInt(properties[FISH_ROW]));
            Fish fish = EntityFactory.createFish(pt,
                    Integer.parseInt(properties[FISH_ACTION_PERIOD]),
                    imageStore.getImageList(FISH_KEY));
            tryAddEntity(world, fish);
        }

        return properties.length == FISH_NUM_PROPERTIES;
    }

    public static boolean parseAtlantis(String[] properties, ImageStore imageStore, WorldModel world) {
        if (properties.length == ATLANTIS_NUM_PROPERTIES) {
            Point pt = new Point(Integer.parseInt(properties[ATLANTIS_COL]),
                    Integer.parseInt(properties[ATLANTIS_ROW]));
            Atlantis atlantis = EntityFactory.createAtlantis(pt,
                    imageStore.getImageList(ATLANTIS_KEY));
            tryAddEntity(world, atlantis);
        }

        return properties.length == ATLANTIS_NUM_PROPERTIES;
    }

    public static boolean parseSgrass(String[] properties, ImageStore imageStore, WorldModel world) {
        if (properties.length == SGRASS_NUM_PROPERTIES) {
            Point pt = new Point(Integer.parseInt(properties[SGRASS_COL]),
                    Integer.parseInt(properties[SGRASS_ROW]));
            SGrass sgrass = EntityFactory.createSgrass(pt,
                    Integer.parseInt(properties[SGRASS_ACTION_PERIOD]),
                    imageStore.getImageList(SGRASS_KEY));
            tryAddEntity(world, sgrass);
        }

        return properties.length == SGRASS_NUM_PROPERTIES;
    }

    public static void tryAddEntity(WorldModel world, Entity entity)
    {
        if (world.isOccupied(entity.getPosition()))
        {
            // arguably the wrong type of exception, but we are not
            // defining our own exceptions yet
            throw new IllegalArgumentException("position occupied");
        }

        world.addEntity(entity);
    }

}
