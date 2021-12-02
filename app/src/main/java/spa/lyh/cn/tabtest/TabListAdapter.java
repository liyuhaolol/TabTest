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

import java.util.Collections;
import java.util.List;

public class TabListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Activity context;
    public boolean isEdit = true;//是否是编辑状态


    public TabListAdapter(Activity context,List<String> list){
        super(R.layout.item_content,list);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.mtv,s);
    }

    /**
     * 对拖拽的元素进行排序
     * @param fromPosition
     * @param toPosition
     */
    public void itemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(getData(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(getData(), i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }
}
