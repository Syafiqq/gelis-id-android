package app.helmi.gelis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;

public class RecycleView extends AppCompatActivity
{
    private List<BannerItem> alternatives;
    private RecyclerView.Adapter adapter;
    private FloatingActionButton calculate;
    private ArrayList<BannerItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.alternatives = new ArrayList<>();
        this.items = new ArrayList<>();
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 1"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500656484-2017-07-21.jpg", "Gambar 2"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 3"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 4"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 5"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 6"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 7"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 8"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 9"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500656484-2017-07-21.jpg", "Gambar 10"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500656484-2017-07-21.jpg", "Gambar 11"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500656484-2017-07-21.jpg", "Gambar 12"));

        this.setProperties();
    }

    private void setProperties()
    {
        this.initializeList();
    }

    private void initializeList()
    {
        final RecyclerView recyclerView = (RecyclerView) super.findViewById(R.id.content_dashboard_recycle_view_container);

        recyclerView.setLayoutManager(new LinearLayoutManager(super.getApplicationContext()));

        recyclerView.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(super.getApplicationContext(), R.drawable.divider)));
        recyclerView.setItemAnimator(new FadeInRightAnimator());

        this.adapter = new VisibleAlternativeRecyclerViewAdapter(this, this.alternatives);
        recyclerView.setAdapter(this.adapter);
    }

    @Override
    protected void onPostResume()
    {
        this.resetAlternative();
        this.populateAlternative();
        super.onPostResume();
    }

    private void resetAlternative()
    {
        this.alternatives.clear();
        this.adapter.notifyDataSetChanged();
    }


    private void populateAlternative()
    {
        this.alternatives.addAll(this.items);
        this.adapter.notifyDataSetChanged();
    }

    public RecyclerView.Adapter getAdapter()
    {

        return adapter;
    }

}
