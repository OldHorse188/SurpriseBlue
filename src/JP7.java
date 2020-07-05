import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

// 仿旧死机界面
public class JP7 extends JPanel implements Runnable {

    // 当s达到100时关机
    int s = 0;

    public JP7() {
        // 设置光标隐藏
        URL classUrl = this.getClass().getResource("");
        Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imageCursor, new Point(0, 0), "cursor"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color background = new Color(0,8,133);
        this.setBackground(background);

        int y = 24;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 24));
        g.drawString("A problem has been detected and windows has been shut down to prevent damage " , 10, y); y+=24;
        g.drawString("to your computer.",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("Attempt to reset the display driver and recover from timeout failed.",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("If this is the first time you've seen this Stop error screen, ",10,y); y+=24;
        g.drawString("restart your computer. If this screen appears again, follow",10,y); y+=24;
        g.drawString("these steps:",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("Check to make sure any new hardware or software is properly installed.",10,y); y+=24;
        g.drawString("If this is a new installation, ask your hardware or software manufacturer ",10,y); y+=24;
        g.drawString("for any windows updates you might need.",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("If problems continue disable or remove any newly installed hardware ",10,y); y+=24;
        g.drawString("or software.Disable BIOS memory options such as caching or shadowing.",10,y); y+=24;
        g.drawString("If you need to use safe Mode to remove or disable components, restart ",10,y); y+=24;
        g.drawString("your computer, press F8 to select Advanced Startup Options, and then ",10,y); y+=24;
        g.drawString("select Safe Mode.",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("Technical Information:",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("*** STOP:   0x00000116  (0xPPPPPA800C60F4e0v OxFPPF^F8800460CCAC* 0x0000000000000000, 0x000000000000000 2)",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("***  atikmpag.sys - Address FFFFF8800460CCAC base at FFFFF88004600000, DateStamp 55c01884",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("",10,y); y+=24;
        g.drawString("Collecting data for crash dunp . . .",10,y); y+=24;
        g.drawString("Initializing disk for crash dump . . .", 10, y); y+=24;
        g.drawString("Beginning dump of physical memory.", 10, y); y+=24;
        g.drawString("Dumping physical memory to disk: " + s, 10, y); y+=24;

        // 当s达到100时关机
        if(s >= 100) {
            g.drawString("Physical memory dump complete.", 10, y); y+=24;
            g.drawString("Contact your system admin or technical support group for further assistance.", 10, y); y+=24;

            try {
                Runtime.getRuntime().exec("shutdown -r -t 0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while(s < 100) {
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