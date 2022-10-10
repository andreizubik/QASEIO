package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class APIResponse {
    boolean status;
    Project result;

}
