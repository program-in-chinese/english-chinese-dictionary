package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import org.junit.Test;

public class 词形变化Test {

  @Test
  public void 转换() {
    相等(词形变化.转换("p"), 词形变化.过去式);
  }

}
