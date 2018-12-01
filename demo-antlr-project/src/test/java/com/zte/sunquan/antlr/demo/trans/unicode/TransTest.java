package com.zte.sunquan.antlr.demo.trans.unicode;

import com.zte.sunquan.antlr.demo.tans.unicode.ShortToUnicodeString;
import com.zte.sunquan.antlr.demo.trans.unicode.gen.DemoTransUnicodeLexer;
import com.zte.sunquan.antlr.demo.trans.unicode.gen.DemoTransUnicodeParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

public class TransTest {
    @Test
    public void testTrans() {
        String sentence = "{1,2,3}";
        //1.Lexical analysis
        DemoTransUnicodeLexer lexer = new DemoTransUnicodeLexer(new ANTLRInputStream(sentence));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //2.Syntax analysis
        DemoTransUnicodeParser parser = new DemoTransUnicodeParser(tokens);
        ParseTree tree = parser.init();
        //3.Aplication based on Syntax Tree
        ParseTreeWalker walker = new ParseTreeWalker();
        ShortToUnicodeString trans = new ShortToUnicodeString();
        walker.walk(trans, tree);
        System.out.println(trans.getResult());
    }
}
