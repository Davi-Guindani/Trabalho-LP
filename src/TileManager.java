import java.awt.*;

public class TileManager {
    GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.magenta);
        for(int x = 0; x < gp.maxScreenCol; x ++) {
            g2.fillRect(x * gp.tileSize, 0, gp.tileSize, gp.tileSize);
            g2.fillRect(x * gp.tileSize, gp.screenHeight - gp.tileSize, gp.tileSize, gp.tileSize);
        }
        for(int y = 1; y < (gp.maxScreenRow - 1); y ++) {
            g2.fillRect(0, y * gp.tileSize, gp.tileSize, gp.tileSize);
            g2.fillRect((gp.maxScreenCol - 1) * gp.tileSize, y * gp.tileSize, gp.tileSize, gp.tileSize);
        }
    }
}
