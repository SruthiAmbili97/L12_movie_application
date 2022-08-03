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
        tvYear.setText(movieItem.getYear()+"");
        if (movieItem.getRating().equals("G")){
            ivRating.setImageResource(R.drawable.rating_g);
        }else if(movieItem.getRating().equals("M18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else if(movieItem.getRating().equals("NC16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else if(movieItem.getRating().equals("PG")) {
            ivRating.setImageResource(R.drawable.rating_pg);
        }else if(movieItem.getRating().equals("PG13")) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        }else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }



        return rowView;
    }

}
