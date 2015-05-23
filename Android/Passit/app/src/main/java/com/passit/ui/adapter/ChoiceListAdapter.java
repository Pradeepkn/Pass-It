package com.passit.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.passit.PassitApplication;
import com.passit.R;

import java.util.ArrayList;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class ChoiceListAdapter extends RecyclerView.Adapter<ChoiceListAdapter.ViewHolder> {

    private ArrayList<String> mChoices = new ArrayList<String>();

    private OnChoiceItemClickListener mOnChoiceItemClickListener;

    private int mSelected = -1;

    public ChoiceListAdapter(OnChoiceItemClickListener onChoiceItemClickListener) {
        mOnChoiceItemClickListener = onChoiceItemClickListener;
    }

    public void setChoices(ArrayList<String> choices, int selected) {
        if (choices != null) {
            mChoices.addAll(choices);
        }

        mSelected = selected;

        notifyDataSetChanged();
    }

    public interface OnChoiceItemClickListener {
        public void onSelected(int item, String value);
    }

    @Override
    public int getItemCount() {
        return mChoices.size();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String value = mChoices.get(position);

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelected = position;
                if (mOnChoiceItemClickListener != null) {
                    mOnChoiceItemClickListener.onSelected(position, value);
                }

                notifyDataSetChanged();
            }
        });

        if (mSelected == position) {
            holder.parentView.setBackgroundColor(
                    PassitApplication.getApplication().getResources().getColor(R.color.accent));
        }

        holder.choice.setText(value);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choice_item, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    /**
     * ViewHolder for this adapter class.
     *
     * @author muthukrishnan
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView choice;

        public RelativeLayout parentView;

        public ViewHolder(View v) {
            super(v);

            choice = (TextView) v.findViewById(R.id.choice);

            parentView = (RelativeLayout) v.findViewById(R.id.parent);
        }
    }
}
