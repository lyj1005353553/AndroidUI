package com.ohterview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.ohterview.R;
import com.ohterview.model.AmimateCheckBoxModel;

import java.util.List;

/**
 * Created by Administrator on 2018/1/10.
 */

public class CombinationCAAdapter extends RecyclerView.Adapter<CombinationCAAdapter.ViewHolder> {


    private List<AmimateCheckBoxModel> items;
    private OnItemClickListener mOnItemClickListener = null;

    public CombinationCAAdapter(List<AmimateCheckBoxModel> items) {
        this.items = items;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

     public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setLists(List<AmimateCheckBoxModel> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ca_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cbox_ca_item.setText(items.get(position).getContent());
        if (items.get(position).isChecked()) {
            holder.cbox_ca_item.setChecked(true);
        } else {
            holder.cbox_ca_item.setChecked(false);
        }
        holder.cbox_ca_item.setTag(position);
        holder.cbox_ca_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbox_ca_item;

        public ViewHolder(View itemView) {
            super(itemView);
            cbox_ca_item = itemView.findViewById(R.id.cbox_ca_item);
        }
    }
}
