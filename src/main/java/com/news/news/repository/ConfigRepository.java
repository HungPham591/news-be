package com.news.news.repository;

import com.news.news.entity.ConfigApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<ConfigApp, Long> {
}
