package DanhVoiMayNHom8;
import java.util.ArrayList;
public class Logic {
    private static ArrayList<String> listMayThang;
    private static ArrayList<String> listNguoiThang;
    public Logic() {
        listMayThang = LoadFile.load("maythang.txt");
        listNguoiThang = LoadFile.load("nguoithang.txt");
    }

    public static boolean checkComputerWin() {
        int size = listMayThang.size();
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < 22 - 4; i++) {
                for (int j = 0; j < 22 - 4; j++) {
                    if (Computer.checkMatrix5(Computer.matrix5(i, j), listMayThang.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static boolean checkHoa() {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                if (MyPanel.board[i][j] != 'T') {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean checkPlayerWin() {
        int size = listNguoiThang.size();
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < 22 - 4; i++) {
                for (int j = 0; j < 22 - 4; j++) {
                    if (Computer.checkMatrix5(Computer.matrix5(i, j), listNguoiThang.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
