package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Asset;
import com.demo.repository.AssetRepo;

@Service
public class AssetService {
	@Autowired
	AssetRepo repo;

	public Asset addAsset(Asset asset){
		return  repo.save(asset);
	}

	public List<Asset> fetchAsset() {
		return repo.findAll();
	}

//	public List<Asset> findByThemeName(String themeName) {
//		return repo.findByThemeName(themeName);
//	}
}
