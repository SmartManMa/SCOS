package es.sources.code.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import code.source.es.sosc.R;
import es.sources.code.fragments.LoginOrRegisterFragment;
import es.sources.code.fragments.OrderFoodFragment;
import es.sources.code.fragments.OrderListFragment;
import es.sources.code.fragments.SystemHelpFragment;

/**
 * @author ：zhiman on 2017/10/2 9:50.
 */

public class MainScreen extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private View mView;
    private Bundle mBundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        //数据传递：SCOSEntry--MainScreen--OrderFoodFragment
        Intent intent = getIntent();
        String mess = intent.getStringExtra("test");
        mBundle = new Bundle();
        mBundle.putString("main",mess);



/*        //1.初始化TabHost
        mTabHost = (FragmentTabHost)this.findViewById(android.R.id.tabhost);
        //用realtabcontent代替tabcontent
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        //2.在mTabHost创建一个空间单元
        TabHost.TabSpec  tabSpec = mTabHost.newTabSpec("OrderFood");
        //3.加载tabhost_items布局
        mInflater = LayoutInflater.from(this);
        //在tabHost上加载布局，上面图片下面文件
        View view = mInflater.inflate(R.layout.tabhost_items,null);
        ImageView tabIcon = (ImageView)view.findViewById(R.id.icon_tab);
        TextView tabText = (TextView) view.findViewById(R.id.txt_indicator);
        tabIcon.setImageResource(R.drawable.icon_home);
        tabText.setText("点餐");
        //4.为tabSpec设置布局
        tabSpec.setIndicator(view);
        //5.将tabSpec添加到TabHost中
        mTabHost.addTab(tabSpec, OrderFoodFragment.class,null);
*/
        //1.初始化TabHost
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        //用realtabcontent代替tabcontent
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //3.加载tabhost_items布局
        mInflater = LayoutInflater.from(this);
        //mView = mInflater.inflate(R.layout.tabhost_items, null);
        initTabHost();

    }

    private void initTabHost() {
        //图片资源数组
        int[] iconResArr = new int[]{
                R.drawable.selector_icon_home,
                R.drawable.selector_icon_order,
                R.drawable.selector_icon_user,
                R.drawable.selector_icon_help
        };
        //Fragment数组
        Class[] fragmentArr = {
                OrderFoodFragment.class,
                OrderListFragment.class,
                LoginOrRegisterFragment.class,
                SystemHelpFragment.class
        };
        //spc
        String[] spcNameArr = {
                "点餐",
                "订单",
                "登录",
                "帮助"
        };
        for (int i = 0; i < iconResArr.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(spcNameArr[i]);
            View view = mInflater.inflate(R.layout.tabhost_items,null);
            ImageView icon = (ImageView) view.findViewById(R.id.icon_tab);
            TextView textIndicator = (TextView) view.findViewById(R.id.txt_indicator);

            icon.setBackgroundResource(iconResArr[i]);
            textIndicator.setText(spcNameArr[i]);

            tabSpec.setIndicator(view);
            if(i == 0) {
                mTabHost.addTab(tabSpec, fragmentArr[i],mBundle);
            } else {
                mTabHost.addTab(tabSpec, fragmentArr[i],null);
            }

        }

    }
}
