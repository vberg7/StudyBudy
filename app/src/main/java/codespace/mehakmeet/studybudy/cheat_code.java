package codespace.mehakmeet.studybudy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.adapter.cheatAdapter;
import codespace.mehakmeet.studybudy.model.resource_model;


/**
 * A simple {@link Fragment} subclass.
 */
public class cheat_code extends Fragment {

    RecyclerView rv;
    FirebaseDatabase database;
    DatabaseReference myRef;

    String lang;
    ArrayList<resource_model> mainList;
    public cheat_code() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_cheat_code, container, false);

        rv=v.findViewById(R.id.rv_cheat);
        lang=getArguments().getString("skill");

        mainList=new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new cheatAdapter(getActivity(),mainList));
        getData();
        return v;
    }
    private void getData() {
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference(lang);
        Log.i("NAME_SKILL",lang);

        myRef.child("cheat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.i("data", String.valueOf(dataSnapshot.getValue()));
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    Log.i("dta", String.valueOf(ds.getValue()));
                    String data= String.valueOf(ds.getValue());
                    Log.i("SDFSF",data);
                    String[] splitted=data.split("#");
                    resource_model rm=new resource_model(splitted[0],splitted[1]);
                    mainList.add(rm);
                }
                rv.setAdapter(new cheatAdapter(getActivity(),mainList));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
