package DanhVoiMayNHom8;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Computer {
    private static ArrayList<String> listTheCo = LoadFile.load("theco.txt");
    public static ToaDo timDiemDanh() {
        ToaDo toaDo = new ToaDo();
        int size = listTheCo.size();
        for (int k = 0; k < size; k++) {
            String theCo = listTheCo.get(k);
            for (int i = 0; i < 22 - 4; i++) {
                for (int j = 0; j < 22 - 4; j++) {
                    if (checkMatrix5(matrix5(i, j), theCo)) {
                        int viTri = theCo.indexOf('D');
                        int x = viTri / 5;
                        int y = viTri % 5;
                        toaDo.setX(x + i);
                        toaDo.setY(j + y);
                        return toaDo;
                    }
                }
            }
        }
        Random random = new Random();
        return toaDo = new ToaDo(random.nextInt(22), random.nextInt(22));
    }

    public static void computerMove() {
        int x = timDiemDanh().getX();
        int y = timDiemDanh().getY();
        MyPanel.board[x][y] = Constants.COMPUTER;
        MyPanel.button[x][y].setIcon(new ImageIcon(LoadFile.path + "x.png"));

    }

    public static boolean checkMatrix5(char[][] matrix5, String theCo) {
        for (int index = 0; index < 25; index++) {
            if (theCo.charAt(index) != 'G') {
                int i = index / 5;
                int j = index % 5;
                if (theCo.charAt(index) == 'D') {
                    if (matrix5[i][j] != 'T') {
                        return false;
                    }
                }
                if (theCo.charAt(index) == 'X') {
                    if (matrix5[i][j] != 'X') {
                        return false;
                    }
                }
                if (theCo.charAt(index) == 'O') {
                    if (matrix5[i][j] != 'O') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static char[][] matrix5(int x, int y) {
        char[][] matrix5 = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix5[i][j] = MyPanel.board[x + i][y + j];
            }
        }
        return matrix5;
    }
}
