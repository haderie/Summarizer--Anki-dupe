package cs3500.pa01;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import readers.ReadQuestion;

/**
 * Handles allQuestions the questions from the question bank
 * including the practice questions
 */
public class HandlesAllQuestions {
  private ArrayList<QuestionAnswerPair> allQuestions;

  private final ArrayList<QuestionAnswerPair> practice = new ArrayList<>();

  private final ArrayList<QuestionAnswerPair> listHardQuestions;

  private final ArrayList<QuestionAnswerPair> listEasyQuestions;

  private final ArrayList<Integer> listOfEasyIndex;

  private final ArrayList<Integer> listOfHardIndex;


  private final File file;

  private int numOfQuestions;

  private final Random rand;


  /**
   * represents the constructor
   */
  public HandlesAllQuestions(File file, int numOfQuestions, Random rand) {
    this.file = file;
    this.allQuestions = createQuestionList();
    this.numOfQuestions = numOfQuestions;
    this.listHardQuestions = new ArrayList<>();
    this.listEasyQuestions = new ArrayList<>();
    this.listOfEasyIndex = new ArrayList<>();
    this.listOfHardIndex = new ArrayList<>();
    listHardQuestions();
    listEasyQuestions();
    this.rand = rand;
    listOfIndex();
    generateRandQuestion();
  }

  /**
   * creates gets the list of questions from the question bank
   *
   * @return the full arrayList
   */
  public ArrayList<QuestionAnswerPair> createQuestionList() {
    ReadQuestion read = new ReadQuestion();
    read.readQuestion(file);
    allQuestions = read.getAllQs();
    return allQuestions;
  }

  /**
   * returns the full list of questions
   *
   * @return the full list of questions
   */
  public ArrayList<QuestionAnswerPair> getFullListQuestions() {
    return allQuestions;
  }

  /**
   * finds the hard questions in the question bank and adds them to one list
   */
  public void listHardQuestions() {
    for (QuestionAnswerPair question : this.allQuestions) {
      if (question.getTag().equals("Hard")) {
        listHardQuestions.add(question);
      }
    }
  }

  /**
   * finds the easy questions in the question bank and adds them to one list
   */
  public void listEasyQuestions() {
    for (QuestionAnswerPair question : this.allQuestions) {
      if (question.getTag().equals("Easy")) {
        listEasyQuestions.add(question);
      }
    }
  }

  /**
   * counts the number of hard questions in the question bank
   *
   * @return the total count of hard questions
   */
  public int hardCount() {
    int count = 0;
    for (QuestionAnswerPair question : this.allQuestions) {
      if (question.getTag().equals("Hard")) {
        count += 1;
      }
    }
    return count;
  }

  /**
   * counts the number of easy questions in the question bank
   *
   * @return the total count of easy questions
   */
  public int easyCount() {
    int count = 0;
    for (QuestionAnswerPair question : this.allQuestions) {
      if (question.getTag().equals("Easy")) {
        count += 1;
      }
    }
    return count;
  }

  /**
   * generates a random list of practice questions
   *
   * @return the list of random practice questions
   */
  public ArrayList<QuestionAnswerPair> generateRandQuestion() {

    for (int i : listOfHardIndex) {
      Collections.shuffle(listHardQuestions);
      practice.add(listHardQuestions.get(i));

    }
    for (int i : listOfEasyIndex) {
      Collections.shuffle(listEasyQuestions);
      practice.add(listEasyQuestions.get(i));
    }
    return practice;
  }


  /**
   * makes a list of the index for the both current hard and easy questions
   */
  public void listOfIndex() {
    if (numOfQuestions > easyCount() + hardCount()) {
      numOfQuestions = easyCount() + hardCount();
    }
    int easy = 0;
    for (int i = 0; i < numOfQuestions; i++) {
      if (i < hardCount()) {
        listOfHardIndex.add(i);
        Collections.shuffle(listOfHardIndex);
      } else {
        listOfEasyIndex.add(easy);
        Collections.shuffle(listOfEasyIndex);
        easy++;
      }

    }
  }


  /**
   * returns the list of practice questions
   *
   * @return gets the list of practice questions
   */
  public ArrayList<QuestionAnswerPair> getPracticeQuestions() {
    return practice;
  }

  /**
   * finds the given question from the question list and changes its tag to easy
   *
   * @param practice represents a question from the list of practice question
   */
  public void changeTagToEasy(QuestionAnswerPair practice) {
    for (QuestionAnswerPair question : allQuestions) {
      if (question.getQuestion().equals(practice.getQuestion())) {
        question.setQuestionEasy();
      }
    }
  }

  /**
   * finds the given question from the question list and changes its tag to hard
   *
   * @param practice represents a question from the list of practice question
   */
  public void changeTagToHard(QuestionAnswerPair practice) {
    for (QuestionAnswerPair question : allQuestions) {
      if (question.getQuestion().equals(practice.getQuestion())) {
        question.setQuestionHard();
      }
    }
  }
}
