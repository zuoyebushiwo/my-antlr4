// Generated from /Users/zhangxuejun/Documents/data/apache/my-antlr4/src/main/java/com/zuoye/github/antlr4/chapter01/Hello.g4 by ANTLR 4.10.1
package com.zuoye.github.antlr4.chapter01.hello;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(HelloParser.RContext ctx);
}