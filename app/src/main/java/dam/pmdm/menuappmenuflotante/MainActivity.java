package dam.pmdm.menuappmenuflotante;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);

        setSupportActionBar(findViewById(R.id.myToolBar));

        findViewById(R.id.txtTexto).setOnLongClickListener(v -> mostrarMenuPopUp(v));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean procesado = super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == R.id.opcRojo) {
            cambiarColorFondo(R.color.rojo);
            procesado = true;
        } else if (id == R.id.opcVerde) {
            cambiarColorFondo(R.color.verde);
            procesado = true;
        } else if (id == R.id.opcAzul) {
            cambiarColorFondo(R.color.azul);
            procesado = true;
        } else if (id == R.id.opcSalir) {
            salirApp();
            procesado = true;
        }

        return procesado;
    }

    private boolean mostrarMenuPopUp(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.mnu_flotante, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> opcionMenuFlotante(item));
        popupMenu.show();
        return true;
    }

    private boolean opcionMenuFlotante(MenuItem item) {
        boolean procesado = false;
        int id = item.getItemId();

        if (id == R.id.opcRojo) {
            cambiarColorTexto(R.color.rojo);
            procesado = true;
        } else if (id == R.id.opcVerde) {
            cambiarColorTexto(R.color.verde);
            procesado = true;
        } else if (id == R.id.opcAzul) {
            cambiarColorTexto(R.color.azul);
            procesado = true;
        }

        return procesado;
    }

    private void cambiarColorFondo(int color) {
        findViewById(R.id.fondo).setBackgroundColor(getColor(color));
    }

    private void cambiarColorTexto(int color) {
        ((TextView) findViewById(R.id.txtTexto)).setTextColor(getColor(color));
    }

    private void salirApp() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.ad_salir_tit)
                .setCancelable(false)
                .setMessage(R.string.ad_salir_msg)
                .setNegativeButton(R.string.ad_salir_no, null)
                .setPositiveButton(R.string.ad_salir_si, (dialog, which) -> finish())
                .show();
    }
}