package codespace.mehakmeet.studybudy.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.fabtransitionactivity.SheetLayout;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

import codespace.mehakmeet.studybudy.R;
import codespace.mehakmeet.studybudy.cheat_code;
import codespace.mehakmeet.studybudy.model.ls_model;
import codespace.mehakmeet.studybudy.quiz;
import codespace.mehakmeet.studybudy.resources;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class lsAdapter extends RecyclerView.Adapter<lsAdapter.ViewHolder>{

    private final Context context;
    ArrayList<ls_model> mainList;
    public lsAdapter(Context context,ArrayList<ls_model> mainList) {
        this.mainList=mainList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.categ_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tit.setText(mainList.get(position).getTitle());
        holder.det.setText(mainList.get(position).getDetail());
        holder.ic_img.setImageResource(mainList.get(position).getIcon());
        holder.fab.setImageResource(R.drawable.navigation);

        if(holder.efv.isBackSide()){
            holder.efv.flipTheView(false);
        }
        holder.efv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.efv.flipTheView();
            }
        });
        holder.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.sl.expandFab();
            }
        });
        if(position==0) {
            holder.sl.setFabAnimationEndListener(new SheetLayout.OnFabAnimationEndListener() {
                @Override
                public void onFabAnimationEnd() {
                    resources rs = new resources();
                    Bundle args = new Bundle();
                    args.putString("skill", mainList.get(position).getSkill());
                    rs.setArguments(args);
                    FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_lay, rs).addToBackStack(null).commit();
                    holder.sl.contractFab();
                }
            });
        }
       else if(position==2){
            holder.sl.setFabAnimationEndListener(new SheetLayout.OnFabAnimationEndListener() {
                @Override
                public void onFabAnimationEnd() {
                    cheat_code rs = new cheat_code();
                    Bundle args = new Bundle();
                    args.putString("skill", mainList.get(position).getSkill());
                    rs.setArguments(args);
                    FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_lay, rs).addToBackStack(null).commit();
                    holder.sl.contractFab();
                }
            });
        }
        else if(position==1){
            holder.sl.setFabAnimationEndListener(new SheetLayout.OnFabAnimationEndListener() {
                @Override
                public void onFabAnimationEnd() {
                    quiz rs = new quiz();
                    Bundle args = new Bundle();
                    args.putString("skill", mainList.get(position).getSkill());
                    rs.setArguments(args);
                    FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_lay, rs).addToBackStack(null).commit();
                    holder.sl.contractFab();
                }
            });
        }
        else
            Log.i("ad","asdas");

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FloatingActionButton fab;
        SheetLayout sl;

        TextView tit,det;
        ImageView ic_img;
        EasyFlipView efv;
        public ViewHolder(View itemView) {
            super(itemView);
            fab=itemView.findViewById(R.id.fab);
            sl=itemView.findViewById(R.id.bottom_sheet);
            sl.setFab(fab);
            sl.setFabAnimationEndListener((SheetLayout.OnFabAnimationEndListener) context);

            tit=itemView.findViewById(R.id.categ_tit);
            det=itemView.findViewById(R.id.categ_det);
            ic_img=itemView.findViewById(R.id.ic_cat);
            efv=itemView.findViewById(R.id.flipview);
        }
    }
}
