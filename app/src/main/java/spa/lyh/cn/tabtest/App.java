package spa.lyh.cn.tabtest;

import android.app.Application;

import java.util.HashMap;
import java.util.List;

public class App extends Application {
    private int fontSize = 20;
    public HashMap<Integer, List<String>> listMap;

    @Override
    public void onCreate() {
        super.onCreate();
        listMap = new HashMap<>();
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
