package co.and.mvvmejemplo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlCuadradoViewModel extends ViewModel {
    //MutableLiveData es de lectura y escritura
    private MutableLiveData<String> resultado;

    public AlCuadradoViewModel(){
        resultado = new MutableLiveData<>();
    }
    public LiveData<String> getResultado(){
        return  resultado;
    }
    public void alCuadrado(String data){
        resultado.setValue(AlCuadradoUseCase.alCuadrado(data));
    }
}
