package com.example.retrofitexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<RealworldArticle> list;
    Context context;

    public RecyclerViewAdapter(List<RealworldArticle> list,Context context){
        super();
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.article_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        RealworldArticle realworldArticle = list.get(position);

        Glide
                .with(context)
                .load(realworldArticle.realworldAuthor.image)
                .into(holder.profileImg);
        holder.nameText.setText(realworldArticle.realworldAuthor.username);
        holder.titleText.setText(realworldArticle.title);
        holder.contentsText.setText(realworldArticle.body);
        holder.likeText.setText(""+realworldArticle.favoritesCount);
        holder.dateText.setText(realworldArticle.createdAt);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImg;
        TextView nameText;
        TextView contentsText;
        TextView likeText;
        TextView titleText;
        TextView dateText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.profile_img);
            nameText = itemView.findViewById(R.id.name_text);
            contentsText = itemView.findViewById(R.id.contents_text);
            likeText = itemView.findViewById(R.id.like_text);
            titleText = itemView.findViewById(R.id.title_text);
            dateText = itemView.findViewById(R.id.date_text);
        }
    }

}
