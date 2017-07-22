package app.helmi.gelis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import app.helmi.gelis.banner.SimpleImageBanner;
import app.helmi.gelis.entity.BannerItem;
import java.util.ArrayList;
import java.util.List;

public class FlycoBanner extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyco_banner);
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


        List<BannerItem> items = new ArrayList<>();
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 1"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500656484-2017-07-21.jpg", "Gambar 2"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 3"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 4"));
        items.add(new BannerItem("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg", "Gambar 5"));


        SimpleImageBanner sib = (SimpleImageBanner) super.findViewById(R.id.sib_simple_usage);

        sib.setSource(items)
           .startScroll();

    }


}
