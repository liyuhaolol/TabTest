package spa.lyh.cn.tabtest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TabModel implements Parcelable {
    public int tabId;
    public String name;

    public TabModel(){}

    protected TabModel(Parcel in) {
        tabId = in.readInt();
        name = in.readString();
    }

    public static final Creator<TabModel> CREATOR = new Creator<TabModel>() {
        @Override
        public TabModel createFromParcel(Parcel in) {
            return new TabModel(in);
        }

        @Override
        public TabModel[] newArray(int size) {
            return new TabModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tabId);
        dest.writeString(name);
    }
}
