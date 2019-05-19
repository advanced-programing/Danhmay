package DanhVoiMayNHom8;
import javax.swing.JFrame;
public class GUI extends JFrame {
    public static final int H_FRAME = 689;
    public static final int W_FRAME = 866;
    private MyPanel myPanel;
    public GUI() {
        initGUI();
        initComps();
    }
    private void initGUI() {
        setTitle("Đánh máy nhóm 8");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initComps() {
        myPanel = new MyPanel();
        add(myPanel);
    }

}
