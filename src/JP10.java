import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

// 仿新死机界面
public class JP10 extends JPanel implements Runnable {

    int s = 0;

    public JP10() {
        // 设置光标隐藏
        URL classUrl = this.getClass().getResource("");
        Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imageCursor, new Point(0, 0), "cursor"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color background = new Color(0,86,162); //win10蓝
        this.setBackground(background);

        // 设置光标隐藏
        URL classUrl = this.getClass().getResource("");
        Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imageCursor, new Point(0, 0), "cursor"));

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 200));
        g.drawString(":(", 200, 400);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 36));
        g.drawString("你的电脑遇到问题，需要重新启动。",200, 600);
        g.drawString("我们只收集某些错误信息，然后为你重新启动。（完成 " + s +"%）",200, 640);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        g.drawString("如果你想了解更多信息，则可以稍后在线搜索此错误：HAL_INITIALIZATION_FAILED",200, 750);

        if(s == 100) {
            try {
                Runtime.getRuntime().exec("shutdown -r -t 0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while(s != 100) {
            s++;
            try {
                Thread.sleep((int)(Math.random()*(750)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}