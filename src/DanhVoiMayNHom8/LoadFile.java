package DanhVoiMayNHom8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class LoadFile {

    public static String path = System.getProperty("user.dir") + "\\data\\";

    public static ArrayList<String> load(String file) {
        ArrayList<String> list = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(path + file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String chuoi = "";
            do {
                line = br.readLine();
                chuoi = chuoi + line;
                chuoi.trim();
                if (chuoi.length() == 25) {
                    list.add(chuoi);
                    chuoi = "";
                }
            } while (line != null);
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Hệ thống bị lỗi !!!");
            e.printStackTrace();
        }
        return list;
    }
}
