package sahil.readytogotravelassignment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    PreferenceHandler handler;
    private int boardingLayouts[];
    ViewPager onBoardPager;
    private TextView dots[];
    private FloatingActionButton sampleButton;
    LinearLayout dotsLayout;
    OnboardPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        handler = new PreferenceHandler(this);
        if (!handler.isFirstLogin())
        {
            startActivity(new Intent(FirstActivity.this,LoginActivity.class));
            finish();
        }
        else
        {
            handler.setFirstLogin();
        }
        boardingLayouts=new int[]{R.layout.on_board_screen_1,R.layout.on_board_screen_b,R.layout.onboard_screen_c};
        onBoardPager=(ViewPager) findViewById(R.id.onBoardPager);
        dotsLayout=(LinearLayout) findViewById(R.id.dots);
        sampleButton=(FloatingActionButton) findViewById(R.id.sampleButton);
        addShiftingDots(0);
        adapter=new OnboardPagerAdapter();
        onBoardPager.setAdapter(adapter);
        onBoardPager.addOnPageChangeListener(adapter);
        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curPage=getCurrentPage();
                if(curPage<=boardingLayouts.length-1)
                {
                    onBoardPager.setCurrentItem(curPage);
                }
                else
                {
                    startActivity(new Intent(FirstActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });
    }

    private void addShiftingDots(int pageNumber) {
        dots=new TextView[boardingLayouts.length];
        int activeColor[]=getResources().getIntArray(R.array.array_dot_active);
        int inactive[]=getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++)
        {

            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            if(i!=pageNumber)
            dots[i].setTextColor(inactive[i]);
            else
            dots[i].setTextColor(activeColor[i]);
            dotsLayout.addView(dots[i]);
        }
    }
    private int getCurrentPage()
    {
        return onBoardPager.getCurrentItem()+1;
    }

    public class OnboardPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
        OnboardPagerAdapter()
        {

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
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addShiftingDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    }

}
