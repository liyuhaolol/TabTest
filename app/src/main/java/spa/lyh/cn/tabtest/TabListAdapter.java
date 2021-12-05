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
    public boolean isEdit = false;//是否是编辑状态
    public int notChangePosition = 0;//前几个不允许的position


    public TabListAdapter(Activity context,List<String> list){
        super(R.layout.item_content,list);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        TextView mtv = baseViewHolder.getView(R.id.mtv);
        mtv.setText(s);
        if (isEdit){
            mtv.setBackgroundColor(context.getColor(R.color.blue));
        }else {
            mtv.setBackgroundColor(context.getColor(R.color.yellow));
        }
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

    public void setItemChange(BaseViewHolder holder){
        TextView mtv = holder.getView(R.id.mtv);
        mtv.setBackgroundColor(context.getColor(R.color.blue));
    }
}
