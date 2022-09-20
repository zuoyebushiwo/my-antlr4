package com.zuoye.github.antlr4.chapter02;

import com.zuoye.github.antlr4.chapter02.array_init.ArrayInitBaseListener;
import com.zuoye.github.antlr4.chapter02.array_init.ArrayInitBaseVisitor;
import com.zuoye.github.antlr4.chapter02.array_init.ArrayInitParser;

/**
 * @author ZhangXueJun
 * @Date 2022年09月20日
 */
public class MyShortToUnicodeString extends ArrayInitBaseListener {

    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
//        super.enterInit(ctx);
        System.out.print('"');
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}
