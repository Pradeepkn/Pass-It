package com.passit.ui.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.passit.R;
import com.passit.model.Questions;
import com.passit.ui.adapter.ChoiceListAdapter;
import com.passit.ui.adapter.QuestionListAdapter;
import com.passit.ui.widget.SpacesItemDecoration;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestScreenFragment extends Fragment implements ChoiceListAdapter.OnChoiceItemClickListener {

    private static final String BUNDLE_SCREEN_ID = "bundle_screen_id";

    private static final String BUNDLE_QUESTION = "question";

    private Questions mQuestions;

    private OnActionListener mOnActionListener;

    private int mScreen;

    private RecyclerView mRecyclerView;
    private ChoiceListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * To get the action list
     */
    public interface OnActionListener {
        public void onQuestionSelected(int question, int choice, String value);

        public Questions getQuestion(int screen);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mOnActionListener = (OnActionListener) activity;

        Bundle bundle = getArguments();

        if(bundle != null) {
            mScreen = bundle.getInt(BUNDLE_SCREEN_ID);

            mQuestions = (Questions) bundle.getSerializable(BUNDLE_QUESTION);
        }
    }

    public static Bundle getBundle(int screen, Questions questions) {
        Bundle bundle = new Bundle();

        bundle.putInt(BUNDLE_SCREEN_ID, screen);
        bundle.putSerializable(BUNDLE_QUESTION, questions);

        return bundle;
    }

    public TestScreenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mQuestions = mOnActionListener.getQuestion(mScreen);

        final View view = inflater.inflate(R.layout.fragment_test_screen, container, false);

        TextView questionView = (TextView) view.findViewById(R.id.question);

        questionView.setText(mQuestions.question+  "- " + mQuestions.choice.get(0));

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(10));

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ChoiceListAdapter(TestScreenFragment.this);

        mAdapter.setChoices(mQuestions.choice, mQuestions.selectedChoice);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onSelected(int item, String value) {
        mOnActionListener.onQuestionSelected(mScreen, item, value);
    }
}
