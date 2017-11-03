package com.leedopoem.ljh.friendlyteacher.newmessage.homepage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.LeaveWord;

import java.util.List;

/**
 * Created by ljh on 17-10-30.
 */

public class LeaveWordsAdapter extends RecyclerView.Adapter<LeaveWordsAdapter.LeaveWordsViewHolder> {

    private List<LeaveWord> leaveWords;
    private OnItemClickListener onItemClickListener;

    static class LeaveWordsViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent,tvData;
        Button btnStar,btnCommunicate;

        public LeaveWordsViewHolder(View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_lw_content);
            tvData = itemView.findViewById(R.id.tv_leave_word_data);
            btnStar = itemView.findViewById(R.id.btn_lw_star);
            btnCommunicate = itemView.findViewById(R.id.btn_lw_communicate);
        }
    }

    public LeaveWordsAdapter(List<LeaveWord> leaveWords,
                             OnItemClickListener onItemClickListener) {
        this.leaveWords=leaveWords;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public LeaveWordsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaveword,
                parent, false);
        return new LeaveWordsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LeaveWordsViewHolder holder, int position) {
        LeaveWord leaveWord=leaveWords.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onLectureClick();
            }
        });
        holder.tvContent.setText(leaveWord.getContent());
        holder.tvData.setText(leaveWord.getData());
        holder.btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onStared();
            }
        });
    }

    @Override
    public int getItemCount() {
        return leaveWords.size();
    }

    public void replaceData(List<LeaveWord> leaveWords) {
        this.leaveWords=leaveWords;
        notifyDataSetChanged();
    }

    public void setData(List<LeaveWord> lectures) {
        this.leaveWords = lectures;
    }

    public interface OnItemClickListener {
        void onLectureClick();

        void onStared();
    }
}
