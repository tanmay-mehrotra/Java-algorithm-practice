package Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KleenAndDotOperatorUTest {

	KleenAndDotOperator solution = null;
	
	@Before
    public void setUp() {
        solution = new KleenAndDotOperator();
    }
	
	@Test(timeout = 2000)
    public void testCase0() {
        String pattern = "..";
        String sample = ".b";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }

	@Test(timeout = 2000)
    public void testCase1() {
        String pattern = "za*";
        String sample = "za";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	
	@Test(timeout = 2000)
    public void testCase2() {
        String pattern = "za*c";
        String sample = "za";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase3() {
        String pattern = "za*.";
        String sample = "zac";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase4() {
        String pattern = "za*";
        String sample = "zadefgh";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase5() {
        String pattern = "za*bc";
        String sample = "zadshgdbc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase6() {
        String pattern = "za*bc";
        String sample = "zadshgdbc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase7() {
        String pattern = "za*b*c";
        String sample = "zadshgdbdefgk";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase8() {
        String pattern = "za*bcd";
        String sample = "zadshgdbcefgbcd";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase9() {
        String pattern = "za*bcd";
        String sample = "zadshgdbcefgbcd";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase10() {
        String pattern = "za**cd";
        String sample = "zadshgdbcefgbcd";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase11() {
        String pattern = "*c";
        String sample = "acdc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase12() {
        String pattern = "*c";
        String sample = "acdc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase13() {
        String pattern = "a*";
        String sample = "abc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	
	@Test(timeout = 2000)
    public void testCase14() {
        String pattern = "ab*c";
        String sample = "abc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase15() {
        String pattern = "abc";
        String sample = "abc*";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase16() {
        String pattern = "abc*";
        String sample = "abc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase17() {
        String pattern = "*c";
        String sample = "abd";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase18() {
        String pattern = ".a*c";
        String sample = "zaabcdfc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase19() {
        String pattern = "";
        String sample = "";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	
	@Test(timeout = 2000)
    public void testCase20() {
        String pattern = "";
        String sample = "zaabcdfc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase21() {
        String pattern = "";
        String sample = "zaabcdfc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	//exhaustive case1
	@Test(timeout = 2000)
    public void testCase22(){
        String pattern = "..a*b**ekg*h*";
        String sample = "kga1234b56789ek123ekgh";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase23(){
        String pattern = "..a*b**ekg*h*";
        String sample = "kgabekgh";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase24(){
        String pattern = ".*.*.**";
        String sample = "abc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase25(){
        String pattern = "...***";
        String sample = "abc";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
	@Test(timeout = 2000)
    public void testCase26(){
        String pattern = "abcd";
        String sample = "ab";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase27(){
        String pattern = ".*";
        String sample = "";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), false);
    }
	
	@Test(timeout = 2000)
    public void testCase28(){
        String pattern = ".*bcd**ef.*gh**";
        String sample = "a1234bcd12efg1234gh";
        Assert.assertEquals(solution.is_match(pattern, sample, 0, 0), true);
    }
	
}
