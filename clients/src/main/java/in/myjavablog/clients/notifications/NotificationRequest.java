package in.myjavablog.clients.notifications;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationRequest {

    private String message;
    private String sender;
    private String sent_to_email;
    private Integer sent_to_customerid;
    private LocalDateTime sentAt;
}
