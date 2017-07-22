package app.helmi.gelis.model.service.api;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 23 July 2017, 4:28 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import app.helmi.gelis.model.orm.BannerOrm;
import app.helmi.gelis.model.setting.constants.Network;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerApi
{
    @GET(Network.BANNER_API)
    Call<List<BannerOrm>> find();
}
