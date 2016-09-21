package com.example.administrator.javabean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by quick_tech cpc on 2016/9/21.
 */
@Table(name="orders")
public class OrderDb {
    @Column(name = "id", isId = true, autoGen = true)
    public int id;
    @Column(name = "code")
    public String code;
    @Column(name = "plan")
    public boolean isPlan;
    @Column(name = "content")
    public String content;

    public String toString() {
        return "person [id=" + id + ", code=" + code + ", content=" + content +  "]";
    }
}
