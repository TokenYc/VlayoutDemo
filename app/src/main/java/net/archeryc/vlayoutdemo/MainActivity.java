package net.archeryc.vlayoutdemo;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //设置一个实质的LayoutManager
        final VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        //设置一个Type的Item缓存的数量
        RecyclerView.RecycledViewPool viewPool=new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(5,5,5,5);
            }
        });
        final List<LayoutHelper> layoutHelpers = new LinkedList<>();

        //定义一个GridLayout类型的Helper
        final GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setItemCount(18);

        final StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelper.setItemCount(1);

        layoutHelpers.add(DefaultLayoutHelper.newHelper(4));
        layoutHelpers.add(stickyLayoutHelper);
        layoutHelpers.add(gridLayoutHelper);

        //将所有的LayoutHelper设置进实质的布局LayoutManager
        layoutManager.setLayoutHelpers(layoutHelpers);

        //绑定Adapter数据，这种写法，所有的布局使用相同的Item布局的View
        recyclerView.setAdapter(new VirtualLayoutAdapter(layoutManager) {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MainViewHolder(new TextView(MainActivity.this));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 200);
                holder.itemView.setLayoutParams(layoutParams);

                if (position==4){
                    layoutParams.width=250;
                    layoutParams.height=250;
                }

                ((TextView)holder.itemView).setText(Integer.toString(position));
                ((TextView)holder.itemView).setGravity(Gravity.CENTER);

                if (position%2==0){
                    holder.itemView.setBackgroundColor(Color.parseColor("#777777"));
                }else{
                    holder.itemView.setBackgroundColor(Color.parseColor("#888888"));
                }
            }

            @Override
            public int getItemCount() {
                List<LayoutHelper> helpers=getLayoutHelpers();
                if (helpers.size()==0){
                    return 0;
                }
                int count=0;
                for (LayoutHelper helper : helpers) {
                    count+=helper.getItemCount();
                }
                return count;
            }
        });
    }

    static class MainViewHolder extends RecyclerView.ViewHolder{

        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
