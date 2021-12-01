package spa.lyh.cn.tabtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment implements FontSizeReceiver.Message{
    private RecyclerView recyclerview;
    private List<String> mList;
    private ListAdapter adapter;
    private FontSizeReceiver receiver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        mList = new ArrayList<>();


    }

    @Override
    public void onResume() {
        super.onResume();
        if (mList.size() == 0){
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            mList.add("测试");
            recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new ListAdapter(getActivity(),mList);
            recyclerview.setAdapter(adapter);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        receiver= new FontSizeReceiver(this);
        FontSizeReceiver.register(getActivity(),receiver);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FontSizeReceiver.unregister(getActivity(),receiver);
    }

    @Override
    public void onFontSizeChange() {
        if (adapter != null){
            adapter.notifyDataSetChanged();
        }
    }
}
