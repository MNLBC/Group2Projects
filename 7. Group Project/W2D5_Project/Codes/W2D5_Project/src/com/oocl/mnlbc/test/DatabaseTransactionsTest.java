package com.oocl.mnlbc.test;

import java.util.List;

import org.junit.Test;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.utils.DatabaseTransactions;
import com.oocl.mnlbc.utils.Timestamp;

public class DatabaseTransactionsTest {
	
	@Test
	public void testGetChatUser() {
		DatabaseTransactions.createUser(new Client("test", "test", "username", "password"));
		Client client = DatabaseTransactions.getChatUser("username", "password");
		assert(client!=null);
	}

	@Test
	public void testGetOnlineUsers() {
		List<Client> check = DatabaseTransactions.getOnlineUsers();
		assert(check.size() >= 1);
	}

	@Test
	public void testDeclareOnline() {
		DatabaseTransactions.createUser(new Client("test", "test", "dummyoffline", "password"));
		int result = DatabaseTransactions.declareOnline(new Client("test", "test", "dummyoffline", "password"), Timestamp.getTimestamp());
		assert(result!=0);
	}

	@Test
	public void testDeclareOffline() {
		DatabaseTransactions.createUser(new Client("test", "test", "dummyonline", "password"));
		DatabaseTransactions.declareOnline(new Client("test", "test", "dummyonline", "password"), Timestamp.getTimestamp());
		int result = DatabaseTransactions.declareOnline(new Client("test", "test", "dummyonline", "password"), Timestamp.getTimestamp());
		assert(result!=0);
	}

	@Test
	public void testVerifyChatUser() {
		assert(DatabaseTransactions.verifyChatUser("username")==true);
	}

	@Test
	public void testCreateUser() {
		int result = DatabaseTransactions.createUser(new Client("test", "test", "createdummy", "password"));
		assert(result!=0);
	}

	@Test
	public void testCreateSession() {
		 int result = DatabaseTransactions.createSession(Timestamp.getTimestamp());
		 assert(result!=0);
	}

	@Test
	public void testSaveMessage() {
		int result = DatabaseTransactions.saveMessage(new Message((long) 1, (long) 1, (long) 1, "test", Timestamp.getTimestamp()));
		assert(result!=0);
	}
	
	@Test
	public void testGetActiveSessionID() {
		long result = DatabaseTransactions.getActiveSessionID();
		assert(result>0);
	}

	@Test
	public void testEndSession() {
		int result = DatabaseTransactions.endSession(DatabaseTransactions.getActiveSessionID(), Timestamp.getTimestamp());
		assert(result!=0);
	}

}
