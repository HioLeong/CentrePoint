package jpmorgan.centrepoint;

import java.util.List;

import jpmorgan.centrepoint.mock.MockQuestions;
import jpmorgan.centrepoint.pojo.Answer;
import jpmorgan.centrepoint.pojo.Question;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizFragment extends Fragment {

	private int currentQuestion = 0;
	private int currentPoints = 0;
	private List<Question> questions = MockQuestions.getInstance()
			.getQuestions();
	private List<Answer> answers = questions.get(currentPoints).getAnswers();
	private QuizAdapter adapter;
	private TextView question;
	private TextView points;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_game, container, false);

		question = (TextView) view.findViewById(R.id.text_quiz_question);
		setQuestionLabel(questions.get(currentQuestion).getQuestion());

		points = (TextView) view.findViewById(R.id.text_quiz_score);
		setPointsLabel(currentPoints);

		ListView answerList = (ListView) view
				.findViewById(R.id.listview_quiz_answers);
		adapter = new QuizAdapter(getActivity(), answers, this);
		answerList.setAdapter(adapter);

		return view;
	}

	public void nextQuestion(boolean correctAnswer) {
		if (correctAnswer) {
			currentPoints++;
			setPointsLabel(currentPoints);
		}
		try {

			answers.clear();
			answers.addAll(questions.get(++currentQuestion).getAnswers());
			setQuestionLabel(questions.get(currentQuestion).getQuestion());

			adapter.notifyDataSetChanged();
		} catch (IndexOutOfBoundsException e) {
			answers.clear();
			adapter.notifyDataSetChanged();
			setQuestionLabel("Final CentrePoints: " + Integer.toString(currentPoints));
		}
	}

	private void setQuestionLabel(String args) {
		question.setText(args);
	}

	private void setPointsLabel(int args) {
		points.setText(String.format(getResources().getString(R.string.score),
				args));
	}

}
