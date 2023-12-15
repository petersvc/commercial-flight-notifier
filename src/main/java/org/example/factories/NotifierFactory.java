package org.example.factories;

import org.example.models.EmailNotifier;
import org.example.models.Notifier;
import org.example.models.PushNotifier;
import org.example.models.SMSNotifier;

public class NotifierFactory {
    public static Notifier create(int notifierType) {
        return switch (notifierType) {
            case 1 -> new SMSNotifier();
            case 2 -> new EmailNotifier();
            case 3 -> new PushNotifier();
            default -> throw new IllegalArgumentException("Notificação não reconhecida: " + notifierType);
        };
    }
}
