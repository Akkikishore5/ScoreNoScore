package com.scorenoscore.springclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scorenoscore.springclient.R;

public class MessageHolder extends RecyclerView.ViewHolder {
    TextView username, message, game;

    public MessageHolder(@NonNull View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.username);
        message = itemView.findViewById(R.id.messageContent);
        game = itemView.findViewById(R.id.gameName);
    }
}
