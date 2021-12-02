package spa.lyh.cn.tabtest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

class TabListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Activity context;

    public TabListAdapter(Activity context,List<String> list){
        super(R.layout.item_content,list);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.mtv,s);
    }
}
