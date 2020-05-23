package com.example.loguin.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loguin.model.Usuario;
import com.example.loguin.request.ApiClient;

public class RegistroViewModel extends AndroidViewModel {
    public RegistroViewModel(@NonNull Application application) {
        super(application);
    }
    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario(){
        if(mldUsuario==null){
            mldUsuario= new MutableLiveData<>();

        }
        return mldUsuario;
    }

    public void Mostrar(Context context){
        Usuario usuario= ApiClient.leer(context);
        mldUsuario.setValue(usuario);
    }

    public void guardar(Context context,Usuario usuario ){
        ApiClient.guardar(context,usuario);
    }
}
