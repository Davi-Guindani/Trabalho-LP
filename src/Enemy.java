import java.awt.*;

public class Enemy extends Entity {
    private int verticalDir;

    public Enemy(GamePanel gp) {
        super(gp);
        this.setVerticalDir(1);
        this.setX(gp.getScreenWidth() - gp.getTileSize() * 2);
        this.setY(gp.getMaxScreenRow() / 2 * gp.getTileSize() - gp.getTileSize());
        this.setSpeed(4);
    }

    public void setVerticalDir(int verticalDir) {
        this.verticalDir = verticalDir;
    }
    public int getVerticalDir() {
        return this.verticalDir;
    }

    @Override
    public void update() {
        if (this.getY() >= this.getGamePanel().getScreenHeight() - this.getGamePanel().getTileSize() * 4 || this.getY() <= this.getGamePanel().getTileSize()) this.setVerticalDir(-(this.getVerticalDir()));
        this.setY(this.getY() + this.getVerticalDir() * this.getSpeed());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(this.getX(), this.getY(), this.getGamePanel().getTileSize(), this.getGamePanel().getTileSize() * 3);
    }
}
