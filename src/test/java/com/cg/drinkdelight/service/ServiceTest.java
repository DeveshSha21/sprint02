package com.cg.drinkdelight.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.drinkdelight.entity.ProductStock;
import com.cg.drinkdelight.entity.RawMaterialStock;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ApplicationServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ServiceTest {
	
	@Autowired
	ApplicationServiceImpl service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTrackRawMaterialOrder() {
		RawMaterialStock rm1=service.addRawMaterialStocks(new RawMaterialStock(31,"Wire", 432.0, 4, null ,null,null,null));
		RawMaterialStock rm=service.trackRawMaterialOrder(rm1.getId());
	    assertEquals(rm1.getName(),rm.getName());
	    
		
	}

	@Test
	void testDisplayProduct() {
		RawMaterialStock rm=service.addRawMaterialStocks(new RawMaterialStock(31,"hard disk",413.0,8,null,null,null, null));
		List<RawMaterialStock> rm1=service.displayProduct();
		assertEquals(rm, rm1);
		
	}

	@Test
	void testSetProcessDate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMfExpDate() {
		fail("Not yet implemented");
	}

	@Test
	void testTrackProductOrder() {
		
		ProductStock prod=service.addProduct(new ProductStock(26, "Bike",2346.0, 5, null, null, null, null));
		ProductStock prod1=service.trackProductOrder(prod.getpId());
		assertEquals(prod.getpName(), prod1.getpName());
		
	}

	@Test
	void testSetExitDate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMfExpProdDate() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplayAllProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePDeliveryDate() {
		ProductStock prod=service.addProduct(new ProductStock(26, "Wire", 432, 4,null,null,null,null));
		ProductStock prod1=service.updatePDeliveryDate(prod.getpId(),prod.getpDeliveryDate());
		assertEquals(prod.getpDeliveryDate(),prod1.getpDeliveryDate());
	}

	@Test
	void testUpdateRmDeliveryDate() {
		RawMaterialStock rm1=service.addRawMaterialStocks(new RawMaterialStock(31,"Wire", 432, 4,null,null,null,null));
		RawMaterialStock rm=service.updateRmDeliveryDate(rm1.getId(),rm1.getDeliveryDate());
		assertEquals(rm1.getDeliveryDate(), rm.getDeliveryDate());
	}

	@Test
	void testAddRawMaterialsIntegerStringInteger() {
		fail("Not yet implemented");
	}

	@Test
	void testAddRawMaterialsRawMaterial() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProduct() {
		fail("Not yet implemented");
	}

}
