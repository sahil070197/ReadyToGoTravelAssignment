package sahil.readytogotravelassignment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import android.os.Handler;
import android.widget.Toast;


/*
* The screen that opens up after a successful login
* Consists of three tabs, Containing sample data
* and
* A navigation drawer with sample options,
* Image and edit profile option
* A floating action button that leads to certain activity, Displaying most impotant data in Toolbar.
* */
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,TabLayout.OnTabSelectedListener,ViewPager.OnPageChangeListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    int boardingLayouts[];
    String titles[];
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(HomeActivity.this,FinalActivity.class),234);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        boardingLayouts=new int[]{R.layout.on_board_screen_1,R.layout.on_board_screen_b,R.layout.onboard_screen_c};
        titles=new String[]{"Title 1","Title 2", "Title 3"};
        mSectionsPagerAdapter = new SectionsPagerAdapter();
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(this);
    }


    public int getItem() {
        return mViewPager.getCurrentItem();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class SectionsPagerAdapter extends PagerAdapter {

        public SectionsPagerAdapter() {

        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater layoutInflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View v=layoutInflater.inflate(boardingLayouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return boardingLayouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
    boolean doublePressed=false;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if(doublePressed)
        {
            //Exit
            finish();
            System.exit(0);
        }
        Toast.makeText(this,"Press again to exit",Toast.LENGTH_SHORT).show();
        doublePressed=true;
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                doublePressed=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.option1) {
            startActivityForResult(new Intent(HomeActivity.this,FinalActivity.class),234);
        } else if (id == R.id.option2) {
            startActivityForResult(new Intent(HomeActivity.this,FinalActivity.class),234);
        } else if (id == R.id.option3) {
            startActivityForResult(new Intent(HomeActivity.this,FinalActivity.class),234);
        } else if (id == R.id.option4) {
            startActivityForResult(new Intent(HomeActivity.this,FinalActivity.class),234);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void profileEdit(View view)
    {
        startActivityForResult(new Intent(HomeActivity.this,FinalActivity.class),234);
    }
}
