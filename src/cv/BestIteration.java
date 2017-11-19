package cv;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/11/13.
 */
public class BestIteration {
    private static final String iterKey = "iteration";

    /**
     * 获取迭代结果列表
     * @param filePath 日志文件路径
     * @param iterRegex 迭代日志匹配正则
     * @param iterIndexRegex 迭代日志行切分正则
     * @param iterIndex 正则切分后，迭代轮数在数组中的下标
     * @param evaluationRegex 评价指标匹配正则
     * @param evaluationIndex 评价指标数值所在数组中的下标
     * @param evaluationItems 评价指标列表
     * @return
     */
    public static List<Map<String, String>> getIterationList(String filePath, String iterRegex, String iterIndexRegex, int iterIndex, String evaluationRegex, int evaluationIndex, List<String> evaluationItems) {
        File file = new File(filePath);

        List<Map<String, String>> resList = new ArrayList<>();

        FileInputStream fis = null;
        BufferedReader br = null;
        String iteration = null;

        try {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line=br.readLine()) !=null) {
                Pattern p = Pattern.compile(iterRegex);
                Matcher m = p.matcher(line);
                if (m.find()) {
                    Map<String,String> evaluationMap = new HashMap<>();

                    int evaluationNum = evaluationItems.size();
                    String iterStr = line.split(iterIndexRegex)[iterIndex];
                    iteration = String.valueOf(iterStr.subSequence(0, iterStr.length()-1));
                    evaluationMap.put(iterKey, iteration);
                    int index = 0;
                    String evaluation = null;
                    while ((evaluation=br.readLine())!=null && index<evaluationNum) {
                        String[] evaluationArray = evaluation.split(evaluationRegex);
                        String evaluationVal = evaluationArray[evaluationArray.length-1];
                        evaluationMap.put(evaluationItems.get(index), evaluationVal);
                        ++index;
                    }
                    resList.add(evaluationMap);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resList;
    }

    /**
     * 获取各个评价标准最大的一组迭代结果
     * @param iterationList 迭代结果列表
     * @param evaluationItems 评价标准项
     * @param key 指定的最大评价标准
     */
    public static void getBest(List<Map<String, String>> iterationList, List<String> evaluationItems, String key) {
        iterationList.sort(new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return Double.compare(Double.valueOf(o1.get(key)), Double.valueOf(o2.get(key)));
            }
        });

        Map<String,String> mapMA = iterationList.get(iterationList.size()-1);
        System.out.println(key +" Best:");
        int mAindex = 0;
        System.out.println(String.format("iteration : %s, pmA=%s, nmA=%s, mA=%s, accuracy=%s, precision=%s, recall=%s, F1=%s",
                mapMA.get(iterKey), mapMA.get(evaluationItems.get(mAindex++)), mapMA.get(evaluationItems.get(mAindex++)), mapMA.get(evaluationItems.get(mAindex++)),
                mapMA.get(evaluationItems.get(mAindex++)), mapMA.get(evaluationItems.get(mAindex++)), mapMA.get(evaluationItems.get(mAindex++)), mapMA.get(evaluationItems.get(mAindex++))
        ));
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public static void getIterationFile(List<Map<String, String>> iterationList, String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Map<String, String> map : iterationList) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String item = entry.getKey() + ":" + entry.getValue();
                    sb.append(String.format("%-25s", item));
                }
                fw.write(sb.toString());
                fw.write("\n\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /**
         * iteration test 文本示例：
         * I1113 16:32:45.473033 32691 solver.cpp:266] Iteration 14500, Testing net (#0)
         */

        // log 文件路径
        String inputFilePath = "E:\\graduate\\cv\\log\\slice_Train-2017-10-22-16-20-14.log";
        // 只有 iteration test 相关信息的log 的输出路径
        String outputFilePath = "E:\\graduate\\cv\\log\\slice_Train-2017-10-22-16-20-14-iteration.log";
        // 匹配 iteration test 文本的正则
        String iterRegex = ".*Iteration\\s\\d+,\\sTesting\\snet\\s\\(\\#\\d\\)";
        // 切分 iteration test 文本行的正则
        String iterIndexRegex = "\\s";
        // 切分 评价标准 文本行的正则
        String evaluationRegex = "\\s";
        // 迭代轮数的下标
        int iterIndex = 5;
        // 评价标准数值的下标， 目前该值可以随意设置，因为会在 getIterationList 方法中默认取最后一个值，作为评价标准数值
        int evaluationIndex = 14;
        // 评价标准项列表
        List<String> evaluationItems = Arrays.asList("pmA", "nmA", "mA", "accuracy", "precision", "recall", "F1");

        // 获取只包含 iteration test 信息的list
        List<Map<String, String>> iterationList = getIterationList(inputFilePath, iterRegex, iterIndexRegex, iterIndex, evaluationRegex, evaluationIndex, evaluationItems);

        // 将只包含 iteration test 的信息输出到文件
        getIterationFile(iterationList, outputFilePath);

        // 输出各个评价指标最高的那个 iteration 信息
        for(String key : evaluationItems) {
            getBest(iterationList, evaluationItems, key);

        }

    }
}
