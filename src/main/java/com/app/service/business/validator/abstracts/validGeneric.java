package com.app.service.business.validator.abstracts;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo //
 */
public abstract class validGeneric<T> {

    private List<String> messages;

    public validGeneric() {
        messages = new ArrayList<String>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
