package com.junits;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.service.ReadInputCSV;
import com.service.ReadInputFactory;

public class ReadInputFactoryTest {
	ReadInputFactory readInputFactory;
	@Before
	public void prpare(){
		readInputFactory = ReadInputFactory.instantiateObject();
	}

	@Test
	public void testReadInputFactoryExposer() {
		assertTrue(readInputFactory.readInputFactoryExposer("CSV").getClass().equals(new ReadInputCSV().getClass()));
	}

}
