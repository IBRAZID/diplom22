package com.example.diplom22;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPlanetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPlanetFragment extends Fragment {
    private FirebaseServices fbs;
    private Button btnAdd;
    private TextView etName,etGalaxy,etSize,etHabitable;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddPlanetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddPlanetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPlanetFragment newInstance(String param1, String param2) {
        AddPlanetFragment fragment = new AddPlanetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_planet, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        fbs = FirebaseServices.getInstance();
        etName=getView().findViewById(R.id.etPlanetNameAddPlanetFragment);
        etSize=getView().findViewById(R.id.etSizeAddPlanetFragment);
        etGalaxy=getView().findViewById(R.id.etGalaxyAddPlanetFragment);
        etHabitable=getView().findViewById(R.id.etDescriptionAddPlanetFragment);
        btnAdd=getView().findViewById(R.id.btnAddAddPlanetFragment);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data from screen
                String PlanetName = etName.getText().toString();
                String PlanetSize = etSize.getText().toString();
                String Galaxy = etGalaxy.getText().toString();
                String Description = etName.getText().toString();

                // data validation


                // add data to firestore
                Planet product = new Planet(PlanetName,PlanetSize,Galaxy, Description);
                fbs.getFire().collection("planets").add(product).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added!", Toast.LENGTH_SHORT).show();
                        gotoHomeFragment();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure AddProduct: ", e.getMessage());
                    }


                });
            }
        });

    }
    private void gotoHomeFragment(){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, new HomeFragment());
        ft.commit();
    }


}