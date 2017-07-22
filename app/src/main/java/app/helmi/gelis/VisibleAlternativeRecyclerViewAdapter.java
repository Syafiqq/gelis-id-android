package app.helmi.gelis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * This <CourierSelection> project created by :
 * Name         : syafiq
 * Date / Time  : 30 April 2017, 4:59 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

public class VisibleAlternativeRecyclerViewAdapter extends RecyclerView.Adapter<VisibleAlternativeRecyclerViewAdapter.SimpleViewHolder>
{
    private final AppCompatActivity root;
    private final List<BannerItem> dataset;
    private final Picasso picasso;

    public VisibleAlternativeRecyclerViewAdapter(AppCompatActivity root, List<BannerItem> objects)
    {
        this.dataset = objects;
        this.root = root;
        Picasso.Builder builder = new Picasso.Builder(root.getApplicationContext())
                .loggingEnabled(true)
                .listener(new Picasso.Listener()
                {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
                    {
                        exception.printStackTrace();
                    }
                })
                .downloader(new OkHttp3Downloader(new OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(120, TimeUnit.SECONDS)
                        .build()));
        this.picasso = builder.build();
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_content, parent, false);
        return new SimpleViewHolder(view, parent.getContext());
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position)
    {
        final BannerItem alternative = this.dataset.get(position);
        this.picasso
                .load(Uri.parse(alternative.getImgUrl().trim()))
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_STORE)
                .into(viewHolder.image, new Callback()
                {
                    @Override public void onSuccess()
                    {
                        viewHolder.text.setText(alternative.getTitle());
                    }

                    @Override public void onError()
                    {
                        Toast.makeText(root, "Error", Toast.LENGTH_SHORT).show();
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


    public static class SimpleViewHolder extends RecyclerView.ViewHolder
    {
        final Context context;
        ImageView image;
        TextView text;

        public SimpleViewHolder(View itemView, final Context context)
        {
            super(itemView);

            this.context = context;
            this.registerView(itemView);
        }

        private void registerView(final View container)
        {
            this.text = container.findViewById(R.id.texttext);
            this.image = container.findViewById(R.id.imgimg);
        }
    }
}

