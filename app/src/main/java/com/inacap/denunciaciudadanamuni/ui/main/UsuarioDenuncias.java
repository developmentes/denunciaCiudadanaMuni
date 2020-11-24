package com.inacap.denunciaciudadanamuni.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inacap.denunciaciudadanamuni.R;
import com.inacap.denunciaciudadanamuni.model.Denuncia;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class UsuarioDenuncias extends Fragment {

List<Denuncia> lista;
TextView txt;
FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_usuario_denuncias, container, false);

        txt = view.findViewById(R.id.txt_usuario_denuncias);
        auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();

        lista = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Denuncias").child(uid);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()){
                   lista.clear();
                   txt.setText("");

                   for (DataSnapshot ds : dataSnapshot.getChildren()) {

                       Denuncia denuncia = ds.getValue(Denuncia.class);
                       denuncia.setId(ds.getKey());
                       lista.add(denuncia);
                   }
                   for ( Denuncia e: lista) {
                       txt.setText(txt.getText() + e.getId() + e.getTitulo());

                   }
               }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        return  view;

    }
}