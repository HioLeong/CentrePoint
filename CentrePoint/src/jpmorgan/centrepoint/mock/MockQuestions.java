package jpmorgan.centrepoint.mock;

import java.util.ArrayList;
import java.util.List;

import jpmorgan.centrepoint.pojo.Answer;
import jpmorgan.centrepoint.pojo.Question;

public class MockQuestions {

	private List<Question> questions = new ArrayList<Question>();

	public static MockQuestions getInstance() {
		return new MockQuestions();
	}
	
	public MockQuestions() {

		Question q1 = new Question();
		q1.setQuestion("How many young people experience homelessness in a year in the UK?");
		q1.setAnswers(getAnswers(getAnswer("78,000 - 80,000", true),
				getAnswer("80,000 - 82,000", false)));
		questions.add(q1);

		Question q2 = new Question();
		q2.setQuestion("Question");
		q2.setAnswers(getAnswers(getAnswer("a", true), getAnswer("b", false)));
		questions.add(q2);

	}

	private Answer getAnswer(String answerString, boolean correctAnswer) {
		Answer answer = new Answer();
		answer.setAnswer(answerString);
		answer.setCorrectAnswer(correctAnswer);
		return answer;
	}

	private List<Answer> getAnswers(Answer... a) {
		List<Answer> answers = new ArrayList<Answer>();
		for (Answer answer : a) {
			answers.add(answer);
		}
		return answers;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

}
