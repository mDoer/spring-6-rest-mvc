package mdoer.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Customer {
    private String customerName;
    private String version;
    private UUID customerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
