package org.liquidbot.bot.script.api.query;

import org.liquidbot.bot.script.api.interfaces.Filter;
import org.liquidbot.bot.script.api.methods.data.Bank;
import org.liquidbot.bot.script.api.wrappers.Item;

import java.util.Arrays;

/**
 * Created by Kenneth on 8/4/2014.
 */
public class BankQuery extends AbstractQuery<BankQuery, Item> {
    @Override
    protected Item[] elements() {
        return Bank.getAllItems();
    }

    public BankQuery name(final String... names) {
        return filter(new Filter<Item>() {
            @Override
            public boolean accept(Item item) {
                return Arrays.asList(names).contains(item.getName());
            }
        });
    }

    public BankQuery id(final int... ids) {
        return filter(new Filter<Item>() {
            @Override
            public boolean accept(Item item) {
                return Arrays.asList(ids).contains(item.getId());
            }
        });
    }
}
