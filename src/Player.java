import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = (gp.maxScreenCol * gp.tileSize - gp.tileSize) / 2;
        y = (gp.maxScreenRow - 2) * gp.tileSize - gp.tileSize / 2;
        speed = 4;
    }

    public void update() {
        if(keyH.rightPressed && ((x + speed) <= (gp.screenWidth - gp.tileSize * 2))) x += speed;
        else if(keyH.leftPressed && ((x - speed) >= (gp.tileSize))) x -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
