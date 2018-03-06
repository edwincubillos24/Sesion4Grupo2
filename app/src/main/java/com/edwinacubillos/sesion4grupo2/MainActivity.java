package com.edwinacubillos.sesion4grupo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eProyecto, ePractica, eAvance;
    TextView tNotaF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Método","onCreate");

        eProyecto =  findViewById(R.id.eProyecto);
        ePractica =  findViewById(R.id.ePractica);
        eAvance =  findViewById(R.id.eAvance);
        tNotaF =  findViewById(R.id.tNotaF);
    }

    public void onButtonClicked(View view) {
        Double proy, pract, avan,notaF;
        proy = Double.parseDouble(eProyecto.getText().toString());
        pract = Double.parseDouble(ePractica.getText().toString());
        avan = Double.parseDouble(eAvance.getText().toString());

        notaF = proy * 0.6 + pract * 0.2 + avan * 0.2;

        tNotaF.setText(String.valueOf(notaF));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK){
            eProyecto.setText(String.valueOf(data.getExtras().getInt("proy")));
            ePractica.setText(String.valueOf(data.getExtras().getInt("lab")));
            eAvance.setText(String.valueOf(data.getExtras().getInt("avance")));
        } else {
            if (requestCode == 1234 && resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Cancelado",Toast.LENGTH_SHORT).show();

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id ==  R.id.mConfig){
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            intent.putExtra("lab",60);
            intent.putExtra("proy",20);
            intent.putExtra("avance",20);
            startActivityForResult(intent,1234);
            //finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Método","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Método","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Método","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Método","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Método","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Método","onDestroy");
    }


}
