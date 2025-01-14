package com.renato.aeroporto_api.exception.dto;

import java.time.LocalDateTime;

public record ApiResponse(
        String message,     
        String details,     
        LocalDateTime timestamp 
) {
}
