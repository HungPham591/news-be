package com.news.news.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CONFIG")
public class Config extends BaseEntity<Config> {
}
