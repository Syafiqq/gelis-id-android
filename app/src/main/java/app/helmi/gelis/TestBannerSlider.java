package app.helmi.gelis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class TestBannerSlider extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_banner_slider);
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

        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        //add banner using image url
        bannerSlider.addBanner(new RemoteBanner("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg"));
        bannerSlider.addBanner(new RemoteBanner("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg"));
        bannerSlider.addBanner(new RemoteBanner("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg"));
        bannerSlider.addBanner(new RemoteBanner("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg"));
        bannerSlider.addBanner(new RemoteBanner("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg"));
        bannerSlider.addBanner(new RemoteBanner("http://gelis.id/admin/geventbanner/1500659005-2017-07-21.jpg"));
    }

}
