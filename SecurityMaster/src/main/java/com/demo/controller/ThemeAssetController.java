package com.demo.controller;

import java.util.ArrayList;
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

import com.demo.dto.AssetResponseDto;
import com.demo.dto.ThemeAssetResponseDto;
import com.demo.exception.DataNotFoundException;
import com.demo.model.Asset;
import com.demo.model.PortfolioHeader;
import com.demo.model.Theme;
import com.demo.model.ThemeAsset;
import com.demo.repository.AssetRepo;
import com.demo.repository.PortfolioHeaderRepo;
import com.demo.repository.ThemeAssetRepo;
import com.demo.repository.ThemeRepo;
import com.demo.service.ThemeAssetService;
;


@RestController
@RequestMapping("/themeAsset")
@CrossOrigin(origins="*")
public class ThemeAssetController {

	@Autowired
	ThemeAssetService service;
	@Autowired
	ThemeRepo themeRepository;
	@Autowired
	AssetRepo assetRepository;
	@Autowired
	ThemeAssetRepo themeAssetRepository;
	
	@PostMapping("/addThemeAllocation")
	public ThemeAsset postAllocation(@RequestBody ThemeAssetResponseDto themeAssetResponseDto)
	{
		Theme theme=new Theme();
		Asset asset=assetRepository.findById(themeAssetResponseDto.getAssetId())
				.orElse(null);
		Theme theme1=themeRepository.findById(themeAssetResponseDto.getThemeName())
				.orElse(null);
		if(theme1==null) {
			theme1=new Theme();
			theme1.setThemeName(themeAssetResponseDto.getThemeName());
			themeRepository.save(theme1);
			
		}
		ThemeAsset themeAsset=new ThemeAsset();
		themeAsset.setAsset(asset);
		themeAsset.setTheme(theme1);
		
		Double allocation=themeAssetRepository.getAllocationByThemeName(themeAssetResponseDto.getThemeName());
		if(allocation==null) {
			allocation=0.0;
		}
		if(allocation+themeAssetResponseDto.getAllocation()>100.0) {
			throw new DataNotFoundException("exceed 100");
		}
		
		themeAsset.setAllocation(themeAssetResponseDto.getAllocation());
		return themeAssetRepository.save(themeAsset);
	}
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
		
		@GetMapping("getByTheme/{themeName}")

		 public List<AssetResponseDto> getByTheme(@PathVariable String themeName){

		 List<ThemeAsset> list=themeAssetRepository.findByThemeName(themeName);

		 List<AssetResponseDto> Dto=new ArrayList<>();

		 for(ThemeAsset theme:list) {

		 AssetResponseDto dto =new AssetResponseDto();

		 dto.setAssetId(theme.getAsset().getAssetId());

		 dto.setAssetClass(theme.getAsset().getAssetClasses());

		 dto.setSubAssetClass(theme.getAsset().getSubAssetClass());

		 dto.setInvestmentHorizon(theme.getAsset().getInvestmentHorizon());

		 dto.setRisk(theme.getAsset().getRisk());

		 dto.setLiquidity(theme.getAsset().getLiquidity());

		 dto.setReturns(theme.getAsset().getReturns());

		 Dto.add(dto);

		 

		 }

		 return Dto;

		 }
}



	

	