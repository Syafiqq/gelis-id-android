package app.helmi.gelis.entity;

public class BannerItem
{
    public String imgUrl;
    public String title;


    public BannerItem(String imgUrl, String title)
    {
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public String getImgUrl()
    {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
