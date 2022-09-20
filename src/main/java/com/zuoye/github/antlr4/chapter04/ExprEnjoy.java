package com.zuoye.github.antlr4.chapter04;

import com.zuoye.github.antlr4.chapter04.expr.ExprLexer;
import com.zuoye.github.antlr4.chapter04.expr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author ZhangXueJun
 * @Date 2022年09月20日
 */
public class ExprEnjoy {

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) {
            inputFile = args[0];
        }

        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        CharStream charStream = CharStreams.fromStream(is);
        ExprLexer lexer = new ExprLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();

        System.out.println(tree.toStringTree(parser));
    }
}
