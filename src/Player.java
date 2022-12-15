import java.awt.*;

public class Player extends Entity {
    private KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.setKeyH(keyH);
        this.setX(gp.getTileSize());
        this.setY((gp.getMaxScreenRow()) / 2 * gp.getTileSize() - gp.getTileSize());
        this.setSpeed(4);
    }

    public void setKeyH(KeyHandler keyH) {
        this.keyH = keyH;
    }
    public KeyHandler getKeyH() {
        return this.keyH;
    }

    @Override
    public void update() {
        if(this.getKeyH().getUpPressed() && ((this.getY() - this.getSpeed()) >= (this.getGamePanel().getTileSize()))) {
            this.setY(this.getY() - this.getSpeed());
        }
        else if(this.getKeyH().getDownPressed() && ((this.getY() + this.getSpeed()) <= (this.getGamePanel().getScreenHeight() - this.getGamePanel().getTileSize() * 4))) {
            this.setY(this.getY() + this.getSpeed());
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(this.getX(), this.getY(), this.getGamePanel().getTileSize(), this.getGamePanel().getTileSize() * 3);
    }
}
