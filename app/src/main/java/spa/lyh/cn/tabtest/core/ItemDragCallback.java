package spa.lyh.cn.tabtest.core;

import static androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_DRAG;

import android.graphics.Canvas;
import android.util.Log;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import spa.lyh.cn.tabtest.TabListAdapter;


public class ItemDragCallback extends ItemTouchHelper.Callback {
    private TabListAdapter mAdapter;
    private boolean mEdit;

    public ItemDragCallback(TabListAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        TabListAdapter adapter = (TabListAdapter) recyclerView.getAdapter();
        mEdit = adapter.isEdit;
        //是否是编辑状态
        if (!mEdit) {
            return 0;
        }
        int position = viewHolder.getLayoutPosition();
        //第一个item不用交换
        if (position == 0) {
            return 0;
        }
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();   //拖动的position
        int toPosition = target.getAdapterPosition();     //释放的position
        int position = viewHolder.getLayoutPosition();
        //第一个item不用交换
        Log.e("qwer","fromPosition:"+fromPosition);
        Log.e("qwer","toPosition:"+toPosition);
        Log.e("qwer","position:"+position);
        if (position == 0 || toPosition == 0) {

            return false;
        }
        Log.e("qwer","onMove");
        mAdapter.itemMove(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Log.e("qwer","onSwiped");
    }


    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //Log.e("qwer","onChildDrawOver");
        if (dX != 0 && dY != 0 || isCurrentlyActive) {
            TabListAdapter adapter = (TabListAdapter) recyclerView.getAdapter();
            mEdit = adapter.isEdit;
        }
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        //拖拽中
        if (actionState == ACTION_STATE_DRAG) {
            //长按时调用
            /*ChannelAdapter.ChannelHolder holder = (ChannelAdapter.ChannelHolder) viewHolder;
            holder.name.setBackgroundColor(Color.parseColor("#FDFDFE"));
            holder.name.setBackground(ContextCompat.getDrawable(ProjectApp.getApp(), R.drawable.shape_channel_bg));
            holder.delete.setVisibility(View.GONE);*/
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        //松手时调用
        /*ChannelAdapter.ChannelHolder holder = (ChannelAdapter.ChannelHolder) viewHolder;
        holder.name.setBackground(ContextCompat.getDrawable(ProjectApp.getApp(), R.drawable.shape_channel_bg));
        holder.delete.setVisibility(View.VISIBLE);*/
    }
}
