package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Asset;

@Repository
public interface AssetRepo extends JpaRepository<Asset,String> {
//    @Query("select a from Asset a where a.themeAsset.themeName=?1")
//	List<Asset> findByThemeName(String themeName);

}
