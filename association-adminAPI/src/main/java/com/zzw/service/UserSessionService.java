package com.zzw.service;

public interface UserSessionService {
    void saveUserSession(String token,int userId);

    int getUserId(String token);

    void removeUserSession(String token);

    void updateUserSession(String token);

    boolean isUserTokenExist(String token);
}
