package com.codeinchinese.英汉词典.工具;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codeinchinese.英汉词典.词条;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;

/**
 * 由于按照CSV格式导出, 生成文件后需手动[!!]在头尾加上{}, 并删去最后一行末的逗号
 */
public class 提取词形变化到JSON {

  // TODO: 少数空格导致json文件不合法(control characters must be escaped), 如:
  //(    测试)
  private static final String 文件后缀 = "";
  private static final String 输出文件名 = "词形变化" + 文件后缀 + ".json";
  private static final InputStream 输入流 =
      提取词形变化到JSON.class.getClassLoader().getResourceAsStream("ecdict" + 文件后缀 + ".csv");
  private static final List<String[]> 所有行 = new ArrayList<>();

  protected static Map<String, 词条> 查词表 = new HashMap<>();

  private static CSVReader 读者 = null;

  public static void main(String[] args) {
    RFC4180Parser rfc4180分析器 = new RFC4180ParserBuilder().build();

    try {
      CSVReaderBuilder csvReaderBuilder =
          new CSVReaderBuilder(new InputStreamReader(输入流)).withCSVParser(rfc4180分析器);

      CSVWriter 写者 = new CSVWriter(new FileWriter(Paths.get(输出文件名).toString()),
          ':',
          '"',
          '\\',
          ",\n");
      
      读者 = csvReaderBuilder.build();

      // 跳过第一行(头)
      读者.readNext();
      String[] 行;
      while ((行 = 读者.readNext()) != null) {
        所有行.add(行);
        String 英文 = 行[0];
        String 词形变化 = 行[10];
        if (词形变化.isEmpty()) {
          continue;
        }
        // 中文释义 = 中文释义.replaceAll("\\\\n", "\\n");
        写者.writeNext(new String[] {英文, 词形变化});
      }
      写者.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
