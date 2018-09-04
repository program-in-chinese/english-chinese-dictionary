package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.为真;
import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import java.util.List;

import org.junit.Test;

public class 英汉词典Test {
  @Test
  public void 查词() {
    相等(英汉词典.查词(""), 0);
  }

  @Test
  public void 总词条数() {
    相等(英汉词典.所有词条().size(), 770611);
    相等(英汉词典.查词表.size(), 770611);

    // TODO: 发布前删除. 临时代码, 为寻找合适的测试用例(某域不为空)
    for (String 英文 : 英汉词典.查词表.keySet()) {
      词条 某词条 = 英汉词典.查词表.get(英文);
      if (某词条.中文释义.indexOf("\\n") != -1) {
        System.out.println(某词条);
        break;
      }
    }
  }

  @Test
  public void 字段数() {
    for (String[] 词条 : 英汉词典.所有词条()) {

      // 测试每行的字段数 13
      相等(词条.length, 13);

      // 测试每行英文均不为空
      为真(!词条[0].isEmpty());
    }
  }

  ///// 下面测试每个域

  @Test
  public void 音标() {
    相等(英汉词典.查词表.get("a").音标, "ei");
  }

  // TODO: 按/n分隔; 提取词性
  @Test
  public void 英文释义() {
    相等(英汉词典.查词表.get("a").英文释义,
        "n. the 1st letter of the Roman alphabet\\nn. the blood group whose red cells carry the A antigen");
  }

  // TODO: 按/n分隔; 提取词性
  @Test
  public void 中文释义() {
    相等(英汉词典.查词表.get("a").中文释义,
        "第一个字母 A; 一个; 第一的\\r\\nart. [计] 累加器, 加法器, 地址, 振幅, 模拟, 区域, 面积, 汇编, 组件, 异步");
  }

  // TODO: 现在数据中'词语位置'域全为空

  @Test
  public void 星级() {
    相等(英汉词典.查词表.get("a").柯林斯星级, 5);
  }

  @Test
  public void 牛津核心() {
    相等(英汉词典.查词表.get("a").为牛津三千核心词, true);
  }

  // TODO: 提取
  @Test
  public void 标签() {
    相等(英汉词典.查词表.get("abrupt").标签, "gk cet6 ky toefl ielts gre");
  }

  @Test
  public void 英国国家语料词频() {
    相等(英汉词典.查词表.get("a").英国国家语料库词频顺序, 5);
  }

  @Test
  public void 当代语料库词频() {
    相等(英汉词典.查词表.get("a").当代语料库词频顺序, 5);
  }

  @Test
  public void 变形() {
    相等(英汉词典.查词表.get("a").变形.size(), 0);

    List<词形变化> 变形 = 英汉词典.查词表.get("collocate").变形;
    相等(变形.get(0), new 词形变化(词形变化类型.名词复数形式, "collocates"));
    相等(变形.get(1), new 词形变化(词形变化类型.第三人称单数, "collocates"));
    相等(变形.get(2), new 词形变化(词形变化类型.现在分词, "collocating"));
    相等(变形.get(3), new 词形变化(词形变化类型.过去式, "collocated"));
    相等(变形.get(4), new 词形变化(词形变化类型.过去分词, "collocated"));
  }

  // 非空'详细'域只有双引号
  @Test
  public void 详细() {
    相等(英汉词典.查词表.get("a").详细, "\"\"");
  }

  // TODO: '在线读音音频'全为空
}
