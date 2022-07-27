package sg.edu.rp.c346.id21028514.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> arrayList;

    public CustomAdapter(Context context, int resource, ArrayList<Movies> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        arrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //OBTAIN THE LAYOUT INFLATER OBJECT-TO LET THE VIEW CAN SHOW
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //"INFLATE" THE VIEW FOR EACH ROW
        View rowView = inflater.inflate(layout_id, parent, false);

        //OBTAIN THE UI COMPONENTS AND DO THE NECESSARY BINDING
        TextView tvTitle = rowView.findViewById(R.id.showTitle);
        TextView tvGenre = rowView.findViewById(R.id.showGenre);
        TextView tvYear = rowView.findViewById(R.id.showYear);
        TextView tvRating = rowView.findViewById(R.id.showRating);

        Movies currentItem = arrayList.get(position);
        ImageView ivRating = rowView.findViewById(R.id.showRating);

        //OBTAIN THE SONG INFORMATION BASED ON THE POSITION
        Movies currentVersion = arrayList.get(position);

        //SET VALUES TO THE TEXTVIEW TO DISPLAY THE CORRESPONDING INFORMATION
        //tvTitle.setText(currentVersion.getNoteContent());
        //tvGenre.setText(currentVersion.getNoteContent2());
        //tvYear.setText(currentVersion.getNoteContent3());
        //tvRating.setText(currentVersion.getNoteContent4());


        //String star = "";
        //if (currentVersion.getNoteContent4() == 1) { star = "*"; }
        //else if (currentVersion.getNoteContent4() == 2) { star = "**"; }
        //else if (currentVersion.getNoteContent4() == 3) { star = "***"; }
        //else if (currentVersion.getNoteContent4() == 4) { star = "****"; }
        //else if (currentVersion.getNoteContent4() == 5) { star = "*****"; }
        //tvStar.setText(star);

        if(currentItem.getRating() =="G")
        {
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if (currentItem.getRating() =="PG")
        {
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if (currentItem.getRating()=="PG13")
        {
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentItem.getRating()=="NC16")
        {
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentItem.getRating()=="M18")
        {
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if (currentItem.getRating()=="R21")
        {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
