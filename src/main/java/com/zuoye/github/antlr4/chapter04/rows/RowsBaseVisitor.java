// Generated from /Users/zhangxuejun/Documents/data/apache/my-antlr4/src/main/java/com/zuoye/github/antlr4/chapter04/Rows.g4 by ANTLR 4.10.1
package com.zuoye.github.antlr4.chapter04.rows;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link RowsVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class RowsBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements RowsVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFile(RowsParser.FileContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRow(RowsParser.RowContext ctx) { return visitChildren(ctx); }
}