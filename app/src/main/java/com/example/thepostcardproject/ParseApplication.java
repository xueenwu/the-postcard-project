package com.example.thepostcardproject;

import android.app.Application;

import com.example.thepostcardproject.models.Filter;
import com.example.thepostcardproject.models.FilteredPhoto;
import com.example.thepostcardproject.models.Location;
import com.example.thepostcardproject.models.Postcard;
import com.example.thepostcardproject.models.User;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Use for troubleshooting -- remove this line for production
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See https://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Q6T66URZyGCx54vOyVsTtqdKWgPQZULQrI3qMls3")
                .clientKey("gFezlWd6ZnawbDE4jOWxDTELGdiCB0IIcanrhVym")
                .server("https://parseapi.back4app.com")
                .build()
        );

        // Register models as Parse subclasses
        ParseObject.registerSubclass(Postcard.class);
        ParseObject.registerSubclass(Location.class);
        ParseUser.registerSubclass(User.class);
        ParseObject.registerSubclass(FilteredPhoto.class);
        ParseObject.registerSubclass(Filter.class);
    }
}
