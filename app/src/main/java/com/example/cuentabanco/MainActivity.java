package com.example.cuentabanco;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cuentabanco.databinding.ActivityMain2Binding;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CuentaBancaria cuenta;

    private EditText montoEditText;
    private TextView saldoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la cuenta bancaria
        cuenta = new CuentaBancaria("123456", "Titular de la cuenta");

        montoEditText = findViewById(R.id.montoEditText);
        saldoTextView = findViewById(R.id.saldoTextView);

        Button depositarButton = findViewById(R.id.depositarButton);
        Button retirarButton = findViewById(R.id.retirarButton);

        depositarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double monto = Double.parseDouble(montoEditText.getText().toString());
                cuenta.depositar(monto);
                actualizarSaldo();
            }
        });

        retirarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double monto = Double.parseDouble(montoEditText.getText().toString());
                cuenta.retirar(monto);
                actualizarSaldo();
            }
        });

        actualizarSaldo();
    }

    private void actualizarSaldo() {
        saldoTextView.setText("Saldo: $" + cuenta.obtenerSaldo());
    }
}
