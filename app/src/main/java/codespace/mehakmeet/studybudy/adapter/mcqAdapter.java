package codespace.mehakmeet.studybudy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.R;
import codespace.mehakmeet.studybudy.model.quiz_model;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class mcqAdapter extends RecyclerView.Adapter<mcqAdapter.ViewHolder> {

    private final ArrayList<quiz_model> mainList;

    private Context context;

    public mcqAdapter(Context context, ArrayList<quiz_model> mainList) {

        this.context = context;
        this.mainList = mainList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.mcq_lay, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tit1.setText(mainList.get(position).getM1());
        holder.tit1.setText(mainList.get(position).getM2());
        holder.tit1.setText(mainList.get(position).getM3());
        holder.tit1.setText(mainList.get(position).getAns());

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tit1, tit2, tit3, tit4;

        LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);
            tit1 = itemView.findViewById(R.id.mcq_txt1);
            tit2 = itemView.findViewById(R.id.mcq_txt2);
            tit3 = itemView.findViewById(R.id.mcq_txt3);
            tit4 = itemView.findViewById(R.id.mcq_txt4);
            ll=itemView.findViewById(R.id.ll_mcq);
        }

    }
}