package com.example.proyecto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView btnNavigation;
FrameLayout fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  asignarReferencias();
    }
    private void asignarReferencias(){
        btnNavigation=findViewById(R.id.btnNavigation);
        btnNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.menu_1){
                    mostraFragmento(new fragmentoSuma());
                    item.setChecked(true);
                }
                if (item.getItemId()==R.id.menu_2){
                    mostraFragmento(new fragmentoMulti());
                    item.setChecked(true);
                }
                if (item.getItemId()==R.id.menu_3){
                    mostraFragmento(new fragmento_divi());
                    item.setChecked(true);
                }
                return false;
            }
        });

    }
    private void mostraFragmento(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}