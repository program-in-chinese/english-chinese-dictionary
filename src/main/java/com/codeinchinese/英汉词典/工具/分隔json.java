package com.codeinchinese.英汉词典.工具;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 分隔json {
  private static final int 每部分行数 = 50000;

  public static void main(String[] args) {
    try {
      FileReader reader = new FileReader("中文释义.json");
      BufferedReader bufferedReader = new BufferedReader(reader);

      String 行;
      List<String> 五万行 = new ArrayList<>();
      
      int 当前行数 = 0;
      int 文件序号 = 0;
      // 跳过第一行 {
      行 = bufferedReader.readLine();
      while ((行 = bufferedReader.readLine()) != null) {
        if (当前行数 < 每部分行数) {
          五万行.add(行);
          当前行数 ++;
        } else {
          写入文件(文件序号, 五万行, true);
          文件序号 ++;
          五万行.clear();
          当前行数 = 0;
        }
      }
      // 删除最后一行: }
      五万行.remove(五万行.size() - 1);
      写入文件(文件序号, 五万行, false);
      reader.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void 写入文件(int 文件序号, List<String> 五万行, boolean 删除最后一行逗号) {
    try {
      FileWriter writer = new FileWriter("词典" + 文件序号 + ".json", false);
      writer.write("{\n");
      
      for (int 行数 = 0; 行数<五万行.size(); 行数++) {
        String 行 = 五万行.get(行数);
        if (删除最后一行逗号 && 行数 == 五万行.size() - 1) {
          writer.write(行.substring(0, 行.length() - 1) + "\n");
        } else {
          writer.write(行 + "\n");
        }
      }
      writer.write("}");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
