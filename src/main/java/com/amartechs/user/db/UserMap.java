package com.amartechs.user.db;

import java.util.HashMap;
import java.util.Map;

import com.amartechs.user.ui.model.UserResponseModel;

public class UserMap {
	static Map<String, UserResponseModel> users = new HashMap<>();

	public static void saveUser(UserResponseModel user) {
		if(users.get(user.getUserName())!=null){
			users.put(user.getUserName(), user);
		}else {
			users.put(user.getUserName(), user);
		}
	}

	public static UserResponseModel getUser(String userId) {
		return users.get(userId);
	}

}
