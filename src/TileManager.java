import java.awt.*;

public class TileManager {
    GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.magenta);
        for(int x = 0; x < this.gp.getMaxScreenCol(); x ++) {
            g2.fillRect(x * this.gp.getTileSize(), 0, this.gp.getTileSize(), this.gp.getTileSize());
            g2.fillRect(x * this.gp.getTileSize(), this.gp.getScreenHeight() - this.gp.getTileSize(), this.gp.getTileSize(), this.gp.getTileSize());
        }
        for(int y = 1; y < (this.gp.getMaxScreenRow() - 1); y ++) {
            g2.fillRect(0, y * this.gp.getTileSize(), this.gp.getTileSize(), this.gp.getTileSize());
            g2.fillRect((this.gp.getMaxScreenCol() - 1) * this.gp.getTileSize(), y * this.gp.getTileSize(), this.gp.getTileSize(), this.gp.getTileSize());
        }
    }
}
