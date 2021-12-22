package com.cg.drinkdelight.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drinkdelight.entity.ProductStock;
import com.cg.drinkdelight.entity.RawMaterialStock;
import com.cg.drinkdelight.service.ApplicationService;

@RestController
@RequestMapping("/DrinkAndDelight")
@Validated
public class ApplicationController {
	@Autowired
	public ApplicationService service;

//	@Autowired
//	private ICustomerRegister cRegister;

	@GetMapping("/raw_material/by/id/{rmId}")
	public ResponseEntity<RawMaterialStock> trackRawMaterialOrder(@PathVariable("rmId") Integer productId) {
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterialStock material = service.trackRawMaterialOrder(productId);
		return new ResponseEntity<RawMaterialStock>(material, HttpStatus.OK);
	}

	@GetMapping("/raw_material/display_raw_material")
	public ResponseEntity<List<RawMaterialStock>> displayProduct() {
		List<RawMaterialStock> material = service.displayProduct();
		return new ResponseEntity<List<RawMaterialStock>>(material, HttpStatus.OK);
	}

	@GetMapping("/raw_material/setDate/{rmId}/{processdate}")
	public ResponseEntity<RawMaterialStock> setProcessDate(@PathVariable("rmId") Integer productId,
			@PathVariable("processdate") Date processDate) {
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterialStock material = service.setProcessDate(productId, processDate);
		return new ResponseEntity<RawMaterialStock>(material, HttpStatus.OK);
	}

	@GetMapping("/raw_material/setDate/{rmId}/{mfdate}/{expdate}")
	public ResponseEntity<RawMaterialStock> updateMfExpDate(@PathVariable("rmId") Integer productId,
			@PathVariable("mfdate") Date mfDate, @PathVariable("expdate") Date expDate) {
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterialStock material = service.updateMfExpDate(productId, mfDate, expDate);
		return new ResponseEntity<RawMaterialStock>(material, HttpStatus.OK);
	}

	@GetMapping("/product/by/{pId}")
	public ResponseEntity<ProductStock> trackOrder(@PathVariable("pId") Integer pId) {
		System.out.println("cntrlr fetch productId: " + pId);
		ProductStock prod = service.trackProductOrder(pId);
		return new ResponseEntity<ProductStock>(prod, HttpStatus.OK);
	}

	@GetMapping("/product/setDate/{pId}/{exitDate}")
	public ResponseEntity<ProductStock> setExitDate(@PathVariable("pId") Integer pId,
			@PathVariable("exitDate") Date exitDate) {
		System.out.println("cntrlr fetch productId: " + pId);
		ProductStock prod = service.setExitDate(pId, exitDate);
		return new ResponseEntity<ProductStock>(prod, HttpStatus.OK);
	}

	@GetMapping("/product/Date/{pid}/{mfdate}/{expdate}")
	public ResponseEntity<ProductStock> updateMfExpProdDate(@PathVariable("pid") Integer pId,
			@PathVariable("mfdate") Date mfDate, @PathVariable("expdate") Date expDate) {
		System.out.println("cntrlr fetch productId: " + pId);
		ProductStock prod = service.updateMfExpProdDate(pId, mfDate, expDate);
		return new ResponseEntity<ProductStock>(prod, HttpStatus.OK);
	}

	@GetMapping("/product/display_products")
	public ResponseEntity<List<ProductStock>> displayAllProduct() {
		List<ProductStock> prod = service.displayAllProduct();
		return new ResponseEntity<List<ProductStock>>(prod, HttpStatus.OK);
	}

	@GetMapping("/product/delivery_status/{pid}/{status}")
	public ResponseEntity<ProductStock> updateDeliveryStatusOfProduct(@Valid @PathVariable("pid") Integer pId,
			@PathVariable("PdeliveryDate") Date pDeliveryDate) {
		System.out.println("cntrlr fetch productId: " + pId);
		ProductStock prod = service.updatePDeliveryDate(pId, pDeliveryDate);
		return new ResponseEntity<ProductStock>(prod, HttpStatus.OK);
	}

	@GetMapping("/raw_material/delivery_status/{rmId}/{status}")
	public ResponseEntity<RawMaterialStock> updateDeliveryStatusOfRawMaterial(
			@Valid @PathVariable("rmId") Integer productId, @PathVariable("deliveryDate") Date deliveryDate) {
		System.out.println("cntrlr fetch productId: " + productId);
		RawMaterialStock rm = service.updateRmDeliveryDate(productId, deliveryDate);
		return new ResponseEntity<RawMaterialStock>(rm, HttpStatus.OK);
	}

	@PostMapping("raw_material/place_order")
	public ResponseEntity<RawMaterialStock> placeRawMaterialOrder(@RequestBody @Valid RawMaterialStock rm) {
		RawMaterialStock rm1 = service.addRawMaterialStocks(rm);

		return new ResponseEntity<RawMaterialStock>(rm1, HttpStatus.OK);
	}

	@PostMapping("product/place_order")
	public ResponseEntity<ProductStock> placeProductOrder(@RequestBody @Valid ProductStock prod) {
		ProductStock prod1 = service.addProduct(prod);

		return new ResponseEntity<ProductStock>(prod1, HttpStatus.OK);
	}

}
