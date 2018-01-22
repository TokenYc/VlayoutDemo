package net.archeryc.vlayoutdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import net.archeryc.vlayoutdemo.R;

/**
 * Created by yc on 2017/12/27.
 */

public class CommonAdapter extends DelegateAdapter.Adapter{
    private Context mContext;
    private int mCount;

    public CommonAdapter(Context mContext, int mCount) {
        this.mContext = mContext;
        this.mCount = mCount;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("create","CommonAdapter-------->onCreateViewHolder");
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_common,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return 112;
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }


}
