package com.codeinchinese.ecdict;

import java.util.HashMap;

public enum 词形变化 {
  过去式("p"),
  过去分词("d"),
  现在分词("i"),
  第三人称单数("3"),
  形容词比较级("r"),
  形容词最高级("t"),
  名词复数形式("s"),
  原型("0"),
  原型变换形式("1");

  private String 字段值;

  词形变化(String 字段值) {
    this.字段值 = 字段值;
  }

  private static final HashMap<String, 词形变化> 字段值转换表 = new HashMap<>();

  static {
    for (词形变化 变化 : 词形变化.values()) {
      字段值转换表.put(变化.字段值, 变化);
    }
  }

  public static 词形变化 转换(String url) {
    return 字段值转换表.get(url);
  }
}
