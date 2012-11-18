package jpmorgan.centrepoint;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class ChatFragment extends Fragment {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_chat, container, false);

		VideoView video = (VideoView) view
				.findViewById(R.id.videoview_chat_video);
		video.setVideoURI(Uri
				.parse("rtsp://v1.cache2.c.youtube.com/CjYLENy73wIaLQmJTUoPKLO2nBMYDSANFEIJbXYtZ29vZ2xlSARSBXdhdGNoYOCTxaDAqoTSUAw=/0/0/0/video.3gp"));
		video.setMediaController(new MediaController(getActivity()));
		video.requestFocus();
		video.start();

		return view;
	}

}
