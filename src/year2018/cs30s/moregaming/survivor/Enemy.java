
/** required package class namespace */
package year2018.cs30s.moregaming.survivor;

import year2018.cs30s.gametools.Directions;
import year2018.cs30s.gametools.GameCharacter;
import year2018.cs30s.gametools.Image;

/**
 * Enemy.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 7, 2018 
 * @instructor Mr. Wachs
 */
public class Enemy extends GameCharacter
{
    
    private Wall[]     walls;
    private Hero       hero;
    private Engine     engine;

    
    public Enemy(Image image, Hero hero, Wall[] walls, Engine engine) {
        super(image, 
              Directions.STOP,
              Constants.ENEMY_MOVE_AMOUNT,
              Constants.ENEMY_TIMER_DELAY,
              Constants.ENEMY_MOVE_DIRECTIONS);
        this.walls  = walls;
        this.hero   = hero;
        this.engine = engine;
        setDebug(Constants.ENEMY_TEXT, Constants.ENEMY_COLOR);
        randomDirection();
    }

    @Override
    public void action() {
        move();
        checkWalls();
        checkHero();
        redraw();
    }
    
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
                randomDirection();
                return;
            }
        }
    }

    private void checkHero() {
        if (isColliding(hero)) {
            engine.shutDown();
        }
    }

}
