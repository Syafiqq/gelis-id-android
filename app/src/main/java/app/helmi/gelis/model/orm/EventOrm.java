package app.helmi.gelis.model.orm;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 22 July 2017, 11:40 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

public class EventOrm
{
    @Nullable @SerializedName("id")
    private Integer id;
    @Nullable @SerializedName("kategori")
    private String category;
    @Nullable @SerializedName("foto")
    private String image;

    public EventOrm()
    {
    }

    public EventOrm(@Nullable Integer id, @Nullable String category, @Nullable String image)
    {
        this.id = id;
        this.category = category;
        this.image = image;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCategory()
    {
        return this.category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getImage()
    {
        return this.image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Override public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof EventOrm))
        {
            return false;
        }

        EventOrm eventOrm = (EventOrm) o;

        if(getId() != null ? !getId().equals(eventOrm.getId()) : eventOrm.getId() != null)
        {
            return false;
        }
        if(getCategory() != null ? !getCategory().equals(eventOrm.getCategory()) : eventOrm.getCategory() != null)
        {
            return false;
        }
        return getImage() != null ? getImage().equals(eventOrm.getImage()) : eventOrm.getImage() == null;

    }

    @Override public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("EventOrm{");
        sb.append("id=").append(id);
        sb.append(", category='").append(category).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
