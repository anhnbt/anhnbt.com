package com.anhnbt.blog.model;

import com.anhnbt.blog.entities.Nickname;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {
    private String code;
    private String message;
    private Object data;
}
