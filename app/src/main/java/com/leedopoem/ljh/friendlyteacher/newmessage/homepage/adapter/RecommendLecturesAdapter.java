package com.leedopoem.ljh.friendlyteacher.newmessage.homepage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

import java.util.List;

/**
 * Created by ljh on 17-10-19.
 */

public class RecommendLecturesAdapter extends RecyclerView.Adapter<RecommendLecturesAdapter.LectureViewHolder> {

    private List<Lecture> lectures;
    private OnItemClickListener onItemClickListener;

    static class LectureViewHolder extends RecyclerView.ViewHolder{
        TextView tvLectureName,tvTeacherName,tvLectureIntroduction,tvLectureLocation,tvLectureTime;
        ImageButton btnStar;

        public LectureViewHolder(View itemView) {
            super(itemView);
            tvLectureName=itemView.findViewById(R.id.tv_lecture_name);
            tvTeacherName=itemView.findViewById(R.id.tv_teacher_name);
            tvLectureIntroduction=itemView.findViewById(R.id.tv_lecture_introduction);
            tvLectureLocation=itemView.findViewById(R.id.tv_lecture_location);
            tvLectureTime=itemView.findViewById(R.id.tv_lecture_time);
            btnStar=itemView.findViewById(R.id.btn_star);
        }
    }

    public RecommendLecturesAdapter(List<Lecture> lectures,OnItemClickListener onItemClickListener) {
        this.lectures = lectures;
        this.onItemClickListener=onItemClickListener;
    }

    @Override
    public LectureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lecture,parent,false);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LectureViewHolder holder, int position) {
        Lecture lecture=lectures.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onLectureClick();
            }
        });
        holder.tvLectureName.setText(lecture.getLectureName());
        holder.tvTeacherName.setText(lecture.getUid());
        holder.tvLectureTime.setText(lecture.getStartingTime()
                +lecture.getEndingTime()+lecture.getClassTime());
        holder.tvLectureLocation.setText(lecture.getLocation());
        holder.tvLectureIntroduction.setText(lecture.getIntroduction());
        holder.btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onStared();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lectures.size();
    }

    public void replaceData(List<Lecture> lectures){
        this.lectures=lectures;
        notifyDataSetChanged();
    }

    public void setData(List<Lecture> lectures){
        this.lectures=lectures;
    }

    public interface OnItemClickListener{
        void onLectureClick();
        void onStared();
    }
}
