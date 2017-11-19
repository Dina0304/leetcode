package cv;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/11/15.
 */
public class GetBodyPartRectanglePos {
    public static List<Map<String, String>> getIterationList(String fileInputPath, String fileoutputPath) {
        File file = new File(fileInputPath);

        List<Map<String, String>> resList = new ArrayList<>();

        FileInputStream fis = null;
        BufferedReader br = null;
        String iteration = null;

        FileWriter fw = null;

        try {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));

            fw = new FileWriter(fileoutputPath);

            String line = null;
            while ((line=br.readLine()) !=null) {
                String[] arr = line.split("\\s");
                Double x1 = Double.valueOf(arr[0]);
                Double y1 = Double.valueOf(arr[1]);
                Double x2 = Double.valueOf(arr[2]);
                Double y2 = Double.valueOf(arr[3]);
                StringBuilder sb = new StringBuilder();
                sb.append("rectangle('Position',[").append(x1).append(" ").append(y1).append(" ").append(x2-x1).append(" ").append(y2-y1).append("])").append("\n");
                fw.write(sb.toString());
            }
            fis.close();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resList;
    }
    public static void main(String[] args) {
        String fileInputPath = "E:\\graduate\\cv\\haohuiRap\\postion.txt";
        String fileoutputPath = "E:\\graduate\\cv\\haohuiRap\\matlab_postion.txt";

        getIterationList(fileInputPath, fileoutputPath);
    }
}
