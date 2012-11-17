package jpmorgan.centrepoint;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class QuizActivity extends FragmentActivity {

	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_game);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
	}
 	
}
