package spa.lyh.cn.tabtest;

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

import spa.lyh.cn.tabtest.core.ItemDragCallback;

public class TabListActivity extends AppCompatActivity {
    List<String> mList;
    RecyclerView head;
    TabListAdapter adapter;
    Button sort;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mList = new ArrayList<>();
        mList.add("荐读");
        mList.add("第一行");
        mList.add("第二行");
        mList.add("第三行");
        mList.add("第四行");
        mList.add("第五行");
        mList.add("第六行");
        mList.add("第七行");
        mList.add("第八行");
        mList.add("第九行");
        mList.add("第十行");
        mList.add("第十一行");
        mList.add("第十二行");
        mList.add("第十三行");
        mList.add("第十四行");
        mList.add("第十五行");
        mList.add("第十六行");
        head = findViewById(R.id.head);
        head.setLayoutManager(new GridLayoutManager(this,4));

        adapter = new TabListAdapter(this,mList);

        head.setAdapter(adapter);


        sort = findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String content: mList){
                    Log.e("qwer",content);
                }
            }
        });

        ItemDragCallback callback = new ItemDragCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(head);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Toast.makeText(TabListActivity.this,mList.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                Toast.makeText(TabListActivity.this,"长按",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
