package Random;

import static org.junit.Assert.*;

import org.junit.Test;

public class PivotElementTestCases {

	//positive test cases
	@Test
	public void middlecase() {
		int arr[] = {1, 4, 6, 3, 2};
		assertEquals(PivotElement.findPivot(arr),2);
	}
	
	@Test
	public void leftboundry() {
		int arr[] = {2,-2,3,-3,2};
		assertEquals(PivotElement.findPivot(arr),0);
	}
	
	@Test
	public void rightboundry(){
		int arr[] = {-2,3,-3,2,5};
		assertEquals(PivotElement.findPivot(arr),4);
	}
	
	@Test
	public void pivotNotPresent(){
		int arr[] = {-2,3,8,2,7};
		assertEquals(PivotElement.findPivot(arr),-1);
	}
	
	//negative test cases
	@Test
	public void NegativeMiddlecase() {
		int arr[] = {1, 4, 6, 3, 2};
		assertNotEquals(PivotElement.findPivot(arr),3);
	}
	
	@Test
	public void NegativeLeftboundry() {
		int arr[] = {2,-2,3,-3,2};
		assertNotEquals(PivotElement.findPivot(arr),1);
	}
	
	@Test
	public void NegativeRightboundry(){
		int arr[] = {-2,3,-3,2,5};
		assertNotEquals(PivotElement.findPivot(arr),2);
	}
}
