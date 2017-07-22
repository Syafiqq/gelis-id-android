package app.helmi.gelis.controller.adapter;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 23 July 2017, 5:14 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.helmi.gelis.R;
import app.helmi.gelis.model.orm.BannerOrm;
import app.helmi.gelis.model.setting.constants.Network;
import com.bumptech.glide.Glide;
import com.flyco.banner.widget.Banner.BaseIndicatorBanner;

public class BannerAdapter extends BaseIndicatorBanner<BannerOrm, BannerAdapter>
{
    private ColorDrawable colorDrawable;

    public BannerAdapter(Context context)
    {
        this(context, null, 0);
    }

    public BannerAdapter(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public BannerAdapter(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        this.colorDrawable = new ColorDrawable(Color.parseColor("#555555"));
    }

    @Override
    public void onTitleSlect(TextView tv, int position)
    {
    }

    @Override
    public View onCreateItemView(int position)
    {
        View inflate = View.inflate(mContext, R.layout.banner_item, null);
        ImageView iv = inflate.findViewById(R.id.banner_item_image_view_image);

        final BannerOrm item = mDatas.get(position);
        int itemWidth = mDisplayMetrics.widthPixels;
        int itemHeight = (int) (itemWidth * 360 * 1.0f / 640);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setLayoutParams(new LinearLayout.LayoutParams(itemWidth, itemHeight));

        String imgUrl = item.getImage();

        if(!TextUtils.isEmpty(imgUrl))
        {
            imgUrl = Network.API_BASE_URL + Network.BANNER_ASSET_API + imgUrl;
            Glide.with(mContext)
                 .load(imgUrl)
                 .override(itemWidth, itemHeight)
                 .fitCenter()
                 //.centerCrop()
                 .placeholder(colorDrawable)
                 .into(iv);
        }
        else
        {
            iv.setImageDrawable(colorDrawable);
        }

        return inflate;
    }
}
