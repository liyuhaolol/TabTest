package spa.lyh.cn.tabtest;

import android.app.Application;

public class App extends Application {
    private int fontSize = 20;


    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
