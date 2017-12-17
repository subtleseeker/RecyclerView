package io.github.subtleseeker.testrecyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by subtleseeker on 17/12/17.
 */

class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder>{

    LayoutInflater inflater;
    List<String> mData;
    private ItemClickListener mClickListener;

    public RVAdapter(Context context, List<String> data){
        this.inflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.rv_list_item, viewGroup,false);
        RVViewHolder viewHolder = new RVViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.rvListItem.setText(animal);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }



    class RVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView rvListItem;

        public RVViewHolder(View itemView) {
            super(itemView);
            rvListItem = itemView.findViewById(R.id.tv_rvlistitem);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
