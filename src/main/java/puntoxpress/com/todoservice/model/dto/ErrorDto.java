package puntoxpress.com.todoservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorDto {
	private String code;
	private String id;
	private LocalDateTime date;
	private String detail;
	private String title;
}
