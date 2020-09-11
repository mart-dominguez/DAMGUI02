package tsti.dam.dam.damgui02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;
import java.util.List;

import tsti.dam.dam.damgui02.util.Serie;
import tsti.dam.dam.damgui02.util.Utils;

public class MainActivity extends AppCompatActivity {


    Spinner spinnerGeneros;
    TextView generoElegido;
    ListView listaSerie;
    Button btnLimpiar, btnSeleccionados;
    TextView tvPeliElegida;

    String[] generos = Utils.GENEROS;
    List<Serie> series = Utils.getSeries();
    Integer ultimaSeleccionada =-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGeneros = findViewById(R.id.spinnerGeneros);
        generoElegido = findViewById(R.id.tvGeneroSeleccionado);
        listaSerie = findViewById(R.id.listViewSeries);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        tvPeliElegida = findViewById(R.id.tvPeliElegida);
        btnSeleccionados = findViewById(R.id.btnSeleccionados);
        // generos
        final ArrayAdapter<String> adaptadorGeneros1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,generos);
        final ArrayAdapter<String> adaptadorGeneros2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,generos);
        spinnerGeneros.setAdapter(adaptadorGeneros2);
        //spinnerSerie.setPrompt("ELEGIR SERIE");
        //spinnerSerie.setDropDownVerticalOffset(180);
        // series
        final ArrayAdapter<Serie> adaptadorSerie = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,series);
        //spinnerSerie.setAdapter(adaptadorSerie);
        // evento genero
        spinnerGeneros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String generoTexto = adaptadorGeneros2.getItem(position);
                ultimaSeleccionada = position;
                generoElegido.setText("Selecciono el genero: "+generoTexto+ " ("+ultimaSeleccionada+")");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                generoElegido.setText("--- NADA --- " );
            }
        });

//        spinnerSerie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Serie serieSeleccionada = adaptadorSerie.getItem(position);
//                Toast.makeText(MainActivity.this,"SERIE ELEGIDA "+serieSeleccionada.toString(),Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerGeneros.setSelected(false);
            }
        });



        btnSeleccionados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String elegidos = "";
                SparseBooleanArray filasSeleccionadas = listaSerie.getCheckedItemPositions();
                for(int i=0;i<adaptadorSerie.getCount();i++){
                    if(filasSeleccionadas.get(i)){
                        elegidos += adaptadorSerie.getItem(i).getTitulo();
                    }
                }
                tvPeliElegida.setText(elegidos);
            }
        });
//          adaptador basico
//        listaSerie.setAdapter(adaptadorSerie);

        final ArrayAdapter<Serie> adaptador2 = new ArrayAdapter<>(this,R.layout.fila01,R.id.miTexto,series);
        listaSerie.setAdapter(adaptador2);

        // EVENTOS SOBRE EL LISTVIEW de pelicuas
        listaSerie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Serie unaSerie = adaptador2.getItem(position);
                tvPeliElegida.setText("Item Click --> "+unaSerie.toString());
            }
        });
    }
}