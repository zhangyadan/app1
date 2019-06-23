package com.example.shappingb.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 张亚丹 on 2019/6/21.
 */
@Entity
public class DatasBean {
@Id(autoincrement = true)
    /**
     * title : Kotlin 新版来了，支持跨平台！
     */

    private Long id;
    private String title;
    private Boolean check;
    @Generated(hash = 1225656480)
    public DatasBean(Long id, String title, Boolean check) {
        this.id = id;
        this.title = title;
        this.check = check;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getCheck() {
        return this.check;
    }
    public void setCheck(Boolean check) {
        this.check = check;
    }
   
   
}