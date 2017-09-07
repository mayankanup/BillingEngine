package mayank.anup.BillingEngine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mayank.anup.controller.BillingEngine;
import mayank.anup.model.LineItem;
import mayank.anup.model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingEngineApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testOrderWithInvalidLineItem(){
		List<LineItem> lines = new ArrayList<LineItem>();
		LineItem line1 = new LineItem();
		line1.setProductId("000");//Invalid product id which doesn't exist in system
		line1.setQuantity(1);
		lines.add(line1);
		boolean exception = false;
		try {
			Order order = BillingEngine.getOrderPrice(lines);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	@Test
	public void testOrderWithOneLineItem() throws Exception{
		List<LineItem> lines = new ArrayList<LineItem>();
		LineItem line1 = new LineItem();
		line1.setProductId("101");//Type C, thus no sales tax
		line1.setQuantity(1);
		lines.add(line1);
		Order order = BillingEngine.getOrderPrice(lines);
		assertEquals(new Double(400.0),order.getOrderTotal());
		assertEquals(new Double(400.0),order.getLineTotal());
		assertEquals(new Double(0.0),order.getSalesTaxTotal());
	}
	
	@Test
	public void testOrderWithTwoLineItem() throws Exception{
		List<LineItem> lines = new ArrayList<LineItem>();
		LineItem line1 = new LineItem();
		line1.setProductId("101");//Type C, thus no sales tax
		line1.setQuantity(1);
		lines.add(line1);
		line1 = new LineItem();
		line1.setProductId("102");//Type A, thus 10% sales tax
		line1.setQuantity(1);
		lines.add(line1);
		
		Order order = BillingEngine.getOrderPrice(lines);
		assertEquals(new Double(565.0),order.getOrderTotal());
		assertEquals(new Double(550.0),order.getLineTotal());
		assertEquals(new Double(15.0),order.getSalesTaxTotal());
	}
	
	@Test
	public void testOrderWithThreeLineItem() throws Exception{
		List<LineItem> lines = new ArrayList<LineItem>();
		LineItem line1 = new LineItem();
		line1.setProductId("101");//Type C, thus no sales tax
		line1.setQuantity(1);
		lines.add(line1);
		line1 = new LineItem();
		line1.setProductId("102");//Type A, thus 10% sales tax
		line1.setQuantity(1);
		lines.add(line1);
		line1 = new LineItem();
		line1.setProductId("104");//Type B, thus 20% sales tax
		line1.setQuantity(1);
		lines.add(line1);
		
		Order order = BillingEngine.getOrderPrice(lines);
		assertEquals(new Double(865.0),order.getOrderTotal());
		assertEquals(new Double(800.0),order.getLineTotal());
		assertEquals(new Double(65.0),order.getSalesTaxTotal());
	}
}
