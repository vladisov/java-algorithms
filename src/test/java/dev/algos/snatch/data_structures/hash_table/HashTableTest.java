package dev.algos.snatch.data_structures.hash_table;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

class HashTableTest {

    @Test
    void getTest() {
        HashTable<String, String> table = new HashTable<>();

        table.put("key", "value");
        assertThat(table.size(), equalTo(1));
        assertThat(table.get("key"), equalTo("value"));
        assertThat(table.toString(), equalTo("[[key, value]]"));
    }

    @Test
    void multiplePutTest() {
        HashTable<String, String> table = new HashTable<>();

        table.put("key", "value");
        table.put("key1", "value1");
        table.put("key2", "value3");
        assertThat(table.size(), equalTo(3));
        assertThat(table.get("key"), equalTo("value"));
        assertThat(table.get("key1"), equalTo("value1"));
        assertThat(table.get("key2"), equalTo("value3"));
        assertThat(table.toString(), equalTo("[[key1, value1],[key2, value3],[key, value]]"));

        table.remove("key");
        assertThat(table.get("key"), nullValue());
    }

    @Test
    void testExtendedMap() {
        HashTable<String, String> table = new HashTable<>();

        for (int i = 0; i < 20; i++) {
            table.put(i + "", Math.random() + "");
        }
        assertThat(table.size(), equalTo(20));

        for (int i = 0; i < 18; i++) {
            table.remove(i + "");
        }
        assertThat(table.size(), equalTo(3));

    }
}
