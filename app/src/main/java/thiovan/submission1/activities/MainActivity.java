package thiovan.submission1.activities;

import androidx.appcompat.app.AppCompatActivity;
import thiovan.submission1.R;
import thiovan.submission1.adapters.MovieAdapter;
import thiovan.submission1.models.Movie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataScore;
    private String[] dataRuntime;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        prepare();

        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE_DETAIL, movies.get(i));
                startActivity(intent);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataScore = getResources().getStringArray(R.array.data_user_score);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setScore(dataScore[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
