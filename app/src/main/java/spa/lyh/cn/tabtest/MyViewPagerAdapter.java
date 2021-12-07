package spa.lyh.cn.tabtest;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import spa.lyh.cn.tabtest.model.TabModel;

class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<TabModel> list = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentManager fm;

    public MyViewPagerAdapter(FragmentManager fm, List<TabModel> data,List<Fragment> fData) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fm = fm;
        this.list = data;
        this.fragments = fData;
        //initFragments();
//        for (ChannelEntity entity : data){
//            this.fragments.add(new TabFragment());
//        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("qwer","position:"+position);
        return list.get(position).name;

    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


    /**
     * 根据频道信息，添加对应的页面
     */
    public void initFragments(){
        for (TabModel entity : list){
            fragments.add(new PageFragment());
        }
    }

    /**
     *    动态刷新数据后，刷新界面
     **/
    public void RefreshFragments(List<TabModel> datalist){
        //避免重复创建fragment
        if(this.fragments != null){
            FragmentTransaction ft = fm.beginTransaction();
            for(Fragment f:this.fragments){
                ft.remove(f);
            }
            ft.commit();
            ft=null;
            fm.executePendingTransactions();
        }
        this.list = datalist;
        //initFragments();
        //notifyDataSetChanged();
    }

}
