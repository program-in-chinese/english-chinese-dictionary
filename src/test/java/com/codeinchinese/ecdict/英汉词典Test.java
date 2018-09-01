package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import org.junit.Test;

public class 英汉词典Test {
  @Test
  public void test查词() {
    相等(英汉词典.查词(""), 0);
  }
}
