package codespace.mehakmeet.studybudy.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.R;
import codespace.mehakmeet.studybudy.model.resource_model;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class cheatAdapter extends RecyclerView.Adapter<cheatAdapter.ViewHolder> {

    private final ArrayList<resource_model> mainList;

    private Context context;

    public cheatAdapter(Context context, ArrayList<resource_model> mainList) {

        this.context = context;
        this.mainList = mainList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cheat_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tit.setText(mainList.get(position).getTitle());
        holder.det.setText(mainList.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tit, det;
        public ViewHolder(View itemView) {
            super(itemView);
            tit = itemView.findViewById(R.id.tit_cheat);
            det = itemView.findViewById(R.id.desc_cheat);
        }

    }
}