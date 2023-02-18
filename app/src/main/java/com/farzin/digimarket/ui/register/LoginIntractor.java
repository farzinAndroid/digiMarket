package com.farzin.digimarket.ui.register;

import android.content.Context;

import com.farzin.digimarket.config.AppSettings;
import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginIntractor {
    //model class

    private ApiCaller apiCaller;
    private AppSettings appSettings;

    public LoginIntractor(Context context) {
        apiCaller = new ApiCaller();
        appSettings = new AppSettings(context);
    }

    //Call Back Listener For Login
    public interface ILoginListener {
        void onUserNameError();

        void onPasswordError();

        void onSuccess();

        void onError();
    }


    //receive data from Presenter and sen back with call back
    public void login(String username, String password, ILoginListener listener) {
        if (username.isEmpty()) {
            //send back
            listener.onUserNameError();
            //dont Continue
            return;
        }
        if (password.isEmpty()) {
            listener.onPasswordError();
            //dont Continue
            return;
        }

        apiCaller.getLogin(username, password, new IMessageListener() {
            @Override
            public void onResponse(Object onResponse) {
                parseJSon(username, onResponse.toString());
                listener.onSuccess();
            }

            @Override
            public void onError(String onError) {
                listener.onError();
            }
        });
    }

    public void register(String username, String password, ILoginListener listener) {
        if (username.isEmpty()) {
            //send back
            listener.onUserNameError();
            //dont Continue
            return;
        }
        if (password.isEmpty()) {
            listener.onPasswordError();
            //dont Continue
            return;
        }

        apiCaller.getRegister(username, password, new IMessageListener() {
            @Override
            public void onResponse(Object onResponse) {
                parseJSon(username, onResponse.toString());
                listener.onSuccess();
            }

            @Override
            public void onError(String onError) {
                listener.onError();
            }
        });
    }


    public void parseJSon(String username, String message) {

        try {
            JSONObject jsonObject = new JSONObject(message);

            int id = jsonObject.getInt("code");
            appSettings.setUserInfo(username, id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
