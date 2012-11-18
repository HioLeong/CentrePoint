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
				getAnswer("80,000 - 82,000", false),
				getAnswer("82,000 - 84,000", false),
				getAnswer("84,000 - 86,000", false)));
		questions.add(q1);

		Question q2 = new Question();
		q2.setQuestion("When was Centre Point founded?");
		q2.setAnswers(getAnswers(getAnswer("1952", false),
				getAnswer("1969", true), getAnswer("1974", false),
				getAnswer("1980", false)));
		questions.add(q2);

		Question q3 = new Question();
		q3.setQuestion("Who is the Patron of Centre Point?");
		q3.setAnswers(getAnswers(getAnswer("Prince Harry", false),
				getAnswer("Prince Boateng", false),
				getAnswer("Prince William", true),
				getAnswer("Princess Anne", false)));
		questions.add(q3);

		Question q4 = new Question();
		q4.setQuestion("Which of these housing services do we NOT offer?");
		q4.setAnswers(getAnswers(getAnswer("Night Shelters", false),
				getAnswer("Britannia Hotels", true),
				getAnswer("Supported Flats", false), getAnswer("Foyers", false)));
		questions.add(q4);
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
