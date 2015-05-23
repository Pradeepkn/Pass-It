package com.passit.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.passit.R;
import com.passit.model.Questions;
import com.passit.ui.fragment.TestScreenFragment;
import com.passit.ui.widget.ZaarkViewPager;
import com.passit.util.TempQuestionUtil;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestScreenActivty extends BaseActivity implements TestScreenFragment.OnActionListener, View.OnClickListener {

    private static final String BUNDLE_KEY_SCREEN = "screen";
    private static final String BUNDLE_KEY_QUESTIONS = "questions";

    private ZaarkViewPager mViewPager;

    private ArrayList<Fragment> mScreens = new ArrayList<Fragment>();

    private ArrayList<Questions> mQuestions = new ArrayList<Questions>();

    private int mCurrentScreen = 0;

    private Button mPrevBtn;

    private Button mNextBtn;

    private Handler mHandler;

    private TextView mTimeText;

    private int mSeconds;

    public static Intent getTestScreen(Context context, int screen, ArrayList<Questions> questions) {
        Intent intent = new Intent(context, TestScreenActivty.class);

        intent.putExtra(BUNDLE_KEY_SCREEN, screen);

        intent.putExtra(BUNDLE_KEY_QUESTIONS, questions);

        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new Handler();

        mViewPager = (ZaarkViewPager) findViewById(R.id.pager);

        mTimeText = (TextView) findViewById(R.id.timer);

        mPrevBtn = (Button) findViewById(R.id.prev_btn);
        mPrevBtn.setOnClickListener(this);

        mNextBtn = (Button) findViewById(R.id.next_btn);
        mNextBtn.setOnClickListener(this);

        Intent intent = getIntent();

        if(intent != null) {
            mCurrentScreen = intent.getIntExtra(BUNDLE_KEY_SCREEN, 0);
        }

        mQuestions = TempQuestionUtil.getQuestions();

        for (int i = 0; i < mQuestions.size(); i++) {
            TestScreenFragment testScreenFragment = new TestScreenFragment();

            testScreenFragment.setArguments(TestScreenFragment.getBundle(i, mQuestions.get(i)));

            mScreens.add(testScreenFragment);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentAdapter adapter = new FragmentAdapter(fragmentManager);
        mViewPager.setPagingEnabled(false);
        mViewPager.setAdapter(adapter);

        showScreen(mCurrentScreen);

        updateTimer();
    }

    Runnable TimerRunnabel = new Runnable() {
        @Override
        public void run() {
            updateTimer();
        }
    };

    private void updateTimer() {
        mSeconds++;

        if(mSeconds < 10) {
            mTimeText.setText("0" + mSeconds);
        } else {
            mTimeText.setText("" + mSeconds);
        }



        mHandler.postDelayed(TimerRunnabel, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mHandler.removeCallbacks(TimerRunnabel);
    }

    private void showScreen(int screenId) {
        mViewPager.setCurrentItem(screenId);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getBaseLayout() {
        return R.layout.activity_test_screen;
    }

    /**
     * Fragment adapter to include all the fragments.
     *
     * @author Muthu.Krishnan
     */
    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mScreens.size();
        }

        @Override
        public Fragment getItem(int position) {

            return mScreens.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Get the title for the bundle.
            Bundle bundle = mScreens.get(position).getArguments();

//            String title = bundle.getString(SubContactFragment.INTENT_TITLE);

            return "";
        }

    }

    public void onClickNext() {

        if(mCurrentScreen >= (mQuestions.size()-1)) {
            mNextBtn.setText("Finish");
            return;
        }
        mPrevBtn.setVisibility(View.VISIBLE);
        mNextBtn.setText("Next");
        mCurrentScreen += 1;

        showScreen(mCurrentScreen);
    }

    public void onClickPrev() {

        if (mCurrentScreen == 0) {
            mPrevBtn.setVisibility(View.INVISIBLE);
            return;
        }
        mCurrentScreen -= 1;

        showScreen(mCurrentScreen);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.prev_btn) {
            onClickPrev();
        } else if (id == R.id.next_btn){
            onClickNext();
        }
    }

    @Override
    public void onQuestionSelected(int question, int choice, String value) {
        ListIterator<Questions> iterator = mQuestions.listIterator();

        while (iterator.hasNext()) {
            final Questions msg = iterator.next();

            if (msg.id == question) {
                msg.selectedChoice = choice;
                msg.selectedValue = value;

                break;
            }
        }
    }

    @Override
    public Questions getQuestion(int screen) {
        return mQuestions.get(screen);
    }
}
