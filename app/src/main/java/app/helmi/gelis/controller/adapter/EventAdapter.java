package app.helmi.gelis.controller.adapter;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 23 July 2017, 5:45 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import app.helmi.gelis.R;
import app.helmi.gelis.model.orm.EventOrm;
import app.helmi.gelis.model.setting.constants.Network;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>
{
    private final Context root;
    private final List<EventOrm> dataset;
    private final Picasso picasso;

    public EventAdapter(Context root, List<EventOrm> objects)
    {
        this.dataset = objects;
        this.root = root;
        @NotNull final Picasso.Builder builder = new Picasso.Builder(root.getApplicationContext())
                .loggingEnabled(true)
                .downloader(new OkHttp3Downloader(new OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(120, TimeUnit.SECONDS)
                        .build()));
        this.picasso = builder.build();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(final ViewHolder viewHolder, final int position)
    {
        final EventOrm event = this.dataset.get(position);
        this.picasso
                .load(Network.API_BASE_URL + Network.EVENT_ASSET_API + event.getImage())
                .into(viewHolder.image, new Callback()
                {
                    @Override public void onSuccess()
                    {
                        viewHolder.text.setText(event.getCategory());
                        viewHolder.text.setVisibility(View.VISIBLE);
                        viewHolder.image.setVisibility(View.VISIBLE);
                        viewHolder.progress.setVisibility(View.GONE);
                        viewHolder.root.setVisibility(View.VISIBLE);
                    }

                    @Override public void onError()
                    {
                        Toast.makeText(root, "Error Retrieving Image", Toast.LENGTH_SHORT).show();
                        viewHolder.text.setVisibility(View.GONE);
                        viewHolder.image.setVisibility(View.GONE);
                        viewHolder.progress.setVisibility(View.GONE);
                        viewHolder.root.setVisibility(View.GONE);
                    }
                });

    }

    private int getProgress(int value, int min, int max)
    {
        return (int) Math.ceil(((value - min) * 100) / (max - min));
    }

    @Override
    public int getItemCount()
    {

        return dataset.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        final Context context;
        RelativeLayout root;
        ImageView image;
        TextView text;
        ProgressBar progress;

        public ViewHolder(View itemView, final Context context)
        {
            super(itemView);

            this.context = context;
            this.registerView(itemView);
        }

        private void registerView(final View container)
        {
            this.text = container.findViewById(R.id.event_item_textview_event_title);
            this.image = container.findViewById(R.id.event_item_imageview_event_image);
            this.progress = container.findViewById(R.id.event_item_imageview_progress);
            this.root = container.findViewById(R.id.event_item_relativelayout_root);
        }
    }
}

