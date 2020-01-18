package thiovan.submission1.activities;

import androidx.appcompat.app.AppCompatActivity;
import thiovan.submission1.R;
import thiovan.submission1.models.Movie;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE_DETAIL = "extra_movie_detail";

    private ImageView mPhoto;
    private TextView mName, mScore, mRuntime, mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE_DETAIL);

        mPhoto.setImageResource(movie.getPhoto());
        mName.setText(movie.getName());
        mScore.setText(String.format("%s%%", movie.getScore()));
        mRuntime.setText(movie.getRuntime());
        mDescription.setText(movie.getDescription());
    }

    private void initView() {
        mPhoto = findViewById(R.id.img_photo);
        mName = findViewById(R.id.txt_name);
        mScore = findViewById(R.id.txt_user_score);
        mRuntime = findViewById(R.id.txt_runtime);
        mDescription = findViewById(R.id.txt_description);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
