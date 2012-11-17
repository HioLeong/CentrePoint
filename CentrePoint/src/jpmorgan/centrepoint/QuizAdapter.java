package jpmorgan.centrepoint;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class QuizAdapter extends ArrayAdapter<String> {
	
	private List<String> answers;
	
	public QuizAdapter(Context context, int textViewResourceId,
			List<String> answers) {
		super(context, textViewResourceId, answers);
	}
	

}
