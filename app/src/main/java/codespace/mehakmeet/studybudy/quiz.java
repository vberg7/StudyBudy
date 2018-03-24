package codespace.mehakmeet.studybudy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.irozon.sneaker.Sneaker;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.adapter.quizAdapter;
import codespace.mehakmeet.studybudy.model.quiz_model;


/**
 * A simple {@link Fragment} subclass.
 */
public class quiz extends Fragment {

    String lang;

    RecyclerView rv_quiz;
    RelativeLayout rl;
    FirebaseDatabase database;
    DatabaseReference myRef;

    ArrayList<quiz_model> mainList;
    public quiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_quiz, container, false);
        rv_quiz=v.findViewById(R.id.rv_quiz);
        rl=v.findViewById(R.id.submit_btn);
        lang=getArguments().getString("skill");

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sneaker.with(getActivity())
                        .setTitle("Success!")
                        .setMessage("Quiz Completed Sucessfully:)")
                        .sneakSuccess();
            }
        });
        mainList=new ArrayList<>();
        rv_quiz.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_quiz.setAdapter(new quizAdapter(getContext(),mainList));
        getData();
        return v;
    }
    private void getData() {
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference(lang);
        Log.i("NAME_SKILL",lang);
        String b;
        if(lang.equals("android")){
            b="a2";
        }
        else if (lang.equals("html")){
            b="h2";
        }
        else
            b="j2";
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
                    quiz_model rm=new quiz_model(splitted[0],splitted[1],splitted[2],splitted[3],splitted[4]);
                    mainList.add(rm);
                }
                rv_quiz.setAdapter(new quizAdapter(getContext(),mainList));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
