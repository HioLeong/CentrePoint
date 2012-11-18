package jpmorgan.centrepoint.pojo;

import java.util.List;

public class Question {

	private List<Answer> answers;
	private String question;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
