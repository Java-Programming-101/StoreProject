package co.shinetech.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategoryTest {

	@Test
	public final void testGetAndSetId() {
		Long id = 1L;
		Category tCat = new Category();
		tCat.setId(id);
		assertEquals(id,tCat.getId());
	}
	@Test
	public final void testGetAndSetName() {
		String name = "Johnny Smith";
		Category tCat = new Category();
		tCat.setName(name);
		assertEquals(name,tCat.getName());
	}

	@Test
	public final void testGetandSetChildandParent(){
		Category one = new Category();


		ArrayList<Category> child = new ArrayList<>();
		child.add(new Category(3L));

		ArrayList<Category> parent = new ArrayList<>();
		parent.add(new Category(7L));

		one.setParent(parent);
		one.setChildren(child);

		assertEquals(child, one.getChildren());
		assertEquals(parent, one.getParent());


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

		assertTrue(one.equals(two));

	}

	@Test
	public final void testGetandSetDescription(){
		Category one = new Category();

		String description = "Size 9 Shoes";
		one.setDescription(description);

		assertEquals(one.getDescription(),description);
	}

	@Test
	public final void testHashcode(){
		Category one = new Category();

		one.setId(2345543L);
		long hash = one.hashCode();

		assertTrue(one.hashCode()== hash);
	}

	@Test
	public final void testToString(){
		Category one = new Category();


		ArrayList<Category> child = new ArrayList<>();
		child.add(new Category(3L));

		ArrayList<Category> parent = new ArrayList<>();
		parent.add(new Category(7L));

		one.setId(2L);
		one.setName("Shoes");
		one.setDescription("Size 9 Shoes");
		one.setParent(parent);
		one.setChildren(child);
		one.setImage("Shoes");

		String tString = "Category{id=2, name='Shoes', description='Size 9 Shoes', image=Shoes, parent=[Category{id=7, name='null', description='null', image=null, parent=null, children=null}], children=[Category{id=3, name='null', description='null', image=null, parent=null, children=null}]}";

		assertTrue(tString.equals(one.toString()));

	}

}