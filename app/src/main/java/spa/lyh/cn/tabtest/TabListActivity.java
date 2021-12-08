package spa.lyh.cn.tabtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

import spa.lyh.cn.lib_utils.view.EmptyItemAnimator;
import spa.lyh.cn.tabtest.core.ItemDragCallback;
import spa.lyh.cn.tabtest.model.TabModel;

public class TabListActivity extends AppCompatActivity {
    ArrayList<TabModel> mList,mList2;
    RecyclerView head,bottom;
    TabListAdapter adapter,adapter2;
    Button sort,ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mList = new ArrayList<>();
        mList.addAll(getIntent().getParcelableArrayListExtra("listData"));
        mList2 = new ArrayList<>();
        mList2.addAll(getIntent().getParcelableArrayListExtra("subListData"));
        head = findViewById(R.id.head);
        head.setLayoutManager(new GridLayoutManager(this,4));
        head.setItemAnimator(new EmptyItemAnimator());

        adapter = new TabListAdapter(this,mList);

        head.setAdapter(adapter);

        bottom = findViewById(R.id.bottom);
        bottom.setLayoutManager(new GridLayoutManager(this,4));
        adapter2 = new TabListAdapter(this,mList2);

        bottom.setAdapter(adapter2);


        sort = findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (TabModel content: mList){
                    Log.e("qwer",content.name);
                }
            }
        });
        ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.isEdit = false;
                adapter.notifyDataSetChanged();
            }
        });

        ItemDragCallback callback = new ItemDragCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(head);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> a, @NonNull View view, int position) {
                if (!adapter.isEdit){
                    Toast.makeText(TabListActivity.this,mList.get(position).name,Toast.LENGTH_SHORT).show();
                }else {
                    mList2.add(0,mList.get(position));
                    mList.remove(position);
                    adapter.notifyDataSetChanged();
                    adapter2.notifyDataSetChanged();
                }
            }
        });

        /*adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter a, @NonNull View view, int position) {
                if (!adapter.isEdit){
                    adapter.isEdit = true;
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });*/
        adapter2.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> a, @NonNull View view, int position) {
                mList.add(mList2.get(position));
                mList2.remove(position);
                adapter.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("listData",mList);
        intent.putParcelableArrayListExtra("subListData",mList2);
        setResult(1,intent);

        super.onBackPressed();
    }
}
