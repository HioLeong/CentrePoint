package jpmorgan.centrepoint.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuContent {

	public static class MenuItem {

		public String id;
		public String content;

		public MenuItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}

	public static List<MenuItem> ITEMS = new ArrayList<MenuItem>();
	public static Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

	static {
		addItem(new MenuItem("1", "Profile"));
		addItem(new MenuItem("2", "Events"));
		addItem(new MenuItem("3", "Share"));
		addItem(new MenuItem("4", "Quiz"));
		addItem(new MenuItem("5", "Request"));
		addItem(new MenuItem("6", "Share a Story"));
		addItem(new MenuItem("7", "Chat"));

	}

	private static void addItem(MenuItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}
}
