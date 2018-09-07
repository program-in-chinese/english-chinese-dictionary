package com.codeinchinese.英汉词典;

public class 词形变化 {
  public 词形变化类型 类型;

  // TODO: shopping - 原型:shop; 原型变换形式:i; <-- i应转换为'现在分词'
  public String 词形;

  public 词形变化(词形变化类型 类型, String 词形) {
    this.类型 = 类型;
    this.词形 = 词形;
  }

  @Override
  public boolean equals(Object 个体) {
    return 个体 instanceof 词形变化 && this.类型.equals(((词形变化) 个体).类型) && this.词形.equals(((词形变化) 个体).词形);
  }

  @Override
  public String toString() {
    return 类型.toString() + ":" + 词形;
  }

}
