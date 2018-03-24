package codespace.mehakmeet.studybudy.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loopeer.cardstack.StackAdapter;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.R;
import codespace.mehakmeet.studybudy.model.resource_model;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class csvAdapter  extends RecyclerView.Adapter<csvAdapter.ViewHolder> {

    private final ArrayList<resource_model> mainList;

    private Context context;
    public static int currentPos=0;
    public csvAdapter(Context context, ArrayList<resource_model> mainList) {

        this.context=context;
        this.mainList=mainList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.stack_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tit.setText(mainList.get(position).getTitle());
        holder.det.setText(mainList.get(position).getDesc());

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
        RelativeLayout rl;

        CardView cdv;
        public ViewHolder(View itemView) {
            super(itemView);
            tit=itemView.findViewById(R.id.tit_item);
            det=itemView.findViewById(R.id.details);
            rl=itemView.findViewById(R.id.slide_lay);
            cdv=itemView.findViewById(R.id.cdv);
        }

    }
}
