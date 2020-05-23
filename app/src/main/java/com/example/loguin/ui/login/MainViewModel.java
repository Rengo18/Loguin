package com.example.loguin.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loguin.model.Usuario;
import com.example.loguin.request.ApiClient;

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario(){
        if(mldUsuario==null){
            mldUsuario= new MutableLiveData<>();

        }
        return mldUsuario;
    }

    public void login (Context context, String email, String passord){
        Usuario u = ApiClient.login(context,email,passord);
        mldUsuario.setValue(u);
    }
}
