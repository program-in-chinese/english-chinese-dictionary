package com.codeinchinese.ecdict;

import static com.github.program_in_chinese.junit4_in_chinese.断言.为假;
import static com.github.program_in_chinese.junit4_in_chinese.断言.相等;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class 词表校验Test {

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

  // TODO: 此中文释义为纯英文, 且英文释义为空, 需改正数据
  private static final Set<String> 中文释义为英文且换行的词汇 = new HashSet<>(
      Arrays.asList("awreet", "bananery", "besotten", "cropful", "dishumor", "duckish", "famble",
          "foredream", "furtle", "huswifely", "loave", "midshock", "overclad", "parasigmoid",
          "peent", "rameish", "sarcle", "spight", "squop", "swaggy", "whoost", "wough", "wramp"));

  // 如bath: s:baths/3:baths/i:/p:bathed/d:bathed 的i对应词形为空
  private static final Set<String> 词形变化之一为空的词汇 = new HashSet<>(Arrays.asList(
      "bath",
      "bitt",
      "burr",
      "can",
      "crossbreed",
      "hyphen",
      "matter",
      "plat",
      "reproof",
      "sick",
      "stink",
      "swathe",
      "undershoot",
      "worst"
      ));

  @Test
  public void 查不到词() {
    相等(英汉词典.查词(""), null);
  }

  @Test
  public void 总词条数() {
    相等(英汉词典.所有原始词条().size(), 770611);
    相等(英汉词典.查词表.size(), 770611);

    // TODO: 发布前删除. 临时代码, 为寻找合适的测试用例(某域不为空)
    /*for (String[] 词条 : 英汉词典.所有原始词条()) {
      词条 某词条 = 英汉词典.查词(词条[0]);
      List<词形变化> 变化 = 某词条.变形;
      for (词形变化 某变化 : 变化) {
        if (某变化.词形.isEmpty()) {
          System.out.println("\"" + 某词条.英文 + "\",");
          break;
        }
      }
    }*/
  }

  @Test
  public void 字段基本检验() {
    for (String[] 词条 : 英汉词典.所有原始词条()) {

      // 验证每行的字段数 13
      相等(词条.length, 13);

      // 验证每行英文均不为空
      验证文本非空(词条[0]);
    }
  }

  @Test
  public void 验证英文释义非空() {
    for (String[] 词条 : 英汉词典.所有原始词条()) {
      词条 某词条 = 英汉词典.查词(词条[0]);
      if (!英文释义带换行的词汇.contains(某词条.英文)) {
        for (String 释义 : 某词条.英文释义) {
          验证文本非空(释义);
        }
      }
    }
  }

  @Test
  public void 验证中文释义非空() {
    for (String[] 词条 : 英汉词典.所有原始词条()) {
      词条 某词条 = 英汉词典.查词(词条[0]);
      if (!中文释义带换行的词汇.contains(某词条.英文) && !中文释义为英文且换行的词汇.contains(某词条.英文)) {
        for (String 释义 : 某词条.中文释义) {
          验证文本非空(释义);
        }
      }
    }
  }

  @Test
  public void 验证词形非空() {
    for (String[] 词条 : 英汉词典.所有原始词条()) {
      词条 某词条 = 英汉词典.查词(词条[0]);
      if (!词形变化之一为空的词汇.contains(某词条.英文)) {
        for (词形变化 变化 : 某词条.变形) {
          验证文本非空(变化.词形);
        }
      }
    }
  }

  private void 验证文本非空(String 文本) {
    为假(文本.isEmpty());
  }

}
