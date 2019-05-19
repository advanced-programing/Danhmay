package DanhVoiMayNHom8;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class MyPanel extends JPanel {

    public static JButton[][] button;
    public static char[][] board;

    private ToaDo toaDo;
    private Logic logic;

    public MyPanel() {
        initMyPanel();
        initComps();
        handleClick();
        logic = new Logic(); 
    }
    
    private void initMyPanel() {
        setLayout(null);
    }
    
    private void initComps() {
        button = new JButton[22][22];
        board = new char[Constants.ROW][Constants.ROW];
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                board[i][j] = Constants.T;
                button[i][j] = new JButton();
                button[i][j].setBounds(i * 30, j * 30, 30, 30);
                button[i][j].setBackground(Color.WHITE);
                add(button[i][j]);
            }
        }

    }
    
    public void handleClick() {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                final int x = i;
                final int y = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (board[x][y] == Constants.T) {
                            board[x][y] = Constants.PLAYER;
                            button[x][y].setIcon(new ImageIcon(LoadFile.path + "o.png"));
                            if (logic.checkPlayerWin()) {
                                JOptionPane.showMessageDialog(MyPanel.this, "Chúc mừng! Bạn đã thắng!");
                                System.exit(0);
                            }
                            Computer.computerMove();
                            if (logic.checkComputerWin()) {
                                JOptionPane.showMessageDialog(MyPanel.this, "Rất tiếc, bạn đã thua!");
                                System.exit(0);
                            }
                            if (logic.checkHoa()) {
                                JOptionPane.showMessageDialog(MyPanel.this, "Hòa ");
                            }

                        }
                    }
                });
            }
        }
    }
}
