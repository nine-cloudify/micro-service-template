package com.nine.app.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author wangjia at 2018/4/8 下午8:46
 */

@Slf4j
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建时间
     */
    @Column(name = "create_date", nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @CreatedBy
    @Column(name = "create_user", nullable = false)
    private Long createUser;
    /**
     * 更新时间
     */
    @Column(name = "update_date", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @LastModifiedBy
    @Column(name = "update_user", nullable = false)
    private Long updateUser;

    /**
     * 是否删除
     * 0-未删除 1-已删除
     */
    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted;

}

