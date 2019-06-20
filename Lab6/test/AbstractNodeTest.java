import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AbstractNodeTest {

  private Sentence sentenceEmpty;
  private Sentence sentenceNoPunc;
  private Sentence sentenceWithPunc;
  private Sentence sentence2NoPunc;
  private Sentence sentence2WithPunc;
  private Sentence wordNoPunc;
  private Sentence wordWithPunc;
  private Sentence sentenceNoPuncUpper;
  private Sentence sentenceWithPuncUpper;

  @Before
  public void setup() {
    sentenceEmpty = new EmptyNode();

    sentenceNoPunc = new WordNode("The", new WordNode("Bruins",
        new WordNode("lost", new WordNode("the", new
            WordNode("cup", new EmptyNode())))));

    sentenceWithPunc = new WordNode("The", new WordNode("zambonis",
        new WordNode("zoomed", new WordNode("on", new
            WordNode("ice", new PunctuationNode("!", new EmptyNode()))))));

    sentence2NoPunc = new WordNode("The", new WordNode("pizza",
        new WordNode("was", new WordNode("the", new
            WordNode("best", new WordNode("part", new WordNode("zzz",
            new EmptyNode())))))));

    sentence2WithPunc = new WordNode("At", new WordNode("least",
        new WordNode("the", new WordNode("Pats", new
            WordNode("won", new WordNode("the", new WordNode("Superbowl",
            new PunctuationNode("?", new EmptyNode()))))))));

    wordNoPunc = new WordNode("Pizza", new EmptyNode());

    wordWithPunc = new WordNode("World", new PunctuationNode(".",
        new EmptyNode()));

    sentenceNoPuncUpper = new WordNode("THE", new WordNode("BRUINS",
        new WordNode("LOST", new WordNode("THE", new
            WordNode("CUP", new EmptyNode())))));

    sentenceWithPuncUpper = new WordNode("THE", new WordNode("ZAMBONIS",
        new WordNode("ZOOMED", new WordNode("ON", new
            WordNode("ICE", new PunctuationNode("!", new EmptyNode()))))));

  }

  @Test
  public void testWordCountNoPunc() {
    assertEquals(5, sentenceNoPunc.getNumberOfWords(0));
  }

  @Test
  public void testEmptyCount() {
    assertEquals(0, sentenceEmpty.getNumberOfWords(0));
  }

  @Test
  public void testWordCountWithPunc() {
    assertEquals(5, sentenceWithPunc.getNumberOfWords(0));
  }

  @Test
  public void testWordCountNoPunc2() {
    assertEquals(7, sentence2NoPunc.getNumberOfWords(0));
  }

  @Test
  public void testWordCountWithPunc2() {
    assertEquals(7, sentence2WithPunc.getNumberOfWords(0));
  }

  @Test
  public void testSingleWordCountNoPunc() {
    assertEquals(1, wordNoPunc.getNumberOfWords(0));
  }

  @Test
  public void testSingleWordCountWithPunc() {
    assertEquals(1, wordWithPunc.getNumberOfWords(0));
  }

  @Test
  public void testToStringNoPunc() {
    assertEquals("The Bruins lost the cup.", sentenceNoPunc.toString());
  }

  @Test
  public void testToStringWithPunc() {
    assertEquals("The zambonis zoomed on ice!", sentenceWithPunc.toString());
  }

  @Test
  public void testToStringNoPunc2() {
    assertEquals("The pizza was the best part zzz.", sentence2NoPunc.toString());
  }

  @Test
  public void testToStringWithPunc2() {
    assertEquals("At least the Pats won the Superbowl?", sentence2WithPunc.toString());

  }

  @Test
  public void testToStringWordNoPunc() {
    assertEquals("Pizza", wordNoPunc.toString());
  }

  @Test
  public void testToString6() {
    assertEquals("World.", wordWithPunc.toString());
  }

  @Test
  public void testLongestWordNoPunc() {
    assertEquals("Bruins", sentenceNoPunc.longestWord());
  }

  @Test
  public void testLongestWordWithPunc() {
    assertEquals("zambonis", sentenceWithPunc.longestWord());
  }

  @Test
  public void testLongestWordNoPunc2() {
    assertEquals("pizza", sentence2NoPunc.longestWord());
  }

  @Test
  public void testLongestWordWithPunc2() {
    assertEquals("Superbowl", sentence2WithPunc.longestWord());
  }

  @Test
  public void testLongestSingleWordNoPunc() {
    assertEquals("Pizza", wordNoPunc.longestWord());
  }

  @Test
  public void testLongestSingleWordWithPunc() {
    assertEquals("World", wordWithPunc.longestWord());
  }

  @Test
  public void testCloneNoPunc() {
    Sentence temp = sentenceNoPunc.clone();
    assertEquals("The Bruins lost the cup.", temp.toString());
  }

  @Test
  public void testCloneWithPunc() {
    Sentence temp = sentenceWithPunc.clone();
    assertEquals("The zambonis zoomed on ice!", temp.toString());
  }

  @Test
  public void testCloneNoPunc2() {
    Sentence temp = sentence2NoPunc.clone();
    assertEquals("The pizza was the best part zzz.", temp.toString());
  }

  @Test
  public void testCloneWithPunc2() {
    Sentence temp = sentence2WithPunc.clone();
    assertEquals("At least the Pats won the Superbowl?", temp.toString());
  }

  @Test
  public void testCloneWordNoPunc() {
    Sentence temp = wordNoPunc.clone();
    assertEquals("Pizza", temp.toString());
  }

  @Test
  public void testCloneWordWithPunc() {
    Sentence temp = wordWithPunc.clone();
    assertEquals("World.", temp.toString());
  }

  @Test
  public void testMergeNoPunc() {
    Sentence temp = sentenceNoPunc.merge(sentence2NoPunc);
    assertEquals("The Bruins lost the cup The pizza was the best part zzz.",
        temp.toString());
  }

  @Test
  public void testMergeOnePunc() {
    Sentence temp = sentenceNoPunc.merge(sentenceWithPunc);
    assertEquals("The Bruins lost the cup The zambonis zoomed on ice!", temp.toString());
  }

  @Test
  public void testMergeTwoPunc() {
    Sentence temp = sentenceWithPunc.merge(sentence2WithPunc);
    assertEquals("The zambonis zoomed on ice! At least the Pats won the Superbowl?",
        temp.toString());
  }

  @Test
  public void testMergeWords() {
    Sentence temp = wordNoPunc.merge(wordWithPunc);
    assertEquals("Pizza World.", temp.toString());
  }

  @Test
  public void testCountNoZ() {
    assertEquals(0, sentenceNoPunc.count((node) -> node.string.contains("z"), 0));
    assertEquals(0, sentence2WithPunc.count((node) -> node.string.contains("z"), 0));
  }

  @Test
  public void testCountZ() {
    assertEquals(2, sentenceWithPunc.count((node) -> node.string.contains("z"), 0));
    assertEquals(2, sentence2NoPunc.count((node) -> node.string.contains("z"), 0));
  }

  @Test
  public void testCountPunctuation() {
    assertEquals(1, sentenceWithPunc.count((node) -> node.getClass()
        == PunctuationNode.class, 0));
    assertEquals(1, sentence2WithPunc.count((node) -> node.getClass()
        == PunctuationNode.class, 0));
  }

  @Test
  public void testCountNoPunctuation() {
    assertEquals(0, sentenceNoPunc.count((node) -> node.getClass()
        == PunctuationNode.class, 0));
    assertEquals(0, sentence2NoPunc.count((node) -> node.getClass()
        == PunctuationNode.class, 0));
  }

  @Test
  public void testPigLatin() {

    assertEquals("HETAY RUINSBAY OSTLAY HETAY UPCAY.",
        sentenceNoPuncUpper.map((string) -> {
          String letter = string.substring(0, 1);
          if (letter.equalsIgnoreCase("A") || letter.equalsIgnoreCase("E")
              || letter.equalsIgnoreCase("I") || letter.equalsIgnoreCase("O")
              || letter.equalsIgnoreCase("U")) {
            return string.concat("WAY");
          }

          String rest = string.substring(1);
          return rest.concat(letter).concat("AY");
        }).toString());
  }

  @Test
  public void testPigLatinPunc() {

    assertEquals("HETAY AMBONISZAY OOMEDZAY ONWAY ICEWAY!",
        sentenceWithPuncUpper.map((string) -> {

          String letter = string.substring(0, 1);
          if (letter.equalsIgnoreCase("A") || letter.equalsIgnoreCase("E")
              || letter.equalsIgnoreCase("I") || letter.equalsIgnoreCase("O")
              || letter.equalsIgnoreCase("U")) {
            return string.concat("WAY");
          }

          String rest = string.substring(1);
          return rest.concat(letter).concat("AY");
        }).toString());
  }

}
