package com.cg.drinkdelight.service;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import com.cg.drinkdelight.entity.ProductStock;
import com.cg.drinkdelight.entity.RawMaterialStock;

public interface ApplicationService { 


	RawMaterialStock trackRawMaterialOrder(Integer ProductId);

	List<RawMaterialStock> displayProduct();

	RawMaterialStock setProcessDate(Integer ProductId, Date processDate);

	RawMaterialStock updateMfExpDate(@Valid Integer ProductId, Date mfDate, Date expDate);

	ProductStock trackProductOrder(Integer pId);

	ProductStock setExitDate(@Valid Integer pId, Date exitDate);

	ProductStock updateMfExpProdDate(@Valid Integer pId, Date mfDate, Date expDate);

	List<ProductStock> displayAllProduct();

	ProductStock updatePDeliveryDate(@Valid Integer pId, Date pDeliveryDate);

	RawMaterialStock updateRmDeliveryDate(@Valid Integer ProductId, Date deliveryDate);

	RawMaterialStock addRawMaterialStocks(Integer id, String name, Integer quantity);

	RawMaterialStock addRawMaterialStocks(@Valid RawMaterialStock rm);

	ProductStock addProduct(@Valid ProductStock prod);

	
	


}
