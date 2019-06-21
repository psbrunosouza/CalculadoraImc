package com.dev.calculadoraimc;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView img_resultado;
    private TextInputEditText txt_altura;
    private TextInputEditText txt_peso;
    private TextView txt_resposta;
    private TextView valorImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_resultado = findViewById(R.id.img_resultado);
        txt_altura = findViewById(R.id.txt_altura);
        txt_peso = findViewById(R.id.txt_peso);
        txt_resposta = findViewById(R.id.textoImc);
        valorImc = findViewById(R.id.valorImc);
    }

    public Double calculoImc(String cPeso, String cAltura) {
        Double valorPeso = Double.parseDouble(cPeso);
        Double valorAltura = Double.parseDouble(cAltura);
        Double imc;
        imc = (valorPeso / (valorAltura * valorAltura));
        imc = Math.floor(imc * 100) / 100;
        if (imc < 17.0) {
            img_resultado.setImageResource(R.drawable.imc_17);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("Você está muito abaixo do peso! Coma mais carboidratos e legumes! ):");
        } else if ((imc > 17.0) && (imc < 18.49)) {
            img_resultado.setImageResource(R.drawable.imc_17_18);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("Você está abaixo do peso, mas não está numa situação preocupante (:");
        } else if ((imc > 18.5) && (imc < 24.99)) {
            img_resultado.setImageResource(R.drawable.imc_18_24);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("É body builder!!! Parabéns, você está na faixa ideal de peso!");
        } else if ((imc > 25.0) && (imc < 29.99)) {
            img_resultado.setImageResource(R.drawable.imc_25_29);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("Achou que aquela pizza do final de semana não fazia diferença?");
        } else if ((imc > 30.0) && (imc < 34.99)) {
            img_resultado.setImageResource(R.drawable.imc_30_34);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("Estou ficando preocupado com você, melhor parar de ir ao MC Donalds...");
        } else if ((imc > 35.0) && (imc < 39.99)) {
            img_resultado.setImageResource(R.drawable.imc_35_39);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("Agora é sério! Obsidade aumenta os indices de diabetes e doenças cardiacas, se cuida mano!");
        } else {
            img_resultado.setImageResource(R.drawable.imc_40);
            valorImc.setText("IMC: " + imc.toString());
            txt_resposta.setText("OMG... Como foi que chegamos aqui... Nunca é tarde para recomeçar!");
        }
        return imc;
    }

    public Boolean validacao(String cPeso, String cAltura) {
        Boolean validador = true;
        if (cPeso.equals("") || cAltura.equals("") || (cPeso == null) || (cAltura == null)) {
            validador = false;
        }
        return validador;
    }

    public void onCalcular(View view) {
        String cPeso = txt_peso.getText().toString();
        String cAltura = txt_altura.getText().toString();
        Boolean validador = validacao(cPeso, cAltura);

        if (validador) {
            calculoImc(cPeso, cAltura);
        } else {
            Toast.makeText(this, "Insira peso e altura válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
