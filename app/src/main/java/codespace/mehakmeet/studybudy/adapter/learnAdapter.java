package codespace.mehakmeet.studybudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import codespace.mehakmeet.studybudy.R;

/**
 * Created by MEHAKMEET on 18-03-2018.
 */

public class learnAdapter extends RecyclerView.Adapter<learnAdapter.MyViewHolder> {

    private String[] myList;

   private int[] Learnimgs=new int[]{R.drawable.java_learn,R.drawable.py_learn,R.drawable.html_5_learn,
           R.drawable.android_learn,R.drawable.apple_learn};

    public learnAdapter(String[] myList) {
        this.myList = myList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learn_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.cat_items.setText(myList[position]);
        holder.fd_imgs.setImageResource(Learnimgs[position]);

    }

    @Override
    public int getItemCount() {
        if (myList == null) {
            return 0;
        } else
            return myList.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView fd_imgs;
        TextView cat_items;
        MyViewHolder(View itemView) {
            super(itemView);

            cat_items = itemView.findViewById(R.id.learn_txt);
            fd_imgs= itemView.findViewById(R.id.learn_img);
        }
    }
}
