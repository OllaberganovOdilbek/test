/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.filter;

import com.google.gson.GsonBuilder;
import extp.store.services.CookieService;

/**
 *
 * @author Ollaberganov-PC
 */
public class BaseFilter extends FilterService {

    public BaseFilter(CookieService cookieservice, GsonBuilder gsonBuilder) {
        this.cookieservice = cookieservice;
        this.gsonBuilder = gsonBuilder;        
    }
}