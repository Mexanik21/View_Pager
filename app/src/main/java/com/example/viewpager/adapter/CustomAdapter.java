package com.example.viewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager.R;
import com.example.viewpager.madel.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        TextView tv_first_name = ((CustomViewHolder) holder).tv_first_name;
        TextView tv_last_name = ((CustomViewHolder) holder).tv_last_name;

        tv_first_name.setText(member.getFirstName());
        tv_last_name.setText(member.getLastName());

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView tv_first_name, tv_last_name;
        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            tv_first_name = view.findViewById(R.id.tv_first_name);
            tv_last_name = view.findViewById(R.id.tv_last_name);
        }
    }
}
