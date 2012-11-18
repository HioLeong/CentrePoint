package jpmorgan.centrepoint;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

public class Review extends Activity {
	/** Called when the activity is first created. */
	private ExpandListAdapter ExpAdapter;
	private ArrayList<ExpandListGroup> ExpListItems;
	private ExpandableListView ExpandList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review);
		ExpandList = (ExpandableListView) findViewById(R.id.list);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandListAdapter(Review.this, ExpListItems);
		ExpandList.setAdapter(ExpAdapter);
		final Button submit = (Button) findViewById(R.id.button);
		submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// /_________\\\
			}
		});

	}

	public ArrayList<ExpandListGroup> SetStandardGroups() {
		ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
		ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru1 = new ExpandListGroup();
		gru1.setName("Overall Experience");
		ExpandListChild ch1 = new ExpandListChild();
		ch1.setName("Title");
		ch1.setTag(null);
		list2.add(ch1);
		gru1.setItems(list2);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru2 = new ExpandListGroup();
		gru2.setName("Housing");
		ExpandListChild ch2 = new ExpandListChild();
		ch2.setName("Title");
		ch2.setTag(null);
		list2.add(ch2);
		gru2.setItems(list2);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru3 = new ExpandListGroup();
		gru3.setName("Learning");
		ExpandListChild ch3 = new ExpandListChild();
		ch3.setName("Title");
		ch3.setTag(null);
		list2.add(ch3);
		gru3.setItems(list2);

		list2 = new ArrayList<ExpandListChild>();

		ExpandListGroup gru4 = new ExpandListGroup();
		gru4.setName("Health");
		ExpandListChild ch4 = new ExpandListChild();
		ch4.setName("Title");
		ch4.setTag(null);
		list2.add(ch4);
		gru4.setItems(list2);

		list.add(gru1);
		list.add(gru2);
		list.add(gru3);
		list.add(gru4);
		return list;
	}
}
