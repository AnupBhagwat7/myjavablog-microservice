package in.myjavablog.notifications;

import in.myjavablog.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest) {

        Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .sender(notificationRequest.getSender())
                .sent_to_email(notificationRequest.getSent_to_email())
                .sent_to_customerid(notificationRequest.getSent_to_customerid())
                .sentAt(notificationRequest.getSentAt())
                .build();
        notificationRepository.save(notification);
        log.info("Notification sent successfully using Feign client for customer id : {} ", notification.getSent_to_customerid());
    }

    @KafkaListener(topics = "notifications_topic", groupId = "customer-notification-group", containerFactory = "notificationListener")
    public void sendNotification(NotificationRequest notificationRequest){
        System.out.println("Notification received from Kafka topic: "+ notificationRequest.toString());
        Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .sender(notificationRequest.getSender())
                .sent_to_email(notificationRequest.getSent_to_email())
                .sent_to_customerid(notificationRequest.getSent_to_customerid())
                .sentAt(notificationRequest.getSentAt())
                .build();
        notificationRepository.save(notification);
        log.info("Notification sent successfully using Kafka topic asynchronous communication for customer id : {} ", notificationRequest.getSent_to_customerid());
    }
}
