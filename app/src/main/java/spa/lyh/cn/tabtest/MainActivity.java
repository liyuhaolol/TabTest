package spa.lyh.cn.tabtest;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.listener.OnTabTextViewInitListener;

import java.util.ArrayList;
import java.util.List;

import spa.lyh.cn.lib_utils.PixelUtils;
import spa.lyh.cn.tabtest.model.TabModel;

public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout tab;
    public ArrayList<TabModel> titles,subTiles;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private Button button,button2,button3;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.vp);

        titles = new ArrayList<>();
        subTiles = new ArrayList<>();

        fragments = new ArrayList<>();

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position).name;
            }
        };
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 1){
                            //Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_SHORT).show();
                            subTiles.clear();
                            subTiles.addAll(result.getData().getParcelableArrayListExtra("subListData"));
                            //初始化数据
                            int oldPosition = tab.getCurrentTab();
                            titles.clear();
                            titles.addAll(result.getData().getParcelableArrayListExtra("listData"));
                            fragments.clear();
                            for (int i = 0; i < titles.size(); i++) {
                                PageFragment news = new PageFragment();
                                Bundle bundle = new Bundle();

                                bundle.putSerializable("index", i);
                                news.setArguments(bundle);
                                fragments.add(news);
                            }
                            int currentPosition = Math.min(oldPosition,(titles.size() - 1));
                            viewPager.setAdapter(fragmentPagerAdapter);
                            viewPager.setOffscreenPageLimit(titles.size());

                            tab.setCurrentTab(currentPosition);
                            tab.notifyDataSetChanged();

                        }
                    }
                }
        );

        TabModel model0 = new TabModel();
        model0.tabId = 0;
        model0.name = "荐读";
        TabModel model1 = new TabModel();
        model1.tabId = 1;
        model1.name = "第1行";
        TabModel model2 = new TabModel();
        model2.tabId = 2;
        model2.name = "第2行";
        TabModel model3 = new TabModel();
        model3.tabId = 3;
        model3.name = "第3行";
        TabModel model4 = new TabModel();
        model4.tabId = 4;
        model4.name = "第4行";
        TabModel model5 = new TabModel();
        model5.tabId = 5;
        model5.name = "第5行";
        TabModel model6 = new TabModel();
        model6.tabId = 6;
        model6.name = "第6行";
        TabModel model7 = new TabModel();
        model7.tabId = 7;
        model7.name = "第7行";
        TabModel model8 = new TabModel();
        model8.tabId = 8;
        model8.name = "第8行";
        TabModel model9 = new TabModel();
        model9.tabId = 9;
        model9.name = "第9行";
        TabModel model10 = new TabModel();
        model10.tabId = 10;
        model10.name = "第10行";
        TabModel model11 = new TabModel();
        model11.tabId = 11;
        model11.name = "第11行";
        TabModel model12 = new TabModel();
        model12.tabId = 12;
        model12.name = "第12行";
        TabModel model13 = new TabModel();
        model13.tabId = 13;
        model13.name = "第13行";
        TabModel model14 = new TabModel();
        model14.tabId = 14;
        model14.name = "第14行";
        TabModel model15 = new TabModel();
        model15.tabId = 15;
        model15.name = "第15行";
        TabModel model16 = new TabModel();
        model16.tabId = 16;
        model16.name = "第16行";
        titles.add(model0);
        titles.add(model1);
        titles.add(model2);
        titles.add(model3);
        titles.add(model4);
        titles.add(model5);
        titles.add(model6);
        titles.add(model7);
        titles.add(model8);
        titles.add(model9);
        titles.add(model10);
        titles.add(model11);
        titles.add(model12);
        titles.add(model13);
        titles.add(model14);
        titles.add(model15);
        titles.add(model16);
        ///////////////////////////////
        TabModel model17 = new TabModel();
        model17.tabId = 17;
        model17.name = "第17行";
        TabModel model18 = new TabModel();
        model18.tabId = 18;
        model18.name = "第18行";
        TabModel model19 = new TabModel();
        model19.tabId = 19;
        model19.name = "第19行";
        TabModel model20 = new TabModel();
        model20.tabId = 20;
        model20.name = "第20行";
        TabModel model21 = new TabModel();
        model21.tabId = 21;
        model21.name = "第21行";
        TabModel model22 = new TabModel();
        model22.tabId = 22;
        model22.name = "第22行";
        TabModel model23 = new TabModel();
        model23.tabId = 23;
        model23.name = "第23行";
        TabModel model24 = new TabModel();
        model24.tabId = 24;
        model24.name = "第24行";
        TabModel model25 = new TabModel();
        model25.tabId = 25;
        model25.name = "第25行";
        TabModel model26 = new TabModel();
        model26.tabId = 26;
        model26.name = "第26行";
        TabModel model27 = new TabModel();
        model27.tabId = 27;
        model27.name = "第27行";
        TabModel model28 = new TabModel();
        model28.tabId = 28;
        model28.name = "第28行";
        TabModel model29 = new TabModel();
        model29.tabId = 29;
        model29.name = "第29行";
        TabModel model30 = new TabModel();
        model30.tabId = 30;
        model30.name = "第30行";
        TabModel model31 = new TabModel();
        model31.tabId = 31;
        model31.name = "第31行";
        TabModel model32 = new TabModel();
        model32.tabId = 32;
        model32.name = "第32行";
        subTiles.add(model17);
        subTiles.add(model18);
        subTiles.add(model19);
        subTiles.add(model20);
        subTiles.add(model21);
        subTiles.add(model22);
        subTiles.add(model23);
        subTiles.add(model24);
        subTiles.add(model25);
        subTiles.add(model26);
        subTiles.add(model27);
        subTiles.add(model28);
        subTiles.add(model29);
        subTiles.add(model30);
        subTiles.add(model31);
        subTiles.add(model32);
        ///////////////////////////////

        for (int i = 0; i < titles.size(); i++) {
            PageFragment news = new PageFragment();
            Bundle bundle = new Bundle();

            bundle.putSerializable("index", i);
            news.setArguments(bundle);
            fragments.add(news);
        }
/*        tab.setOnTabTextViewListener(new OnTabTextViewInitListener() {
            @Override
            public void onTabTextViewInit(int position, TextView tv) {
                *//*if (position == 1){
                    SpannableString spanString = new SpannableString(" ");
                    Drawable drawable = getDrawable(R.drawable.icon_main_logo);
                    drawable.setBounds(0,0,PixelUtils.dip2px(MainActivity.this,101),PixelUtils.dip2px(MainActivity.this,26));
                    ImageSpan imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_CENTER);
                    spanString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    tv.setText(spanString);
                }else if (position == 0){
                    SpannableString spanString = new SpannableString(" ");
                    Drawable drawable = getDrawable(R.drawable.train_yes);
                    drawable.setBounds(0,0,PixelUtils.dip2px(MainActivity.this,25),PixelUtils.dip2px(MainActivity.this,25));
                    ImageSpan imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_CENTER);
                    spanString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    tv.setText(spanString);
                }*//*
                if (position == 0){
                    String text = tv.getText().toString();
                    tv.setText(text);
                }
            }

            @Override
            public void onTabTextViewSelect(int position,boolean isSelect, TextView tv) {
                *//*if (position == 0){
                    if (isSelect){
                        SpannableString spanString = new SpannableString(" ");
                        Drawable drawable = getDrawable(R.drawable.train_yes);
                        drawable.setBounds(0,0,PixelUtils.dip2px(MainActivity.this,25),PixelUtils.dip2px(MainActivity.this,25));
                        ImageSpan imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_CENTER);
                        spanString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tv.setText(spanString);
                    }else {
                        SpannableString spanString = new SpannableString(" ");
                        Drawable drawable = getDrawable(R.drawable.train_no);
                        drawable.setBounds(0,0,PixelUtils.dip2px(MainActivity.this,25),PixelUtils.dip2px(MainActivity.this,25));
                        ImageSpan imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_CENTER);
                        spanString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tv.setText(spanString);
                    }
                }*//*
                if (position == 0){
                    String text = tv.getText().toString();
                    tv.setText(text);
                }
            }
        });*/

        viewPager.setAdapter(fragmentPagerAdapter);
        //viewPager.setAdapter(myViewPagerAdapter);
        tab.setViewPager(viewPager);
        viewPager.setOffscreenPageLimit(titles.size());
        viewPager.setCurrentItem(0);


/*        TextView a = tab.getTitleView(0);
        SpannableStringBuilder builder = new SpannableStringBuilder("第一行");
        builder.setSpan(new ForegroundColorSpan(getColor(R.color.teal_200)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new AbsoluteSizeSpan(PixelUtils.dip2px(this,25)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"lishu.ttf");
        builder.setSpan(new TypefaceSpan(typeface), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        a.setText(builder);*/

/*        TextView ab = findViewById(R.id.ab);
        SpannableString spanString = new SpannableString("你好");
        *//*Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);*//*
        ImageSpan imageSpan = new ImageSpan(this,R.mipmap.ic_launcher);
        spanString.setSpan(imageSpan, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        ab.setText(spanString);*/

        button = findViewById(R.id.setting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.tab_list);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabListActivity.class);
                intent.putParcelableArrayListExtra("listData",titles);
                intent.putParcelableArrayListExtra("subListData",subTiles);
                launcher.launch(intent);
            }
        });

        button3 = findViewById(R.id.change_sort);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab.setCurrentTab(1);
            }
        });

    }
}