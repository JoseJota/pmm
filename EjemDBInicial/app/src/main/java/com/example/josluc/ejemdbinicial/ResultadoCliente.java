package com.example.josluc.ejemdbinicial;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class ResultadoCliente extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cliente);

        Bundle miBundle = getIntent().getExtras();
        Cliente cliente= (Cliente) miBundle.getSerializable("NOMBRE");

        TextView nombre = (TextView) findViewById(R.id.nombre);
        TextView telf = (TextView) findViewById(R.id.telefono);

        nombre.setText("Nombre: " + cliente.getNombre());
        telf.setText("Telefono: " + cliente.getTelf());
    }
}
