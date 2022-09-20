package com.zuoye.github.antlr4.chapter04;

import com.zuoye.github.antlr4.chapter04.labeled_expr.LabeledExprLexer;
import com.zuoye.github.antlr4.chapter04.labeled_expr.LabeledExprParser;
import com.zuoye.github.antlr4.chapter04.labeled_expr.LabeledExprVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;

/**
 * @author ZhangXueJun
 * @Date 2022年09月20日
 */
public class LabeledExprEnjoy {

    public static void main(String[] args) throws Exception {
        InputStream is = System.in;
        CharStream charStream = CharStreams.fromStream(is);
        LabeledExprLexer lexer = new LabeledExprLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog();
        LabeledExprVisitor<Integer> visitor = new LabeledEvalVisitor();
        Integer visit = visitor.visit(tree);
//        System.out.println("result:"+visit);

    }



}
