package codespace.mehakmeet.studybudy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.R;
import codespace.mehakmeet.studybudy.model.quiz_model;
import codespace.mehakmeet.studybudy.ui.RecyclerItemClickListener;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class quizAdapter extends RecyclerView.Adapter<quizAdapter.ViewHolder> {

    private final ArrayList<quiz_model> mainList;

    private Context context;
    public static int currentPos=0;
    public static int curpos=-1;
    public quizAdapter(Context context, ArrayList<quiz_model> mainList) {

        this.context=context;
        this.mainList=mainList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.quiz_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tit.setText(mainList.get(position).getQ());

        holder.rv_mcq.setLayoutManager(new LinearLayoutManager(context));
        holder.rv_mcq.setAdapter(new mcqAdapter(context,mainList));
        holder.rv_mcq.addOnItemTouchListener(new RecyclerItemClickListener(context.getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(View view, final int position) {

            }}));
        holder.rl.setVisibility(View.GONE);
        if(currentPos==position){
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.rl.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.rl.startAnimation(slideDown);

        }
        holder.cdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tit,det;
        LinearLayout rl;

        RecyclerView rv_mcq;
        CardView cdv;
        public ViewHolder(View itemView) {
            super(itemView);
            tit=itemView.findViewById(R.id.quiz_q);
            det=itemView.findViewById(R.id.details);
            rl=itemView.findViewById(R.id.mcq_lay);
            cdv=itemView.findViewById(R.id.cdv_quiz);
            rv_mcq=itemView.findViewById(R.id.rv_mcq);
        }

    }
}
