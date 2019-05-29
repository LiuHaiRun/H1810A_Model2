package com.example.liuhairui.day01_text02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liuhairui.day01_text02.R;
import com.example.liuhairui.day01_text02.bean.Student;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MyAdapter extends XRecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Student> mStudents;

    public MyAdapter(Context context, ArrayList<Student> students) {
        mContext = context;
        mStudents = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = mStudents.get(position);

        holder.tv1.setText(student.getName());
        holder.tv2.setText(student.getAge()+"");
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1,tv2;
        public ViewHolder(View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
