package kr.ac.hansung.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 인자가 없는 생성자
@AllArgsConstructor // 모든 인자가 있는 생성자
public class ErrorResponse {

	private String errorCode;
	private String errorMsg;
	private String requestURL;
	
}
