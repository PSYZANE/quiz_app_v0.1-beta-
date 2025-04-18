package com.psyzane.quizup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class test extends LinearLayout {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> posts = new ArrayList<>();
    private int nextPostId = 0;
    private int totalNumberOfPosts = 100; // Let's say we have 100 posts in total. In a real app, this would come from the server.
    private boolean isLastPageLoaded = false;
    private RecyclerView.OnScrollListener scrollListener;

    public test(Context context) {
        super(context);
        init(context);
    }

    public test(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public test(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //Inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.activity_home, this, true);

        recyclerView = view.findViewById(R.id.postsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        postAdapter = new PostAdapter(posts);
        recyclerView.setAdapter(postAdapter);

        //Add initial post
        addMorePosts(1);
        addMorePosts(20);
//        addMorePosts(101);
//        addMorePosts();

        scrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                //Check if there are more posts to add
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0 && !isLastPageLoaded) {
                    addMorePosts(1);
                }
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
    }

    private void addMorePosts(int size) {
        // Checking whether content(post) limit is reached
        if (posts.size() >= totalNumberOfPosts) {

            isLastPageLoaded = true;
            recyclerView.removeOnScrollListener(scrollListener);
            return;
        }

        // Add new posts
        List<Post> newPosts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newPosts.add(new Post(nextPostId++, "this is a new post no. " + nextPostId));
        }
        postAdapter.addPost(newPosts);

        // Log for post size
        Log.i("my app", "post size on scroll" + posts.size());
    }
}