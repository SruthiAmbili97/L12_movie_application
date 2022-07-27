package sg.edu.rp.c346.id21023701.movieapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<movie> movieList;

    public CustomerAdapter(Context context,int resource,ArrayList<movie> objects){
        super(context, resource,objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context. getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle1);
        TextView tvGenre = rowView.findViewById(R.id.tvGenere1);
        TextView tvYear = rowView.findViewById(R.id.tvYear1);
        ImageView ivRating = rowView.findViewById(R.id.imageView);

        movie movieItem = movieList.get(position);
        tvTitle.setText(movieItem.getTitle());
        tvGenre.setText(movieItem.getGenre());
        tvYear.setText(movieItem.getYear());
        if (movieItem.getGender()== 'F'){
            ivGender.setImageResource(R.drawable.female);
        }else{
            ivGender.setImageResource(R.drawable.male);

        }


        return rowView;
    }

}
