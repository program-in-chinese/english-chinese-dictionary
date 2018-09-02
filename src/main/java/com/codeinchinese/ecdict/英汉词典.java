package com.codeinchinese.ecdict;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class 英汉词典 {

  private static final String 源数据文件 = "src/main/resources/ecdict.csv";

  private static CSVReader 读者 = null;
  private static List<String[]> 所有行 = new ArrayList<>();
  public static Map<String, 词条> 查词表 = new HashMap<>();

  static {
    try {
      读者 = new CSVReader(new FileReader(源数据文件));

      // 跳过第一行(头)
      读者.readNext();
      String[] 行;
      while ((行 = 读者.readNext()) != null) {
        所有行.add(行);

        词条 新词 = new 词条();
        新词.英文 = 行[0];
        新词.音标 = 行[1];
        新词.英文释义 = 行[2];
        新词.中文释义 = 行[3];
        新词.词语位置 = 行[4];
        新词.柯林斯星级 = 行[5];
        新词.为牛津三千核心词 = 行[6];
        新词.标签 = 行[7];
        新词.英国国家语料库词频顺序 = 行[8];
        新词.当代语料库词频顺序 = 行[9];
        新词.变形 = 行[10];
        新词.详细 = 行[11];
        新词.在线读音音频 = 行[12];

        查词表.put(新词.英文, 新词);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int 查词(String 英文词) {
    return 0;
  }

  public static List<String[]> 所有词条() {
    return 所有行;
  }
}
