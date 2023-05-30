package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Asset;
import com.demo.model.PortfolioHeader;
import com.demo.model.ThemeAsset;
import com.demo.repository.AssetRepo;
import com.demo.repository.PortfolioHeaderRepo;
import com.demo.repository.ThemeAssetRepo;
import com.demo.service.ThemeAssetService;


@RestController
@RequestMapping("/themeAsset")
@CrossOrigin(origins="*")
public class ThemeAssetController {

	@Autowired
	ThemeAssetService service;
	@Autowired
	AssetRepo assetRepo;
	@Autowired
	ThemeAssetRepo repo;
	
	
	@PostMapping("/addThemeAsset")
	public ResponseEntity<ThemeAsset>addThemeAsset(@RequestBody ThemeAsset themeAsset){
			ThemeAsset object=service.addThemeAsset(themeAsset);
			return new  ResponseEntity<>(object,HttpStatus.OK);
				
			}
		@GetMapping("/fetchThemeAsset")
	    public ResponseEntity<List<ThemeAsset>>fetchThemeAsset(){
		List<ThemeAsset> themeAsset=service.fetchThemeAsset();
		return new ResponseEntity<>(themeAsset,HttpStatus.OK);
	}
}



	

	