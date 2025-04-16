package com.psyzane.quizup;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> posts = new ArrayList<>();
    private int nextPostId = 0;

    //Limiting the number of posts
    private int totalNumberOfPosts = 100;
    private boolean isLastPageLoaded = false;
    private RecyclerView.OnScrollListener scrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.postsRecyclerView);
        postAdapter = new PostAdapter(posts);
        recyclerView.setAdapter(postAdapter);

        //Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Add initial post
        addMorePosts(1);
        addMorePosts(20);
//        addMorePosts(101);
//        addMorePosts();

        //Detect end of the list
        scrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                // check if there are more posts to add
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && !isLastPageLoaded) {
                    addMorePosts(1);

                    Log.i("my app", "post size" + posts.size());
                }
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
    }

    private void addMorePosts(int size){
        if(posts.size() >= totalNumberOfPosts)
            return;
        List<Post> newPosts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newPosts.add(new Post(nextPostId++, "this is a new post no. " + nextPostId));
        }
        postAdapter.addPost(newPosts);

        // Log for post size
        Log.i("my app", "post size on scroll" + posts.size());

        //Check if there are no more posts to add
        if (posts.size() > totalNumberOfPosts){
            isLastPageLoaded = true;
            recyclerView.removeOnScrollListener(scrollListener);
        }
    }
}