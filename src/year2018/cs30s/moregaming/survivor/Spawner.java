
package year2018.cs30s.moregaming.survivor;

import java.util.ArrayList;
import year2018.cs30s.gametools.GameObject;
import year2018.cs30s.gametools.Image;
import year2018.cs30s.tools.MediaPlayer;
import year2018.cs30s.tools.Numbers;


public class Spawner 
{
        
    private Hero                  hero;
    private Goal                  goal;
    private Wall[]                walls;
    private SurvivorUI            survivorUI;
    private Engine                engine;
    private MediaPlayer           player;
    
    public  ArrayList<SpawnPoint> allSpawnPoints;    
    public  ArrayList<Enemy>      enemies;
    
    
    public Spawner(Hero hero, Goal goal, Wall[] walls, SurvivorUI survivorUI, 
                    Engine engine) {
        this.hero       = hero;
        this.goal       = goal;
        this.walls      = walls;
        this.survivorUI = survivorUI;
        this.engine     = engine;
        allSpawnPoints  = new ArrayList<>();        
        enemies         = new ArrayList<>();
        player = new MediaPlayer();        
        createSpawnPoint();
    }

    private void createSpawnPoint() {
        int x = 0;
        int y = 0;
        int w = Constants.SPAWN_POINT_WIDTH;
        int h = Constants.SPAWN_POINT_HEIGHT;
        do {            
            x = Numbers.random(Constants.SPAWN_LOW_X, Constants.SPAWN_HIGH_X);
            y = Numbers.random(Constants.SPAWN_LOW_Y, Constants.SPAWN_HIGH_Y);            
        } while (isClear(x,y,w+10,h+10) == false);                
        Image image = engine.createImage(x, y, w, h, Constants.SPAWN_POINT_IMAGE);
        SpawnPoint spawnPoint = new SpawnPoint(image,hero,walls,engine,this);
        allSpawnPoints.add(spawnPoint);        
    }
    
    
    public void shutDown() {
        player.stop();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);    // get an enemy 
            enemy.hide();                       // hide enemy
            enemy.shutDown();                   // shut down enemy
        }
        enemies.clear();
        for (int i = 0; i < allSpawnPoints.size(); i++) {
            SpawnPoint spawnPoint = allSpawnPoints.get(i);    // get an enemy 
            spawnPoint.hide();                       // hide enemy
            spawnPoint.shutDown();                   // shut down enemy           
        }
        allSpawnPoints.clear();
    }

    public void check(Projectile projectile) {        
        checkSpawnPoints(projectile);            
        checkEnemies(projectile);
    }

    private void checkEnemies(Projectile projectile) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);    // get en enemy
            if (projectile.isColliding(enemy)) {               // collision with enemy
                enemies.remove(enemy);   // remove from list
                enemy.hide();                       // hide enemy
                enemy.shutDown();                   // shut down enemy
                projectile.hide();                             // hide projectile
                projectile.shutDown();                         // shut down projectile
                player.playWav(Constants.ENEMY_DIE_SOUND_FILE);
                return;
            }
        }
    }

    private void checkSpawnPoints(Projectile projectile) {
        for (int i = 0; i < allSpawnPoints.size(); i++) {
            SpawnPoint spawnPoint = allSpawnPoints.get(i);
            if (projectile.isColliding(spawnPoint)) {
                allSpawnPoints.remove(spawnPoint);
                spawnPoint.hide();
                spawnPoint.shutDown();
                projectile.hide();                             // hide projectile
                projectile.shutDown();                         // shut down projectile
                player.playWav(Constants.ENEMY_DIE_SOUND_FILE);
                createSpawnPoint();
                createSpawnPoint();
                return;
            }
        }
    }

    private boolean isClear(int x, int y, int w, int h) {
        GameObject location = new GameObject(x,y,w,h);
        if (location.isColliding(hero)) return false;
        if (location.isColliding(goal)) return false;
        for (int i = 0; i < walls.length; i++) {
            if (location.isColliding(walls[i])) return false;        
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (location.isColliding(enemy)) return false;        
        }
        return true;
    }

}
