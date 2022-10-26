package com.zuoye.github.antlr4.chapter10;

import com.zuoye.github.antlr4.chapter04.expr.ExprLexer;
import com.zuoye.github.antlr4.chapter10.expr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

/**
 * @author ZhangXueJun
 * @Date 2022年09月28日
 */
public class ExprEnjoy {

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String expr = br.readLine();              // get first expression
        int line = 1;                             // track input expr line numbers

        ExprParser parser = new ExprParser(null);
        parser.setBuildParseTree(false);

        while (expr != null) {
            CharStream charStream = CharStreams.fromString(expr + "\n");
            ExprLexer lexer = new ExprLexer(charStream);
            lexer.setLine(line);
            lexer.setCharPositionInLine(0);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser.setInputStream(tokens);
            parser.stat();                 // start the parser
            expr = br.readLine();          // see if there's another line
            line++;
        }
    }

}
