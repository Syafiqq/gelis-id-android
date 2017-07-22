package app.helmi.gelis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

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

    public VisibleAlternativeRecyclerViewAdapter(AppCompatActivity root, List<BannerItem> objects)
    {
        this.dataset = objects;
        this.root = root;
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
        Context context = viewHolder.image.getContext();
        //viewHolder.text.setText(alternative.getTitle());
        System.out.println(Uri.parse(alternative.getImgUrl()));
        ImageView iv = viewHolder.image;

        iv.setScaleType(ImageView.ScaleType.FIT_XY);

        String imgUrl = alternative.imgUrl;

        if(!TextUtils.isEmpty(imgUrl))
        {
            Glide.with(context)
                 .load(imgUrl)
                 .fitCenter()
                 //.centerCrop()
                 .placeholder(new ColorDrawable(Color.parseColor("#555555")))
                 .into(iv);
        }
        else
        {
            iv.setImageDrawable(new ColorDrawable(Color.parseColor("#555555")));
        }
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
            //this.text = container.findViewById(R.id.texttext);
            this.image = container.findViewById(R.id.imgimg);
        }
    }
}

