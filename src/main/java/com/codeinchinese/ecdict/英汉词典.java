package com.codeinchinese.ecdict;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;

public class 英汉词典 {

  private static final String 源数据文件 = "src/main/resources/ecdict.csv";

  private static CSVReader 读者 = null;
  private static List<String[]> 所有行 = new ArrayList<>();
  public static Map<String, 词条> 查词表 = new HashMap<>();

  static {
    RFC4180Parser rfc4180Parser = new RFC4180ParserBuilder().build();

    try {
      CSVReaderBuilder csvReaderBuilder =
          new CSVReaderBuilder(new FileReader(源数据文件)).withCSVParser(rfc4180Parser);

      读者 = csvReaderBuilder.build();

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
        新词.柯林斯星级 = 转为整数(行[5]);
        新词.为牛津三千核心词 = 转为布尔量(行[6]);
        新词.标签 = 行[7];
        新词.英国国家语料库词频顺序 = 转为整数(行[8]);
        新词.当代语料库词频顺序 = 转为整数(行[9]);
        新词.变形 = 转为词形变化(行[10]);
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

  private static List<词形变化> 转为词形变化(String 变形原字符串) {
    List<词形变化> 变化 = new ArrayList<>();
    if (变形原字符串.isEmpty()) {
      return 变化;
    }
    String[] 词形字段 = 变形原字符串.split("/");
    for (String 某字段 : 词形字段) {
      String[] 分段 = 某字段.split(":");
      if (分段.length != 2) {

        // 如hyphen(vt): s:hyphens/p:hyphened/i:/3:hyphens/d:, i与d缺失, 暂时略过
        continue;
      }
      变化.add(new 词形变化(词形变化类型.转换(分段[0]), 分段[1]));
    }
    return 变化;
  }

  private static boolean 转为布尔量(String 数字) {
    if (!数字.equals("1") && !数字.isEmpty()) {
      System.out.println("非布尔: " + 数字);
    }
    return 数字.equals("1");
  }

  private static int 转为整数(String 数字字符串) {
    return 数字字符串.isEmpty() ? 0 : Integer.parseInt(数字字符串);
  }

  public static List<String[]> 所有词条() {
    return 所有行;
  }
}
