package com.passit.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.passit.R;
import com.passit.model.Questions;

import java.util.ArrayList;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {

    private ArrayList<Questions> mQuestionses = new ArrayList<Questions>();

    private OnQuestionItemClickListener mOnQuestionItemClickListener;

    public QuestionListAdapter(OnQuestionItemClickListener onQuestionItemClickListener) {
        mOnQuestionItemClickListener = onQuestionItemClickListener;
    }

    public void setQuestions(ArrayList<Questions> question) {
        mQuestionses.addAll(question);

        notifyDataSetChanged();
    }

    public interface OnQuestionItemClickListener {
        public void onQuestionToView(int question);
    }

    @Override
    public int getItemCount() {
        return mQuestionses.size();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Questions questions = mQuestionses.get(position);

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnQuestionItemClickListener != null) {
                    mOnQuestionItemClickListener.onQuestionToView(position);
                }
            }
        });

        holder.question.setText(questions.question);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_list_item, parent, false);

        ViewHolder vh = new ViewHolder(view);


        return vh;
    }

    /**
     * ViewHolder for this adapter class.
     *
     * @author muthukrishnan
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView question;
        public CheckBox seleceted;

        public RelativeLayout parentView;

        public ViewHolder(View v) {
            super(v);

            question = (TextView) v.findViewById(R.id.question);
            seleceted = (CheckBox) v.findViewById(R.id.selected);

            parentView = (RelativeLayout) v.findViewById(R.id.parent);
        }
    }
}
