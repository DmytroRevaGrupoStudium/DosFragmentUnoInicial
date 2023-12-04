package es.studium.pruebafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Fragment fragmentPrincipal;
    Fragment fragmentSegundario;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        if (savedInstanceState == null)
        {
            crearMainFragment();
        }
    }

    private void crearMainFragment()
    {
        fragmentPrincipal = new PrimerFragment();

        ft = fm.beginTransaction();
        ft.replace(R.id.contenedorFragmentos, fragmentPrincipal);
        ft.commitNow();
    }


    @Override
    public void onClick(View v) {
        cambiarFragmento();
    }

    private void cambiarFragmento()
    {
        fragmentSegundario = new SegundoFragment();

        ft = fm.beginTransaction();
        ft.replace(R.id.contenedorFragmentos, fragmentSegundario);
        ft.commitNow();
    }
}