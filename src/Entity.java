import processing.core.PImage;

/*
Entity ideally would includes functions for how all the entities in our virtual world might act...
 */

interface Entity {

   public Point getPosition();
   public void setPosition(Point pos);
   public PImage getCurrentImage();


}
