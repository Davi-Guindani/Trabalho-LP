import java.awt.*;

public class Ball extends Entity {
    private int ydir, xdir;
    private Player p;
    private Enemy e;

    public Ball(GamePanel gp, Player p, Enemy e) {
        super(gp);
        this.setPlayer(p);
        this.setEnemy(e);
        this.setXDir(-1);
        this.setYDir(1);
        this.setSpeed(3);
        setDefaultValues();
    }

    public void setYDir(int dir) { this.ydir = dir; }
    public int getYDir() { return this.ydir; }

    public void setXDir(int dir) { this.xdir = dir; }
    public int getXDir() { return this.xdir; }

    public void setPlayer(Player p) { this.p = p; }
    public Player getPlayer() { return this.p; }

    public void setEnemy(Enemy e) { this.e = e; }
    public Enemy getEnemy() { return this.e; }

    public void setDefaultValues() {
        this.setX(this.getGamePanel().getScreenWidth() / 2);
        this.setY(this.getGamePanel().getScreenHeight() / 2);
    }

    @Override
    public void update() {
        if((this.getYDir() == 1 && this.getY() >= (this.getGamePanel().getScreenHeight() - this.getGamePanel().getTileSize() - this.getGamePanel().getTileSize() / 4)) || (this.getYDir() == -1 && this.getY() <= this.getGamePanel().getTileSize())) {
            this.setYDir(-(this.getYDir()));
        }
        if(this.getX() <= this.getGamePanel().getTileSize() || this.getX() >= this.getGamePanel().getScreenWidth() - this.getGamePanel().getTileSize() - this.getGamePanel().getTileSize() / 4) {
            setDefaultValues();
        }
        if(((this.getX() <= this.getPlayer().getX() + this.getGamePanel().getTileSize()) && (this.getY() >= this.getPlayer().getY() && this.getY() <= this.getPlayer().getY() + this.getGamePanel().getTileSize() * 3)) || ((this.getX() >= this.getEnemy().getX() - this.getGamePanel().getTileSize() / 4) && (this.getY() >= this.getEnemy().getY() && this.getY() <= this.getEnemy().getY() + this.getGamePanel().getTileSize() * 3))) {
            this.setYDir(-(this.getYDir()));
            this.setXDir(-(this.getXDir()));
        }
        this.setX(this.getX() + this.getXDir() * this.getSpeed());
        this.setY(this.getY() + this.getYDir() * this.getSpeed());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.getX(), this.getY(), this.getGamePanel().getTileSize() / 4, this.getGamePanel().getTileSize() / 4);
    }
}
