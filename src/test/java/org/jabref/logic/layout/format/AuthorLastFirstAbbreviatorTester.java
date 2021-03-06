package org.jabref.logic.layout.format;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case  that verifies the functionalities of the
 * formater AuthorLastFirstAbbreviator.
 *
 * @author Carlos Silla
 * @author Christopher Oezbek <oezi@oezi.de>
 */
public class AuthorLastFirstAbbreviatorTester {

    /**
     * Verifies the Abbreviation of one single author with a simple name.
     * <p/>
     * Ex: Lastname, Name
     */
    @Test
    public void testOneAuthorSimpleName() {
        Assert.assertEquals("Abbreviator Test", "Lastname, N.", abbreviate("Lastname, Name"));
    }

    /**
     * Verifies the Abbreviation of one single author with a common name.
     * <p/>
     * Ex: Lastname, Name Middlename
     */
    @Test
    public void testOneAuthorCommonName() {
        Assert.assertEquals("Abbreviator Test", "Lastname, N. M.", abbreviate("Lastname, Name Middlename"));
    }

    /**
     * Verifies the Abbreviation of two single with a common name.
     * <p/>
     * Ex: Lastname, Name Middlename
     */
    @Test
    public void testTwoAuthorsCommonName() {
        String result = abbreviate("Lastname, Name Middlename and Sobrenome, Nome Nomedomeio");
        String expectedResult = "Lastname, N. M. and Sobrenome, N. N.";

        Assert.assertEquals("Abbreviator Test", expectedResult, result);
    }

    @Test
    public void testJrAuthor() {
        Assert.assertEquals("Other, Jr., A. N.", abbreviate("Other, Jr., Anthony N."));
    }

    @Test
    public void testFormat() {
        Assert.assertEquals("", abbreviate(""));
        Assert.assertEquals("Someone, V. S.", abbreviate("Someone, Van Something"));
        Assert.assertEquals("Smith, J.", abbreviate("Smith, John"));
        Assert.assertEquals("von Neumann, J. and Smith, J. and Black Brown, P.",
                abbreviate("von Neumann, John and Smith, John and Black Brown, Peter"));
    }

    protected String abbreviate(String name) {
        return new AuthorLastFirstAbbreviator().format(name);
    }

}
