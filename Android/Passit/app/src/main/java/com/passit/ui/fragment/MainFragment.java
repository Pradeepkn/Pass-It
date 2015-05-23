package com.passit.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.passit.R;
import com.passit.model.Company;
import com.passit.ui.activity.TestInfoScreen;
import com.passit.ui.adapter.CompanyListAdapter;
import com.passit.ui.widget.SpacesItemDecoration;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements CompanyListAdapter.OnTestItemClickListener {

    private RecyclerView mRecyclerView;
    private CompanyListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(10));

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CompanyListAdapter(MainFragment.this);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onClick(Company company) {
        startActivity(TestInfoScreen.getTestInfoScreenIntent(getActivity()));
//        DialogUtil.showAlert(getActivity(), Util.getString(R.string.app_name),
//                "Are you ready to  start the test..?",
//                new ZaarkDialog.OnPositiveButtonClickListener() {
//                    @Override
//                    public void onClick() {
//
//                    }
//                });
    }
}
