package spa.lyh.cn.tabtest;

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

public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout tab;
    private List<String> titles;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.vp);

        titles = new ArrayList<>();

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
                return titles.get(position);
            }
        };

        titles.add("第一行");
        titles.add("第二行");
        titles.add("第三行");
        titles.add("第四行");
        titles.add("第五行");
        titles.add("第六行");
        titles.add("第七行");
        titles.add("第八行");
        titles.add("第九行");
        titles.add("第十行");
        titles.add("第十一行");
        titles.add("第十二行");
        titles.add("第十三行");
        titles.add("第十四行");
        titles.add("第十五行");
        titles.add("第十六行");

        for (int i = 0; i < titles.size(); i++) {
            PageFragment news = new PageFragment();Bundle bundle = new Bundle();

            bundle.putSerializable("channel", titles.get(i));
            news.setArguments(bundle);
            fragments.add(news);
        }
        tab.setOnTabTextViewListener(new OnTabTextViewInitListener() {
            @Override
            public void onTabTextViewInit(int position, TextView tv) {
                /*if (position == 1){
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
                }*/
                if (position == 0){
                    String text = tv.getText().toString();
                    tv.setText(text);
                }
            }

            @Override
            public void onTabTextViewSelect(int position,boolean isSelect, TextView tv) {
                /*if (position == 0){
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
                }*/
                if (position == 0){
                    String text = tv.getText().toString();
                    tv.setText(text);
                }
            }
        });

        viewPager.setAdapter(fragmentPagerAdapter);
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
                startActivity(intent);
            }
        });

    }
}