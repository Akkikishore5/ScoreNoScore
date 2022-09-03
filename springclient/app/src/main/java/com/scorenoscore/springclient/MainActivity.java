package com.scorenoscore.springclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.scorenoscore.springclient.adapter.MessageAdapter;
import com.scorenoscore.springclient.model.Message;
import com.scorenoscore.springclient.retrofit.MessageAPI;
import com.scorenoscore.springclient.retrofit.RetrofitService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMessages();
        initializeComponents();

    }

    private void loadMessages(){
        RetrofitService retrofitService = new RetrofitService();
        MessageAPI messageAPI = retrofitService.getRetrofit().create(MessageAPI.class);

        messageAPI.getAllMessages()
                .enqueue(new Callback<List<Message>>() {
                    @Override
                    public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Message>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Messages Failed to Load", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error Occurred");
                    }
                });
    }

    private void populateListView(List<Message> messageList) {
        MessageAdapter messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
    }

    private void initializeComponents() {
        Spinner gameSelector = (Spinner) findViewById(R.id.game_selector);

        ArrayAdapter<String> gameAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.games));

        gameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameSelector.setAdapter(gameAdapter);

        TextInputEditText inputEditText = findViewById(R.id.message);
        MaterialButton button = findViewById(R.id.button);

        RetrofitService retrofitService = new RetrofitService();
        MessageAPI messageAPI = retrofitService.getRetrofit().create(MessageAPI.class);

        button.setOnClickListener(view -> {
            String messageContent = String.valueOf(inputEditText.getText());
            String game = gameSelector.getSelectedItem().toString();

            Message message = new Message();
            message.setMessage(messageContent);
            message.setGame(game);

            messageAPI.save(message)
                    .enqueue(new Callback<Message>() {
                        @Override
                        public void onResponse(Call<Message> call, Response<Message> response) {
                            Toast.makeText(MainActivity.this, "Message Sent Successfully", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Message> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Message Send Successful", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error Occurred");
                        }
                    });
        });
    }
}