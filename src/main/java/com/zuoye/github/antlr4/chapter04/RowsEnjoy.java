package com.zuoye.github.antlr4.chapter04;

import com.zuoye.github.antlr4.chapter04.rows.RowsLexer;
import com.zuoye.github.antlr4.chapter04.rows.RowsParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author ZhangXueJun
 * @Date 2022年09月21日
 */
public class RowsEnjoy {

    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromStream(System.in);
        RowsLexer lexer = new RowsLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        int col = Integer.valueOf(args[0]);
        RowsParser parser = new RowsParser(tokens, col);
        parser.setBuildParseTree(false);
        parser.file();
    }
}
