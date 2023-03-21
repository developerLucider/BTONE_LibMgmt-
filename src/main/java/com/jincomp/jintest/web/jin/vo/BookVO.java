
package com.jincomp.jintest.web.jin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class BookVO {

	private String goodsId;
	private String goodsName;
	private String goodsPrice;
	private String eventId;
	
	private EventVO eventVo;
	private RentVO rentVo;
	//모현진
	private UserLogin userLogin;
	private BooksEventInfo eventInfo;

}