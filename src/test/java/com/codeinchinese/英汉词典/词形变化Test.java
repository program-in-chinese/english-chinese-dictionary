package com.codeinchinese.英汉词典;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import org.junit.Test;

import com.codeinchinese.英汉词典.词形变化类型;

public class 词形变化Test {

  @Test
  public void 转换() {
    相等(词形变化类型.转换("p"), 词形变化类型.过去式);
  }

}
