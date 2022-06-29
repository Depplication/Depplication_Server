package com.project.Dion.domain.advertising.repository;

import com.project.Dion.domain.advertising.entity.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisingRepository extends JpaRepository<Advertising, String> {
}
