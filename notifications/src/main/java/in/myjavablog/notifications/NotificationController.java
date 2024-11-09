package in.myjavablog.notifications;

import in.myjavablog.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping("/send")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){

        //notificationService.send(notificationRequest);
        //notificationService.sendNotification(notificationRequest);
    }
}
