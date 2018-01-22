package net.archeryc.vlayoutdemo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import net.archeryc.vlayoutdemo.R;

/**
 * Created by yc on 2017/12/27.
 */

public class TopicAdapter extends DelegateAdapter.Adapter {

    private Context mContext;

    public TopicAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("create","TopicAdapter------->onCreateViewHOlder");
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        viewHolder.tvTopic.setText("推荐话题");
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        viewHolder.recyclerView.setAdapter(new TopicItemAdapter());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 11;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTopic;
        private RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTopic= (TextView) itemView.findViewById(R.id.tv_topic);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }

    class TopicItemAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(mContext).inflate(R.layout.item_topic,parent,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder{
            private TextView tvTopic;
            private ImageView imvLeft;
            public ItemViewHolder(View itemView) {
                super(itemView);
                tvTopic= (TextView) itemView.findViewById(R.id.tv_topic);
                imvLeft= (ImageView) itemView.findViewById(R.id.imv_left);
            }
        }
    }
}
