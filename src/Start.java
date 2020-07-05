import java.util.Properties;

public class Start {
    public static void main(String[] args) {
        BlueFrame bf = new BlueFrame();

        JP7 jp7 = new JP7();
        JP10 jp10 = new JP10();

        Properties props = System.getProperties();
        String isWin = props.getProperty("os.name");
        Double osVer = Double.parseDouble(props.getProperty("os.version"));
        if(isWin.toLowerCase().startsWith("win") &&  osVer > 7)
        {
            bf.add(jp10);
            new Thread(jp10).start();
        }
        else
        {
            bf.add(jp7);
            new Thread(jp7).start();
        }
        //System.out.println(props.getProperty("os.name") + "\n" + props.getProperty("os.arch") + "\n" + props.getProperty("os.version"));

        bf.open();
    }
}
