package codespace.mehakmeet.studybudy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.StackView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopeer.cardstack.CardStackView;

import java.util.ArrayList;
import java.util.Map;

import codespace.mehakmeet.studybudy.adapter.csvAdapter;
import codespace.mehakmeet.studybudy.model.resource_model;


/**
 * A simple {@link Fragment} subclass.
 */
public class resources extends Fragment {
    String lang;
    RecyclerView rv;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<resource_model> mainList;
    public resources() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_resources, container, false);
        rv=v.findViewById(R.id.rv_res);

         lang=getArguments().getString("skill");
        mainList=new ArrayList<>();

        Log.i("main_size", String.valueOf(mainList.size()));
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new csvAdapter(getActivity(),mainList));
        getData();
        return v;
    }

    private void getData() {
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference(lang);
        Log.i("NAME_SKILL",lang);
        String b;
        if(lang.equals("android")){
        b="a1";
        }
        else if (lang.equals("html")){
            b="h1";
        }
        else
            b="j1";
        myRef.child(b).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.i("data", String.valueOf(dataSnapshot.getValue()));
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    Log.i("dta", String.valueOf(ds.getValue()));
                            String data= String.valueOf(ds.getValue());
                            data.replace("\\n","\n");
                            Log.i("SDFSF",data);
                            String[] splitted=data.split(";");
                            resource_model rm=new resource_model(splitted[0],splitted[1]);
                            mainList.add(rm);
                        }
                        rv.setAdapter(new csvAdapter(getActivity(),mainList));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
