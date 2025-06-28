package com.example.projeck.ui.user.movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.projeck.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import android.util.Log;
public class MovieDetailFragment  extends Fragment{



    private ImageView imageBanner;
    private TextView textTitle, textStatus, textGener, textDescription;
    private Button btnBookTicket;

    private DatabaseReference movieRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        imageBanner = view.findViewById(R.id.imageBanner);
        textTitle = view.findViewById(R.id.textTitle);
        textStatus = view.findViewById(R.id.textStatus);
        textGener = view.findViewById(R.id.textGener);
        textDescription = view.findViewById(R.id.textDescription);
        btnBookTicket = view.findViewById(R.id.btnBookTicket);

        // ✅ Chỉ dùng đúng 1 lần và đúng key
        String movieId = null;
        Log.d("DEBUG", "movieId nhận được là: [" + movieId + "]");

        if (getArguments() != null) {
            movieId = getArguments().getString("movieId"); // đúng key!
        }

        if (movieId == null || movieId.isEmpty()) {
            Log.e("MovieDetailFragment", "movieId null, không thể tải dữ liệu.");
            return view;
        }


        // ✅ Truy vấn Firebase khi movieId hợp lệ
        movieRef = FirebaseDatabase.getInstance().getReference("movies").child(movieId);
        movieRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String title = snapshot.child("title").getValue(String.class);
                String status = snapshot.child("status").getValue(String.class);
                String gener = snapshot.child("gener").getValue(String.class);
                String description = snapshot.child("description").getValue(String.class);
                String posterUrl = snapshot.child("posterUrl").getValue(String.class);

                Log.d("DEBUG", "posterUrl: " + posterUrl);

                textTitle.setText(title);
                textStatus.setText(status);
                textGener.setText(gener);
                textDescription.setText(description);

                if (getContext() != null) {
                    Glide.with(getContext()).load(posterUrl).into(imageBanner);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Lỗi tải dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });

        btnBookTicket.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Chuyển sang đặt vé...", Toast.LENGTH_SHORT).show();
            // TODO: Chuyển sang màn đặt vé
        });

        return view;
    }
}

