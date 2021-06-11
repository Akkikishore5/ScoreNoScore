package com.scorenoscore.springclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.scorenoscore.springclient.R;
import com.scorenoscore.springclient.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

    List<Message> messageList;

    public MessageAdapter(List<Message> messageList){
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        Message message = messageList.get(position);
        holder.username.setText("Akki");
        holder.message.setText(message.getMessage());
        holder.game.setText(message.getGame());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
