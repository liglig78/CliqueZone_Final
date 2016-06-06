package DB.Actions;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.util.concurrent.TimeUnit;

/**
 * Created by Toshiba on 06/06/2016.
 */
public class AddressesConverter {
    public static final double EPSILON = 0.000001;
    public String key;
    private GeoApiContext context;

    public AddressesConverter(String key) {
        this.key = key;
        this.context = new GeoApiContext()
                .setApiKey(key)
                .setQueryRateLimit(3)
                .setConnectTimeout(1, TimeUnit.SECONDS)
                .setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }


    public LatLng convertAddress(String adderess) throws Exception {

        GeocodingResult[] results = GeocodingApi.newRequest(context).address(adderess).await();

        return results[0].geometry.location;
    }


}
