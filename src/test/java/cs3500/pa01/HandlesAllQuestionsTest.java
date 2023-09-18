package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlesAllQuestionsTest {

  QuestionAnswerPair question1;
  QuestionAnswerPair question2;

  QuestionAnswerPair question3;
  HandlesAllQuestions allQuestions;
  File questionBank;

  ArrayList<QuestionAnswerPair> listOfQuestions;

  /**
   * sets up the fields
   */
  @BeforeEach
  void setUp() {
    question1 = new QuestionAnswerPair("Easy[[What is the capital of Canada? "
        + "::: The capital is Ottawa.]]");
    question2 = new QuestionAnswerPair("Hard[[Which country is known as the Land "
        + "of the Rising Sun? ::: Japan.]]");
    question3 = new QuestionAnswerPair("Easy[[What is the largest river in Africa?"
        + " ::: The largest river is the Nile River.]]");
    questionBank = new File("sample/questBank.sr");
    allQuestions = new HandlesAllQuestions(questionBank, 2, new Random(1));
    listOfQuestions = new ArrayList<>();
    listOfQuestions.add(question1);
    assertEquals(1, listOfQuestions.size());
    listOfQuestions.add(question2);
    assertEquals(2, listOfQuestions.size());
    listOfQuestions.add(question3);

  }

  /**
   * tests that the questions are added to the list
   */
  @Test
  void getFullListQuestions() {
    assertEquals(listOfQuestions.get(0).getQuestion(),
        allQuestions.getFullListQuestions().get(0).getQuestion());
  }

  /**
   * tests that the random questions are being added to a list
   */
  @Test
  void generateRandQuestion() {
    allQuestions = new HandlesAllQuestions(questionBank, 3, new Random(1));

    assertEquals(listOfQuestions.get(1).getQuestion(),
        allQuestions.generateRandQuestion().get(0).getQuestion());

  }

  /**
   * tests that the difficulty of the question has been changed
   */
  @Test
  void changeTagToEasy() {
    assertEquals("Hard", question2.getTag());
    allQuestions.changeTagToEasy(question2);

    for (int ind = 0; ind < listOfQuestions.size(); ind++) {
      if (listOfQuestions.get(ind).getQuestion().equals(question2.getQuestion())) {
        listOfQuestions.get(ind).setQuestionEasy();
      }
    }

    assertEquals("Easy", question2.getTag());
  }

  /**
   * tests that the difficulty of the question has been changed
   */
  @Test
  void changeTagToHard() {
    assertEquals("Easy", question1.getTag());
    allQuestions.changeTagToHard(question1);

    for (int ind = 0; ind < listOfQuestions.size(); ind++) {
      if (listOfQuestions.get(ind).getQuestion().equals(question1.getQuestion())) {
        listOfQuestions.get(ind).setQuestionHard();
      }
    }

    assertEquals("Hard", question2.getTag());
  }

  /**
   * represents that the practice questions are equal to the one created
   */
  @Test
  void getPracticeQuestions() {
    assertEquals(listOfQuestions.get(1).getQuestion(),
        allQuestions.getPracticeQuestions().get(0).getQuestion());
  }


}