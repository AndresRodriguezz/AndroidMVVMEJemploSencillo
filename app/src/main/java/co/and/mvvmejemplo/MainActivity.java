package co.and.mvvmejemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText eValue;
    private Button btOk;
    private TextView txtCalculate,txtResult;
    private AlCuadradoViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView() {
        viewModel = ViewModelProviders.of(this).get(AlCuadradoViewModel.class);
        eValue = (EditText)findViewById(R.id.eValue);
        btOk = (Button)findViewById(R.id.bOk);
        txtResult =(TextView)findViewById(R.id.txtResult);


        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.alCuadrado(eValue.getText().toString());
            }
        });
        final Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(String resultado) {
                txtResult.setText(resultado);
            }
        };

        viewModel.getResultado().observe(this,observer);
    }
}