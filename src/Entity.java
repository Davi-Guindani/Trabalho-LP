import java.awt.*;

public abstract class Entity {
    private int x, y, speed;
    private GamePanel gp;

    public Entity (GamePanel gp) {
        this.setGamePanel(gp);
    }

    public void setGamePanel(GamePanel gp) { this.gp = gp; }
    public GamePanel getGamePanel() { return this.gp; }

    public void setX (int x) {
        this.x = x;
    }
    public int getX () {
        return this.x;
    }

    public void setY (int y) {
        this.y = y;
    }
    public int getY () {
        return this.y;
    }

    public void setSpeed (int speed) {
        this.speed = speed;
    }
    public int getSpeed () {
        return this.speed;
    }

    public void update() { }

    public void draw(Graphics g) { }
}


