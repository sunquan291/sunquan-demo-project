//package com.zte.sunquan.antlr.demo;
//
//import com.zte.sunquan.antlr.demo.gen.demoLexer;
//import com.zte.sunquan.antlr.demo.gen.demoParser;
//import com.zte.sunquan.antlr.isl.ISLLexer;
//import com.zte.sunquan.antlr.isl.ISLParser;
//import org.antlr.v4.runtime.ANTLRInputStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
//import org.junit.Test;
//
///**
// * Created by Administrator on 2017/3/22.
// */
//public class MainTest {
//    @Test
//    public void test1() {
//        String sentence = "{99,3,451}";
//        //1.Lexical analysis
//        demoLexer lexer = new demoLexer(new ANTLRInputStream(sentence));
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        //2.Syntax analysis
//        demoParser parser = new demoParser(tokens);
//        ParseTree tree = parser.init();
//        //3.Aplication based on Syntax Tree
//        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk(new ShortToUnicodeString(), tree);
//        System.out.println();
//    }
//
//    @Test
//    public void test2() {
//        String input = "return (([车速]*10+3)>(200)) && ([企业ID] == \"123\") && ([时间]>1200 && [时间]<1700);";
//
//        ANTLRInputStream inputStream = new ANTLRInputStream(input);
//        ISLLexer lexer = new ISLLexer(inputStream);
//
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        ISLParser parser = new ISLParser(tokens);
//
//        ParseTree tree = parser.return_statement();
//
//        //ISLVisitor visitor = new ISLVisitor();
//        //object ret = visitor.Visit(tree);
//
//        ISLVistor visitor = new ISLVistor();
//        Result ret = visitor.visit(tree);
//        System.out.println(ret.getValue());
//
//    }
//}
