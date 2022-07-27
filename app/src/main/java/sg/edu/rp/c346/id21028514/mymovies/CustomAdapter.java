package sg.edu.rp.c346.id21028514.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        TextView tvSong = rowView.findViewById(R.id.tvSong);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvStar = rowView.findViewById(R.id.tvStar);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);

        //OBTAIN THE SONG INFORMATION BASED ON THE POSITITION
        Movies currentVersion = arrayList.get(position);

        //SET VALUES TO THE TEXTVIEW TO DISPLAY THE CORRESPONDING INFORMATION
        tvSong.setText(currentVersion.getNoteContent());
        tvSinger.setText(currentVersion.getNoteContent2());
        tvYear.setText(currentVersion.getNoteContent3());


        String star = "";
        if (currentVersion.getNoteContent4() == 1) { star = "*"; }
        else if (currentVersion.getNoteContent4() == 2) { star = "**"; }
        else if (currentVersion.getNoteContent4() == 3) { star = "***"; }
        else if (currentVersion.getNoteContent4() == 4) { star = "****"; }
        else if (currentVersion.getNoteContent4() == 5) { star = "*****"; }
        tvStar.setText(star);

        return rowView;
    }
}
