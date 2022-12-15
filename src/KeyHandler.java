import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean upPressed, downPressed;

    public KeyHandler() {
        this.setUpPressed(false);
        this.setDownPressed(false);
    }

    public void setUpPressed(boolean upp) { this.upPressed = upp; }
    public boolean getUpPressed() { return this.upPressed; }

    public void setDownPressed(boolean dwp) { this.downPressed = dwp; }
    public boolean getDownPressed() { return this.downPressed; }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W) this.setUpPressed(true);
        if(code == KeyEvent.VK_S) this.setDownPressed(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W) this.setUpPressed(false);
        if(code == KeyEvent.VK_S) this.setDownPressed(false);
    }
}
