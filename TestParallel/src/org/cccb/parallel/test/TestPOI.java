package org.cccb.parallel.test;

import static literal.collection.List;

import java.util.List;

import static junit.framework.Assert.*;

import org.cccb.parallel.model.POI;
import org.junit.Test;

public class TestPOI {

	@Test
	public void testCreatePOI() {
		POI p = new POI();
		
		p.setId(10);
		p.setAdrress("Address of test");
		p.setLatitude(0.8888f);
		p.setLongitude(1.98);
		
		List<String> tags = List("Tag1", "Tag2", "Tag3");
		p.setTags(tags);
		
		assertEquals(10, p.getId());
		assertEquals("Tag1", p.getTags().get(0));
		
		
		
	}

}
