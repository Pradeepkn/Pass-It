package com.passit.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.passit.R;
import com.passit.model.Company;

import java.util.ArrayList;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.ViewHolder> {

    private ArrayList<Company> mCompanies = new ArrayList<Company>();

    private OnTestItemClickListener mOnTestItemClickListener;

    public CompanyListAdapter(OnTestItemClickListener onTestItemClickListener) {
        mOnTestItemClickListener = onTestItemClickListener;
        Company sanpdeal = new Company();
        Company thought = new Company();
        Company amazon = new Company();

        thought.description = "Hackathon pre screeening for mobile";
        amazon.description = "Amazon screen for SSE";
        sanpdeal.description = "C, C++";

        thought.companyName = "ThoughtWorks";
        amazon.companyName = "Amazon";
        sanpdeal.companyName = "Sanpdeal";

        mCompanies.add(thought);
        mCompanies.add(amazon);
        mCompanies.add(sanpdeal);
    }

    public interface OnTestItemClickListener {
        public void onClick(Company company);
    }

    @Override
    public int getItemCount() {
        return mCompanies.size();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Company company = mCompanies.get(position);
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnTestItemClickListener != null) {
                    mOnTestItemClickListener.onClick(null);
                }
            }
        });

        holder.company.setText(company.companyName);
        holder.description.setText(company.description);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_items, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }
    /**
     * ViewHolder for this adapter class.
     *
     * @author muthukrishnan
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView logo;

        public TextView company;
        public TextView description;

        public RelativeLayout parentView;

        public ViewHolder(View v) {
            super(v);

            logo = (ImageView) v.findViewById(R.id.logo);

            company = (TextView) v.findViewById(R.id.company_name);
            description = (TextView) v.findViewById(R.id.description);

            parentView = (RelativeLayout) v.findViewById(R.id.parent);
        }
    }
}
