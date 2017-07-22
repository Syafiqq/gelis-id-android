package app.helmi.gelis.model.orm;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 22 July 2017, 11:40 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import org.jetbrains.annotations.Nullable;

public class BannerOrm
{
    @Nullable @SerializedName("id")
    private Integer id;
    @Nullable @SerializedName("tanggal_dibuat")
    private Date start;
    @Nullable @SerializedName("tanggal_berakhir")
    private Date end;
    @Nullable @SerializedName("fitur_promosi")
    private Integer promotion;
    @Nullable @SerializedName("foto")
    private String image;
    @Nullable @SerializedName("is_show")
    private String isShown;
    @Nullable @SerializedName("action")
    private Integer action;

    public BannerOrm()
    {
    }

    public BannerOrm(@Nullable Integer id, @Nullable Date start, @Nullable Date end, @Nullable Integer promotion, @Nullable String image, @Nullable String isShown, @Nullable Integer action)
    {
        this.id = id;
        this.start = start;
        this.end = end;
        this.promotion = promotion;
        this.image = image;
        this.isShown = isShown;
        this.action = action;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getStart()
    {
        return this.start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd()
    {
        return this.end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }

    public Integer getPromotion()
    {
        return this.promotion;
    }

    public void setPromotion(Integer promotion)
    {
        this.promotion = promotion;
    }

    public String getImage()
    {
        return this.image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getIsShown()
    {
        return this.isShown;
    }

    public void setIsShown(String isShown)
    {
        this.isShown = isShown;
    }

    public Integer getAction()
    {
        return this.action;
    }

    public void setAction(Integer action)
    {
        this.action = action;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof BannerOrm))
        {
            return false;
        }

        BannerOrm banner = (BannerOrm) o;

        if(getId() != null ? !getId().equals(banner.getId()) : banner.getId() != null)
        {
            return false;
        }
        if(getStart() != null ? !getStart().equals(banner.getStart()) : banner.getStart() != null)
        {
            return false;
        }
        if(getEnd() != null ? !getEnd().equals(banner.getEnd()) : banner.getEnd() != null)
        {
            return false;
        }
        if(getPromotion() != null ? !getPromotion().equals(banner.getPromotion()) : banner.getPromotion() != null)
        {
            return false;
        }
        if(getImage() != null ? !getImage().equals(banner.getImage()) : banner.getImage() != null)
        {
            return false;
        }
        if(getIsShown() != null ? !getIsShown().equals(banner.getIsShown()) : banner.getIsShown() != null)
        {
            return false;
        }
        return getAction() != null ? getAction().equals(banner.getAction()) : banner.getAction() == null;

    }

    @Override public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        result = 31 * result + (getPromotion() != null ? getPromotion().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getIsShown() != null ? getIsShown().hashCode() : 0);
        result = 31 * result + (getAction() != null ? getAction().hashCode() : 0);
        return result;
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("BannerApi{");
        sb.append("id=").append(id);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", promotion=").append(promotion);
        sb.append(", image='").append(image).append('\'');
        sb.append(", isShown='").append(isShown).append('\'');
        sb.append(", action=").append(action);
        sb.append('}');
        return sb.toString();
    }
}
