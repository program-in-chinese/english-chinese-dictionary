package com.codeinchinese.ecdict;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class 英汉词典 {

  private static final String 源数据文件 = "src/main/resources/ecdict.csv";

  private static CSVReader 读者 = null;
  private static List<String[]> 所有行 = new ArrayList<String[]>();

  static {
    try {
      读者 = new CSVReader(new FileReader(源数据文件));

      // 跳过第一行(头)
      读者.readNext();
      String[] 行;
      while ((行 = 读者.readNext()) != null) {
        所有行.add(行);
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
