    package com.lista.listadetareas.riuz.calculadora;

            import androidx.annotation.NonNull;                         import androidx.appcompat.app.AppCompatActivity;
            import androidx.appcompat.widget.Toolbar;                   import android.content.Intent;
            import android.content.pm.ActivityInfo;                     import android.view.View;
            import android.graphics.Color;                              import android.os.Bundle;
            import android.view.Menu;                                   import android.view.MenuItem;
            import android.widget.Button;                               import android.widget.TextView;
            import android.widget.Toast;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private Button btn0 , bnt1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 ,btn_suma , btn_pi , btn_resta , btn_multi , btn_divi , btn_igual, btn_del;
        private TextView textView;
        private TextView textView2;
        private String numero1;
        private String operador;
        private String numero2;
        public int resultado = 0;
        private Toolbar toolbar;

        private String radianesYdeg = null;

        private Math math;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView = findViewById(R.id.resultado);
            textView2 = findViewById(R.id.resultado2);
            toolbar = findViewById(R.id.toolbar_gome);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            btn_del = findViewById(R.id.borrar);        btn_igual = findViewById(R.id.btn_igual);
            bnt1 = findViewById(R.id.btn_1);            btn0 = findViewById(R.id.btn_0);
            btn2 = findViewById(R.id.btn_2);            btn3 = findViewById(R.id.btn_3);
            btn4 = findViewById(R.id.btn_4);            btn5 = findViewById(R.id.btn_5);
            btn6 = findViewById(R.id.btn_6);            btn7 = findViewById(R.id.btn_7);
            btn8 = findViewById(R.id.btn_8);            btn9 = findViewById(R.id.btn_9);
            btn_suma = findViewById(R.id.btn_suma);     btn_divi = findViewById(R.id.btn_divicion);
            btn_resta = findViewById(R.id.btn_resta);   btn_multi = findViewById(R.id.btn_multiplicacion);

            btn0.setOnClickListener(this);              bnt1.setOnClickListener(this);
            btn2.setOnClickListener(this);              btn4.setOnClickListener(this);
            btn3.setOnClickListener(this);              btn5.setOnClickListener(this);
            btn_pi.setOnClickListener(this);            btn6 .setOnClickListener(this);
            btn7.setOnClickListener(this);              btn8.setOnClickListener(this);
            btn9.setOnClickListener(this);              btn_suma.setOnClickListener(this);
            btn_divi.setOnClickListener(this);            btn_resta.setOnClickListener(this);
            btn_multi.setOnClickListener(this);         btn_igual.setOnClickListener(this);

            btn_del.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    textView.setText( "" );
                    textView2.setText( "" );
                    numero1 = null;
                    numero2 = null;
                    return  true;
                }
            });
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btn_igual:

                    if(numero1 == null) {

                    } else {
                        String resul = String.valueOf(resultado);
                        textView.setText( resul );
                        textView2.setText("");
                        numero1=resul;
                    }
                    break;

                case R.id.btn_0:
                    buttomClicket("0");
                    break;

                case R.id.btn_1:
                    buttomClicket("1");

                    break;

                case R.id.btn_2:
                    buttomClicket("2");
                    break;

                case R.id.btn_3:
                    buttomClicket("3");
                    break;

                case R.id.btn_4:
                    buttomClicket("4");
                    break;

                case R.id.btn_5:
                    buttomClicket("5");
                    break;

                case R.id.btn_6:
                    buttomClicket("6");
                    break;

                case R.id.btn_7:
                    buttomClicket("7");
                    break;
                case R.id.btn_8:
                    buttomClicket("8");
                    break;

                case R.id.btn_9:
                    buttomClicket("9");
                    break;

                case R.id.btn_suma:
                    buttonOperadorClicket("+");
                    break;

                case R.id.btn_resta:
                    buttonOperadorClicket("-");
                    break;

                case R.id.btn_multiplicacion:
                    buttonOperadorClicket("*");
                    break;
                case R.id.btn_divicion:
                    buttonOperadorClicket("/");
                    break;
            }
        }

        public void buttonOperadorClicket (String operadores) {

            if (numero1 == null){

            } else {
                operador = operadores;
                textView.setText( textView.getText() + operador );

                if (numero2 == null) {

                } else {
                    Toast.makeText(getApplicationContext() , "Numero 2 = " + numero2 , Toast.LENGTH_LONG).show();
                    operaciones(numero1, operador , numero2);
                }

            }

        }

        public void buttomClicket (String numero) {

            getLong();

            if (operador == null) {

                if (numero1 == null) {
                    numero1=  numero;
                } else {
                    numero1 = numero1 + numero;
                }

                textView.setText( textView.getText() +  numero);

            } else {

                if (numero2 == null) {
                    numero2 = numero;

                    operaciones(numero1 , operador , numero2);

                } else {
                    numero2 =  numero;
                    Toast.makeText(getApplicationContext() , numero2 , Toast.LENGTH_LONG).show();
                    operaciones(numero1 , operador , numero2);
                }
                textView.setText(textView.getText() +  numero);
            }
        }

        public void operaciones (String numero_1 ,  String operador  , String numero_2) {

            int a = 0;
            int b = 0;
            String parsResultado;

            try {

                switch (operador) {

                    case "+":
                            a = Integer.parseInt(numero_1);
                            b = Integer.parseInt(numero_2);

                            resultado = a+b;
                            parsResultado = String.valueOf(resultado);

                           // numero1 = parsResultado;
                           //      number_counter = parsResultado;
                          //  numero2=null;
                            Toast.makeText(getApplicationContext() , a + "+" + b + "=" + resultado , Toast.LENGTH_LONG).show();
                            textView2.setText(parsResultado);
                            textView2.setTextColor(Color.GRAY);
                        break;

                    case "-":

                            a = Integer.parseInt(numero_1);
                            b = Integer.parseInt(numero_2);

                            resultado = a-b;
                            parsResultado = String.valueOf(resultado);

                           // numero1 = parsResultado;
                        //numero2=null;

                          //  resultado_num_1 = parsResultado;
                            Toast.makeText(getApplicationContext() , a + "-" + b + "=" + resultado , Toast.LENGTH_LONG).show();
                            textView2.setText(parsResultado);
                            textView2.setTextColor(Color.GRAY);
                        break;


                    case "×":
                            a = Integer.parseInt(numero_1);
                            b = Integer.parseInt(numero_2);

                            resultado = a*b;
                            parsResultado = String.valueOf(resultado);

                        //numero1 = parsResultado;
                        //numero2=null;

                            //numero1 = parsResultado;
                            Toast.makeText(getApplicationContext() , a + "*" + b + "=" + resultado , Toast.LENGTH_LONG).show();
                            textView2.setText(parsResultado);
                            textView2.setTextColor(Color.GRAY);
                        break;

                    case "÷":

                        //No se puede dividir en disimales arraglar error

                            a = Integer.parseInt(numero_1);
                            b = Integer.parseInt(numero_2);

                            resultado = a/b;
                            int resultado_desimal =  resultado;
                            parsResultado = String.valueOf(resultado_desimal);

                       // numero1 = parsResultado;
                       // numero2=null;

                            //numero1 = parsResultado;
                            Toast.makeText(getApplicationContext() , a + "/" + b + "=" + resultado , Toast.LENGTH_LONG).show();
                            textView2.setText(parsResultado);
                            textView2.setTextColor(Color.GRAY);
                        break;
                }

            } catch (Exception e) {
                textView2.setText("Erro en la sintaxis.");
                textView2.setTextColor(Color.parseColor("#BF3632"));
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_home , menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {

                case R.id.radianes:

                    if (radianesYdeg == null) {
                        radianesYdeg = "RAD";
                        item.setTitle("RAD");
                        Toast.makeText(getApplicationContext() , "Modo radianes" , Toast.LENGTH_LONG).show();
                    } else if (radianesYdeg == "RAD") {
                        radianesYdeg = "DEG";
                        item.setTitle("DEG");
                        Toast.makeText(getApplicationContext() , "Modo DEG" , Toast.LENGTH_LONG).show();
                    } else {
                        radianesYdeg = "RAD";
                        item.setTitle("RAD");
                        Toast.makeText(getApplicationContext() , "Modo radianes" , Toast.LENGTH_LONG).show();
                    }

                    break;

                case R.id.historial:
                    startActivity(new Intent(MainActivity.this , HistorialActivity.class));
                    break;
            }

            return super.onOptionsItemSelected(item);
        }

        public void getLong () {

            String cadena = textView.getText().toString();
            int getNumber = cadena.length();
            String a = String.valueOf(getNumber);

            if (getNumber == 13) {
                textView.setTextSize(30.0f);
            } else if (getNumber == 18) {
                textView.setTextSize(27.0f);
            }

        }

    }