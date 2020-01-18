package thiovan.submission1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import thiovan.submission1.R;
import thiovan.submission1.models.Movie;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            //Menghubungkan ViewHolder dengan View
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        //Mengubah nilai pahlawan sesuai dari posisinya
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder {
        private final TextView txtName;
        private final TextView txtDescription;
        private final ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie movie) {
            txtName.setText(movie.getName());
            txtDescription.setText(movie.getDescription());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
