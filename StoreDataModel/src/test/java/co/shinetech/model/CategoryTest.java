package co.shinetech.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

	@Test
	public final void testGetAndSetId() {
		Long id = 1L;
		Category tCat = new Category();
		tCat.setId(id);
		assertEquals(id,tCat.getId());
	}

	@Test
	public final void testEquals(){
		Category one = new Category();
		Category two = new Category();

		ArrayList<Category> child = new ArrayList<>();
		child.add(new Category(3L));

		ArrayList<Category> parent = new ArrayList<>();
		parent.add(new Category(7L));

		one.setId(2L);
		one.setName("Shoes");
		one.setDescription("Size 9 Shoes");
		one.setParent(parent);
		one.setChildren(child);

		two.setId(2L);
		two.setName("Shoes");
		two.setDescription("Size 9 Shoes");
		two.setParent(parent);
		two.setChildren(child);

		assert(one.equals(two));

	}
	

}