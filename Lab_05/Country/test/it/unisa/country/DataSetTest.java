package it.unisa.country;

import org.junit.Assert;
import org.junit.Test;

public class DataSetTest {
    @Test
    public void testMinimum() {
        DataSet dataSet = new DataSet();
        Country c1 = new Country("Italia",154000);
        Country c2 = new Country("Francia",231000);
        Country c3 = new Country("Nucaer",1910);

        dataSet.add(c1);
        dataSet.add(c2);
        dataSet.add(c3);

        Assert.assertEquals("Nucaer",dataSet.getMinimum().getName());
    }

    @Test
    public void testMaximum() {
        DataSet dataSet = new DataSet();
        Country c1 = new Country("Italia",154000);
        Country c2 = new Country("Francia",231000);
        Country c3 = new Country("Nucaer",1910);

        dataSet.add(c1);
        dataSet.add(c2);
        dataSet.add(c3);

        Assert.assertEquals("Francia",dataSet.getMaximum().getName());
    }
}