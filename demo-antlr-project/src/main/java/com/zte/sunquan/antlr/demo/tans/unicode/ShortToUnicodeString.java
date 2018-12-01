package com.zte.sunquan.antlr.demo.tans.unicode;


import com.zte.sunquan.antlr.demo.trans.unicode.gen.DemoTransUnicodeParser;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/3/22.
 */
public class ShortToUnicodeString extends com.zte.sunquan.antlr.demo.trans.unicode.gen.DemoTransUnicodeBaseListener {
    private StringBuilder result = new StringBuilder();

    @Override
    public void enterValue(DemoTransUnicodeParser.ValueContext ctx) {
        if (ctx.INT() == null)
            System.out.print(ctx.INT());
        else {
            String output = String.format("\\u%04x", Integer.valueOf(ctx.INT().getText()));
            result.append(output);
        }
        super.enterValue(ctx);
    }

    public StringBuilder getResult() {
        return result;
    }
}
