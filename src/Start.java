import java.util.Properties;

public class Start {
    public static void main(String[] args) {
        BlueFrame bf = new BlueFrame();


        Properties props = System.getProperties();
        String isWin = props.getProperty("os.name");
        Double osVer = Double.parseDouble(props.getProperty("os.version"));
        //System.out.println(props.getProperty("os.name") + "\n" + props.getProperty("os.arch") + "\n" + props.getProperty("os.version"));

        // 判断系统版本，选择对应界面
        if(isWin.toLowerCase().startsWith("win") &&  osVer > 7)
        {
            JP10 jp10 = new JP10();
            bf.add(jp10);
            new Thread(jp10).start();
        }
        else
        {
            JP7 jp7 = new JP7();
            bf.add(jp7);
            new Thread(jp7).start();
        }
        bf.open();
    }
}
