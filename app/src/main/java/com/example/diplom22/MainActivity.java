package com.example.diplom22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FirebaseServices fbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbs=FirebaseServices.getInstance();
        if(fbs.getAuth().getCurrentUser()==null){
            gotoLoginFragment();
        }
        else {
            gotoHomeFragment();
        }
    }

    private void gotoHomeFragment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain,new HomeFragment());
        ft.commit();
    }

    private void gotoLoginFragment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain,new LoginFragment());
        ft.commit();
}}