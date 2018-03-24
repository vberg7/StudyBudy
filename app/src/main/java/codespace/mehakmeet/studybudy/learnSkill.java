package codespace.mehakmeet.studybudy;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.fabtransitionactivity.SheetLayout;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.adapter.lsAdapter;
import codespace.mehakmeet.studybudy.model.ls_model;


/**
 * A simple {@link Fragment} subclass.
 */
public class learnSkill extends Fragment {

    RecyclerView rv;
    ArrayList<ls_model> mainList;
    public learnSkill() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_learn_skill, container, false);

        String skill_sel=getArguments().getString("skills");
        mainList=new ArrayList<>();
        mainList.add(new ls_model("Resources","This will help you to get stronger basics by providing straight forward description of the selected language."
        ,R.drawable.resources_ic,skill_sel.toLowerCase()));
        mainList.add(new ls_model("Quiz","Take a quiz to know how good of a grip you have on the language.",
                R.drawable.quiz,skill_sel.toLowerCase()));
        mainList.add(new ls_model("Code Sheet","A cheat sheet for quickly remembering of some tricky codes.",
                R.drawable.cheat,skill_sel.toLowerCase()));

        rv=v.findViewById(R.id.rv_ls);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new lsAdapter(getActivity(),mainList));


        return v;
    }


}
