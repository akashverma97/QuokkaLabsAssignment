package com.example.task1.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;

public class NetworkHelper {
    private Context context;

    NetworkHelper(Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        boolean result = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network networkCapabilities = connectivityManager.getActiveNetwork();
            if (networkCapabilities == null) {
                return false;
            }
            NetworkCapabilities actNw = connectivityManager.getNetworkCapabilities(networkCapabilities);
            if (actNw == null) {
                return false;
            }
            if (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                result = true;
            } else if (actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                result = true;
            } else if (actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                result = true;
            }

        } else {
            switch (connectivityManager.getActiveNetworkInfo().getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    result = true;
                    break;

                case ConnectivityManager.TYPE_MOBILE:
                    result = true;
                    break;

                case ConnectivityManager.TYPE_ETHERNET:
                    result = true;
                    break;
                default:
                    result = false;
                    break;
            }


        }
        return result;
    }
}
