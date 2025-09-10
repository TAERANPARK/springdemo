package com.multi.di.di3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//보일러 플레이트 코드
//해결문법 @-
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Member {
    private Long id;
    private String name;
}
