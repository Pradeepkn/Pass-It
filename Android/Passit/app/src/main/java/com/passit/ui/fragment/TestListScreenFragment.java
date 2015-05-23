package com.passit.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.passit.R;
import com.passit.model.Company;
import com.passit.ui.activity.TestScreenActivty;
import com.passit.ui.adapter.CompanyListAdapter;
import com.passit.ui.adapter.QuestionListAdapter;
import com.passit.ui.widget.SpacesItemDecoration;
import com.passit.util.TempQuestionUtil;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestListScreenFragment extends Fragment implements QuestionListAdapter.OnQuestionItemClickListener {

    private RecyclerView mRecyclerView;
    private QuestionListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TestListScreenFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_test_list_screen, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(10));

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Toast.makeText(getActivity(), "Size : " + TempQuestionUtil.getQuestions().size(), Toast.LENGTH_SHORT).show();

        mAdapter = new QuestionListAdapter(TestListScreenFragment.this);
        mAdapter.setQuestions(TempQuestionUtil.getQuestions());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onQuestionToView(int question) {
        getActivity().startActivity(TestScreenActivty.getTestScreen(getActivity(), question, null));

        getActivity().finish();
    }
}
