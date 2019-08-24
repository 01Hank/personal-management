package com.pm.Pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "maia_user")
public class MaiaUser {

  @Id
  @KeySql(useGeneratedKeys = true)
  private long id;
  private String uid;
  @Column(name = "type")
  private int type;
  @Column(name = "firstName")
  private String firstName;
  @Column(name = "lastName")
  private String lastName;
  private String email;
  private String password;
  private String birth;
  private int cateory;
  private int visiable;
}
