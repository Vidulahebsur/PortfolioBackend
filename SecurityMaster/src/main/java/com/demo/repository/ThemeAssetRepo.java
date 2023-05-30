package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.ThemeAsset;

@Repository
public interface ThemeAssetRepo extends JpaRepository <ThemeAsset,Integer>{
	@Query("select t from ThemeAsset t where t.theme.themeName=?1")
	Double getAllocationByThemeName(String themeName);
	@Query("select a from ThemeAsset a where a.theme.themeName=?1")
	List<ThemeAsset> findByThemeName(String themeName);
}
