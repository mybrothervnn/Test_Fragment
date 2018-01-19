package net.simplifiedcoding.androidtablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//Implementing the interface OnTabSelectedListener to our MainActivity
//This interface would help in swiping views
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
//    todo use FragmentStatePagerAdapter 4: Declare TabLayout and ViewPager
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//    todo use FragmentStatePagerAdapter 5:Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//    todo use FragmentStatePagerAdapter 6:Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

//    todo use FragmentStatePagerAdapter 7:Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

//    todo use FragmentStatePagerAdapter 8:Adding adapter to pager
        viewPager.setAdapter(adapter);

//    todo use FragmentStatePagerAdapter 9:Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
//    todo use FragmentStatePagerAdapter 10:Adding addOnPageChangeListener to swipe Tab -> Pager.java
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        test();
    }

    private void test() {
        //xóa hiển thị của 1 tab

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Khởi tạo notification_menu cho menu khi CreateOptionMenu
        getMenuInflater().inflate(R.menu.notification_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.actionbar_item0:
//    todo use FragmentStatePagerAdapter 13_END: test remove tab.
                tabLayout.removeTab(tabLayout.getTabAt(1));
                break;
            case R.id.actionbar_item1:
                tabLayout.addTab(tabLayout.newTab().setText("added tab OK"));
                break;
            case R.id.actionbar_item:
                break;
            case R.id.actionbar_item2:
                break;
            case R.id.actionbar_item3:
                break;
            case R.id.actionbar_item4:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
