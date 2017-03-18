/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.services;

import extp.store.dto.UserDto;
        
/**
 *
 * @author Ollaberganov-PC
 */

public interface AuthService {
    
    UserDto CheckLoginPassword(String login, String password);
    
    boolean CheckLogin(String login);
    
    boolean SetUser(String fio, String login, String password);
    
}
