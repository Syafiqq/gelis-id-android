package app.helmi.gelis.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import app.helmi.gelis.R;
import app.helmi.gelis.controller.adapter.BannerAdapter;
import app.helmi.gelis.model.custom.java.util.ObservableList;
import app.helmi.gelis.model.orm.BannerOrm;
import app.helmi.gelis.model.orm.EventOrm;
import app.helmi.gelis.model.service.api.BannerApi;
import app.helmi.gelis.model.service.api.EventApi;
import app.helmi.gelis.model.setting.constants.Network;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dashboard extends AppCompatActivity
{
    ObservableList<BannerOrm> banners;
    ObservableList<EventOrm> events;
    private BannerAdapter bannerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.initializeProperties();
        this.initializeAdapter();
        this.initializeData();
    }

    private void initializeData()
    {
        @NotNull final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Network.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        @NotNull final BannerApi bannerApi = retrofit.create(BannerApi.class);
        bannerApi.find().enqueue(new Callback<List<BannerOrm>>()
        {
            @Override public void onResponse(@NotNull Call<List<BannerOrm>> call, @NotNull Response<List<BannerOrm>> response)
            {
                if(response.body() != null)
                {
                    Dashboard.this.banners.update(response.body());
                }
            }

            @Override public void onFailure(Call<List<BannerOrm>> call, Throwable throwable)
            {
                String error = "Unable To get Banner Data";
                Toast.makeText(Dashboard.this, error, Toast.LENGTH_SHORT).show();
                Log.e("Banner API", error, throwable);
            }
        });

        @NotNull final EventApi eventApi = retrofit.create(EventApi.class);
        eventApi.find().enqueue(new Callback<List<EventOrm>>()
        {
            @Override public void onResponse(@NotNull Call<List<EventOrm>> call, @NotNull Response<List<EventOrm>> response)
            {
                if(response.body() != null)
                {
                    Dashboard.this.events.update(response.body());
                }
            }

            @Override public void onFailure(Call<List<EventOrm>> call, Throwable throwable)
            {
                String error = "Unable To get Event Data";
                Toast.makeText(Dashboard.this, error, Toast.LENGTH_SHORT).show();
                Log.e("Event API", error, throwable);
            }
        });
    }

    private void initializeAdapter()
    {
        this.bannerAdapter = (BannerAdapter) super.findViewById(R.id.activity_dashboard_adapter_banner_adapter);
        this.banners.addObserver(new Observer()
        {
            @Override public void update(Observable observable, Object o)
            {
                Dashboard.this.bannerAdapter.setSource(((ObservableList<BannerOrm>) observable).getList()).startScroll();
            }
        });
    }

    private void initializeProperties()
    {
        this.banners = new ObservableList<>(new ArrayList<BannerOrm>());
        this.events = new ObservableList<>(new ArrayList<EventOrm>());
    }
}
