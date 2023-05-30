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

import com.demo.exception.DataNotFoundException;
import com.demo.model.Asset;
import com.demo.model.Master;
import com.demo.model.PortfolioComposition;
import com.demo.model.ThemeAsset;
import com.demo.repository.AssetRepo;
import com.demo.repository.ThemeAssetRepo;
import com.demo.service.AssetService;
import com.demo.service.MasterService;


@RestController
@RequestMapping("/asset")
@CrossOrigin(origins="*")
public class AssetController {
	@Autowired
	private AssetRepo assetRepository;
	@Autowired
	private AssetService service;
	@Autowired
	private MasterService masterService;
	
	@RequestMapping("/fetch")
	public void setAssetData() {
		masterService.saveAssetData();
	}

	
	  @PostMapping("/add") public Asset postAsset(@RequestBody Asset asset) {
	  asset=assetRepository.save(asset); return asset; }
  

	@GetMapping("/fetchAsset")
	public ResponseEntity<List<Asset>>getAll(){
		List<Asset> asset=service.fetchAsset();
		return new ResponseEntity<>(asset,HttpStatus.OK);
	}
	
	
//	@GetMapping("/fetchAssetByThemeName/{themeName}")
//	public ResponseEntity<List<Asset>>findByThemeName(@PathVariable String themeName){ 
//			  List<Asset>object=service.findByThemeName(themeName);
//			  if(object.isEmpty())
//			  { 
//				  throw new DataNotFoundException("Given themeName is not available"); 
//				  }
//			  else
//			  { 
//				  return new  ResponseEntity<>(object,HttpStatus.OK);
//				  } 
//			  }
//	}
}