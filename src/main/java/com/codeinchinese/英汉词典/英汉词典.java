package com.codeinchinese.英汉词典;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;

/**
 * 词典数据来源: https://github.com/skywind3000/ECDICT v1.0.28中的ecdict.csv文件.
 * 提取/分隔规则取自原词典数据说明文档.
 * 可查单词和常见词组, 如: be bad at, beat around the bush 等
 */
public class 英汉词典 {
  private static final InputStream 输入流 =
      英汉词典.class.getClassLoader().getResourceAsStream("ecdict.csv");
  private static final List<String[]> 所有行 = new ArrayList<>();

  protected static Map<String, 词条> 查词表 = new HashMap<>();

  private static CSVReader 读者 = null;

  static {
    RFC4180Parser rfc4180分析器 = new RFC4180ParserBuilder().build();

    try {
      CSVReaderBuilder csvReaderBuilder =
          new CSVReaderBuilder(new InputStreamReader(输入流)).withCSVParser(rfc4180分析器);

      读者 = csvReaderBuilder.build();

      // 跳过第一行(头)
      读者.readNext();
      String[] 行;
      while ((行 = 读者.readNext()) != null) {
        所有行.add(行);

        词条 新词 = new 词条();
        新词.英文 = 行[0];
        新词.音标 = 行[1];
        新词.英文释义 = 分隔释义(行[2]);
        新词.中文释义 = 分隔释义(行[3]);
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

  /**
   * 返回英文完全匹配(大小写相同, 无变形)的词条
   * @param 英文词 大小写敏感
   * @return null 如果未查到此词
   */
  public static 词条 查词(String 英文词) {
    return 查词表.get(英文词);
  }

  /**
   * 数组长度13, 数据格式见https://github.com/skywind3000/ECDICT#%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F
   * @return 从csv文件按行拆分出的字段列表, 无额外提取/转换/清理处理
   */
  public static List<String[]> 所有原始词条() {
    return 所有行;
  }

  /**
   * 释义部分按行分隔释义. 有小比例词汇释义数据非按行分隔, 详见测试.
   * @param 原释义
   * @return
   */
  private static List<String> 分隔释义(String 原释义) {
    if (原释义.isEmpty()) {
      return new ArrayList<>();
    }
    return Arrays.asList(原释义.split("\\\\n"));
  }

  /**
   * 词形部分数据格式描述: https://github.com/skywind3000/ECDICT#%E8%AF%8D%E5%BD%A2%E5%8F%98%E5%8C%96
   * @param 原字符串
   * @return 提取所有词形变化置于列表
   */
  private static List<词形变化> 转为词形变化(String 原字符串) {
    List<词形变化> 变化 = new ArrayList<>();
    if (原字符串.isEmpty()) {
      return 变化;
    }
    String[] 词形字段 = 原字符串.split("/");
    for (String 某字段 : 词形字段) {
      String[] 分段 = 某字段.split(":");

      // 如hyphen(vt): s:hyphens/p:hyphened/i:/3:hyphens/d:, i与d内容缺失, 用空字符串占位
      变化.add(new 词形变化(词形变化类型.转换(分段[0]), 分段.length == 1 ? "" : 分段[1]));
    }
    return 变化;
  }

  private static boolean 转为布尔量(String 数字) {
    return 数字.equals("1");
  }

  private static int 转为整数(String 数字字符串) {
    return 数字字符串.isEmpty() ? 0 : Integer.parseInt(数字字符串);
  }
}
