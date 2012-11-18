package jpmorgan.centrepoint;

import android.widget.Button;

public class ExpandListChild {
    private String Name;
    private String Tag;
    private Button submit;
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getTag() {
        return Tag;
    }
    public void setTag(String Tag) {
        this.Tag = Tag;
    }
    public Button getSubmitButton()
    {
    	return submit;
    }
}

