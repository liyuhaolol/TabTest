package spa.lyh.cn.tabtest;

import android.os.Bundle;
import android.util.Log;
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

import spa.lyh.cn.tabtest.model.TabModel;

public class PageFragment extends Fragment implements FontSizeReceiver.Message{
    private RecyclerView recyclerview;
    private List<String> mList;
    private ListAdapter adapter;
    private FontSizeReceiver receiver;
    private int index;
    private App app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        app = (App) getActivity().getApplication();
        recyclerview = view.findViewById(R.id.recyclerview);
        index = (int) getArguments().get("index");
        mList = new ArrayList<>();


    }

    @Override
    public void onResume() {
        super.onResume();
        if (mList.size() == 0){
            MainActivity activity = (MainActivity) getActivity();
            TabModel tabModel = activity.titles.get(index);
            if (app.listMap.get(tabModel.tabId) != null){
                //存在缓存数据
                mList.addAll(app.listMap.get(tabModel.tabId));
            }else {
                //没有缓存数据
                mList.add(tabModel.name);
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                mList.add(index+"");
                app.listMap.put(tabModel.tabId,mList);
            }

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
