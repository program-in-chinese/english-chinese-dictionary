package com.codeinchinese.英汉词典;

import java.util.HashMap;

public enum 词形变化类型 {
  过去式("p"), // past tense
  过去分词("d"),
  现在分词("i"), // -ing
  第三人称单数("3"),
  形容词比较级("r"), // -er
  形容词最高级("t"), // -est
  名词复数形式("s"),
  原型("0"),
  原型变换形式("1");

  private String 缩写;

  词形变化类型(String 缩写) {
    this.缩写 = 缩写;
  }

  private static final HashMap<String, 词形变化类型> 字段值转换表 = new HashMap<>();

  static {
    for (词形变化类型 变化 : 词形变化类型.values()) {
      字段值转换表.put(变化.缩写, 变化);
    }
  }

  public static 词形变化类型 转换(String 缩写) {
    return 字段值转换表.get(缩写);
  }
}
