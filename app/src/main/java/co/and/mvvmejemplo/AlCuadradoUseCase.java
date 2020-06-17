package co.and.mvvmejemplo;

public class AlCuadradoUseCase {
    public static String alCuadrado(String data){
        if (data.equals("")){
            return "El campo esta vacio";
        } else{
            return String.valueOf(Double.parseDouble(data) * Double.parseDouble(data));
        }
    }

}
