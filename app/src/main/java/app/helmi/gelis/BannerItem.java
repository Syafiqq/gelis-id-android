package app.helmi.gelis;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 22 July 2017, 6:07 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

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
