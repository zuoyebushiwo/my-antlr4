// Generated from /Users/zhangxuejun/Documents/data/apache/my-antlr4/src/main/java/com/zuoye/github/antlr4/chapter01/Hello.g4 by ANTLR 4.10.1
package com.zuoye.github.antlr4.chapter01.hello;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(HelloParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(HelloParser.RContext ctx);
}