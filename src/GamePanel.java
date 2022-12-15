import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    private int originalTileSize, scale, FPS, tileSize, maxScreenCol, maxScreenRow, screenWidth, screenHeight;

    private TileManager tileM;
    private KeyHandler keyH;
    private Thread gameThread;
    private ArrayList<Entity> entities = new ArrayList<>();
    private Player player;
    private Enemy enemy;
    private Ball ball;

    public GamePanel() {
        this.setKeyH(new KeyHandler());
        this.setScale(3);
        this.setOriginalTileSize(16);
        this.setMaxScreenCol(16);
        this.setMaxScreenRow(12);
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setFPS(60);
        this.setDoubleBuffered(true);
        this.setTileSize(this.getOriginalTileSize() * this.getScale());
        this.setScreenWidth(this.getTileSize() * this.getMaxScreenCol());
        this.setScreenHeight(this.getTileSize() * this.getMaxScreenRow());
        this.setPreferredSize(new Dimension(this.getScreenWidth(), this.getScreenHeight()));
        this.addKeyListener(this.getKeyH());
        this.setPlayer(new Player(this, this.getKeyH()));
        this.setEnemy(new Enemy(this));
        this.setBall(new Ball(this, this.getPlayer(), this.getEnemy()));
        this.setTileM(new TileManager(this));

        entities.add(this.getPlayer());
        entities.add(this.getEnemy());
        entities.add(this.getBall());
    }

    public Player getPlayer() {
        return this.player;
    }
    public void setPlayer(Player p) {
        this.player = p;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }
    public void setEnemy(Enemy e) {
        this.enemy = e;
    }

    public Ball getBall() {
        return this.ball;
    }
    public void setBall(Ball b) { this.ball = b; }

    public KeyHandler getKeyH() {
        return this.keyH;
    }
    public void setKeyH(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public TileManager getTileM() {
        return this.tileM;
    }
    public void setTileM(TileManager tileM) { this.tileM = tileM; }

    public int getOriginalTileSize() {
       return this.originalTileSize;
    }
    public void setOriginalTileSize(int size) {
        this.originalTileSize = size;
    }

    public int getScale() {
        return this.scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getFPS() {
        return this.FPS;
    }
    public void setFPS(int fps) {
        this.FPS = fps;
    }

    public int getTileSize() {
        return this.tileSize;
    }
    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getMaxScreenCol() {
        return this.maxScreenCol;
    }
    public void setMaxScreenCol(int maxCols) {
        this.maxScreenCol = maxCols;
    }

    public int getMaxScreenRow() {
        return this.maxScreenRow;
    }
    public void setMaxScreenRow(int maxRows) {
        this.maxScreenRow = maxRows;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        for (Entity entity : entities) entity.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Entity entity : entities) entity.draw(g2);
        tileM.draw(g2);
        g2.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / this.getFPS(), delta = 0;
        long lastTime = System.nanoTime(), currentTime, timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                this.update();
                this.repaint();
                delta --;
                drawCount ++;
            }
            if(timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
}
