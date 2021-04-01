package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test (expected = NullPointerException.class) //Checks to see if NullPointerException will
    public void testCountNumbers2() {             //be thrown if string is set to null
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test
    public void testCountNumbers3() {                               //Checks to see if method works for string
        mycustomstring.setString("This sentence has no numbers.");  //with no numbers and returns 0
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {                               //Checks to see if method works for string
        mycustomstring.setString("H3110 W0r1d");                    //with numbers mixed into letters
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {                               //Checks to see if method works for a proper sentence with numbers
        mycustomstring.setString("2 pigs went to the market, only 1 came home.");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {                               //Checks to see if method works for a longer string
        mycustomstring.setString("There are 343 people attending today's event but only 200 have come prepared for it.");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = IllegalArgumentException.class)             //Checks for IllegalArgumentException when n = 0
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {  //when startFromEnd = false
        mycustomstring.setString("Hello World");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0,false);
    }

    @Test(expected = IllegalArgumentException.class)             //Checks for IllegalArgumentException when n = 0
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {  //when startFromEnd = true
        mycustomstring.setString("Hello World");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0,true);
    }

    @Test(expected = NullPointerException.class)                //Checks for NullPointerException when string is null
    public void testGetEveryNthCharacterFromBeginningOrEnd5() { //when startFromEnd = false
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2,false);
    }

    @Test(expected = NullPointerException.class)                //Checks for NullPointerException when string is null
    public void testGetEveryNthCharacterFromBeginningOrEnd6() { //when startFromEnd = true
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2,true);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() { //Checks to see if output is an empty string
        mycustomstring.setString("A");                          //when string length is less than n when startFromEnd = false
        assertEquals("",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() { //Checks to see if output is an empty string
        mycustomstring.setString("A");                          //when string length is less than n when startFromEnd = true
        assertEquals("",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() { //Checks to see if method works for a longer string when startFromEnd = false
        mycustomstring.setString("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        assertEquals("mulieot igtdeomii a o aq", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5,false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() { //Checks to see if method works for a longer string when startFromEnd = true
        mycustomstring.setString("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        assertEquals("esosmccrpnie me dtledeni", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5,true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() { //Checks to see if method works for a string with letters and numbers when startFromEnd = false
        mycustomstring.setString("1234567890 1234567890 AB CD EF GH IJ KL MN OP QR ST UV WX YZ");
        assertEquals("2468013579 BC FG JK NO RS VW Z", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2,false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() { //Checks to see if method works for a string with letters and numbers when startFromEnd = false
        mycustomstring.setString("1234567890 1234567890 AB CD EF GH IJ KL MN OP QR ST UV WX YZ");
        assertEquals("13579 24680A DE HI LM PQ TU XY", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2,true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() { //Checks to see if method works when n is a larger number and startFromEnd = false
        mycustomstring.setString("Today I heard something new and unmemorable. Improve your goldfish's physical fitness by getting him a bicycle.");
        assertEquals( "sn ocgi", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(15, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() { //Checks to see if method works when n is a larger number and startFromEnd = true
        mycustomstring.setString("Today I heard something new and unmemorable. Improve your goldfish's physical fitness by getting him a bicycle.");
        assertEquals( "Inme'n ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(15, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() { //Checks for IllegalArgumentException when startPosition > endPosition
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(20, 15);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() { //Checks for MyIndexOutOfBoundsException when endPosition is
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?"); //greater than string length
        mycustomstring.convertDigitsToNamesInSubstring(1, 50);
    }

    @Test(expected = NullPointerException.class) //checks for NullPointerException when string is null but startPosition
    public void testConvertDigitsToNamesInSubstring4() { //and endPosition are both greater than 0
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(10, 20);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() { //checks to see if method works for longer string and substring
        mycustomstring.setString("H3 app3ared to b3 confusingly p3rpl3x3d.The spa att3ndant appli3d th3 d33p cl3aning mask to th3 g3ntl3man’s back.");
        mycustomstring.convertDigitsToNamesInSubstring(1, 110);
        assertEquals("HThree appThreeared to bThree confusingly pThreerplThreexThreed.The spa attThreendant appliThreed thThree dThreeThreep clThreeaning mask to thThree gThreentlThreeman’s back.", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() { //checks to see if method works for a long string but short substring
        mycustomstring.setString("H3 app3ared to b3 confusingly p3rpl3x3d.The spa att3ndant appli3d th3 d33p cl3aning mask to th3 g3ntl3man’s back.");
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("HThree app3ared to b3 confusingly p3rpl3x3d.The spa att3ndant appli3d th3 d33p cl3aning mask to th3 g3ntl3man’s back.", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() { //checks to see if method works for various numbers between numbers
        mycustomstring.setString("There are 123456789 people in this country.");
        mycustomstring.convertDigitsToNamesInSubstring(12,16);
        assertEquals("There are 1TwoThreeFourFiveSix789 people in this country.", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() { //checks to see if method works for longer string with various numbers spread apart
        mycustomstring.setString("I dr0ve 10 miles t0day and went t0 th3 gym to deadl1ft 500 pounds but fa1led when l1fting 300 pounds.");
        mycustomstring.convertDigitsToNamesInSubstring(30, 70);
        assertEquals("I dr0ve 10 miles t0day and went tZero thThree gym to deadlOneft FiveZeroZero pounds but fa1led when l1fting 300 pounds.", mycustomstring.getString());
    }

}
