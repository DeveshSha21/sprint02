package com.cg.drinkdelight.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.drinkdelight.dao.ProductDAO;
import com.cg.drinkdelight.dao.RawMaterialDAO;
import com.cg.drinkdelight.entity.ProductStock;
import com.cg.drinkdelight.entity.RawMaterialStock;
import com.cg.drinkdelight.exception.ProductException;
import com.cg.drinkdelight.exception.RawMaterialException;
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService{
	@Autowired
	private RawMaterialDAO mDao;
	@Autowired
	private ProductDAO pDao;

	@Override
	public RawMaterialStock trackRawMaterialOrder(Integer productId) {
		Optional<RawMaterialStock> op=mDao.findById(productId);
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		return  op.get();
	}

	@Override
	public List<RawMaterialStock> displayProduct() {
		System.out.println(mDao.getClass().getName());
		List<RawMaterialStock> list = mDao.findAll();
        return list;
	}

	@Override
	public RawMaterialStock setProcessDate(Integer productId,Date processDate) {
		Optional<RawMaterialStock> op=mDao.findById(productId);
		RawMaterialStock rm=null;
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		else
		{
			rm=op.get();
			rm.setProcessDate(processDate); 
			mDao.save(rm);
			System.out.println("Process date is inserted");
		}
		return rm;
	}

	@Override
	public RawMaterialStock updateMfExpDate(@Valid Integer productId, Date mfDate, Date expDate) {
		Optional<RawMaterialStock> op=mDao.findById(productId);
		RawMaterialStock rm=null;
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		else
		{
			rm=op.get();
			rm.setMfgDate(mfDate);
			rm.setExpiryDate(expDate); 
			mDao.save(rm);
			System.out.println(" Manufacturing Date, Expiry Date  is inserted");
		}
		return rm;
	}

	@Override
	public ProductStock trackProductOrder(Integer pId) 
	{
		Optional<ProductStock> op=pDao.findById(pId);
		if(!op.isPresent())
			throw new ProductException("No Product Found For Product id: "+pId);
		return  op.get();
	}

	@Override
	public ProductStock setExitDate(@Valid Integer pId, Date exitDate) {
		
		Optional<ProductStock> op=pDao.findById(pId);
		ProductStock prod=null;
		if(!op.isPresent())
			throw new ProductException("No Raw Material Found For Product id: "+pId);
		else
		{
			prod=op.get();
			prod.setExitDate(exitDate); 
			pDao.save(prod);
			System.out.println("Exit date is inserted");
		}
		return prod;
	}

	@Override
	public ProductStock updateMfExpProdDate(@Valid Integer pId, Date mfDate, Date expDate) {
	
		Optional<ProductStock> op=pDao.findById(pId);
		ProductStock prod=null;
		if(!op.isPresent())
			throw new ProductException("No Product Found For Product id: "+pId);
		else
		{
			prod=op.get();
			prod.setMfDate(mfDate);
			prod.setExpDate(expDate); 
			pDao.save(prod);
			System.out.println(" Manufacturing Date, Expiry Date  is inserted");
		}
		return prod;
		
	}

	@Override
	public List<ProductStock> displayAllProduct() {
		System.out.println(pDao.getClass().getName());
		List<ProductStock> list = pDao.findAll();
        return list;
	}

	@Override
	public ProductStock updatePDeliveryDate(@Valid Integer pId, Date pDeliveryDate) {
		Optional<ProductStock> op=pDao.findById(pId);
		ProductStock prod=null;
		if(!op.isPresent())
			throw new RawMaterialException("No ProductFound For Product id: "+pId);
		else
		{
			prod=op.get();
			prod.setpDeliveryDate(pDeliveryDate);
			pDao.save(prod);
			System.out.println(" Manufacturing Date, Expiry Date  is inserted");
		}
		return prod;
	}

	@Override
	public RawMaterialStock updateRmDeliveryDate(@Valid Integer productId, Date deliveryDate) {
		Optional<RawMaterialStock> op=mDao.findById(productId);
		RawMaterialStock rm=null;
		if(!op.isPresent())
			throw new RawMaterialException("No Raw Material Found For Product id: "+productId);
		else
		{
			rm=op.get();
			rm.setDeliveryDate(deliveryDate);
			mDao.save(rm);
			System.out.println("Delivery Status updated for product id:"+productId);
		}
		return rm;
	}

	@Override
	public RawMaterialStock addRawMaterialStocks(Integer id, String name, Integer quantity) {
		
		Optional<RawMaterialStock> op=mDao.findById(id);
		RawMaterialStock rm=null;
		int a=(int) (200 + (Math.random() * 1000));
			rm=op.get();
			rm.setId(id);
			rm.setName(name);
			rm.setQuantity(quantity);
			rm.setUnitPrice(a);
			
			mDao.save(rm);
		
		return rm;
		
	}

	@Override
	public RawMaterialStock addRawMaterialStocks(@Valid RawMaterialStock rm) {
		RawMaterialStock rm1=new RawMaterialStock();
			rm1.setId(rm.getId());
			rm1.setName(rm.getName());
			rm1.setQuantity(rm.getQuantity());
			rm1.setUnitPrice(rm.getUnitPrice());
			mDao.save(rm1);
		
		return rm1;
	}

	@Override
	public ProductStock addProduct(@Valid ProductStock prod) {
		ProductStock prod1=new ProductStock();
		prod1.setpId(prod.getpId());
		prod1.setpName(prod.getpName());
		prod1.setpQuantity(prod.getpQuantity());
		prod1.setpPrice(prod.getpPrice());
		pDao.save(prod1);
		return prod1;
	}


}
