package com.zuoye.github.antlr4.chapter02.array_init;

import com.zuoye.github.antlr4.chapter02.MyShortToUnicodeString;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenSource;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * @author ZhangXueJun
 * @Date 2022年09月20日
 */
public class MyArrayInitMain {

    public static void main(String[] args) throws Exception {
        org.antlr.v4.runtime.ANTLRInputStream input = new org.antlr.v4.runtime.ANTLRInputStream (System.in);
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);

        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init();
//        String s = tree.toStringTree(parser);
//        System.out.println(s);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyShortToUnicodeString(), tree);
        System.out.println();


    }
}
