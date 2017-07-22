package app.helmi.gelis.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import app.helmi.gelis.R;
import app.helmi.gelis.model.custom.java.util.ObservableList;
import app.helmi.gelis.model.orm.BannerOrm;
import app.helmi.gelis.model.orm.EventOrm;
import app.helmi.gelis.model.service.api.BannerApi;
import app.helmi.gelis.model.service.api.EventApi;
import app.helmi.gelis.model.setting.constants.Network;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.initializeProperties();
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
                Log.e("Banner API", "Unable To get Banner Data", throwable);
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
                Log.e("Event API", "Unable To get Event Data", throwable);
            }
        });
    }

    private void initializeProperties()
    {
        this.banners = new ObservableList<>(new ArrayList<BannerOrm>());
        this.events = new ObservableList<>(new ArrayList<EventOrm>());
    }
}
