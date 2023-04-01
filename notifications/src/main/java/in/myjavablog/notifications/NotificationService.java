package in.myjavablog.notifications;

import in.myjavablog.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("Notification is sent successfully with id : {} ", notification.getId());
    }
}
