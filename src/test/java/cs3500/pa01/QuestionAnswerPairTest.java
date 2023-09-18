package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests for class that holds an individual question, answer and difficulty tag
 */
class QuestionAnswerPairTest {

  QuestionAnswerPair question1;
  QuestionAnswerPair question2;

  /**
   * sets up an example of questions
   */
  @BeforeEach
  void setUp() {
    question1 = new QuestionAnswerPair("Hard[[What is 1 + 1? ::: 2]]");
    question2 = new QuestionAnswerPair("Easy[[Is apple a vegetable? ::: No, it is a fruit]]");
  }

  /**
   * tests that the method is able to return both the question and answer
   */
  @Test
  void getBothQestAndAnsw() {
    assertEquals("[[What is 1 + 1? ::: 2]]", question1.getBothQuestAndAnsw());
    assertEquals("[[Is apple a vegetable? ::: No, it is a fruit]]",
        question2.getBothQuestAndAnsw());

  }

  /**
   * tests that the method can return just the question
   */
  @Test
  void getQuestion() {
    assertEquals("What is 1 + 1? ", question1.getQuestion());
    assertEquals("Is apple a vegetable? ", question2.getQuestion());
  }

  /**
   * tests that the method can return just the answer
   */
  @Test
  void getAnswer() {
    assertEquals(" 2", question1.getAnswer());
    assertEquals(" No, it is a fruit", question2.getAnswer());
  }

  /**
   * tests that the method can return the difficulty tag
   */
  @Test
  void getTag() {
    assertEquals("Hard", question1.getTag());
    assertEquals("Easy", question2.getTag());
  }

  /**
   * tests that the method can set the difficulty of a question to easy
   */
  @Test
  void setQuestionEasy() {
    assertEquals("Hard", question1.getTag());
    question1.setQuestionEasy();
    assertEquals("Easy", question1.getTag());
    question1.setQuestionEasy();
    assertEquals("Easy", question1.getTag());
  }

  /**
   * tests that the method can set the difficulty of a question to hard
   */
  @Test
  void setQuestionHard() {
    assertEquals("Easy", question2.getTag());
    question2.setQuestionHard();
    assertEquals("Hard", question2.getTag());
    question2.setQuestionHard();
    assertEquals("Hard", question2.getTag());
  }
}