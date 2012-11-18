/**
 * Copyright 2012 Facebook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jpmorgan.centrepoint;

import java.util.ArrayList;
import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;

import com.facebook.FacebookActivity;
import com.facebook.GraphObject;
import com.facebook.GraphUser;
import com.facebook.LoginButton;
import com.facebook.ProfilePictureView;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends FacebookActivity {
    @SuppressWarnings("serial")
    private static final List<String> PERMISSIONS = new ArrayList<String>() {{
        add("publish_actions");
        add("email");
    }};

    private final int PICK_FRIENDS_ACTIVITY = 1;
    private final int PICK_PLACE_ACTIVITY = 2;
    private final int REAUTHORIZE_ACTIVITY = 3;
    private final String APP_ID = "285201308268056";
    private final String PENDING_ACTION_BUNDLE_KEY = "com.facebook.samples.hellofacebook:PendingAction";

    private LoginButton loginButton;
    private ProfilePictureView profilePictureView;
    private TextView greeting;
    private PendingAction pendingAction = PendingAction.NONE;
    private final Location SEATTLE_LOCATION = new Location("") {
        {
            setLatitude(47.6097);
            setLongitude(-122.3331);
        }
    };
    private GraphUser user;

    private enum PendingAction {
        NONE,
        POST_PHOTO,
        POST_STATUS_UPDATE
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "3a0AWRjtB6xTFeZZE4t2HP0sxDrH8dIwOUBGtcik", "cee175bPTp4AY92M3k53FH4U1zXjjI7iyy88ZMmv"); 
        
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setApplicationId(APP_ID);
        loginButton.setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {
            public void onUserInfoFetched(GraphUser user) {
                MainActivity.this.user = user;
                updateUI();
            }
        });

        profilePictureView = (ProfilePictureView) findViewById(R.id.profilePicture);
        greeting = (TextView) findViewById(R.id.greeting);

    }

    @Override
    protected void onStart() {
        super.onStart();

        updateUI();

        IntentFilter filter = new IntentFilter();
        filter.addAction(com.facebook.Session.ACTION_ACTIVE_SESSION_OPENED);
        filter.addAction(com.facebook.Session.ACTION_ACTIVE_SESSION_CLOSED);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(PENDING_ACTION_BUNDLE_KEY, pendingAction.ordinal());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int ordinal = savedInstanceState.getInt(PENDING_ACTION_BUNDLE_KEY, 0);
        pendingAction = PendingAction.values()[ordinal];
    }

    private void updateUI() {
        boolean enableButtons = com.facebook.Session.getActiveSession() != null &&
                com.facebook.Session.getActiveSession().getState().isOpened();

        if (enableButtons && user != null) {
            profilePictureView.setUserId(user.getId());
            greeting.setText(String.format("Hello %s!", user.getFirstName()));
            
            ParseQuery query = new ParseQuery("Users");
            query.whereEqualTo("FacebookID", user.getId());
            query.getFirstInBackground(new GetCallback() {
			@Override
			public void done(ParseObject arg0, com.parse.ParseException arg1) 
			{
				if(arg0==null)
				{
					ParseObject testObject = new ParseObject("Users");
		            testObject.put("FacebookID", user.getId());
		            testObject.put("Name", user.getFirstName());
		            testObject.put("email", (String)user.getProperty("email"));
		            testObject.put("CentrePoints", 50);
		            testObject.put("mostRecent", "");
		            testObject.saveInBackground();
				}
				else
				{
					Log.d("1","Next");
				}
				
			}
            });
            
        } else {
            profilePictureView.setUserId(null);
            greeting.setText(null);
        }
    }

    private interface GraphObjectWithId extends GraphObject {
        String getId();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI();
        }
    };


}
