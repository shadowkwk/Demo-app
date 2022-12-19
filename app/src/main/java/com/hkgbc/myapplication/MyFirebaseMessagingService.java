package com.hkgbc.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        userLogin(token);
        //Log.e("newToken", token);
        //sendRegistrationToServer(token);
        //getSharedPreferences("_", MODE_PRIVATE).edit().putString("fb", s).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("TAG", "From: " + remoteMessage.getFrom());
        super.onMessageReceived(remoteMessage);
    }

    public static String getToken(Context context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("fb", "empty");
    }

    private void userLogin(String token) {
        class UserLogin extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                RequestHandler requestHandler = new RequestHandler();
                HashMap<String, String> params = new HashMap<>();
                params.put("username", SharedPrefManager.getInstance(getApplicationContext()).getUser().getUsername());
                params.put("token", token);
                requestHandler.sendPostRequest(URLs.URL_NEWTOKEN, params);
                return null;
            }
        }

        UserLogin ul = new UserLogin();
        ul.execute();
    }
}