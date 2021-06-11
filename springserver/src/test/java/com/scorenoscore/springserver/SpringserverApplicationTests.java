package com.scorenoscore.springserver;

import com.scorenoscore.springserver.model.message.Message;
import com.scorenoscore.springserver.model.message.MessageDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringserverApplicationTests {

	@Autowired
	private MessageDAO messageDAO;

	@Test
	void addMessageTest() {
		Message message = new Message();
		message.setGame("Baseball");
		message.setMessage("That pitcher is good");
		messageDAO.save(message);
	}

	//@Test
	void getAllMessages() {
		List<Message> messages = messageDAO.getAllMessages();
		System.out.println(messages);
	}

	//@Test
	void deleteAllMessages() {
		List<Message> messages = messageDAO.getAllMessages();
		for (Message message : messages){
			messageDAO.delete(message);
		}
	}
}
