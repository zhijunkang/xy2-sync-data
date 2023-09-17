package com.xy2.bean;

import com.xy2.entity.Usertable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class UserDataBean {
    private Usertable userTable;

    private List<RoleDataBean> roleDataBeans;

}
