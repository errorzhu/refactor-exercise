package com.gildedrose;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestSafeNet {

    @Test
    public void test_baseline() throws IOException {

        String result = TexttestFixture.printOutput();
        String expect = Files.toString(new File("src/test/baseline.txt"), Charsets.UTF_8);
        Assert.assertEquals(result,expect);

    }
}
