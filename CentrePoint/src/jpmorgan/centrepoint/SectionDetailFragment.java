package jpmorgan.centrepoint;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SectionDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    MenuContent.MenuItem mItem;

    public SectionDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_detail, container, false);
//        if (mItem != null) {
//            ((TextView) rootView.findViewById(R.id.section_detail)).setText(mItem.content);
//        }
        return rootView;
    }
}
