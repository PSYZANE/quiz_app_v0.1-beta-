package com.psyzane.quizup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts){
        this.posts = posts;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView contentTextView;

        public PostViewHolder(View itemView) {
            super(itemView);
            contentTextView = itemView.findViewById(R.id.postContentTextView);
        }
    }

    @NonNull
    @Override
    public  PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post currentPost = posts.get(position);
        holder.contentTextView.setText(currentPost.getContent());
        //set the content description dynamically
        holder.contentTextView.setContentDescription("Post: "+ currentPost.getContent());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void addPost(List<Post> newPosts) {
        int startPosition = posts.size();
        posts.addAll(newPosts);
        notifyItemRangeInserted(startPosition, newPosts.size());
    }
}
