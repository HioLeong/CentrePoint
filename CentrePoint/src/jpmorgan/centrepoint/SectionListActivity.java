package jpmorgan.centrepoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class SectionListActivity extends FragmentActivity implements
		SectionListFragment.Callbacks {

	private boolean mTwoPane;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_section_twopane);

		if (findViewById(R.id.section_detail_container) != null) {
			mTwoPane = true;
			((SectionListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.section_list))
					.setActivateOnItemClick(true);

		}
	}

	public void onItemSelected(String id) {

		Fragment f = new QuizFragment();
		if (id.equals("4")) {
			f = new QuizFragment();
		} else if (id.equals("7")) {
			f = new ChatFragment();
		} else if (id.equals("6")) {
			f = new ReviewFragment();
		} else {
			f = new SectionDetailFragment();
		}
		if (mTwoPane) {

			getSupportFragmentManager().beginTransaction()
					.replace(R.id.section_detail_container, f).commit();

		} else {
			Intent detailIntent = new Intent(this, SectionDetailActivity.class);
			detailIntent.putExtra(SectionDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
