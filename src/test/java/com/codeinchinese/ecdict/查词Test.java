package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class 查词Test {

  ///// 下面测试每个域

  @Test
  public void 音标() {
    相等(英汉词典.查词("a").音标, "ei");
  }

  // TODO: 提取词性; 删除句末\r
  @Test
  public void 英文释义() {
    相等(英汉词典.查词("a").英文释义, Arrays.asList("n. the 1st letter of the Roman alphabet",
        "n. the blood group whose red cells carry the A antigen"));
  }

  // TODO: 提取词性; 删除句末\r
  @Test
  public void 中文释义() {
    相等(英汉词典.查词("a").中文释义,
        Arrays.asList("第一个字母 A; 一个; 第一的\\r", "art. [计] 累加器, 加法器, 地址, 振幅, 模拟, 区域, 面积, 汇编, 组件, 异步"));
  }

  // TODO: 现在数据中'词语位置'域全为空

  @Test
  public void 星级() {
    相等(英汉词典.查词("a").柯林斯星级, 5);
  }

  @Test
  public void 牛津核心() {
    相等(英汉词典.查词("a").为牛津三千核心词, true);
  }

  // TODO: 提取
  @Test
  public void 标签() {
    相等(英汉词典.查词("abrupt").标签, "gk cet6 ky toefl ielts gre");
  }

  @Test
  public void 英国国家语料词频() {
    相等(英汉词典.查词("a").英国国家语料库词频顺序, 5);
  }

  @Test
  public void 当代语料库词频() {
    相等(英汉词典.查词("a").当代语料库词频顺序, 5);
  }

  @Test
  public void 变形() {
    相等(英汉词典.查词("a").变形.size(), 0);

    List<词形变化> 变形 = 英汉词典.查词("collocate").变形;
    相等(变形.get(0), new 词形变化(词形变化类型.名词复数形式, "collocates"));
    相等(变形.get(1), new 词形变化(词形变化类型.第三人称单数, "collocates"));
    相等(变形.get(2), new 词形变化(词形变化类型.现在分词, "collocating"));
    相等(变形.get(3), new 词形变化(词形变化类型.过去式, "collocated"));
    相等(变形.get(4), new 词形变化(词形变化类型.过去分词, "collocated"));
  }

  // 非空'详细'域只有双引号
  @Test
  public void 详细() {
    相等(英汉词典.查词("a").详细, "\"\"");
  }

  // TODO: '在线读音音频'全为空

}
