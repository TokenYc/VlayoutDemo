package net.archeryc.vlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.LinkedList;
import java.util.List;

public class MultiLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_layout);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        final VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        //设置实质的LayoutManager
        recyclerView.setLayoutManager(virtualLayoutManager);

        final DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);

        recyclerView.setAdapter(delegateAdapter);

        final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        adapters.add(new DelegateAdapter.Adapter() {
            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return new DefaultLayoutHelper();
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new FirstViewHolder(LayoutInflater.from(MultiLayoutActivity.this).inflate(R.layout.item_first, parent, false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            protected void onBindViewHolderWithOffset(RecyclerView.ViewHolder holder, int position, int offsetTotal) {
                if (holder instanceof FirstViewHolder) {
                    FirstViewHolder viewHolder = (FirstViewHolder) holder;
                    viewHolder.textView.setText(Integer.toString(offsetTotal));
                }
            }

            @Override
            public int getItemCount() {
                return 8;
            }
        });

        adapters.add(new DelegateAdapter.Adapter() {
            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return new GridLayoutHelper(5);
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new FirstViewHolder(LayoutInflater.from(MultiLayoutActivity.this).inflate(R.layout.item_second, parent, false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            protected void onBindViewHolderWithOffset(RecyclerView.ViewHolder holder, int position, int offsetTotal) {
                if (holder instanceof FirstViewHolder) {
                    FirstViewHolder viewHolder = (FirstViewHolder) holder;
                    viewHolder.textView.setText(Integer.toString(offsetTotal));
                }
            }

            @Override
            public int getItemCount() {
                return 30;
            }
        });
        delegateAdapter.setAdapters(adapters);

    }

    static class FirstViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public FirstViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}



