package net.archeryc.vlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

import net.archeryc.vlayoutdemo.adapter.CommonAdapter;
import net.archeryc.vlayoutdemo.adapter.TopicAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yc
 */
public class QfLayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private VirtualLayoutManager virtualLayoutManager;

    private DelegateAdapter delegateAdapter;

    private List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qf_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        virtualLayoutManager = new VirtualLayoutManager(this);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        recyclerView.setLayoutManager(virtualLayoutManager);
        recyclerView.setAdapter(delegateAdapter);

        adapters.add(new TopicAdapter(this));

        adapters.add(new CommonAdapter(this, 30));

        adapters.add(new TopicAdapter(this));

        adapters.add(new CommonAdapter(this, 15));

        adapters.add(new TopicAdapter(this));

        adapters.add(new CommonAdapter(this, 15));

        delegateAdapter.setAdapters(adapters);

    }
}
