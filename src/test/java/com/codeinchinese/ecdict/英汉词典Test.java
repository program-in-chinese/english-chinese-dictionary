package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import org.junit.Test;

public class 英汉词典Test {
  @Test
  public void test查词() {
    相等(英汉词典.查词(""), 0);
  }

  @Test
  public void test总词条数() {
    相等(英汉词典.所有词条().size(), 770611);
  }

  // 测试每行的字段数 13
  @Test
  public void test字段数() {
    for (String[] 词条 : 英汉词典.所有词条()) {
      相等(词条.length, 13);
    }
  }
}
