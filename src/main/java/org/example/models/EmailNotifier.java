package org.example.models;

import org.example.models.Notifier;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(String msg) {
        System.out.println("Email: " + msg);
    }
}
