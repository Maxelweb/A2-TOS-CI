package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MenuItemTest {
	
	

	@Test
	public void isNameReallyWorking_Test() {
		
		MenuItem iMenu = new MenuItem("Spaghetti alla Carbonara", MenuItem.items.PRIMO, 8.50);
		
		assertEquals("Spaghetti alla Carbonara", iMenu.getName());
	}

}
