package cs3500.pa01;

/**
 * represents a singular question and answer with its difficulty tag
 */
public class QuestionAnswerPair {
  private final String bothQuestAndAnsw;
  private String question;
  private String answer;
  private String tag;

  /**
   * represents the constructor
   */
  public QuestionAnswerPair(String bothQuestAndAnsw) {
    this.bothQuestAndAnsw = bothQuestAndAnsw;
    this.tag = bothQuestAndAnsw.substring(0, 4);
    this.question = getQuestion();
    this.answer = getAnswer();
  }

  /**
   * returns both the question and answer without the tag
   */
  public String getBothQuestAndAnsw() {

    return bothQuestAndAnsw.substring(bothQuestAndAnsw.indexOf("[["));
  }

  /**
   * returns just the question
   */
  public String getQuestion() {
    question = bothQuestAndAnsw.substring(bothQuestAndAnsw.indexOf("[[") + 2,
        bothQuestAndAnsw.indexOf(":::"));
    return question;
  }

  /**
   * returns just the answer of the question
   */
  public String getAnswer() {
    answer = bothQuestAndAnsw.substring(bothQuestAndAnsw.indexOf(":::") + 3,
        bothQuestAndAnsw.length() - 2);
    return answer;
  }

  /**
   * returns just the tag
   */
  public String getTag() {
    return tag;
  }

  /**
   * sets the question difficulty tag to easy
   */
  public void setQuestionEasy() {
    this.tag = UserInput.EASY.getTagName();
  }

  /**
   * sets the question difficulty tag to hard
   */
  public void setQuestionHard() {
    this.tag = UserInput.HARD.getTagName();
  }

}
