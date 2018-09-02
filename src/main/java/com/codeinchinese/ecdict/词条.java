package com.codeinchinese.ecdict;

/**
 * 对应数据格式: https://github.com/skywind3000/ECDICT#%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F
 */
public class 词条 {

  private String 英文;
  private String 音标;
  private String 英文释义;
  private String 中文释义;
  private String 词语位置;
  private String 柯林斯星级;
  private String 为牛津三千核心词;

  // zk/中考，gk/高考，cet4/四级等
  private String 标签;
  private String 英国国家语料库词频顺序;
  private String 当代语料库词频顺序;
  private String 变形;
  private String 详细;
  private String 在线读音音频;
}
