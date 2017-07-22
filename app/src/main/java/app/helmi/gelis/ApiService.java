package app.helmi.gelis;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 22 July 2017, 1:26 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService
{
    @GET("admin/index_php/eventbanner")
    Call<List<Banner>> listBanner();
}
