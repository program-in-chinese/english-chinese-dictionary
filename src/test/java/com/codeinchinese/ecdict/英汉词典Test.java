package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.为假;
import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class 英汉词典Test {

  // 英文释义有\n但并非分隔符
  private static final Set<String> 英文释义带换行的词汇 =
      new HashSet<>(Arrays.asList(
          "-meric",
          "academic bulemia",
          "Alaskian",
          "arch douche",
          "Atheism Plus",
          "Audience typing",
          "Babalawo",
          "Best-Behavior Friend",
          "booty text",
          "Bootybrows",
          "boregasm",
          "Brony",
          "Brosama Bin Laden",
          "buy-curious",
          "Check your Totem",
          "computer-face",
          "ConfabLab",
          "cool story bro",
          "cuck",
          "da kine",
          "Degifting",
          "derp",
          "Desk Rage",
          "directionally challenged",
          "divey",
          "Dohment",
          "Electile Dysfunction",
          "Elf-Esteem",
          "Emperor Harperius Mandatorius Minimus",
          "Eskimo Brother",
          "facebook mommy",
          "Fame Whore",
          "feed the beast",
          "Feku",
          "flat earther",
          "front-seat back-seat dilemma",
          "G6",
          "girlfriend zone",
          "glifnard",
          "Google harder",
          "Gramma-phone",
          "Harliano",
          "Hollywood Undead",
          "hopeless romantic",
          "Hoprah",
          "I Heard You Using the Microwave",
          "I know, right?",
          "Iconomy",
          "Imma let you finish",
          "Immaculate Defecation",
          "index finger discount",
          "Instagram Prime Time",
          "Internet Coma",
          "jejemon",
          "job talker",
          "jobble",
          "katshit",
          "Keep fucking that chicken",
          "Khloe Kardashian",
          "kludgy",
          "Kordanize",
          "kpop",
          "kurwa",
          "Ladyboner",
          "LBH",
          "Lent Trap",
          "libercarelessian",
          "Luke Hemmings",
          "Martii",
          "meetable",
          "mimping",
          "mistext",
          "moany",
          "mudbugging",
          "Muddy Helmet",
          "multicult",
          "murderation",
          "mwah-mwah",
          "myth-information",
          "Newkie",
          "Nice Guy Syndrome",
          "nigger free zone",
          "NiggerFaggot",
          "niggergram",
          "nightcore",
          "No hair off my balls",
          "No Lifer",
          "no-motion",
          "noggy",
          "nonsensity",
          "Northwest Nap",
          "Nusas",
          "Obdicut",
          "Ocarina of Time",
          "Oirish",
          "Omelette du fromage",
          "Onew Condition",
          "Onision",
          "OOTD",
          "Opelousa",
          "Otherkin",
          "Owen Tate",
          "Picentary",
          "pisshap",
          "pitless",
          "pop sock",
          "power shopper",
          "power-shop",
          "pre-board",
          "puffa",
          "Queer Bait",
          "queerplatonic",
          "Questionable Fart",
          "quid pro quo-job",
          "quif",
          "QUILTBAG",
          "qwertyuiopasdfghjklzxcvbnmmnbvcxzlkjhgfdsapoiuytrewqqazwsxedcrfvtgbyhnujmikolp",
          "qwop",
          "Ragism",
          "residuate",
          "ridin dirty",
          "ring-a-levio",
          "ROFLMAO",
          "sapiosexual",
          "Shut up and keep talking",
          "sloth-cloth",
          "Smartphone Shuffle",
          "Soulja Boy",
          "spacescape",
          "Spokompton",
          "super-chilled",
          "Thanksgiving Beard",
          "Trigger warning",
          "TV stoned",
          "U got no jams",
          "UberHaxorNova",
          "Ulster Scot",
          "Ultraforge",
          "unfappable",
          "Urban Dictionary Cover-Up",
          "USUK",
          "VagHag",
          "VagVamp",
          "vajazzling",
          "Vas happening",
          "Vatication",
          "vegetablization",
          "VISTASTER",
          "VOCD",
          "voluntold",
          "vote smurfing",
          "vyvanse",
          "wackadoo",
          "Waifu",
          "WalMart Tax",
          "weaboo",
          "webshite",
          "Whack it Off",
          "when the economy picks up",
          "where is this coming from",
          "Whovian",
          "Work Mouth",
          "wumbo",
          "x reader",
          "Xemobile",
          "Xiumin",
          "Xtrykr",
          "YAAB",
          "YDG",
          "YMCMB",
          "you mad bro?",
          "Your first name",
          "YouTube Loop",
          "Yuna Kim",
          "Zef",
          "Zeta Phi Beta",
          "Zugg my gogg",
          "Zutara",
          "Zynga"
          ));

  // 中文释义有\n但并非分隔符
  private static final Set<String> 中文释义带换行的词汇 =
      new HashSet<>(Arrays.asList("companied", "companying", "say-", "say-ing", "welled"));

  // TODO: 此中文释义为纯英文, 需改正数据; 且英文释义为空
  private static final Set<String> 中文释义为英文且换行的词汇 = new HashSet<>(
      Arrays.asList("awreet", "bananery", "besotten", "cropful", "dishumor", "duckish", "famble",
          "foredream", "furtle", "huswifely", "loave", "midshock", "overclad", "parasigmoid",
          "peent", "rameish", "sarcle", "spight", "squop", "swaggy", "whoost", "wough", "wramp"));

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

      // 验证每行的字段数 13
      相等(词条.length, 13);

      // 验证每行英文均不为空
      验证文本非空(词条[0]);
    }
  }

  @Test
  public void 验证英文释义非空() {
    for (String[] 词条 : 英汉词典.所有词条()) {
      词条 某词条 = 英汉词典.查词表.get(词条[0]);
      if (!英文释义带换行的词汇.contains(某词条.英文)) {
        for (String 释义 : 某词条.英文释义) {
          验证文本非空(释义);
        }
      }
    }
  }

  @Test
  public void 验证中文释义非空() {
    for (String[] 词条 : 英汉词典.所有词条()) {
      词条 某词条 = 英汉词典.查词表.get(词条[0]);
      if (!中文释义带换行的词汇.contains(某词条.英文) && !中文释义为英文且换行的词汇.contains(某词条.英文)) {
        for (String 释义 : 某词条.中文释义) {
          验证文本非空(释义);
        }
      }
    }
  }

  ///// 下面测试每个域

  @Test
  public void 音标() {
    相等(英汉词典.查词表.get("a").音标, "ei");
  }

  // TODO: 提取词性; 删除句末\r
  @Test
  public void 英文释义() {
    相等(英汉词典.查词表.get("a").英文释义, Arrays.asList("n. the 1st letter of the Roman alphabet",
        "n. the blood group whose red cells carry the A antigen"));
  }

  // TODO: 提取词性; 删除句末\r
  @Test
  public void 中文释义() {
    相等(英汉词典.查词表.get("a").中文释义,
        Arrays.asList("第一个字母 A; 一个; 第一的\\r", "art. [计] 累加器, 加法器, 地址, 振幅, 模拟, 区域, 面积, 汇编, 组件, 异步"));
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

  private void 验证文本非空(String 文本) {
    为假(文本.isEmpty());
  }

}
