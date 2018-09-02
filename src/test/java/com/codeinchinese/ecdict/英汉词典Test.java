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
    相等(英汉词典.查词表.size(), 770611);

    // TODO: 发布前删除. 临时代码, 为寻找合适的测试用例(某域不为空)
    for (String 英文 : 英汉词典.查词表.keySet()) {
      词条 某词条 = 英汉词典.查词表.get(英文);
      if (!某词条.详细.isEmpty()) {
        System.out.println(某词条);
        break;
      }
    }
  }

  // 测试每行的字段数 13
  @Test
  public void test字段数() {
    for (String[] 词条 : 英汉词典.所有词条()) {
      相等(词条.length, 13);
    }
  }
}
