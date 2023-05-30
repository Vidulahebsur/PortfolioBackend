package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.ThemeAsset;

@Repository
public interface ThemeAssetRepo extends JpaRepository <ThemeAsset,Integer>{

}
