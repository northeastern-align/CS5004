import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for sentence and nodes.
 */

public class ISentenceTest {

  private ISentence sentenceEmpty;
  private ISentence sentenceNoPunc;
  private ISentence sentenceWithPunc;
  private ISentence sentence2NoPunc;
  private ISentence sentence2WithPunc;
  private ISentence wordNoPunc;
  private ISentence wordWithPunc;

  @Before
  public void setup() {
    sentenceEmpty = new EmptyNode();

    sentenceNoPunc = new WordNode("The", new WordNode("Bruins",
        new WordNode("lost", new WordNode("the", new
            WordNode("cup", new EmptyNode())))));

    sentenceWithPunc = new WordNode("The", new WordNode("Bruins",
        new WordNode("lost", new WordNode("the", new
            WordNode("cup", new PunctuationNode("?", new EmptyNode()))))));

    sentence2NoPunc = new WordNode("At", new WordNode("least",
        new WordNode("the", new WordNode("Pats", new
            WordNode("won", new WordNode("the", new WordNode("Superbowl",
            new EmptyNode())))))));

    sentence2WithPunc = new WordNode("At", new WordNode("least",
        new WordNode("the", new WordNode("Pats", new
            WordNode("won", new WordNode("the", new WordNode("Superbowl",
            new PunctuationNode("!", new EmptyNode()))))))));

    wordNoPunc = new WordNode("Hello", new EmptyNode());

    wordWithPunc = new WordNode("World", new PunctuationNode(".",
        new EmptyNode()));

  }

  @Test
  public void testWordCountNoPunc() {
    assertEquals(5, sentenceNoPunc.getNumberOfWords(0));
  }

  @Test
  public void testEmptyCount () {
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
    assertEquals("The Bruins lost the cup?", sentenceWithPunc.toString());
  }

  @Test
  public void testToStringNoPunc2() {
    assertEquals("At least the Pats won the Superbowl.", sentence2NoPunc.toString());
  }

  @Test
  public void testToStringWithPunc2() {
    assertEquals("At least the Pats won the Superbowl!", sentence2WithPunc.toString());

  }

  @Test
  public void testToStringWordNoPunc() {
    assertEquals("Hello.", wordNoPunc.toString());
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
    assertEquals("Bruins", sentenceWithPunc.longestWord());
  }

  @Test
  public void testLongestWordNoPunc2() {
    assertEquals("Superbowl", sentence2NoPunc.longestWord());
  }

  @Test
  public void testLongestWordWithPunc2() {
    assertEquals("Superbowl", sentence2WithPunc.longestWord());
  }

  @Test
  public void testLongestSingleWordNoPunc() {
    assertEquals("Hello", wordNoPunc.longestWord());
  }

  @Test
  public void testLongestSingleWordWithPunc() {
    assertEquals("World", wordWithPunc.longestWord());
  }

  @Test
  public void testCloneNoPunc() {
    ISentence temp = sentenceNoPunc.clone();
    assertEquals("The Bruins lost the cup.", temp.toString());
  }

  @Test
  public void testCloneWithPunc() {
    ISentence temp = sentenceWithPunc.clone();
    assertEquals("The Bruins lost the cup?", temp.toString());
  }

  @Test
  public void testCloneNoPunc2() {
    ISentence temp = sentence2NoPunc.clone();
    assertEquals("At least the Pats won the Superbowl.", temp.toString());
  }

  @Test
  public void testCloneWithPunc2() {
    ISentence temp = sentence2WithPunc.clone();
    assertEquals("At least the Pats won the Superbowl!", temp.toString());
  }

  @Test
  public void testCloneWordNoPunc() {
    ISentence temp = wordNoPunc.clone();
    assertEquals("Hello.", temp.toString());
  }

  @Test
  public void testCloneWordWithPunc() {
    ISentence temp = wordWithPunc.clone();
    assertEquals("World.", temp.toString());
  }

  @Test
  public void testMergeNoPunc() {
    ISentence temp = sentenceNoPunc.merge(sentence2NoPunc);
    assertEquals("The Bruins lost the cup At least the Pats won the Superbowl.",
        temp.toString());
  }

  @Test
  public void testMergeOnePunc() {
    ISentence temp = sentenceNoPunc.merge(sentenceWithPunc);
    assertEquals("The Bruins lost the cup The Bruins lost the cup?", temp.toString());
  }

  @Test
  public void testMergeTwoPunc() {
    ISentence temp = sentenceWithPunc.merge(sentence2WithPunc);
    assertEquals("The Bruins lost the cup?At least the Pats won the Superbowl!",
        temp.toString());
  }

  @Test
  public void testMergeWords() {
    ISentence temp = wordNoPunc.merge(wordWithPunc);
    assertEquals("Hello World.", temp.toString());
  }
}