package jpmorgan.centrepoint;

import java.util.List;

import jpmorgan.centrepoint.pojo.Answer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class QuizAdapter extends ArrayAdapter<Answer> {

	private List<Answer> mAnswers;
	private Context mContext;
	private QuizFragment mFragment;

	public QuizAdapter(Context context, List<Answer> answers,
			QuizFragment fragment) {
		super(context, R.layout.quiz_container, answers);
		mFragment = fragment;
		mAnswers = answers;
		mContext = context;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final Answer positionAnswer = mAnswers.get(position);

		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.quiz_container, parent, false);

		TextView answer = (TextView) view.findViewById(R.id.text_quiz_answer);
		answer.setText(positionAnswer.getAnswer());

		view.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				if (positionAnswer.isCorrectAnswer()) {
					mFragment.nextQuestion(true);
				} else {
					mFragment.nextQuestion(false);
				}
			}

		});

		return view;
	}
}
